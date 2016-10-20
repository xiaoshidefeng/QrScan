package com.example.cw.qrlogintest;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity {

    //账号输入
    private EditText etAccount;

    //密码输入
    private EditText etPassword;
    //

    //登录按钮
    private  Button Btnlonin;

    //扫码登录按钮
    private Button btnScan;

    //扫码结果显示
    private TextView tvResult;

    //登录接口
    private String loninUrl="";

    //获取的账号
    private String account=null;

    //获取的密码
    private  String password=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Btnlonin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.id_Btnlogin){
                    account=etAccount.getText().toString();
                    password=etPassword.getText().toString();
                    if(account.equals("")||account==null||password.equals("")||password==null){
                        //提示输入为空
                        Toast.makeText(MainActivity.this,"请输入密码和账号",Toast.LENGTH_SHORT).show();
                        tvResult.setText("null");
                        return;
                    }
                    sendHttpURLconnection();

                }


            }
        });
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    private void sendHttpURLconnection() {
        //开启子线程访问网络
        new Thread(new Runnable() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                HttpURLConnection connection = null;

            }
        });
    }

    private void initView() {
        //初始化控件
        btnScan=(Button)findViewById(R.id.id_btnScan);
        tvResult=(TextView)findViewById(R.id.id_tvResult);
        etAccount=(EditText)findViewById(R.id.id_ETaccount);
        etPassword=(EditText)findViewById(R.id.id_ETpassword);
        Btnlonin=(Button)findViewById(R.id.id_Btnlogin);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK){
            String result= data.getExtras().getString("result");
            tvResult.setText(result);
        }
    }


}
