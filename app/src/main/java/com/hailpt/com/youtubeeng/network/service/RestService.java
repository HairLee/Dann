package com.hailpt.com.youtubeeng.network.service;


import com.hailpt.com.youtubeeng.network.response.Test;
import com.hailpt.com.youtubeeng.network.response.YoutubeRes;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by hailpt on 2/2/16.
 */
public interface RestService {

    /* For Program*/
    @GET("playlistItems?part=snippet&playlistId=PLklScY-qIgglLu1nfH-i-L_KEHA9CfwAH&key=AIzaSyAKOtDCpaGQ9624yS8-9pADYH0qFvmK6f8")
    Call<RestData<YoutubeRes>> getYoutube();

    @GET("json/movies.json")
    Call<RestData<List<Test>>> getData();
}
