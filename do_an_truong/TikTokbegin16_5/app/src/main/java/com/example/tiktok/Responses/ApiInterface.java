package com.example.tiktok.Responses;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    /////geting all posts////
    @GET("posts.php")
    Call<Users> performAllPosts();
    /////geting all sounds////
    @GET("sounds.php")
    Call<Users> performAllSounds();
}
