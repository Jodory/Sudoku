package com.example.sudoku;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

public class GameLevel extends Dialog {
    int num = 10;
    public void setLevel(int a){
        this.num = a;
    }
    public int getLevel(){
        return this.num;
    }
    public GameLevel(Context context) {
        super(context);
        setContentView(R.layout.level);

//        findViewById(R.id.easy).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setLevel(1);
//                dismiss();
//            }
//        });
//
//        findViewById(R.id.normal).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setLevel(2);
//                dismiss();
//            }
//        });
//
//        findViewById(R.id.hard).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setLevel(3);
//                dismiss();
//            }
//        });
    }
}
