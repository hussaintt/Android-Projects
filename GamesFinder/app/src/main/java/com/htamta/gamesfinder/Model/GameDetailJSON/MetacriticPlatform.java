
package com.htamta.gamesfinder.Model.GameDetailJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetacriticPlatform {

    @SerializedName("metascore")
    @Expose
    private Integer metascore;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("platform")
    @Expose
    private Platform platform;

    public Integer getMetascore() {
        return metascore;
    }

    public void setMetascore(Integer metascore) {
        this.metascore = metascore;
    }

    public MetacriticPlatform withMetascore(Integer metascore) {
        this.metascore = metascore;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MetacriticPlatform withUrl(String url) {
        this.url = url;
        return this;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public MetacriticPlatform withPlatform(Platform platform) {
        this.platform = platform;
        return this;
    }

}
