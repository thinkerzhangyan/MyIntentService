package tk.thinkerzhangyan.myintentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;


public class  MyService extends IntentService {


    private static final String TAG = "MyService";

    public MyService() {
        super(TAG);
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        SystemClock.sleep(1000);
        Log.d(TAG,"::::name::::"+intent.getStringExtra("name"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}