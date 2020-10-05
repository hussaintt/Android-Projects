package com.htamta.gamesfinder.Model;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.htamta.gamesfinder.Model.GameDetailJSON.Rating;
import com.htamta.gamesfinder.Model.GameJSON.Genre;
import com.htamta.gamesfinder.Model.GameJSON.ParentPlatform;
import com.htamta.gamesfinder.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GameDataBrain {
    public static final String DATE_FORMAT_3 = "yyy-MM-dd";
    List<String> genresString = new ArrayList<>();
    List<String> platforms = new ArrayList<>();
    SimpleDateFormat simpleDateFormat;
    private int TotalRatings;

    public GameDataBrain() {
        simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_3);
    }

    public void setPlatforms(ImageView pc, ImageView xbox, ImageView ps, List<ParentPlatform> parentPlatforms) {
        platforms.clear();
        if (parentPlatforms != null) {
            for (ParentPlatform p : parentPlatforms) {
                platforms.add(p.getPlatform().getName());
            }
        }
        if (!platforms.contains("PC")) {
            pc.setVisibility(View.GONE);
        }
        if (!platforms.contains("PlayStation")) {
            ps.setVisibility(View.GONE);
        }
        if (!platforms.contains("Xbox")) {
            xbox.setVisibility(View.GONE);
        }
    }

    public void setGenre(List<Genre> genres, TextView genre) {
        genresString.clear();
        for (Genre g : genres) {
            genresString.add(g.getName());
        }
        String text = genresString.toString().replace("[", "").replace("]", "");
        genre.setText(text);
    }

    public void setDate(String releaseDate, TextView Date) {
        if (releaseDate != null) {
            try {
                java.util.Date d = simpleDateFormat.parse(releaseDate);
                DateFormat pstFormat = new SimpleDateFormat("MMM-yyyy");
                Date.setText(pstFormat.format(d));
            } catch (ParseException ex) {
                Log.v("Exception", ex.getLocalizedMessage());
            }
        }
    }

    public void setRatings(List<Rating> ratings, TextView recom, TextView meh, TextView skip, TextView exc, TextView total) {
        for (Rating r : ratings) {
            switch (r.getTitle()) {
                case "exceptional":
                    exc.setText(String.valueOf(r.getCount()));
                    TotalRatings += r.getCount();
                case "recommended":
                    recom.setText(String.valueOf(r.getCount()));
                    TotalRatings += r.getCount();
                case "meh":
                    meh.setText(String.valueOf(r.getCount()));
                    TotalRatings += r.getCount();
                case "skip":
                    skip.setText(String.valueOf(r.getCount()));
                    TotalRatings += r.getCount();
            }
        }
        String totalR = "Total Ratings: " + TotalRatings;
        total.setText(totalR);
    }

    public void setColorRingForRatings(ImageView ring,Double rate){
        if (rate>4){
            ring.setBackgroundResource(R.drawable.circle_rating_green);
        }
        if(rate <4 && rate >2.9){
            ring.setBackgroundResource(R.drawable.circle_rating_yellow);
        }
        if (rate<3){
            ring.setBackgroundResource(R.drawable.circle_rating_red);
        }
    }
}
