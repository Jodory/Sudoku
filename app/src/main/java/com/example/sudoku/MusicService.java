package com.example.sudoku;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        if(MainActivity.level == 1)
            mediaPlayer = MediaPlayer.create(this, R.raw.back1);
        else if(MainActivity.level == 2)
            mediaPlayer = MediaPlayer.create(this, R.raw.back2);
        else if(MainActivity.level == 3)
            mediaPlayer = MediaPlayer.create(this, R.raw.back3);
        mediaPlayer.setLooping(true); // 무한 루프
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();
    }
}
