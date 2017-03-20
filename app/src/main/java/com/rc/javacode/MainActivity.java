package com.rc.javacode;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private String sign="MainActivity";//Log日志的标记
    private Button button;
    private TextView textView;
    private ImageView imageView;
    private Animation animation;
    private Button button2;
    private Animation shadow;
    private Button second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView1);
        second=(Button)findViewById(R.id.button4);
        //log日志调试级别
        Log.v(sign,"属于--普通信息--级别");
        Log.d(sign,"属于--调试信息--级别");
        Log.i(sign,"属于--提示信息--级别");
        Log.w(sign,"属于--警告信息--级别");
        Log.e(sign,"属于--错误信息--级别");
        //实现图片缩放效果
        animation = AnimationUtils.loadAnimation(this, R.anim.anima);
        //对按钮实现监听
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("实现更换文本同时缩放图片效果");
                imageView.startAnimation(animation);//关联初始化参数
                Log.i(sign,"提示信息");
                toast("我是一个toast");//关联toast（）方法
            }
        });
        //实现渐变效果
        //1、初始化按钮
        button2= (Button) findViewById(R.id.button2);
        //2、初始化渐变效果
        shadow=AnimationUtils.loadAnimation(this, R.anim.shadow);
        //3、为按钮绑定监听事件
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("实现更换文本同时渐变显示");
                textView.startAnimation(shadow);
            }
        });
        //页面跳转的监听事件,关联toSecondPage（）
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSecondPage();
            }
        });

    }

    //实现页面跳转
    private void toSecondPage(){
        Intent intent=new Intent(this,Second.class);
        startActivity(intent);
    }
    //toast提示（温馨提示）
    private void toast(String content){
        Toast toast=Toast.makeText(this,content,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }



    //Dialog提示(实现关闭当前应用)
    private void dialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("温馨提示");
        builder.setMessage("确认退出吗？");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
    //重写返回按钮的方法，调用dialog方法
    @Override
    public void onBackPressed() {
        dialog();
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



