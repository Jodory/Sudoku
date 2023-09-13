package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.Lifecycle;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int level = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
//        vib.vibrate(1000);
//        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
////        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);  // 전화 벨소리
////        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM); //알람
//        Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), notification);
//        ringtone.play();


        TableLayout table;
        table = (TableLayout) findViewById(R.id.tableLayout);

        MediaPlayer start = MediaPlayer.create(getApplicationContext(), R.raw.start);
        start.start();

//        MediaPlayer back = MediaPlayer.create(getApplicationContext(), R.raw.back1);
//        back.start();
        startService(new Intent(getApplicationContext(), MusicService.class));

        run(table);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.9f;
        getWindow().setAttributes(layoutParams);



        Button btnEASY = findViewById(R.id.easy);
        btnEASY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(MainActivity.this, "Level: EASY", Toast.LENGTH_SHORT);
                t.show();
                table.removeAllViews();
                level = 1;
                run(table, level);
                stopService(new Intent(getApplicationContext(), MusicService.class));
                startService(new Intent(getApplicationContext(), MusicService.class));
                Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vib.vibrate(VibrationEffect.createOneShot(1000,100));
                }
            }
        });

        Button btnNORMAL = findViewById(R.id.normal);
        btnNORMAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(MainActivity.this, "Level: NORMAL", Toast.LENGTH_SHORT);
                t.show();
                table.removeAllViews();
                level = 2;
                run(table, level);
                stopService(new Intent(getApplicationContext(), MusicService.class));
                startService(new Intent(getApplicationContext(), MusicService.class));
                Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vib.vibrate(VibrationEffect.createOneShot(1000,100));
                }
            }
        });

        Button btnHARD = findViewById(R.id.hard);
        btnHARD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(MainActivity.this, "Level: HARD", Toast.LENGTH_SHORT);
                t.show();
                table.removeAllViews();
                level = 3;
                run(table, level);
                stopService(new Intent(getApplicationContext(), MusicService.class));
                startService(new Intent(getApplicationContext(), MusicService.class));
                Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vib.vibrate(VibrationEffect.createOneShot(1000,100));
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(getApplicationContext(), MusicService.class));

        super.onDestroy();
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        //이벤트 작성
        // System.exit(0);
        stopService(new Intent(getApplicationContext(), MusicService.class));
    }




    public void run(TableLayout table, int level){
//        Button[][] buttons = new Button[9][9];
        BoardGenerator board = new BoardGenerator();
        CustomButton buttons[][] = new CustomButton[9][9];
        for (int i = 0; i < 9; i++) {
            TableRow tableRow = new TableRow(this);
            table.addView(tableRow);
//            int cnt = 0;
            for (int j = 0; j < 9; j++) {
//                buttons[i][j] = new Button(this);
                buttons[i][j] = new CustomButton(this, i, j, buttons);
                TableRow.LayoutParams layoutParams =
                        new TableRow.LayoutParams(
                                TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT,
                                1.0f);

                buttons[i][j].setLayoutParams(layoutParams);
                buttons[i][j].setId(i + j);
                int num = board.get(i, j);
                buttons[i][j].value = num;
                buttons[i][j].setStartNum(this, level);
                tableRow.addView(buttons[i][j]);

                if ((i == 2 || i == 5) && (j == 2 || j == 5)) {
                    layoutParams.setMargins(2, 2, 20, 20);
                } else if (i == 2 || i == 5) {
                    layoutParams.setMargins(2, 2, 2, 20);
                } else if (j == 2 || j == 5) {
                    layoutParams.setMargins(2, 2, 20, 2);
                } else {
                    layoutParams.setMargins(2, 2, 2, 2);
                }
            }
        }


        Button RESET = findViewById(R.id.btnRESET);
        RESET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttons[0][0].reStart();
            }

        });
    }


    public void run(TableLayout table) {
//        Button[][] buttons = new Button[9][9];
        BoardGenerator board = new BoardGenerator();
        CustomButton buttons[][] = new CustomButton[9][9];
        for (int i = 0; i < 9; i++) {
            TableRow tableRow = new TableRow(this);
            table.addView(tableRow);
//            int cnt = 0;
            for (int j = 0; j < 9; j++) {
//                buttons[i][j] = new Button(this);
                buttons[i][j] = new CustomButton(this, i, j, buttons);
                TableRow.LayoutParams layoutParams =
                        new TableRow.LayoutParams(
                                TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT,
                                1.0f);

                buttons[i][j].setLayoutParams(layoutParams);
                buttons[i][j].setId(i + j);
                int num = board.get(i, j);
                buttons[i][j].value = num;
                buttons[i][j].setStartNum(this);
                tableRow.addView(buttons[i][j]);

                if ((i == 2 || i == 5) && (j == 2 || j == 5)) {
                    layoutParams.setMargins(2, 2, 20, 20);
                } else if (i == 2 || i == 5) {
                    layoutParams.setMargins(2, 2, 2, 20);
                } else if (j == 2 || j == 5) {
                    layoutParams.setMargins(2, 2, 20, 2);
                } else {
                    layoutParams.setMargins(2, 2, 2, 2);
                }
            }
        }


        Button RESET = findViewById(R.id.btnRESET);
        RESET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[0][0].reStart();
            }
        });
    }


    public void onClickButton(View v) {
        //v.setVisibility(View.GONE);
        //Memo[i] = findViewById(getResources().getIdentifier("button" + i, "id", "com.ehsehsl.osz"));
    }

}