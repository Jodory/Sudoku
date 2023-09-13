package com.example.sudoku;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomButton extends FrameLayout {
    int row, col, value;
    static CustomButton[][] buttons;
    public CustomButton btn;
    //    static int conflictCount = 0;
    TextView[] memos = new TextView[9];
    TextView textView;

    public CustomButton(Context context, int row, int col, CustomButton buttons[][]) {
        super(context);
        this.row = row;
        this.col = col;
        this.btn = this;
        this.buttons = buttons;

        TextView textView = new TextView(context);
        addView(textView);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TableLayout memo = (TableLayout) layoutInflater.inflate(R.layout.show_memo, null);
        addView(memo);

        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            TableRow tableRow = (TableRow) memo.getChildAt(i);
            for (int j = 0; j < 3; j++, cnt++) {
                memos[cnt] = (TextView) tableRow.getChildAt(j);
            }
        }
    }

    public void reStart() {
        MediaPlayer player = MediaPlayer.create(getContext(), R.raw.del);
        player.start();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                buttons[i][j].textView.setBackgroundResource(R.drawable.button_selector);
                if (buttons[i][j].isClickable()) {
                    buttons[i][j].set(0);
                }
            }
        }
    }

    public void set(int a) {
        this.value = a;
        if (a == 0) {
            textView.setText("");
        } else {
            textView.setText("" + this.value);
        }
    }


//    public void newStart(Context context) {
//
//        double random = Math.random();
//        if (random < 0.9) {
//            set(0);
//            setClickable(true);
//            textView.setTextColor(Color.BLUE);
//            textView.setBackgroundResource(R.drawable.button_selector);
////            textView.setBackgroundColor(Color.TRANSPARENT);
//
//            setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    NumberPad numberPad;
//                    numberPad = new NumberPad(context, btn);
//                    numberPad.show();
//                }
//            });
//
//            setOnLongClickListener(new OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View view) {
//                    MemoPad memoPad;
//                    memoPad = new MemoPad(context, btn, memos);
//                    memoPad.show();
//                    return true;
//                }
//            });
//        }
//
//    }

    public void setStartNum(Context context, int level) {
        double per;
        this.textView = new TextView(context);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        textView.setText("" + this.value);
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundResource(R.drawable.button_selector);
//        textView.setBackgroundColor(Color.TRANSPARENT);
        addView(textView);

        double random = Math.random();
        if (level == 1)
            per = 0.3;
        else if (level == 2)
            per = 0.5;
        else if (level == 3)
            per = 0.7;
        else
            per = 0.5;

        if (random < per) {
            set(0);
            setClickable(true);
            textView.setTextColor(Color.BLUE);
            textView.setBackgroundResource(R.drawable.button_selector);
//            textView.setBackgroundColor(Color.TRANSPARENT);

            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    NumberPad numberPad;
                    numberPad = new NumberPad(context, btn);
                    numberPad.show();
                }
            });

            setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    MemoPad memoPad;
                    memoPad = new MemoPad(context, btn, memos);
                    memoPad.show();
                    return true;
                }
            });
        }
    }


    public void setStartNum(Context context) {
        this.textView = new TextView(context);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        textView.setText("" + this.value);
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundResource(R.drawable.button_selector);
//        textView.setBackgroundColor(Color.TRANSPARENT);
        addView(textView);

        double random = Math.random();
        if (random < 0.05) {
            set(0);
            setClickable(true);
            textView.setTextColor(Color.BLUE);
            textView.setBackgroundResource(R.drawable.button_selector);
//            textView.setBackgroundColor(Color.TRANSPARENT);

            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    NumberPad numberPad;
                    numberPad = new NumberPad(context, btn);
                    numberPad.show();
                }
            });

            setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    MemoPad memoPad;
                    memoPad = new MemoPad(context, btn, memos);
                    memoPad.show();
                    return true;
                }
            });
        }
    }

    public void exitCheckBtn(Context context, int row, int col) {
        boolean success = true;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (buttons[i][j].value == 0) {
                    success = false;
                }
            }
        }

        if (success && !setConflict(row, col)) {
            GameEndCheck clear = new GameEndCheck(context);
            clear.show();
            context.stopService(new Intent(getContext(), MusicService.class));

            MediaPlayer player = MediaPlayer.create(getContext(), R.raw.end);
            player.start();;
//                TableLayout endgame;
//                endgame = (TableLayout) findViewById(R.id.endgame);
//                endgame.setVisibility(VISIBLE);
        }
    }

    public boolean setConflict(int row, int col) {
        boolean buf = false;        // 충돌 여부
        boolean bufbuf = false;
        // Horizontal conflict
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    continue;
                }
                if (buttons[row][i].value == buttons[row][j].value) {
                    if (buttons[row][i].value == 0 || buttons[row][j].value == 0)
                        continue;
                    if (buttons[row][i].isClickable()) {
                        buttons[row][i].textView.setBackgroundColor(Color.RED);
                        buf = true;
                    }
                    if (buttons[row][j].isClickable()) {
                        buttons[row][j].textView.setBackgroundColor(Color.RED);
                        buf = true;
                    }
                }
            }
        }
        //all horizontal
        for(int k = 0; k < 9; k++){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    continue;
                }
                if (buttons[k][i].value == buttons[k][j].value) {
                    if (buttons[k][i].value == 0 || buttons[k][j].value == 0)
                        continue;
                    if (buttons[k][i].isClickable()) {
                        buttons[k][i].textView.setBackgroundColor(Color.RED);
                    }
                    if (buttons[k][j].isClickable()) {
                        buttons[k][j].textView.setBackgroundColor(Color.RED);
                    }
                }
            }
        }}


        // Vertical conflict
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j)
                    continue;
                if (buttons[i][col].value == buttons[j][col].value) {
                    if (buttons[i][col].value == 0 || buttons[j][col].value == 0)
                        continue;
                    if (buttons[i][col].isClickable()) {
                        buttons[i][col].textView.setBackgroundColor(Color.RED);
                        buf = true;
                    }
                    if (buttons[j][col].isClickable()) {
                        buttons[j][col].textView.setBackgroundColor(Color.RED);
                        buf = true;
                    }
                }
            }
        }

        // All Vertical conflict
        for(int k =0; k < 9; k++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (i == j)
                        continue;
                    if (buttons[i][k].value == buttons[j][k].value) {
                        if (buttons[i][k].value == 0 || buttons[j][k].value == 0)
                            continue;
                        if (buttons[i][k].isClickable()) {
                            buttons[i][k].textView.setBackgroundColor(Color.RED);

                        }
                        if (buttons[j][k].isClickable()) {
                            buttons[j][k].textView.setBackgroundColor(Color.RED);
                        }
                    }
                }
            }
        }



        // 3x3 conflict
