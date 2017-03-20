package com.rc.javacode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by MAC on 2017/3/20.
 */

public class Second extends Activity {
    private String sign="Second";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
    }
    //Activity声明周期
    //1、开始
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(sign,"onStart");
    }
    //2、摘要，重启
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(sign,"onResume");
    }
    //3、暂停
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(sign,"onPause");
    }
    //4、停止
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(sign,"onStop");
    }
    //5、重启
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(sign,"onRestart");
    }
    //6、销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(sign,"onDestroy");
    }

}
