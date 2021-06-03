package com.example.tiktok.Responses;

import com.example.tiktok.Models.MediaObject;
import com.example.tiktok.Models.SoundModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {
    @SerializedName("ALL_POSTS")
    private List<MediaObject> AllPosts;

    @SerializedName("ALL_SOUNDS")
    private List<SoundModel> AllSounds;

    public List<MediaObject> getAllPosts() {
        return AllPosts;
    }

    public List<SoundModel> getAllSounds() {
        return AllSounds;
    }
}
