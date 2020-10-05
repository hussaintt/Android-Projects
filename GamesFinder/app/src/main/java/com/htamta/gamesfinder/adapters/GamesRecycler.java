package com.htamta.gamesfinder.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.htamta.gamesfinder.Model.GameDataBrain;
import com.htamta.gamesfinder.Model.GameJSON.Result;
import com.htamta.gamesfinder.R;
import java.util.List;


public class GamesRecycler extends RecyclerView.Adapter<GamesRecycler.viewHolder> {
    final ListItemClickListener mOnClick;
    private int itemCount;
    private List<Result> ResponseGamesList;
    public GamesRecycler(ListItemClickListener listener, int list, List<Result> my) {
        mOnClick = (ListItemClickListener) listener;
        itemCount = list;
        ResponseGamesList = my;

    }


    public interface ListItemClickListener {
        void onClickListener(int clickedItemIndex);
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int LayoutListItem = R.layout.games_recycler;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(LayoutListItem, viewGroup, false);
        viewHolder ViewHolder = new viewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(viewHolder viewHolder, int i) {
        viewHolder.bind(i);
    }


    @Override
    public int getItemCount() {
        return itemCount;
    }

    class viewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView num;
        ImageView link;
        ImageView ps;
        ImageView xbox;
        ImageView pc;
        TextView Date;
        TextView genre;

        viewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            num=itemView.findViewById(R.id.GameName);
            link=itemView.findViewById(R.id.link);
            ps=itemView.findViewById(R.id.ps);
            xbox=itemView.findViewById(R.id.xbox);
            pc=itemView.findViewById(R.id.pc);
            Date=itemView.findViewById(R.id.Date);
            genre=itemView.findViewById(R.id.genres);
        }


        void bind(final int possition) {
            num.setText(String.valueOf(ResponseGamesList.get(possition).getName()));
            setImage(possition);
            GameDataBrain b =new GameDataBrain();
            b.setGenre(ResponseGamesList.get(possition).getGenres(),genre);
            b.setPlatforms(pc,xbox,ps,ResponseGamesList.get(possition).getParentPlatforms());
            b.setDate(ResponseGamesList.get(possition).getReleased(),Date);
        }


        private void setImage(int possition) {
            if(ResponseGamesList.get(possition).getBackgroundImage()!=null){
            RequestOptions requestOptions = new RequestOptions();
            requestOptions = requestOptions.transform(new CenterCrop(), new RoundedCorners(40));
            Glide.with(itemView)
                    .load(ResponseGamesList.get(possition).getBackgroundImage())
                    .centerCrop()
                    .apply(requestOptions)
                    .into(link);
            }
        }

        @Override
        public void onClick(View view) {
            int getPossition = getAdapterPosition();
            mOnClick.onClickListener(getPossition);
        }

    }


}
