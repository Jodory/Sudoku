package com.example.sudoku;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MemoPad extends Dialog {
//    static int num = 0;
    public MemoPad(Context context, CustomButton customButton, TextView[] memos) {
        super(context);
        setContentView(R.layout.memopad);
        boolean clickBuf[] = new boolean[9];
        for (int i = 0; i < 9; i++) {
            clickBuf[i] = false;
        }
        ToggleButton btnMEMO[] = new ToggleButton[9];
        btnMEMO[0] = findViewById(R.id.btn1);
        btnMEMO[1] = findViewById(R.id.btn2);
        btnMEMO[2] = findViewById(R.id.btn3);
        btnMEMO[3] = findViewById(R.id.btn4);
        btnMEMO[4] = findViewById(R.id.btn5);
        btnMEMO[5] = findViewById(R.id.btn6);
        btnMEMO[6] = findViewById(R.id.btn7);
        btnMEMO[7] = findViewById(R.id.btn8);
        btnMEMO[8] = findViewById(R.id.btn9);

        for (int i = 0; i < 9; i++) {
            if (memos[i].getVisibility() == View.VISIBLE) {
                btnMEMO[i].setChecked(true);
            }
        }

//        while(num < 9){
//            btnMEMO[num].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton compoundButton, boolean buf33) {
//                    if (buf) {
//                        memos[num].setVisibility(View.VISIBLE);
//                        clickBuf[num] = true;
//                    } else {
//                        memos[num].setVisibility(View.INVISIBLE);
//                    }
//                }
//            });
//            num++;
//        }

//        for(int i = 0; i < 9; i++){
//            num = i;
//            btnMEMO[num].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton compoundButton, boolean buf) {
//                    if (buf) {
//                        memos[num].setVisibility(View.VISIBLE);
//                        clickBuf[num] = true;
//                    } else {
//                        memos[num].setVisibility(View.INVISIBLE);
//                    }
//                }
//            });
//        }

        btnMEMO[0].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean buf) {
                if (buf) {
                    memos[0].setVisibility(View.VISIBLE);
                    clickBuf[0] = true;
                } else {
                    memos[0].setVisibility(View.INVISIBLE);
                }
            }
        });

        btnMEMO[1].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean buf) {
                if (buf) {
                    memos[1].setVisibility(View.VISIBLE);
                    clickBuf[1] = true;
                } else {
                    memos[1].setVisibility(View.INVISIBLE);
                }
            }
        });

        btnMEMO[2].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean buf) {
                if (buf) {
                    memos[2].setVisibility(View.VISIBLE);
                    clickBuf[2] = true;
                } else {
                    memos[2].setVisibility(View.INVISIBLE);
                }
            }
        });

        btnMEMO[3].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean buf) {
                if (buf) {
                    memos[3].setVisibility(View.VISIBLE);
                    clickBuf[3] = true;
                } else {
                    memos[3].setVisibility(View.INVISIBLE);
                }
            }
        });

        btnMEMO[4].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean buf) {
                if (buf) {
                    memos[4].setVisibility(View.VISIBLE);
                    clickBuf[4] = true;
                } else {
                    memos[4].setVisibility(View.INVISIBLE);
                }
            }
        });

        btnMEMO[5].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean buf) {
                if (buf) {
                    memos[5].setVisibility(View.VISIBLE);
                    clickBuf[5] = true;
                } else {
                    memos[5].setVisibility(View.INVISIBLE);
                }
            }
        });

        btnMEMO[6].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean buf) {
                if (buf) {
                    memos[6].setVisibility(View.VISIBLE);
                    clickBuf[6] = true;
                } else {
                    memos[6].setVisibility(View.INVISIBLE);
                }
            }
        });

        btnMEMO[7].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean buf) {
                if (buf) {
                    memos[7].setVisibility(View.VISIBLE);
                    clickBuf[7] = true;
                } else {
                    memos[7].setVisibility(View.INVISIBLE);
                }
            }
        });

        btnMEMO[8].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean buf) {
                if (buf) {
                    memos[8].setVisibility(View.VISIBLE);
                    clickBuf[8] = true;
                } else {
                    memos[8].setVisibility(View.INVISIBLE);
                }
            }
        });

        findViewById(R.id.btnDEL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 9; i++) {
                    btnMEMO[i].setChecked(false);
                    memos[i].setVisibility(View.INVISIBLE);
                }
                dismiss();
            }
        });

        findViewById(R.id.btnCANCEL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 9; i++) {
                    if (clickBuf[i] == true) {
                        btnMEMO[i].setChecked(false);
                        memos[i].setVisibility(View.INVISIBLE);
                    }
                }
                dismiss();
            }
        });

        findViewById(R.id.btnOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}