package com.example.osmany.ahorcado;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Osmany on 17/01/2018.
 */

public class Reproductor {

    Context context;
    VideoView videoView;

    public Reproductor(Context context, VideoView videoView){
        this.context=context;
        this.videoView=videoView;
    }

    public void reproducirSonido(MediaPlayer mediaPlayer, int sonido){
        mediaPlayer = MediaPlayer.create(context,sonido);
        mediaPlayer.start();

    }

    public void reproduceVideo(VideoView videoView, String urlVideo){
        videoView.setVideoURI(Uri.parse(urlVideo));
        videoView.setMediaController(new MediaController(context));

    }

}
