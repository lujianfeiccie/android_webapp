package com.lujianfei.webapptest;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestPageActivity extends Activity {
	private WebView mWebView;     
	private Button  bt_test;
	private EditText edit_test;
    private Handler mHandler = new Handler();   
    int _count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_page);
        mWebView = (WebView) findViewById(R.id.webview);
        bt_test = (Button)findViewById(R.id.bt_test);
        edit_test = (EditText)findViewById(R.id.edit_test);
        WebSettings webSettings = mWebView.getSettings();     
        webSettings.setJavaScriptEnabled(true);     
        mWebView.addJavascriptInterface(new Object() {     
            public void clickOnAndroid(String count) {
            	final String t_count = count;
                mHandler.post(new Runnable() {     
                    public void run() {     
                      //  Toast.makeText(MainActivity.this,"Click on Webpage!", Toast.LENGTH_LONG).show();
                    	edit_test.setText(t_count+"");
                    }     
                });     
            }     
        }, "demo");     
        mWebView.loadUrl("file:///android_asset/index.html");  
        
        bt_test.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//mWebView.loadUrl("javascript:wave()");
				  mWebView.loadUrl("javascript:wave('"+_count+"')");
				  //javascript:·½·¨Ãû
				  ++_count;
			}
        });
    }
    

}
