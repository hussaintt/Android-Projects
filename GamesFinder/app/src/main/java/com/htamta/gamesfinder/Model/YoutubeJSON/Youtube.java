
package com.htamta.gamesfinder.Model.YoutubeJSON;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Youtube {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;
    @SerializedName("regionCode")
    @Expose
    private String regionCode;
    @SerializedName("pageInfo")
    @Expose
    private PageInfo pageInfo;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Youtube withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Youtube withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public Youtube withNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
        return this;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Youtube withRegionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Youtube withPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Youtube withItems(List<Item> items) {
        this.items = items;
        return this;
    }

}
