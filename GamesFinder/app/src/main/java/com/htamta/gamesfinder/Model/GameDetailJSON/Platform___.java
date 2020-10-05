
package com.htamta.gamesfinder.Model.GameDetailJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Platform___ {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("year_end")
    @Expose
    private Object yearEnd;
    @SerializedName("year_start")
    @Expose
    private Object yearStart;
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

    public Platform___ withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Platform___ withName(String name) {
        this.name = name;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Platform___ withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public Platform___ withImage(Object image) {
        this.image = image;
        return this;
    }

    public Object getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(Object yearEnd) {
        this.yearEnd = yearEnd;
    }

    public Platform___ withYearEnd(Object yearEnd) {
        this.yearEnd = yearEnd;
        return this;
    }

    public Object getYearStart() {
        return yearStart;
    }

    public void setYearStart(Object yearStart) {
        this.yearStart = yearStart;
    }

    public Platform___ withYearStart(Object yearStart) {
        this.yearStart = yearStart;
        return this;
    }

    public Integer getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(Integer gamesCount) {
        this.gamesCount = gamesCount;
    }

    public Platform___ withGamesCount(Integer gamesCount) {
        this.gamesCount = gamesCount;
        return this;
    }

    public String getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
    }

    public Platform___ withImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
        return this;
    }

}
