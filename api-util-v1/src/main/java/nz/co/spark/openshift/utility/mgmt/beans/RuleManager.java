package nz.co.spark.openshift.utility.mgmt.beans;

import com.sun.org.apache.xpath.internal.XPathAPI;
import com.sun.org.apache.xpath.internal.objects.XBoolean;
import nz.co.spark.openshift.utility.mgmt.model.re.RuleEngineConfigurations;
import nz.co.spark.openshift.utility.mgmt.model.re.RuleRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RuleManager {

    private static Logger logger = LoggerFactory.getLogger("RuleManager");


    ReportManager reportManager;

    private JAXBContext context;

    private RuleEngineConfigurations configurations;

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    List<RuleEngineConfigurations.UseCase.Rules.Rule> commonRuleList;

    Map<String, List<RuleEngineConfigurations.UseCase.Rules.Rule>> ruleMap = new HashMap<String, List<RuleEngineConfigurations.UseCase.Rules.Rule>>();


    public void init(File rulesFile,ReportManager reportManager) {
        try {
            this.reportManager = reportManager;
            context = JAXBContext.newInstance(RuleEngineConfigurations.class);
            configurations = (RuleEngineConfigurations) context.createUnmarshaller().unmarshal(rulesFile);
            List<RuleEngineConfigurations.UseCase> useCaseList = configurations.getUseCase();
            for (RuleEngineConfigurations.UseCase useCase : useCaseList) {
                if (StringUtils.isEmpty(useCase.getTemplateId())) {
                    RuleEngineConfigurations.UseCase.Rules rules = useCase.getRules();
                    commonRuleList = rules.getRule();
                } else {
                    RuleEngineConfigurations.UseCase.Rules rules = useCase.getRules();
                    ruleMap.put(useCase.getTemplateId(), rules.getRule());
                }
            }
            logger.debug("Common Rule List Size "+ commonRuleList.size());
            logger.debug("Exclusive Rule List UseCases "+ ruleMap.size());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<RuleRecord> validateRules(String useCase, ResponseEntity<?> response) {
        ArrayList<RuleRecord> responseList = new ArrayList<RuleRecord>();

        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document model = builder.parse(new InputSource(new StringReader(response.getBody().toString())));
            Node responseRoot = model.getDocumentElement();

            List<RuleRecord> commonRuleRecordOut = executeCommonRules(useCase, responseRoot, response);
            List<RuleRecord> exclusiveRuleRecordOut = executeUsecaseRules(useCase, responseRoot, response);

            responseList.addAll(commonRuleRecordOut);
            responseList.addAll(exclusiveRuleRecordOut);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseList;

    }

    private List<RuleRecord> executeUsecaseRules(String useCase, Node responseRoot, ResponseEntity<?> response) {
        List<RuleRecord> ruleRecordList = new ArrayList<>();
        List<RuleEngineConfigurations.UseCase.Rules.Rule> exclusiveRuleList = ruleMap.get(useCase);
        if (exclusiveRuleList != null) {
            for (RuleEngineConfigurations.UseCase.Rules.Rule rule : exclusiveRuleList) {

                RuleRecord record = new RuleRecord();
                record.setName(rule.getName());
                record.setUseCase(useCase);
                record.setSuccess(false);
                record.setPath(rule.getResponseContext());
                record.setAssertion(rule.getValidationAssertion());

                if(matchRule(useCase, rule, responseRoot,record)){
                    ruleRecordList.add(record);
                };
                matchHttpRule(useCase,rule,response,record);

            }
        }
        return ruleRecordList;
    }

    private List<RuleRecord> executeCommonRules(String useCase, Node responseRoot, ResponseEntity<?> response) {
        List<RuleRecord> ruleRecordList = new ArrayList<>();
        for (RuleEngineConfigurations.UseCase.Rules.Rule rule : commonRuleList) {
            RuleRecord record = new RuleRecord();
            record.setName(rule.getName());
            record.setUseCase(useCase);
            record.setSuccess(false);
            record.setPath(rule.getResponseContext());
            record.setAssertion(rule.getValidationAssertion());

            if(matchRule(useCase, rule, responseRoot,record)){
                ruleRecordList.add(record);
            };
            matchHttpRule(useCase,rule,response,record);

        }

        return ruleRecordList;
    }

    private boolean matchHttpRule(String useCase, RuleEngineConfigurations.UseCase.Rules.Rule rule, ResponseEntity<?> response, RuleRecord ruleRecord) {
        String message = ruleRecord.getErrorMessage();
        StringWriter st = new StringWriter();
        st.append(message);
        if(rule.getHttpStatus() != null && !rule.getHttpStatus().equalsIgnoreCase(response.getStatusCode().value()+"")){
            st.append(" Response Http Status Code " + response.getStatusCode().value() +"  doesnt Match with rule " + rule.getHttpStatus());
            st.flush();
            ruleRecord.setErrorMessage(st.toString());
            return true;
        }
        return false;
    }

    private boolean  matchRule(String useCase, RuleEngineConfigurations.UseCase.Rules.Rule rule, Node responseRoot,RuleRecord record) {

        if (rule.getResponseContext() != null) {
            try {
                NodeList modelNodes = XPathAPI.selectNodeList(responseRoot, rule.getResponseContext());
                if (modelNodes.getLength() == 0) {
                    record.setErrorMessage("Configured XPath not Matched");
                } else {
                    for (int j = 0; j < modelNodes.getLength(); j++) {
                        Node modelNode = modelNodes.item(j);
                        XBoolean result = (XBoolean) XPathAPI.eval(modelNode, rule.getValidationAssertion());
                        String path = getAbsolutePath((Element) modelNode);
                        record.setPath(path);

                        if (!result.bool()) {
                            record.setErrorMessage(rule.getErrorMessage());
                        } else {
                            record.setSuccess(true);
                        }
                    }
                }
            } catch (TransformerException e) {
                record.setErrorMessage("Exception :: " + e.getLocalizedMessage());;
                e.printStackTrace();
            }

        }

        return true;
    }

    public static String getAbsolutePath(Element e)
    {
        String path = "/" + e.getTagName();
        if (e.hasAttribute("id"))
        {
            path += "[@id='" + e.getAttribute("id") + "']";
        }
        Node parent = e.getParentNode();
        if (parent.getNodeType() == Node.ELEMENT_NODE)
        {
            return getAbsolutePath((Element)parent) + path;
        }
        else
        {
            return path;
        }
    }
}
