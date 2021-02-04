package nz.co.spark.openshift.utility.mgmt.beans;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import nz.co.spark.openshift.utility.mgmt.model.InputParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

@Component
public class RequestManager {

    @Autowired
    InputParameters parameters;
    
    private  Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);


    public void init() throws IOException {
        TemplateLoader templateLoader =  getTemplateLoader();
        cfg.setTemplateLoader(templateLoader);

    }

    public String prepareRequest(Map<String,String> recordMap) throws IOException, TemplateException {
        Template template = cfg.getTemplate(recordMap.get("Usecase"));
        StringWriter out = new StringWriter();
        template.process(recordMap,out);
        out.flush();
        return out.toString();
    }

    private TemplateLoader getTemplateLoader() throws IOException {
            TemplateLoader templateLoader = new FileTemplateLoader(parameters.getTemplateDirectory());
            return templateLoader;
    }

}
