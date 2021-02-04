package co.nz.spark.utility.BackFillProcessor.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "from",
        "to",
        "modules"
})
public class Backfill {

    @JsonProperty("title")
    private String title;
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;
    @JsonProperty("modules")
    private List<String> modules = null;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Backfill withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    public Backfill withFrom(String from) {
        this.from = from;
        return this;
    }

    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(String to) {
        this.to = to;
    }

    public Backfill withTo(String to) {
        this.to = to;
        return this;
    }

    @JsonProperty("modules")
    public List<String> getModules() {
        return modules;
    }

    @JsonProperty("modules")
    public void setModules(List<String> modules) {
        this.modules = modules;
    }

    public Backfill withModules(List<String> modules) {
        this.modules = modules;
        return this;
    }

}
