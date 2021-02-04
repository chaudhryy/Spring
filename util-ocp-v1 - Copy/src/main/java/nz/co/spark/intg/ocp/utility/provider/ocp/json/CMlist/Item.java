
package nz.co.spark.intg.ocp.utility.provider.ocp.json.CMlist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "data"
})
public class Item {

    @JsonProperty("metadata")
    private Metadata_ metadata;
    @JsonProperty("data")
    private Data data;

    @JsonProperty("metadata")
    public Metadata_ getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata_ metadata) {
        this.metadata = metadata;
    }

    public Item withMetadata(Metadata_ metadata) {
        this.metadata = metadata;
        return this;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    public Item withData(Data data) {
        this.data = data;
        return this;
    }

}
