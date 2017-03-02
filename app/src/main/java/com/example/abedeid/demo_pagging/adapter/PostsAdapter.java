package com.example.abedeid.demo_pagging.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.abedeid.demo_pagging.R;
import com.example.abedeid.demo_pagging.model.Posts;

import java.util.List;

/**
 * Created by abed_eid on 10/12/2016.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {


    List<Posts> postList;
    Context context;

    public PostsAdapter(List<Posts> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Posts CurrentPost = postList.get(position);
        holder.post_txt.setText(CurrentPost.post_txt);
        holder.writer_post_name.setText(CurrentPost.name);


    }

    @Override
    public int getItemCount() {
        return postList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView writer_post_name, writer_post_time, post_txt, comment_number;
        ImageView image_post;
        CardView post_card;

        public MyViewHolder(View itemView) {
            super(itemView);
            writer_post_name = (TextView) itemView.findViewById(R.id.writer_post_name);
            post_txt = (TextView) itemView.findViewById(R.id.post_txt);
            post_card = (CardView) itemView.findViewById(R.id.post_card);

        }
    }
}
