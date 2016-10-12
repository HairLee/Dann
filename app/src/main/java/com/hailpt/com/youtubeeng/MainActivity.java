package com.hailpt.com.youtubeeng;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.hailpt.com.youtubeeng.network.service.RestService;
import com.hailpt.com.youtubeeng.util.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    protected RestService restService;
    public static final String PLAYLIST_ID = "PLklScY-qIgglLu1nfH-i-L_KEHA9CfwAH";
    public static final String KEY = "AIzaSyAKOtDCpaGQ9624yS8-9pADYH0qFvmK6f8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getData();

//        restService = RestClient.getClient();
//
//
//        restService.getYoutube().enqueue(new Callback<RestData<YoutubeRes>>() {
//            @Override
//            public void onResponse(Response<RestData<YoutubeRes>> response) {
//                if (response.body() != null) {
//                    Log.d("hailpt", "=======hailpt==========" + response.body().data.getNextPageToken());
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
    }

    public void getData(){

        // we will using AsyncTask during parsing
        new AsyncTaskParseJson().execute();



    }


    // you can make this class as another java file so it will be separated from your main activity.
    public class AsyncTaskParseJson extends AsyncTask<String, String, String> {

        final String TAG = "AsyncTaskParseJson.java";

        // set your json string url here
        String yourJsonStringUrl = "http://api.androidhive.info/json/movies.json";

        // contacts JSONArray
        JSONArray dataJsonArr = null;

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... arg0) {

            // instantiate our json parser
            JsonParser jParser = new JsonParser();

            // get json string from url
            JSONObject json = jParser.getJSONFromUrl(yourJsonStringUrl);

//                dataJsonArr = json.getJSONArray("");
            Gson gson = new Gson();
            String jsond = gson.toJson(json);

            Log.d("====","===="+jsond);


            // get the array of users
//                dataJsonArr = json.getJSONArray("");

            // loop through all users
//                for (int i = 0; i < dataJsonArr.length(); i++) {
//
//                    JSONObject c = dataJsonArr.getJSONObject(i);
//
//                    // Storing each json item in variable
//                    String firstname = c.getString("title");
//
//                    // show the values in our logcat
//                    Log.e(TAG, "firstname: " + firstname
//                    );
//
//                }

            return null;
        }

        @Override
        protected void onPostExecute(String strFromDoInBg) {
        }
    }
}
