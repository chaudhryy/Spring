
package nz.co.spark.intg.ocp.utility.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "entities",
    "pageSize",
    "pageNumber",
    "total",
    "firstUri",
    "selfUri",
    "previousUri",
    "nextUri",
    "lastUri",
    "pageCount"
})
public class Properties_______ {

    @JsonProperty("entities")
    private Entities entities;
    @JsonProperty("pageSize")
    private PageSize pageSize;
    @JsonProperty("pageNumber")
    private PageNumber pageNumber;
    @JsonProperty("total")
    private Total total;
    @JsonProperty("firstUri")
    private FirstUri firstUri;
    @JsonProperty("selfUri")
    private SelfUri__ selfUri;
    @JsonProperty("previousUri")
    private PreviousUri previousUri;
    @JsonProperty("nextUri")
    private NextUri nextUri;
    @JsonProperty("lastUri")
    private LastUri lastUri;
    @JsonProperty("pageCount")
    private PageCount pageCount;

    @JsonProperty("entities")
    public Entities getEntities() {
        return entities;
    }

    @JsonProperty("entities")
    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public Properties_______ withEntities(Entities entities) {
        this.entities = entities;
        return this;
    }

    @JsonProperty("pageSize")
    public PageSize getPageSize() {
        return pageSize;
    }

    @JsonProperty("pageSize")
    public void setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    public Properties_______ withPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @JsonProperty("pageNumber")
    public PageNumber getPageNumber() {
        return pageNumber;
    }

    @JsonProperty("pageNumber")
    public void setPageNumber(PageNumber pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Properties_______ withPageNumber(PageNumber pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    @JsonProperty("total")
    public Total getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Total total) {
        this.total = total;
    }

    public Properties_______ withTotal(Total total) {
        this.total = total;
        return this;
    }

    @JsonProperty("firstUri")
    public FirstUri getFirstUri() {
        return firstUri;
    }

    @JsonProperty("firstUri")
    public void setFirstUri(FirstUri firstUri) {
        this.firstUri = firstUri;
    }

    public Properties_______ withFirstUri(FirstUri firstUri) {
        this.firstUri = firstUri;
        return this;
    }

    @JsonProperty("selfUri")
    public SelfUri__ getSelfUri() {
        return selfUri;
    }

    @JsonProperty("selfUri")
    public void setSelfUri(SelfUri__ selfUri) {
        this.selfUri = selfUri;
    }

    public Properties_______ withSelfUri(SelfUri__ selfUri) {
        this.selfUri = selfUri;
        return this;
    }

    @JsonProperty("previousUri")
    public PreviousUri getPreviousUri() {
        return previousUri;
    }

    @JsonProperty("previousUri")
    public void setPreviousUri(PreviousUri previousUri) {
        this.previousUri = previousUri;
    }

    public Properties_______ withPreviousUri(PreviousUri previousUri) {
        this.previousUri = previousUri;
        return this;
    }

    @JsonProperty("nextUri")
    public NextUri getNextUri() {
        return nextUri;
    }

    @JsonProperty("nextUri")
    public void setNextUri(NextUri nextUri) {
        this.nextUri = nextUri;
    }

    public Properties_______ withNextUri(NextUri nextUri) {
        this.nextUri = nextUri;
        return this;
    }

    @JsonProperty("lastUri")
    public LastUri getLastUri() {
        return lastUri;
    }

    @JsonProperty("lastUri")
    public void setLastUri(LastUri lastUri) {
        this.lastUri = lastUri;
    }

    public Properties_______ withLastUri(LastUri lastUri) {
        this.lastUri = lastUri;
        return this;
    }

    @JsonProperty("pageCount")
    public PageCount getPageCount() {
        return pageCount;
    }

    @JsonProperty("pageCount")
    public void setPageCount(PageCount pageCount) {
        this.pageCount = pageCount;
    }

    public Properties_______ withPageCount(PageCount pageCount) {
        this.pageCount = pageCount;
        return this;
    }

}
