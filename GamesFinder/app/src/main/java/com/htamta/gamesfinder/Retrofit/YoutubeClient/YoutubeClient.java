package com.htamta.gamesfinder.Retrofit.YoutubeClient;


import android.util.Log;

import com.htamta.gamesfinder.Model.YoutubeJSON.Youtube;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class YoutubeClient {
    private static final String BASE_URL ="https://www.googleapis.com";
    private YoutubeApiInterface apiInterface;
    private static YoutubeClient Instance;
    private static final String KEY ="AIzaSyCeiSRuEAB9WqLI16rmUeybfFG1Dk4TUaw";
    private String part ="snippet";
    private String type = "video";
    private YoutubeClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
         apiInterface = retrofit.create(YoutubeApiInterface.class);
    }
    public static YoutubeClient getInstance(){
        if(Instance==null){
            Instance = new YoutubeClient();
        }
        return Instance;
    }
    public Single<Youtube> getYoutubeVideos(String GameName){
        String s = GameName + " gameplay";
        return  apiInterface.getDetail(part,s,type,KEY);
    }


}
