package com.htamta.gamesfinder.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.htamta.gamesfinder.Model.GameDataBrain;
import com.htamta.gamesfinder.Model.GameDetailsViewModel;
import com.htamta.gamesfinder.Model.YoutubeJSON.Item;
import com.htamta.gamesfinder.R;
import com.htamta.gamesfinder.adapters.YoutubeVideosRecycler;
import com.htamta.gamesfinder.databinding.ActivityGameDetailBinding;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class GameDetailActivity extends AppCompatActivity implements YoutubeVideosRecycler.ListItemClickListener {
    SimpleExoPlayerView exoPlayerView;
    SimpleExoPlayer exoPlayer;
    private GameDetailsViewModel viewModel;
    private ActivityGameDetailBinding b;
    String videoURL="";
    String YoutubeBASE_URL="https://www.youtube.com/watch?v=";
    List<Item> youtubeList=new ArrayList<>();
    List<String>Platforms =new ArrayList<>();
    List<String>Geners=new ArrayList<>();
    List<String>Developers=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this,R.layout.activity_game_detail);
        exoPlayerView=b.imageView2;
        viewModel = ViewModelProviders.of(this).get(GameDetailsViewModel.class);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        viewModel.getGamesDetails(id);
        viewModel.gameDetailMutableLiveData.observe(this,game ->{
            if(game.getClip()!=null){
                b.imageView3.setVisibility(View.INVISIBLE);
            videoURL=game.getClip().getClip();
            }else {
                b.imageView2.setVisibility(View.INVISIBLE);
                Picasso.get().load(game.getBackgroundImage()).into(b.imageView3);
            }
            b.GameName.setText(game.getName());
            b.About.setText(game.getDescriptionRaw());
            b.Rating.setText(String.valueOf(game.getRating()));
            String avg = "AVERAGE PLAYTIME: "+game.getPlaytime()+" HOURS";
            b.playingTime.setText(avg);
            b.Release.setText(game.getReleased());
            game.getPlatforms().iterator().forEachRemaining(platform__ -> {Platforms.add(platform__.getPlatform().getName());});
            game.getGenres().iterator().forEachRemaining(Genre->{ Geners.add(Genre.getName());});
            game.getDevelopers().iterator().forEachRemaining(Developer->{Developers.add(Developer.getName());});
            b.Genre.setText(Geners.toString());
            b.Developer.setText(Developers.toString());
            b.Platforms.setText(Platforms.toString());
            GameDataBrain brain = new GameDataBrain();
            brain.setPlatforms(b.pc,b.xbox,b.ps,game.getParentPlatforms());
            brain.setDate(game.getReleased(),b.GameDate);
            brain.setRatings(game.getRatings(),b.Recom,b.meh,b.Skip,b.exc,b.total);
            brain.setColorRingForRatings(b.ring,game.getRating());
            initializePlayer2();
            viewModel.getYoutubeVideos(game.getName());
        } );

        viewModel.youtubeMutableLiveData.observe(this,youtube -> {
            youtubeList=youtube.getItems();
            setRecyclerView();
        });
    }

    private void initializePlayer2(){
        try {
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
            Uri videoURI = Uri.parse(videoURL);
            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource mediaSource = new ExtractorMediaSource(videoURI, dataSourceFactory, extractorsFactory, null, null);
            exoPlayerView.setPlayer(exoPlayer);
            exoPlayer.prepare(mediaSource);
            exoPlayer.setPlayWhenReady(true);
        }catch (Exception e){
            Log.e("MainAcvtivity"," exoplayer error "+ e.toString());
        }
    }

    private void setRecyclerView() {
        b.YoutubeRecycler.setHasFixedSize(true);
        b.YoutubeRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        YoutubeVideosRecycler myadb = new YoutubeVideosRecycler(this, youtubeList.size(), youtubeList);
        b.YoutubeRecycler.setAdapter(myadb);
    }
    @Override
    protected void onPause() {
        super.onPause();
        exoPlayer.stop();
    }

    @Override
    public void onClickListener(int clickedItemIndex) { getMyVideo(clickedItemIndex);}

    public void getMyVideo(int i){
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String link = YoutubeBASE_URL+youtubeList.get(i).getId().getVideoId();
        intent.setData(Uri.parse(link));
        startActivity(intent);
    }
}
