
package com.htamta.gamesfinder.Model.GameJSON;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("playtime")
    @Expose
    private Integer playtime;
    @SerializedName("platforms")
    @Expose
    private List<Platform> platforms = null;
    @SerializedName("stores")
    @Expose
    private Object stores;
    @SerializedName("released")
    @Expose
    private String released;
    @SerializedName("tba")
    @Expose
    private Boolean tba;
    @SerializedName("background_image")
    @Expose
    private String backgroundImage;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("rating_top")
    @Expose
    private Integer ratingTop;
    @SerializedName("ratings")
    @Expose
    private List<Rating> ratings = null;
    @SerializedName("ratings_count")
    @Expose
    private Integer ratingsCount;
    @SerializedName("reviews_text_count")
    @Expose
    private Integer reviewsTextCount;
    @SerializedName("added")
    @Expose
    private Integer added;
    @SerializedName("added_by_status")
    @Expose
    private AddedByStatus addedByStatus;
    @SerializedName("metacritic")
    @Expose
    private Object metacritic;
    @SerializedName("suggestions_count")
    @Expose
    private Integer suggestionsCount;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("clip")
    @Expose
    private Object clip;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = null;
    @SerializedName("user_game")
    @Expose
    private Object userGame;
    @SerializedName("reviews_count")
    @Expose
    private Integer reviewsCount;
    @SerializedName("community_rating")
    @Expose
    private Integer communityRating;
    @SerializedName("saturated_color")
    @Expose
    private String saturatedColor;
    @SerializedName("dominant_color")
    @Expose
    private String dominantColor;
    @SerializedName("short_screenshots")
    @Expose
    private List<ShortScreenshot> shortScreenshots = null;
    @SerializedName("parent_platforms")
    @Expose
    private List<ParentPlatform> parentPlatforms = null;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Result withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Result withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPlaytime() {
        return playtime;
    }

    public void setPlaytime(Integer playtime) {
        this.playtime = playtime;
    }

    public Result withPlaytime(Integer playtime) {
        this.playtime = playtime;
        return this;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public Result withPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
        return this;
    }

    public Object getStores() {
        return stores;
    }

    public void setStores(Object stores) {
        this.stores = stores;
    }

    public Result withStores(Object stores) {
        this.stores = stores;
        return this;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public Result withReleased(String released) {
        this.released = released;
        return this;
    }

    public Boolean getTba() {
        return tba;
    }

    public void setTba(Boolean tba) {
        this.tba = tba;
    }

    public Result withTba(Boolean tba) {
        this.tba = tba;
        return this;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public Result withBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Result withRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public Integer getRatingTop() {
        return ratingTop;
    }

    public void setRatingTop(Integer ratingTop) {
        this.ratingTop = ratingTop;
    }

    public Result withRatingTop(Integer ratingTop) {
        this.ratingTop = ratingTop;
        return this;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Result withRatings(List<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public Result withRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
        return this;
    }

    public Integer getReviewsTextCount() {
        return reviewsTextCount;
    }

    public void setReviewsTextCount(Integer reviewsTextCount) {
        this.reviewsTextCount = reviewsTextCount;
    }

    public Result withReviewsTextCount(Integer reviewsTextCount) {
        this.reviewsTextCount = reviewsTextCount;
        return this;
    }

    public Integer getAdded() {
        return added;
    }

    public void setAdded(Integer added) {
        this.added = added;
    }

    public Result withAdded(Integer added) {
        this.added = added;
        return this;
    }

    public AddedByStatus getAddedByStatus() {
        return addedByStatus;
    }

    public void setAddedByStatus(AddedByStatus addedByStatus) {
        this.addedByStatus = addedByStatus;
    }

    public Result withAddedByStatus(AddedByStatus addedByStatus) {
        this.addedByStatus = addedByStatus;
        return this;
    }

    public Object getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(Object metacritic) {
        this.metacritic = metacritic;
    }

    public Result withMetacritic(Object metacritic) {
        this.metacritic = metacritic;
        return this;
    }

    public Integer getSuggestionsCount() {
        return suggestionsCount;
    }

    public void setSuggestionsCount(Integer suggestionsCount) {
        this.suggestionsCount = suggestionsCount;
    }

    public Result withSuggestionsCount(Integer suggestionsCount) {
        this.suggestionsCount = suggestionsCount;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Result withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Result withScore(String score) {
        this.score = score;
        return this;
    }

    public Object getClip() {
        return clip;
    }

    public void setClip(Object clip) {
        this.clip = clip;
    }

    public Result withClip(Object clip) {
        this.clip = clip;
        return this;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Result withTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public Object getUserGame() {
        return userGame;
    }

    public void setUserGame(Object userGame) {
        this.userGame = userGame;
    }

    public Result withUserGame(Object userGame) {
        this.userGame = userGame;
        return this;
    }

    public Integer getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public Result withReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
        return this;
    }

    public Integer getCommunityRating() {
        return communityRating;
    }

    public void setCommunityRating(Integer communityRating) {
        this.communityRating = communityRating;
    }

    public Result withCommunityRating(Integer communityRating) {
        this.communityRating = communityRating;
        return this;
    }

    public String getSaturatedColor() {
        return saturatedColor;
    }

    public void setSaturatedColor(String saturatedColor) {
        this.saturatedColor = saturatedColor;
    }

    public Result withSaturatedColor(String saturatedColor) {
        this.saturatedColor = saturatedColor;
        return this;
    }

    public String getDominantColor() {
        return dominantColor;
    }

    public void setDominantColor(String dominantColor) {
        this.dominantColor = dominantColor;
    }

    public Result withDominantColor(String dominantColor) {
        this.dominantColor = dominantColor;
        return this;
    }

    public List<ShortScreenshot> getShortScreenshots() {
        return shortScreenshots;
    }

    public void setShortScreenshots(List<ShortScreenshot> shortScreenshots) {
        this.shortScreenshots = shortScreenshots;
    }

    public Result withShortScreenshots(List<ShortScreenshot> shortScreenshots) {
        this.shortScreenshots = shortScreenshots;
        return this;
    }

    public List<ParentPlatform> getParentPlatforms() {
        return parentPlatforms;
    }

    public void setParentPlatforms(List<ParentPlatform> parentPlatforms) {
        this.parentPlatforms = parentPlatforms;
    }

    public Result withParentPlatforms(List<ParentPlatform> parentPlatforms) {
        this.parentPlatforms = parentPlatforms;
        return this;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Result withGenres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

}
