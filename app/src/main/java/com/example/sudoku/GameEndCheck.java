package com.example.sudoku;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

public class GameEndCheck extends Dialog
{
    public GameEndCheck(Context context)
    {
        super(context);
        setContentView(R.layout.endgame);

        findViewById(R.id.restart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener ok = new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        System.exit(0);
                        dismiss();
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setMessage("정말 종료하시겠습니까?");
                builder.setTitle("알림");
                builder.setPositiveButton("YES", ok);
                builder.setNegativeButton("NO", null);
                builder.setCancelable(false);

                AlertDialog alertDialog;
                alertDialog=builder.create();
                alertDialog.show();
            }
        });

    }
}
