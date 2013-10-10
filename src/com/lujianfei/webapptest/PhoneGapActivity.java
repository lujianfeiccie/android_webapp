package com.lujianfei.webapptest;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.phonegap.DroidGap;


public class PhoneGapActivity  extends DroidGap {
	String tag ="PhoneGapActivity";
	private long startTime = 0;
	private long endTime = 0;
	private ProgressDialog pd;
	WebView _WebView = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phonegap_page);
		log("onCreate");
		_WebView = (WebView)findViewById(R.id.webview);
		super.loadUrl("http://www.baidu.com",1000);
		//setWebViewClient(, _WebViewClient);
		setWebViewClient(_WebView, _WebViewClient);
	//	setwe
	}
	WebViewClient _WebViewClient = new WebViewClient(){
		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
			endTime = System.currentTimeMillis();
//			Toast.makeText(NormalLoadActivity.this, String.format("用时%s毫秒", endTime-startTime), 200).show();
//					// TODO Auto-generated method stub
			pd.setMessage("载入完毕！");
			pd.dismiss();
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);
			startTime = System.currentTimeMillis();
			//pd= ProgressDialog.show(NormalLoadActivity.this, "等待", "正在载入...");
			pd = getProgressDialog("等待", "正在载入...");
			pd.show();
			//WeakReference<Context> context = new WeakReference<Context>(NormalLoadActivity.this);
			//Toast.makeText(context.get(), "Finished loading !", 200).show();
		}
    };
    public ProgressDialog getProgressDialog(String title,String msg) {
		ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setIndeterminate(true);
		progressDialog.setTitle(title);
		progressDialog.setMessage(msg);
		progressDialog.setCancelable(true);
		return progressDialog;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}
	void log(String msg){
		Log.d(tag, msg);
	}
}