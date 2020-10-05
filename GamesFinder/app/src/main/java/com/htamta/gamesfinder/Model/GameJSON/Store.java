
package com.htamta.gamesfinder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Store {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("store")
    @Expose
    private Store_ store;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Store withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Store withUrl(String url) {
        this.url = url;
        return this;
    }

    public Store_ getStore() {
        return store;
    }

    public void setStore(Store_ store) {
        this.store = store;
    }

    public Store withStore(Store_ store) {
        this.store = store;
        return this;
    }

}
