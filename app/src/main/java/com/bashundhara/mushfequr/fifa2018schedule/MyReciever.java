package com.bashundhara.mushfequr.fifa2018schedule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public  class MyReciever extends BroadcastReceiver
{

    private static  final String TAG = MyReciever.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"Recieved Brodacast Intent");
        Intent intent1 =new Intent(context,AlarmService.class);
        context.startService(intent1);
    }
}
