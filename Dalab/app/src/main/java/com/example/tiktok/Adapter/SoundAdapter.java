package com.example.tiktok.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tiktok.HomeActivity;
import com.example.tiktok.MessageActivity;
import com.example.tiktok.Models.SoundModel;
import com.example.tiktok.R;
import com.example.tiktok.VideoEditorFolder.PortraitCameraActivity;

import java.util.List;

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.SoundViewHolder> {

    List<SoundModel> soundModelList;
    Context context;

    public SoundAdapter(List<SoundModel> soundModelList, Context context) {
        this.soundModelList = soundModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public SoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_sound, parent, false);
        return new SoundViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoundViewHolder holder, int position) {
        SoundModel soundModel = soundModelList.get(position);
        holder.sound_title.setText(soundModel.getSound_title());
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PortraitCameraActivity.class);
                intent.putExtra("sound_url",soundModel.getSound_file());
                context.startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            }
        });
    }

    @Override
    public int getItemCount() {
        return soundModelList.size();
    }

    public class SoundViewHolder extends RecyclerView.ViewHolder {
        private TextView sound_title;
        public SoundViewHolder(@NonNull View itemView) {
            super(itemView);
            sound_title = itemView.findViewById(R.id.textView9);
        }
    }
}
