package com.lujianfei.webapptest.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/*
��Ȩ���У���Ȩ����(C)2013���������
�ļ����ƣ�com.lujianfei.servicesWebViewService.java
ϵͳ��ţ�
ϵͳ���ƣ�SMART-IVI
ģ���ţ�
ģ�����ƣ�
����ĵ���
������ڣ�2013-5-27
�� �ߣ�½����
����ժҪ�� 
���еĴ�������������Σ���������������������෽������
�ļ�����:
 */
public class WebViewService extends Service {
String tag = "WebViewService";
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		log("onCreate");
	}
	void log(String msg){
		Log.d(tag,msg);
	}
}


