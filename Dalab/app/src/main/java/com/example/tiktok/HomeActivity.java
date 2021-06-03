package com.example.tiktok;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.tiktok.MainRecyclerView.VerticalSpacingItemDecorator;
import com.example.tiktok.MainRecyclerView.VideoPlayerRecyclerAdapter;
import com.example.tiktok.MainRecyclerView.VideoPlayerRecyclerView;
import com.example.tiktok.MainRecyclerView.VideoPlayerViewHolder;
import com.example.tiktok.Models.MediaObject;
import com.example.tiktok.Responses.ApiClient;
import com.example.tiktok.Responses.ApiInterface;
import com.example.tiktok.Responses.Users;
import com.example.tiktok.VideoEditorFolder.PortraitCameraActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<MediaObject> mediaObjectList = new ArrayList<>() ;
    private VideoPlayerRecyclerView recyclerView;
    public static ApiInterface apiInterface;
    private TextView urlShareText,likeText;
    private ImageView like,diskLike;

    ///////////////////////////////////
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 88888;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        init();
        urlShareText = (TextView)findViewById(R.id.urlShare);

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

                    Toast.makeText(HomeActivity.this, "Network Error.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Network Error.", Toast.LENGTH_SHORT).show();

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

    public void followingbtn(View view) {
        Intent intent = new Intent(HomeActivity.this,FollowingActivity.class);
        startActivity(intent);
        Animatoo.animateSwipeRight(this);
        finish();
    }

    public void addBtn(View view) {
        checkPermission();

        Intent intent = new Intent(HomeActivity.this, PortraitCameraActivity.class);
        startActivity(intent);
        Animatoo.animateSlideUp(this);
        finish();
    }
    ////////////////////////////share///////
    public void shareBtn(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        urlShareText = findViewById(R.id.urlShare);
        String url = urlShareText.getText().toString();

        sendIntent.putExtra(Intent.EXTRA_TEXT,url);
        sendIntent.setType("text/plain");
        Intent.createChooser(sendIntent,"Share via");
        startActivity(sendIntent);
    };

    ////////////////////////////////
    public void like(View view){
        likeText = findViewById(R.id.textView12);
        likeText.setText("like");
        like = findViewById(R.id.imageView5);
        like.setVisibility(View.GONE);
        diskLike = findViewById(R.id.imageFavorite);
        diskLike.setVisibility(View.VISIBLE);


    }
    ///////////////////////////////
    public void disk_like(View view){
        likeText = findViewById(R.id.textView12);
        likeText.setText("disk_like");
        diskLike = findViewById(R.id.imageFavorite);
        diskLike.setVisibility(View.GONE);
        like = findViewById(R.id.imageView5);
        like.setVisibility(View.VISIBLE);


    }
    ////
    @Override
    protected void onResume() {
        super.onResume();
        checkPermission();
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        // request camera permission if it has not been grunted.
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
        ) {

            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_PERMISSION_REQUEST_CODE);
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CAMERA_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(HomeActivity.this, "permission has been granted.", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(HomeActivity.this, "[WARN] permission is not granted.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void discoverPage(View view) {
        Intent intent = new Intent(HomeActivity.this,DiscoverActivity.class);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Animatoo.animateSlideUp(this);
        finish();
    }

    public void accountPage(View view) {
        Intent intent = new Intent(HomeActivity.this,AccountActivity.class);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Animatoo.animateSlideUp(this);
        finish();
    }

    public void messagePage(View view) {
        Intent intent = new Intent(HomeActivity.this,MessageActivity.class);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Animatoo.animateSlideUp(this);
        finish();
    }
}