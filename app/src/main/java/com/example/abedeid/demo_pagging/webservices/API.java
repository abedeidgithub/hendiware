package com.example.abedeid.demo_pagging.webservices;


import com.example.abedeid.demo_pagging.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by abed_eid on 08/12/2016.
 */

public interface API {







    @POST("pagging.php")
    Call<List<Posts>> getPosts();



}
