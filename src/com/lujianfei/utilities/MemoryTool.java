package com.lujianfei.utilities;

import java.util.List;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;

public class MemoryTool {
	String _packageName = "";
	int _pid = 0;
	Context _context;
   public MemoryTool(String packageName,Context context){
	   _packageName = packageName;
	   _context = context;
	   _pid = getPID(_packageName,context);
   }
	 // Print memory values
   public int getMemoryValue() {
       // get Activity manager
       ActivityManager activity_manager;
       activity_manager =  (ActivityManager)_context.getSystemService(Context.ACTIVITY_SERVICE);
       // Get memory Info
       int process_pid[] = new int[] {_pid};
       MemoryInfo[] memoryInfo = activity_manager.getProcessMemoryInfo(process_pid);
       return (memoryInfo[0].getTotalPss()/1024);
   }
	private int getPID(String packageName,Context context){
		int result = 0;
		ActivityManager mActivityManager = (ActivityManager) context
		  .getSystemService(context.ACTIVITY_SERVICE);
		try{
			  List<ActivityManager.RunningAppProcessInfo> mRunningProcess = mActivityManager
			  .getRunningAppProcesses();
			  for (ActivityManager.RunningAppProcessInfo amProcess : mRunningProcess)
			  {
				  if(amProcess.processName.equals(packageName)){
				  //names.add("PID: " + amProcess.pid
					//	  + " processName=" + amProcess.processName + " UID="+amProcess.uid+"");
					  return amProcess.pid;
				  }
			  }
		}catch(Exception e){
			return -1;
		}
		return result;
	}
}
