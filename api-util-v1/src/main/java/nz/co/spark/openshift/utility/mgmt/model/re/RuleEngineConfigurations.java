//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.10.19 at 02:01:20 PM NZDT 
//


package nz.co.spark.openshift.utility.mgmt.model.re;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UseCase" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Rules"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Rule" maxOccurs="unbounded" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *                                       &lt;element name="ResponseContext" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="ValidationAssertion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="httpStatus" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *                                       &lt;element name="httpMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                     &lt;/choice&gt;
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="templateId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "useCase"
})
@XmlRootElement(name = "RuleEngineConfigurations")
public class RuleEngineConfigurations {

    @XmlElement(name = "UseCase")
    protected List<RuleEngineConfigurations.UseCase> useCase;

    /**
     * Gets the value of the useCase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the useCase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUseCase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RuleEngineConfigurations.UseCase }
     * 
     * 
     */
    public List<RuleEngineConfigurations.UseCase> getUseCase() {
        if (useCase == null) {
            useCase = new ArrayList<RuleEngineConfigurations.UseCase>();
        }
        return this.useCase;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Rules"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Rule" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
     *                             &lt;element name="ResponseContext" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="ValidationAssertion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="httpStatus" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
     *                             &lt;element name="httpMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                           &lt;/choice&gt;
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="templateId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "rules"
    })
    public static class UseCase {

        @XmlElement(name = "Rules", required = true)
        protected RuleEngineConfigurations.UseCase.Rules rules;
        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "templateId")
        protected String templateId;

        /**
         * Gets the value of the rules property.
         * 
         * @return
         *     possible object is
         *     {@link RuleEngineConfigurations.UseCase.Rules }
         *     
         */
        public RuleEngineConfigurations.UseCase.Rules getRules() {
            return rules;
        }

        /**
         * Sets the value of the rules property.
         * 
         * @param value
         *     allowed object is
         *     {@link RuleEngineConfigurations.UseCase.Rules }
         *     
         */
        public void setRules(RuleEngineConfigurations.UseCase.Rules value) {
            this.rules = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the templateId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTemplateId() {
            return templateId;
        }

        /**
         * Sets the value of the templateId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTemplateId(String value) {
            this.templateId = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="Rule" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
         *                   &lt;element name="ResponseContext" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="ValidationAssertion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="httpStatus" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
         *                   &lt;element name="httpMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                 &lt;/choice&gt;
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "rule"
        })
        public static class Rules {

            @XmlElement(name = "Rule")
            protected List<RuleEngineConfigurations.UseCase.Rules.Rule> rule;

            /**
             * Gets the value of the rule property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the rule property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRule().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link RuleEngineConfigurations.UseCase.Rules.Rule }
             * 
             * 
             */
            public List<RuleEngineConfigurations.UseCase.Rules.Rule> getRule() {
                if (rule == null) {
                    rule = new ArrayList<RuleEngineConfigurations.UseCase.Rules.Rule>();
                }
                return this.rule;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
             *         &lt;element name="ResponseContext" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="ValidationAssertion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="httpStatus" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
             *         &lt;element name="httpMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *       &lt;/choice&gt;
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "responseContext",
                    "validationAssertion",
                    "errorMessage",
                    "httpStatus",
                    "httpMessage",
                    })
            public static class Rule {


                @XmlElement(name = "ResponseContext")
                protected String responseContext;

                @XmlElement(name = "ValidationAssertion")
                protected String validationAssertion;

                @XmlElement(name = "ErrorMessage")
                protected String errorMessage;

                @XmlElement(name = "httpStatus")
                protected String httpStatus;

                @XmlElement(name = "httpMessage")
                protected String httpMessage;


                @XmlAttribute(name = "name")
                protected String name;

                public String getResponseContext() {
                    return responseContext;
                }

                public void setResponseContext(String responseContext) {
                    this.responseContext = responseContext;
                }

                public String getValidationAssertion() {
                    return validationAssertion;
                }

                public void setValidationAssertion(String validationAssertion) {
                    this.validationAssertion = validationAssertion;
                }

                public String getErrorMessage() {
                    return errorMessage;
                }

                public void setErrorMessage(String errorMessage) {
                    this.errorMessage = errorMessage;
                }

                public String getHttpStatus() {
                    return httpStatus;
                }

                public void setHttpStatus(String httpStatus) {
                    this.httpStatus = httpStatus;
                }

                public String getHttpMessage() {
                    return httpMessage;
                }

                public void setHttpMessage(String httpMessage) {
                    this.httpMessage = httpMessage;
                }

                /**
                 * Gets the value of the name property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

            }

        }

    }

}
