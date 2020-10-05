
package com.htamta.gamesfinder.Model.GameJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("percent")
    @Expose
    private Double percent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rating withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Rating withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Rating withCount(Integer count) {
        this.count = count;
        return this;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Rating withPercent(Double percent) {
        this.percent = percent;
        return this;
    }

}
