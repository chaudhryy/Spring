package co.nz.spark.utility.BackFillProcessor.model;

import java.util.List;

import co.nz.spark.utility.BackFillProcessor.model.Backfill;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "backfill"
})
public class BackFillJsonModel {

    @JsonProperty("backfill")
    private List<Backfill> backfill = null;

    @JsonProperty("backfill")
    public List<Backfill> getBackfill() {
        return backfill;
    }

    @JsonProperty("backfill")
    public void setBackfill(List<Backfill> backfill) {
        this.backfill = backfill;
    }

    public BackFillJsonModel withBackfill(List<Backfill> backfill) {
        this.backfill = backfill;
        return this;
    }

}
