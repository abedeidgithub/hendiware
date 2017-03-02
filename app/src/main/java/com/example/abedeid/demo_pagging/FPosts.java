package com.example.abedeid.demo_pagging;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.abedeid.demo_pagging.adapter.PostsAdapter;
import com.example.abedeid.demo_pagging.model.Posts;
import com.example.abedeid.demo_pagging.webservices.WebService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FPosts extends Fragment {
    private final String TAG = "PostTAG";

    private PostsAdapter adapter;
    RecyclerView recycler_view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fposts, container, false);
        recycler_view = (RecyclerView) view.findViewById(R.id.recycler_view_posts);

        WebService.getInstance().getApi().getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                adapter=new PostsAdapter(response.body(),getContext());
                recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
                recycler_view.setItemAnimator(new DefaultItemAnimator());
                recycler_view.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


        return  view;
    }


}
