package com.htamta.gamesfinder.Model;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.htamta.gamesfinder.Model.GameDetailJSON.GameDetail;
import com.htamta.gamesfinder.Model.GameJSON.ResponseGames;
import com.htamta.gamesfinder.Retrofit.RetrofitClient;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GameViewModel extends ViewModel {
   public MutableLiveData<ResponseGames> gamesMutableLiveData = new MutableLiveData<>();

    public void getGames(String order,String platform,String Genre,String PageNumber){
       Single<ResponseGames> observable = RetrofitClient.getInstance().getGames(order,platform,Genre,PageNumber)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());
        MySingleObserver(observable);
    }
    public void getSearchResults(String s,String PageNumber){
        Observable<ResponseGames> observable = RetrofitClient.getInstance().getSeachGames(s,PageNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<ResponseGames> observer = new Observer<ResponseGames>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onNext(ResponseGames responseGames) {
                gamesMutableLiveData.setValue(responseGames);
            }
            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };
        observable.subscribe(observer);
    }


    private void MySingleObserver(Single<ResponseGames> observable) {
        SingleObserver<ResponseGames> observer = new SingleObserver<ResponseGames>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onSuccess(ResponseGames responseGames) {
                gamesMutableLiveData.setValue(responseGames);
            }
            @Override
            public void onError(Throwable e) {
                Log.i("GameViewModel","the error is "+e);
            }

        };
        observable.subscribe(observer);
    }
}
