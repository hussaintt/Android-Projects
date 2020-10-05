
package com.htamta.gamesfinder.Model.GameDetailJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddedByStatus {

    @SerializedName("yet")
    @Expose
    private Integer yet;
    @SerializedName("owned")
    @Expose
    private Integer owned;
    @SerializedName("beaten")
    @Expose
    private Integer beaten;
    @SerializedName("toplay")
    @Expose
    private Integer toplay;
    @SerializedName("dropped")
    @Expose
    private Integer dropped;
    @SerializedName("playing")
    @Expose
    private Integer playing;

    public Integer getYet() {
        return yet;
    }

    public void setYet(Integer yet) {
        this.yet = yet;
    }

    public AddedByStatus withYet(Integer yet) {
        this.yet = yet;
        return this;
    }

    public Integer getOwned() {
        return owned;
    }

    public void setOwned(Integer owned) {
        this.owned = owned;
    }

    public AddedByStatus withOwned(Integer owned) {
        this.owned = owned;
        return this;
    }

    public Integer getBeaten() {
        return beaten;
    }

    public void setBeaten(Integer beaten) {
        this.beaten = beaten;
    }

    public AddedByStatus withBeaten(Integer beaten) {
        this.beaten = beaten;
        return this;
    }

    public Integer getToplay() {
        return toplay;
    }

    public void setToplay(Integer toplay) {
        this.toplay = toplay;
    }

    public AddedByStatus withToplay(Integer toplay) {
        this.toplay = toplay;
        return this;
    }

    public Integer getDropped() {
        return dropped;
    }

    public void setDropped(Integer dropped) {
        this.dropped = dropped;
    }

    public AddedByStatus withDropped(Integer dropped) {
        this.dropped = dropped;
        return this;
    }

    public Integer getPlaying() {
        return playing;
    }

    public void setPlaying(Integer playing) {
        this.playing = playing;
    }

    public AddedByStatus withPlaying(Integer playing) {
        this.playing = playing;
        return this;
    }

}
