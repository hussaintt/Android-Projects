
package com.htamta.gamesfinder.Model.GameJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParentPlatform {

    @SerializedName("platform")
    @Expose
    private Platform__ platform;

    public Platform__ getPlatform() {
        return platform;
    }

    public void setPlatform(Platform__ platform) {
        this.platform = platform;
    }

    public ParentPlatform withPlatform(Platform__ platform) {
        this.platform = platform;
        return this;
    }

}
