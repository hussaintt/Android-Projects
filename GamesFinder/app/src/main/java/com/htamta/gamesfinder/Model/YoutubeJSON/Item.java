
package com.htamta.gamesfinder.Model.YoutubeJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("id")
    @Expose
    private Id id;
    @SerializedName("snippet")
    @Expose
    private Snippet snippet;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Item withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Item withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Item withId(Id id) {
        this.id = id;
        return this;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public Item withSnippet(Snippet snippet) {
        this.snippet = snippet;
        return this;
    }

}