//        int bufNum[] = new int[9];
        List<Integer> bufNum = new ArrayList<>();
        List<Integer> confNum = new ArrayList<>();
        int cnt = 0;
        int hor;
        int ver;
        boolean buf33;
        boolean buf33buf = false;
        while (cnt != 9) {
            buf33 = false;
            hor = (cnt / 3) * 3;
            ver = (cnt % 3) * 3;
            for (int i = hor; i < hor + 3; i++) {
                for (int j = ver; j < ver + 3; j++) {
                    // 빈 칸의 좌표는 스킵한다.
                    if (buttons[i][j].value == 0) continue;
                    // 후보로 전달 된 정수가 이미 스도쿠 판에 존재하는 숫자와 일치하면
                    // 유망하지 않은 정수이므로 false 리턴
                    bufNum.add(buttons[i][j].value);
                }
            }
            for (int i = 0; i < bufNum.size(); i++) {
                for (int j = 0; j < i; j++) {
                    if (bufNum.get(i).equals(bufNum.get(j))) {  // 중복 검사
                        confNum.add(bufNum.get(i));
                        buf33 = true;
                        buf = true;
                    }
                }
            }
            if (buf33) {
                for (int i = hor; i < hor + 3; i++) {
                    for (int j = ver; j < ver + 3; j++) {
                        for (int k = 0; k < confNum.size(); k++) {
                            if (buttons[i][j].value == confNum.get(k) && buttons[i][j].isClickable()) {
                                buttons[i][j].textView.setBackgroundColor(Color.RED);
                                if (buttons[i][j].value == buttons[row][col].value)
                                    buf33buf = true;
                            }
                        }
                    }
                }
            }
            bufNum.clear();
            confNum.clear();
            cnt++;
        }
        if (buf33buf == true) {
            buttons[row][col].textView.setBackgroundColor(Color.RED);
        }




        if(buf == true && buttons[row][col].value != 0) {
            ColorDrawable color = (ColorDrawable) buttons[row][col].textView.getBackground();
            int bgColor = color.getColor();
            if (bgColor == Color.RED) {
                Toast t = Toast.makeText(getContext(), "오답입니다..ㅜ", Toast.LENGTH_SHORT);
                t.show();
                MediaPlayer player = MediaPlayer.create(getContext(), R.raw.alert);
                player.start();
//            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
////        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);  // 전화 벨소리
////        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM); //알람
//            Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), notification);
//            ringtone.play();
            }
            else {
                Toast t = Toast.makeText(getContext(), "정답입니다!!!", Toast.LENGTH_SHORT);
                t.show();
                MediaPlayer player = MediaPlayer.create(getContext(), R.raw.correct);
                player.start();;
            }
        }
        else {
            if(buttons[row][col].value != 0) {
                Toast t = Toast.makeText(getContext(), "정답입니다!!!", Toast.LENGTH_SHORT);
                t.show();
                MediaPlayer player = MediaPlayer.create(getContext(), R.raw.correct);
                player.start();;
            }
            if(buttons[row][col].value == 0) {
                Toast t = Toast.makeText(getContext(), "해당 입력 삭제", Toast.LENGTH_SHORT);
                t.show();
                MediaPlayer player = MediaPlayer.create(getContext(), R.raw.del);
                player.start();
            }
        }

//        int cnt33 = 0;
//        for (int i = 0; i < 9; i++) {
//            if (cnt33 == i / 3)
//                for (int j = cnt33; j < 9; j++) {
//                    if (cnt33 == j / 3) {
//                        if ((i == row) & (j == col)) {
//                            continue;
//                        }
//                        if (buttons[row][col].value == buttons[i][j].value) {
//                            if (buttons[i][j].isClickable()) {
//                                buttons[i][j].textView.setBackgroundColor(Color.RED);
//                            }
//                            buf33 = true;
//                        }
//                    }
//                }
//        }

        //buf가 true. 즉, 충돌이 있으면

        return buf;
    }

    public void unsetConflict() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
//                buttons[i][j].textView.setBackgroundResource(R.drawable.button_selector);
                if (buttons[i][j].value == 0) {
                    buttons[i][j].textView.setBackgroundResource(R.drawable.button_selector);
//                    buttons[i][j].textView.setBackgroundColor(Color.TRANSPARENT);
                } else
                    buttons[i][j].textView.setBackgroundColor(Color.WHITE);
            }
        }
    }
}
