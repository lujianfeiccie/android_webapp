package com.lujianfei.webapptest;

import java.lang.ref.WeakReference;

import com.lujianfei.webapptest.services.WebViewService;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this,WebViewService.class));
        ((Button)findViewById(R.id.bt_test)).setOnClickListener(
        		new OnClickListener(){
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						WeakReference<Context> context = new WeakReference<Context>(MainActivity.this);
						MainActivity.this.startActivity(new Intent(context.get(),TestPageActivity.class));
					}
        });
        ((Button)findViewById(R.id.bt_phoneGap)).setOnClickListener(
        		new OnClickListener(){
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						WeakReference<Context> context = new WeakReference<Context>(MainActivity.this);
						MainActivity.this.startActivity(new Intent(context.get(),PhoneGapActivity.class));
					}
        });
    }
}
