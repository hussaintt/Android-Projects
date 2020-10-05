package com.htamta.gamesfinder.Retrofit;

import com.htamta.gamesfinder.Model.GameDetailJSON.GameDetail;
import com.htamta.gamesfinder.Model.GameJSON.ResponseGames;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL ="https://api.rawg.io/";
    private ApiInterface apiInterface;
    private static RetrofitClient Instance;
    private static final String DATE_FORMAT_3 = "yyy-MM-dd";
    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat(DATE_FORMAT_3);
    private String d = simpleDateFormat.format(Calendar.getInstance().getTime());
    private String Mainquery= "2008-01-01,"+d;

    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
         apiInterface = retrofit.create(ApiInterface.class);
    }

    public static RetrofitClient getInstance(){
        if(Instance==null){
            Instance = new RetrofitClient();
        }
        return Instance;
    }

    public Single<ResponseGames> getGames(String ordering,String platform,String genre,String PageNumber){
        return  apiInterface.getGames(Mainquery,ordering,platform,genre,PageNumber);
    }

    public Single<GameDetail> gameDetailSingle(int Id){
        return  apiInterface.getDetail(Id);
    }
    public Observable<ResponseGames> getSeachGames(String s,String Page){return apiInterface.search(s,Page);}


}
