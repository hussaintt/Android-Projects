package com.htamta.gamesfinder.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.htamta.gamesfinder.Model.YoutubeJSON.Item;
import com.htamta.gamesfinder.Model.YoutubeJSON.Youtube;
import com.htamta.gamesfinder.R;
import com.squareup.picasso.Picasso;


import java.util.List;

public class YoutubeVideosRecycler extends RecyclerView.Adapter<YoutubeVideosRecycler.numOfViewHolder> {
    final ListItemClickListener mOnClick;
    private int  itemCount;
    private List<Item> myMovie;

    public YoutubeVideosRecycler(YoutubeVideosRecycler.ListItemClickListener listener, int list, List<Item> my) {
        mOnClick = (ListItemClickListener) listener;
        itemCount = list;
        myMovie = my;
    }

    public interface ListItemClickListener{
        void onClickListener(int clickedItemIndex);
    }
    @Override
    public numOfViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int LayoutListItem = R.layout.recycler_view_adapter_trailer;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(LayoutListItem, viewGroup, false);
        numOfViewHolder ViewHolder = new numOfViewHolder(view);
        return ViewHolder;
    }
    @Override
    public void onBindViewHolder(numOfViewHolder numOfViewHolder, int i) {
        numOfViewHolder.bind(i);
    }
    @Override
    public int getItemCount() {
        return itemCount;
    }
    class numOfViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        TextView text;
        ImageView image;

        public numOfViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textView);
            image = (ImageView) itemView.findViewById(R.id.imageView2);
            itemView.setOnClickListener(this);
        }
        public void bind(int possition) {
            text.setText(myMovie.get(possition).getSnippet().getTitle());
            Picasso.get().load(myMovie.get(possition).getSnippet().getThumbnails().getHigh().getUrl()).into(image);
        }

        @Override
        public void onClick(View view) {
            int getPossition=getAdapterPosition();
            mOnClick.onClickListener(getPossition);
        }
    }


}
