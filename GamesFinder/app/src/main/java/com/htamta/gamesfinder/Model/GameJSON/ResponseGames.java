
package com.htamta.gamesfinder.Model.GameJSON;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseGames {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("previous")
    @Expose
    private String previous;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("user_platforms")
    @Expose
    private Boolean userPlatforms;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ResponseGames withCount(Integer count) {
        this.count = count;
        return this;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public ResponseGames withNext(String next) {
        this.next = next;
        return this;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ResponseGames withPrevious(String previous) {
        this.previous = previous;
        return this;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public ResponseGames withResults(List<Result> results) {
        this.results = results;
        return this;
    }

    public Boolean getUserPlatforms() {
        return userPlatforms;
    }

    public void setUserPlatforms(Boolean userPlatforms) {
        this.userPlatforms = userPlatforms;
    }

    public ResponseGames withUserPlatforms(Boolean userPlatforms) {
        this.userPlatforms = userPlatforms;
        return this;
    }

}
