package com.hailpt.com.youtubeeng.network.service;


import com.hailpt.com.youtubeeng.common.Common;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


/**
 * Created by hailpt on 12/15/15.
 */
public class RestClient {

    private static RestService restService;

    public static RestService getClient() {
        if (restService == null) {

            OkHttpClient okClient = new OkHttpClient();
            okClient.setReadTimeout(Common.TIMEOUT, TimeUnit.MILLISECONDS);
            okClient.setConnectTimeout(Common.TIMEOUT, TimeUnit.MILLISECONDS);
            okClient.setWriteTimeout(Common.TIMEOUT, TimeUnit.MILLISECONDS);
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Common.API)
                    .addConverter(String.class, new ToStringConverter())
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            restService = client.create(RestService.class);
        }
        return restService;
    }
}
