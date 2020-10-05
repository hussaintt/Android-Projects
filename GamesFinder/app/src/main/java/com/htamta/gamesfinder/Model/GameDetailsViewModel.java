package com.htamta.gamesfinder.Model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.htamta.gamesfinder.Model.GameDetailJSON.GameDetail;
import com.htamta.gamesfinder.Model.YoutubeJSON.Youtube;
import com.htamta.gamesfinder.Retrofit.RetrofitClient;
import com.htamta.gamesfinder.Retrofit.YoutubeClient.YoutubeClient;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GameDetailsViewModel extends ViewModel {
   public MutableLiveData<GameDetail> gameDetailMutableLiveData=new MutableLiveData<>();
   public MutableLiveData<Youtube> youtubeMutableLiveData=new MutableLiveData<>();
    public void getGamesDetails(int id){
        Single<GameDetail> observable = RetrofitClient.getInstance().gameDetailSingle(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        SingleObserver<GameDetail> observer = new SingleObserver<GameDetail>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onSuccess(GameDetail responseGames) {
                gameDetailMutableLiveData.setValue(responseGames);
            }
            @Override
            public void onError(Throwable e) {
                Log.i("GameDetailViewModel","the error is "+e);
            }
        };
        observable.subscribe(observer);
    }

    public void getYoutubeVideos(String q){
        Single<Youtube> observable = YoutubeClient.getInstance().getYoutubeVideos(q)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        SingleObserver<Youtube> observer = new SingleObserver<Youtube>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onSuccess(Youtube responseGames) {
                Log.i("zzz",responseGames.getItems().get(0).getSnippet().getTitle());
                youtubeMutableLiveData.setValue(responseGames);
            }
            @Override
            public void onError(Throwable e) {
                Log.i("GameDetailViewModel","the error is "+e);
            }
        };
        observable.subscribe(observer);
    }

}
