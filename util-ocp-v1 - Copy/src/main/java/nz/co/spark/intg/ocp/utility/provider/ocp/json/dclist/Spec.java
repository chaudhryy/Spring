
package nz.co.spark.intg.ocp.utility.provider.ocp.json.dclist;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "strategy",
    "triggers",
    "replicas",
    "revisionHistoryLimit",
    "test",
    "selector",
    "template"
})
public class Spec {

    @JsonProperty("strategy")
    private Strategy strategy;
    @JsonProperty("triggers")
    private List<Trigger> triggers = null;
    @JsonProperty("replicas")
    private int replicas;
    @JsonProperty("revisionHistoryLimit")
    private Long revisionHistoryLimit;
    @JsonProperty("test")
    private Boolean test;
    @JsonProperty("selector")
    private Selector selector;
    @JsonProperty("template")
    private Template template;

    @JsonProperty("strategy")
    public Strategy getStrategy() {
        return strategy;
    }

    @JsonProperty("strategy")
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Spec withStrategy(Strategy strategy) {
        this.strategy = strategy;
        return this;
    }

    @JsonProperty("triggers")
    public List<Trigger> getTriggers() {
        return triggers;
    }

    @JsonProperty("triggers")
    public void setTriggers(List<Trigger> triggers) {
        this.triggers = triggers;
    }

    public Spec withTriggers(List<Trigger> triggers) {
        this.triggers = triggers;
        return this;
    }

    @JsonProperty("replicas")
    public int getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(int replicas) {
        this.replicas = replicas;
    }

    public Spec withReplicas(int replicas) {
        this.replicas = replicas;
        return this;
    }

    @JsonProperty("revisionHistoryLimit")
    public Long getRevisionHistoryLimit() {
        return revisionHistoryLimit;
    }

    @JsonProperty("revisionHistoryLimit")
    public void setRevisionHistoryLimit(Long revisionHistoryLimit) {
        this.revisionHistoryLimit = revisionHistoryLimit;
    }

    public Spec withRevisionHistoryLimit(Long revisionHistoryLimit) {
        this.revisionHistoryLimit = revisionHistoryLimit;
        return this;
    }

    @JsonProperty("test")
    public Boolean getTest() {
        return test;
    }

    @JsonProperty("test")
    public void setTest(Boolean test) {
        this.test = test;
    }

    public Spec withTest(Boolean test) {
        this.test = test;
        return this;
    }

    @JsonProperty("selector")
    public Selector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public Spec withSelector(Selector selector) {
        this.selector = selector;
        return this;
    }

    @JsonProperty("template")
    public Template getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(Template template) {
        this.template = template;
    }

    public Spec withTemplate(Template template) {
        this.template = template;
        return this;
    }

}
