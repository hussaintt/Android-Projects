
package com.htamta.gamesfinder.Model.GameDetailJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tag {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("games_count")
    @Expose
    private Integer gamesCount;
    @SerializedName("image_background")
    @Expose
    private String imageBackground;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tag withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag withName(String name) {
        this.name = name;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Tag withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Tag withLanguage(String language) {
        this.language = language;
        return this;
    }

    public Integer getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(Integer gamesCount) {
        this.gamesCount = gamesCount;
    }

    public Tag withGamesCount(Integer gamesCount) {
        this.gamesCount = gamesCount;
        return this;
    }

    public String getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
    }

    public Tag withImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
        return this;
    }

}
