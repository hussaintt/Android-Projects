package com.htamta.gamesfinder.Retrofit.YoutubeClient;

import com.htamta.gamesfinder.Model.GameDetailJSON.GameDetail;
import com.htamta.gamesfinder.Model.GameJSON.ResponseGames;
import com.htamta.gamesfinder.Model.YoutubeJSON.Youtube;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface YoutubeApiInterface {



    @GET("/youtube/v3/search")
    public Single<Youtube> getDetail(@Query("part") String part, @Query("q") String q, @Query("type")
                                        String type, @Query("key") String key);

}
