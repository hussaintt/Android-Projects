
package com.htamta.gamesfinder.Model.GameDetailJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genre {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
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

    public Genre withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre withName(String name) {
        this.name = name;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Genre withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public Integer getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(Integer gamesCount) {
        this.gamesCount = gamesCount;
    }

    public Genre withGamesCount(Integer gamesCount) {
        this.gamesCount = gamesCount;
        return this;
    }

    public String getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
    }

    public Genre withImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
        return this;
    }

}
