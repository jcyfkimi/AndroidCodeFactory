/**
 *  @Title: SysApplication.java
 *  @Package: com.example.androidcodefactory.utils
 *  @Description: TODO
 *  @Author: 514435771 http://www.eoeandroid.com/thread-265652-1-1.html
 *  @Date: 2013-4-13 ÏÂÎç4:12:16
 *  @Version: V1.0
 */
package com.example.androidcodefactory.utils;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

/**
 * @ClassName: SysApplication
 * @Description: Used for exit all activities.
 * @Usage: Call SysApplication.getInstance().addActivity(this); in activity's
 *         OnCreate function. When want to finish all the activities and exit
 *         application, call SysApplication.getInstance().exit();
 * @Author: 514435771 http://www.eoeandroid.com/thread-265652-1-1.html
 * @Date: 2013-4-13 ÏÂÎç4:12:16
 * 
 */
public class SysApplication extends Application {

	private List<Activity> mList = new LinkedList<Activity>();
	private static SysApplication instance;

	private SysApplication() {
	}

	public synchronized static SysApplication getInstance() {
		if (null == instance) {
			instance = new SysApplication();
		}
		return instance;
	}

	/**
	 * 
	 * @Title: addActivity
	 * @Description: Add a activity to mList
	 * @param: @param activity
	 * @return: void
	 * @throw
	 */
	public void addActivity(Activity activity) {
		mList.add(activity);
	}

	/**
	 * 
	 * @Title: exit
	 * @Description: exit all the activity
	 * @param: 
	 * @return: void
	 * @throw
	 */
	public void exit() {
		try {
			for (Activity activity : mList) {
				if (activity != null)
					activity.finish();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

	public void onLowMemory() {
		super.onLowMemory();
		System.gc();
	}
}
