package com.example.tiktok.MainRecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestManager;
import com.example.tiktok.HomeActivity;
import com.example.tiktok.Models.MediaObject;
import com.example.tiktok.R;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
//import cray.ajm.app.R;

public class VideoPlayerViewHolder extends RecyclerView.ViewHolder {

    FrameLayout media_container;
    TextView title,url,likeText;
    ImageView thumbnail, volumeControl, sounDisk,like,disk_like;
    ProgressBar progressBar;
    View parent;
    RequestManager requestManager;
    Map map = new HashMap();

    public VideoPlayerViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        media_container = itemView.findViewById(R.id.media_container);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        title = itemView.findViewById(R.id.textView4);
        progressBar = itemView.findViewById(R.id.progressBar);
        volumeControl = itemView.findViewById(R.id.volume_control);
        sounDisk = itemView.findViewById(R.id.sound_disc);
        url = itemView.findViewById(R.id.urlShare);
        likeText = itemView.findViewById(R.id.textView12);
        like = itemView.findViewById(R.id.imageFavorite);
        disk_like = itemView.findViewById(R.id.imageView5);


    }

    public void onBind(MediaObject mediaObject, RequestManager requestManager) {
        this.requestManager = requestManager;
        parent.setTag(this);
        title.setText(mediaObject.getDescription()+",\n"+mediaObject.getDate());
        url.setText(mediaObject.getMedia_url());
        this.requestManager.load(mediaObject.getThumbnail()).into(thumbnail);
//        mediaObject.setUser_id("1");
//        if(likeText.getText().toString().equals("like")){
//            disk_like.setVisibility(View.GONE);
//            like.setVisibility(View.INVISIBLE);
//        }else{
//            like.setVisibility(View.GONE);
//            disk_like.setVisibility(View.INVISIBLE);
//        }
//        map.put(mediaObject.getPost_id(),mediaObject.getUser_id());

    }
    public String getUrl(MediaObject mediaObject) {
        return(mediaObject.getMedia_url());
    }


}