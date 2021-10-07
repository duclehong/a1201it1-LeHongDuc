package com.example.tiktok.Models;

public class SoundModel {
    public SoundModel(){

    }
    private String sound_img,sound_sound,sound_title,sound_file;

    public SoundModel(String sound_img, String sound_sound, String sound_title, String sound_file) {
        this.sound_img = sound_img;
        this.sound_sound = sound_sound;
        this.sound_title = sound_title;
        this.sound_file = sound_file;
    }

    public String getSound_img() {
        return sound_img;
    }

    public String getSound_file() {
        return sound_file;
    }

    public void setSound_file(String sound_file) {
        this.sound_file = sound_file;
    }

    public void setSound_img(String sound_img) {
        this.sound_img = sound_img;
    }

    public String getSound_sound() {
        return sound_sound;
    }

    public void setSound_sound(String sound_sound) {
        this.sound_sound = sound_sound;
    }

    public String getSound_title() {
        return sound_title;
    }

    public void setSound_title(String sound_title) {
        this.sound_title = sound_title;
    }
}
