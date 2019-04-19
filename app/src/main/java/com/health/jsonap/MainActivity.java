package com.health.jsonap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.data);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://s3-sa-east-1.amazonaws.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Data>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {

                List<Data> datas = response.body();

                for(Data d: datas){
                    txt.setText("name" + d.getName());
                    txt.setText("id"+ String.valueOf(d.getId()));
                    txt.setText("pwd"+ String.valueOf(d.getPwd()));
                }


            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {

                txt.setText(getApplicationContext() + t.getMessage());

            }
        });

    }
}
