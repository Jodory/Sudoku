package com.example.sudoku;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;

public class NumberPad extends Dialog {
    public NumberPad(Context context, CustomButton customBtn) {
        super(context);
        setContentView(R.layout.numberpad);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customBtn.set(1);
                customBtn.unsetConflict();
                customBtn.setConflict(customBtn.row, customBtn.col);
                customBtn.exitCheckBtn(context, customBtn.row, customBtn.col);

                dismiss();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customBtn.set(2);
                customBtn.unsetConflict();
                customBtn.setConflict(customBtn.row, customBtn.col);
                customBtn.exitCheckBtn(context, customBtn.row, customBtn.col);
                dismiss();
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customBtn.set(3);
                customBtn.unsetConflict();
                customBtn.setConflict(customBtn.row, customBtn.col);
                customBtn.exitCheckBtn(context, customBtn.row, customBtn.col);
                dismiss();
            }
        });

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customBtn.set(4);
                customBtn.unsetConflict();
                customBtn.setConflict(customBtn.row, customBtn.col);
                customBtn.exitCheckBtn(context, customBtn.row, customBtn.col);
                dismiss();
            }
        });

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customBtn.set(5);
                customBtn.unsetConflict();
                customBtn.setConflict(customBtn.row, customBtn.col);
                customBtn.exitCheckBtn(context, customBtn.row, customBtn.col);
                dismiss();
            }
        });

        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customBtn.set(6);
                customBtn.unsetConflict();
                customBtn.setConflict(customBtn.row, customBtn.col);
                customBtn.exitCheckBtn(context, customBtn.row, customBtn.col);
                dismiss();
            }
        });
        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customBtn.set(7);
                customBtn.unsetConflict();
                customBtn.setConflict(customBtn.row, customBtn.col);
                customBtn.exitCheckBtn(context, customBtn.row, customBtn.col);
                dismiss();
            }
        });
        findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customBtn.set(8);
                customBtn.unsetConflict();
                customBtn.setConflict(customBtn.row, customBtn.col);
                customBtn.exitCheckBtn(context, customBtn.row, customBtn.col);
                dismiss();
            }
        });
        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customBtn.set(9);
                customBtn.unsetConflict();
                customBtn.setConflict(customBtn.row, customBtn.col);
                customBtn.exitCheckBtn(context, customBtn.row, customBtn.col);
                dismiss();
            }
        });
        findViewById(R.id.btnCANCEL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        findViewById(R.id.btnDEL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customBtn.set(0);
                customBtn.unsetConflict();
                customBtn.setConflict(customBtn.row, customBtn.col);
//                customBtn.textView.setBackgroundColor(Color.WHITE);
//                customBtn.textView.setBackgroundResource(R.drawable.button_selector);
//                customBtn.textView.setBackgroundColor(Color.TRANSPARENT);
                customBtn.textView.setBackgroundResource(R.drawable.button_selector);
                dismiss();
            }
        });
    }
}