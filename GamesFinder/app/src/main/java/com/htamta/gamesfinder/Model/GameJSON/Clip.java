
package com.htamta.gamesfinder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clip {

    @SerializedName("clip")
    @Expose
    private String clip;
    @SerializedName("clips")
    @Expose
    private Clips clips;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("preview")
    @Expose
    private String preview;

    public String getClip() {
        return clip;
    }

    public void setClip(String clip) {
        this.clip = clip;
    }

    public Clip withClip(String clip) {
        this.clip = clip;
        return this;
    }

    public Clips getClips() {
        return clips;
    }

    public void setClips(Clips clips) {
        this.clips = clips;
    }

    public Clip withClips(Clips clips) {
        this.clips = clips;
        return this;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Clip withVideo(String video) {
        this.video = video;
        return this;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Clip withPreview(String preview) {
        this.preview = preview;
        return this;
    }

}
