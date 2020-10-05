
package com.htamta.gamesfinder.Model.GameJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShortScreenshot {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ShortScreenshot withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ShortScreenshot withImage(String image) {
        this.image = image;
        return this;
    }

}
