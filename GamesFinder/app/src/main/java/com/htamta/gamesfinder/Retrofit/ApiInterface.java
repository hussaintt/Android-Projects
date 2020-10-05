package com.htamta.gamesfinder.Retrofit;

import com.htamta.gamesfinder.Model.GameDetailJSON.GameDetail;
import com.htamta.gamesfinder.Model.GameJSON.ResponseGames;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/games")
    public Single<ResponseGames> getGames(@Query("dates")String mainquery, @Query("ordering")
            String ordering, @Query("parent_platforms") String platforms,@Query("genres")String Genre,@Query("page") String PageNumber);

    @GET("/api/games")
    public Observable<ResponseGames> search(@Query("search") String searchText,@Query("page") String PageNumber);

    @GET("/api/games/{id}")
    public Single<GameDetail> getDetail(@Path("id")int id);

}
