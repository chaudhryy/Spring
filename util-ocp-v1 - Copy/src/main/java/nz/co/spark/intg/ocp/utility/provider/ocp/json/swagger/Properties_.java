
package nz.co.spark.intg.ocp.utility.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "partNumber",
    "grouping",
    "unitOfMeasureType",
    "usageQuantity",
    "overagePrice",
    "prepayQuantity",
    "prepayPrice",
    "usageNotes",
    "isCancellable"
})
public class Properties_ {

    @JsonProperty("name")
    private Name name;
    @JsonProperty("partNumber")
    private PartNumber partNumber;
    @JsonProperty("grouping")
    private Grouping grouping;
    @JsonProperty("unitOfMeasureType")
    private UnitOfMeasureType unitOfMeasureType;
    @JsonProperty("usageQuantity")
    private UsageQuantity usageQuantity;
    @JsonProperty("overagePrice")
    private OveragePrice overagePrice;
    @JsonProperty("prepayQuantity")
    private PrepayQuantity prepayQuantity;
    @JsonProperty("prepayPrice")
    private PrepayPrice prepayPrice;
    @JsonProperty("usageNotes")
    private UsageNotes usageNotes;
    @JsonProperty("isCancellable")
    private IsCancellable isCancellable;

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    public Properties_ withName(Name name) {
        this.name = name;
        return this;
    }

    @JsonProperty("partNumber")
    public PartNumber getPartNumber() {
        return partNumber;
    }

    @JsonProperty("partNumber")
    public void setPartNumber(PartNumber partNumber) {
        this.partNumber = partNumber;
    }

    public Properties_ withPartNumber(PartNumber partNumber) {
        this.partNumber = partNumber;
        return this;
    }

    @JsonProperty("grouping")
    public Grouping getGrouping() {
        return grouping;
    }

    @JsonProperty("grouping")
    public void setGrouping(Grouping grouping) {
        this.grouping = grouping;
    }

    public Properties_ withGrouping(Grouping grouping) {
        this.grouping = grouping;
        return this;
    }

    @JsonProperty("unitOfMeasureType")
    public UnitOfMeasureType getUnitOfMeasureType() {
        return unitOfMeasureType;
    }

    @JsonProperty("unitOfMeasureType")
    public void setUnitOfMeasureType(UnitOfMeasureType unitOfMeasureType) {
        this.unitOfMeasureType = unitOfMeasureType;
    }

    public Properties_ withUnitOfMeasureType(UnitOfMeasureType unitOfMeasureType) {
        this.unitOfMeasureType = unitOfMeasureType;
        return this;
    }

    @JsonProperty("usageQuantity")
    public UsageQuantity getUsageQuantity() {
        return usageQuantity;
    }

    @JsonProperty("usageQuantity")
    public void setUsageQuantity(UsageQuantity usageQuantity) {
        this.usageQuantity = usageQuantity;
    }

    public Properties_ withUsageQuantity(UsageQuantity usageQuantity) {
        this.usageQuantity = usageQuantity;
        return this;
    }

    @JsonProperty("overagePrice")
    public OveragePrice getOveragePrice() {
        return overagePrice;
    }

    @JsonProperty("overagePrice")
    public void setOveragePrice(OveragePrice overagePrice) {
        this.overagePrice = overagePrice;
    }

    public Properties_ withOveragePrice(OveragePrice overagePrice) {
        this.overagePrice = overagePrice;
        return this;
    }

    @JsonProperty("prepayQuantity")
    public PrepayQuantity getPrepayQuantity() {
        return prepayQuantity;
    }

    @JsonProperty("prepayQuantity")
    public void setPrepayQuantity(PrepayQuantity prepayQuantity) {
        this.prepayQuantity = prepayQuantity;
    }

    public Properties_ withPrepayQuantity(PrepayQuantity prepayQuantity) {
        this.prepayQuantity = prepayQuantity;
        return this;
    }

    @JsonProperty("prepayPrice")
    public PrepayPrice getPrepayPrice() {
        return prepayPrice;
    }

    @JsonProperty("prepayPrice")
    public void setPrepayPrice(PrepayPrice prepayPrice) {
        this.prepayPrice = prepayPrice;
    }

    public Properties_ withPrepayPrice(PrepayPrice prepayPrice) {
        this.prepayPrice = prepayPrice;
        return this;
    }

    @JsonProperty("usageNotes")
    public UsageNotes getUsageNotes() {
        return usageNotes;
    }

    @JsonProperty("usageNotes")
    public void setUsageNotes(UsageNotes usageNotes) {
        this.usageNotes = usageNotes;
    }

    public Properties_ withUsageNotes(UsageNotes usageNotes) {
        this.usageNotes = usageNotes;
        return this;
    }

    @JsonProperty("isCancellable")
    public IsCancellable getIsCancellable() {
        return isCancellable;
    }

    @JsonProperty("isCancellable")
    public void setIsCancellable(IsCancellable isCancellable) {
        this.isCancellable = isCancellable;
    }

    public Properties_ withIsCancellable(IsCancellable isCancellable) {
        this.isCancellable = isCancellable;
        return this;
    }

}
