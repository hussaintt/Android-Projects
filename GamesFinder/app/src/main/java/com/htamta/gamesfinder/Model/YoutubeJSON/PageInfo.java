
package com.htamta.gamesfinder.Model.YoutubeJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageInfo {

    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("resultsPerPage")
    @Expose
    private Integer resultsPerPage;

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public PageInfo withTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    public Integer getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    public PageInfo withResultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
        return this;
    }

}
