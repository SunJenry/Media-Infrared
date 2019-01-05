package com.sun.remotecontroller;

import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    L,A,A',B,B',C,C',  S, L,A,A',B,B',C,C'

    int zeroLow = 560;
    int zeroHigh = 560;
    int oneLow = 560;
    int oneHigh = 1680;


    public static final int zeroLogic1 = 560;
    public static final int zeroLogic2 = 560;
    public static final int oneLogic1 = 560;
    public static final int oneLogic2 = 1680;

    public static final int[] open1 = {
            4500, 4500,
            // 1011
            // 0010,
            // 0100
            // 1101,
            oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, oneLogic1, oneLogic2,
            zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2,
            zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2,
            oneLogic1, oneLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2,
            //0001
            // 1111,
            // 1110
            // 0000,

            //5F
            //0101 1111
            //1010 0000
            zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2,
            oneLogic1, oneLogic2, oneLogic1, oneLogic2, oneLogic1, oneLogic2, oneLogic1, oneLogic2,
            oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2,
            zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2,
            // 0100
            // 1100,
            // 1011
            // 0011,
            //1011 1100
            //0100 0011
//            zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2,
//            oneLogic1, oneLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2,
//            oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, oneLogic1, oneLogic2,
//            zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, oneLogic1, oneLogic2,
            oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, oneLogic1, oneLogic2,
            oneLogic1, oneLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2,
            zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2,
            zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, oneLogic1, oneLogic2,

            500, 5300,
            4500, 4500,

            //            10110010, 01001101,
            oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, oneLogic1, oneLogic2,
            zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2,
            zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2,
            oneLogic1, oneLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2,

            zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2,
            oneLogic1, oneLogic2, oneLogic1, oneLogic2, oneLogic1, oneLogic2, oneLogic1, oneLogic2,
            oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2,
            zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2,
//            01001100, 10110011,
            oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, oneLogic1, oneLogic2,
            oneLogic1, oneLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2,
            zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2,
            zeroLogic1, zeroLogic2, zeroLogic1, zeroLogic2, oneLogic1, oneLogic2, oneLogic1, oneLogic2,

            560, 20000
    };

    int[] OPEN = {
            4500, 4500,
            //1011 0010 A
            oneLow, oneHigh, zeroLow, zeroHigh, oneLow, oneHigh, oneLow, oneHigh,
            zeroLow, zeroHigh, zeroLow, zeroHigh, oneLow, oneHigh, zeroLow, zeroHigh,           //A
            //0100 1101 a
            zeroLow, zeroHigh, oneLow, oneHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,
            oneLow, oneHigh, oneLow, oneHigh, zeroLow, zeroHigh, oneLow, oneHigh,         //A'
            //1011 1111 B
            oneLow, oneHigh, zeroLow, zeroHigh, oneLow, oneHigh, oneLow, oneHigh,
            oneLow, oneHigh, oneLow, oneHigh, oneLow, oneHigh, oneLow, oneHigh,        //B
            //0100 0000 b
            zeroLow, zeroHigh, oneLow, oneHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,
            zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,            //B'
            //1011 1111 C
            zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,
            oneLow, oneHigh, zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,           //C
            //0100 0000 c
            zeroLow, zeroHigh, oneLow, oneHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,
            zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,//C'
            500, 5300,
            4500, 4500,
            //1011 0010 A
            oneLow, oneHigh, zeroLow, zeroHigh, oneLow, oneHigh, oneLow, oneHigh,
            zeroLow, zeroHigh, zeroLow, zeroHigh, oneLow, oneHigh, zeroLow, zeroHigh,           //A
            //0100 1101 a
            zeroLow, zeroHigh, oneLow, oneHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,
            oneLow, oneHigh, oneLow, oneHigh, zeroLow, zeroHigh, oneLow, oneHigh,         //A'
            //1011 1111 B
            oneLow, oneHigh, zeroLow, zeroHigh, oneLow, oneHigh, oneLow, oneHigh,
            oneLow, oneHigh, oneLow, oneHigh, oneLow, oneHigh, oneLow, oneHigh,        //B
            //0100 0000 b
            zeroLow, zeroHigh, oneLow, oneHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,
            zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,            //B'
            //1011 1111 C
            zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,
            oneLow, oneHigh, zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,           //C
            //0100 0000 c
            zeroLow, zeroHigh, oneLow, oneHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,
            zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh, zeroLow, zeroHigh,//C'
            560, 20000
    };

    private ConsumerIrManager mConsumerIrManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mConsumerIrManager = (ConsumerIrManager) getSystemService(Context.CONSUMER_IR_SERVICE);
        if (mConsumerIrManager != null && mConsumerIrManager.hasIrEmitter()) {
            Toast.makeText(MainActivity.this, "有红外！！！", Toast.LENGTH_SHORT).show();
        }

        findViewById(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControllerUtils.openWarm30(MainActivity.this);
            }
        });

        findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mConsumerIrManager.transmit(38000, OPEN);
            }
        });

        AlarmUtils.setAlarm(MainActivity.this);
    }
}
