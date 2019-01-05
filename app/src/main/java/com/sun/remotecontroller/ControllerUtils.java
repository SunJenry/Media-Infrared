package com.sun.remotecontroller;

import android.content.Context;
import android.hardware.ConsumerIrManager;

/**
 * @author sun on 2018/11/24.
 */
public class ControllerUtils {

    public static final int zeroLogic1 = 560;
    public static final int zeroLogic2 = 560;
    public static final int oneLogic1 = 560;
    public static final int oneLogic2 = 1680;

    public static final int[] WARM_30 = {
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


    public static void openWarm30(Context context) {
        ConsumerIrManager consumerIrManager = (ConsumerIrManager) context.getSystemService(Context.CONSUMER_IR_SERVICE);
        if (consumerIrManager != null && consumerIrManager.hasIrEmitter()) {
            consumerIrManager.transmit(38000, WARM_30);
        }
    }
}
