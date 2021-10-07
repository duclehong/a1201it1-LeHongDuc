package com.example.tiktok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tiktok.Adapter.SoundAdapter;
import com.example.tiktok.Models.SoundModel;
import com.example.tiktok.Responses.ApiClient;
import com.example.tiktok.Responses.ApiInterface;
import com.example.tiktok.Responses.Users;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SoundActivity extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private List<SoundModel> soundModelList = new ArrayList<>();
    private SoundAdapter soundAdapter;

    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this);
        layoutManager3.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        Call<Users> call = apiInterface.performAllSounds();
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()) {
                    soundModelList = response.body().getAllSounds();
                    soundAdapter = new SoundAdapter(soundModelList, getApplicationContext());
                    recyclerView.setAdapter(soundAdapter);
                    soundAdapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(SoundActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });





    }
    public void backBtn(View view) {
        Intent intent = new Intent(SoundActivity.this,HomeActivity.class);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Animatoo.animateSlideDown(this);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SoundActivity.this,HomeActivity.class);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Animatoo.animateSlideDown(this);
        finish();
    }
}