package com.example.tiktok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.tiktok.MainRecyclerView.VerticalSpacingItemDecorator;
import com.example.tiktok.MainRecyclerView.VideoPlayerRecyclerAdapter;
import com.example.tiktok.MainRecyclerView.VideoPlayerRecyclerView;
import com.example.tiktok.Models.MediaObject;
import com.example.tiktok.Responses.ApiClient;
import com.example.tiktok.Responses.ApiInterface;
import com.example.tiktok.Responses.Users;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FollowingActivity extends AppCompatActivity {
    private ArrayList<MediaObject> mediaObjectList = new ArrayList<>() ;
    private VideoPlayerRecyclerView recyclerView;
    public static ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        init();

    }
    private void init(){
//        sound_dis = (ImageView) findViewById(R.id.sound_disc);
//        Glide.with(this).load(R.drawable.record).into(sound_dis);
        if (Build.VERSION.SDK_INT>=19 && Build.VERSION.SDK_INT <21){
//            Window window = getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.BLUE);
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
//        if (Build.VERSION.SDK_INT>=19){
//            String Color = null;
//            getWindow().setNavigationBarColor(android.graphics.Color.parseColor(Color));
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN );
//        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT>=21){
//            Window window = getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.BLUE);
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }



        ////////recyclerview/////////////
        recyclerView = (VideoPlayerRecyclerView ) findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(0);
        recyclerView.addItemDecoration(itemDecorator);

        SnapHelper msnapHelper = new PagerSnapHelper();
        msnapHelper.attachToRecyclerView(recyclerView);

        LoadAllPosts();



    }

    private void LoadAllPosts() {


//        Call<Users> call = apiInterface.performAllPosts();
//        call.enqueue(new Callback<Users>() {
//            @Override
//            public void onResponse(Call<Users> call, Response<Users> response) {
//
//                if(response.isSuccessful())
//                {
//                    Toast.makeText(HomeActivity.this, "Network Error0.", Toast.LENGTH_SHORT).show();
//                    mediaObjectList = (ArrayList<MediaObject>) response.body().getAllPosts();
//
//                    recyclerView.setMediaObjects(mediaObjectList);
//                    VideoPlayerRecyclerAdapter adapter = new VideoPlayerRecyclerAdapter(mediaObjectList, initGlide());
//                    recyclerView.setAdapter(adapter);
//                    adapter.notifyDataSetChanged();
//                    recyclerView.setKeepScreenOn(true);
////                    recyclerView.smoothScrollToPosition(mediaObjectList.size()+1);
//                }
//                else
//                {
//                    Toast.makeText(HomeActivity.this, "Network Error.", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Users> call, Throwable t) {
//                Toast.makeText(HomeActivity.this, "Network Error2", Toast.LENGTH_SHORT).show();
//
//            }
//        });


        Call<Users> call = apiInterface.performAllPosts();
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {

                if(response.isSuccessful())
                {

                    mediaObjectList = (ArrayList<MediaObject>) response.body().getAllPosts();

                    recyclerView.setMediaObjects(mediaObjectList);
                    VideoPlayerRecyclerAdapter adapter = new VideoPlayerRecyclerAdapter(mediaObjectList, initGlide());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    recyclerView.setKeepScreenOn(true);
                    recyclerView.smoothScrollToPosition(mediaObjectList.size()+1);
                }
                else
                {

                    Toast.makeText(FollowingActivity.this, "Network Error.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(FollowingActivity.this, "Network Error.", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on){
        Window win  = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if(on){
            winParams.flags |= bits;
        } else {
            winParams.flags &= bits;
        }
        win.setAttributes(winParams);
    }
    private RequestManager initGlide(){
        RequestOptions options = new RequestOptions()
                .placeholder(R.color.design_default_color_background)
                .error(R.color.design_default_color_error);

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }
    @Override
    protected void onDestroy() {
        if(recyclerView!=null)
            recyclerView.releasePlayer();
        super.onDestroy();
    }
    @Override
    protected void onStop() {
        super.onStop();

        if(recyclerView!=null)
            recyclerView.releasePlayer();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }


    public void forUbtn(View view) {
        Intent intent = new Intent(FollowingActivity.this,HomeActivity.class);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Animatoo.animateSwipeLeft(this);
        finish();
    }
}