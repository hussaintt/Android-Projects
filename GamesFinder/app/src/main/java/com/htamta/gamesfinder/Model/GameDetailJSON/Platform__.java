
package com.htamta.gamesfinder.Model.GameDetailJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Platform__ {

    @SerializedName("platform")
    @Expose
    private Platform___ platform;
    @SerializedName("released_at")
    @Expose
    private String releasedAt;
    @SerializedName("requirements")
    @Expose
    private Object requirements;

    public Platform___ getPlatform() {
        return platform;
    }

    public void setPlatform(Platform___ platform) {
        this.platform = platform;
    }

    public Platform__ withPlatform(Platform___ platform) {
        this.platform = platform;
        return this;
    }

    public String getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(String releasedAt) {
        this.releasedAt = releasedAt;
    }

    public Platform__ withReleasedAt(String releasedAt) {
        this.releasedAt = releasedAt;
        return this;
    }

    public Object getRequirements() {
        return requirements;
    }

    public void setRequirements(Object requirements) {
        this.requirements = requirements;
    }

    public Platform__ withRequirements(Object requirements) {
        this.requirements = requirements;
        return this;
    }

}
