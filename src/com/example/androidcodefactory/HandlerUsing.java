/**
 *  @Title: HandlerUsing.java
 *  @Package: com.example.androidcodefactory
 *  @Description: TODO
 *  @Author: Kimi_Jin jcyfkimi@gmail.com
 *  @Date: 2013-4-13 ÏÂÎç2:37:02
 *  @Version: V1.0
 */
package com.example.androidcodefactory;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @ClassName: HandlerUsing
 * @Description: One activity useing another activitiy's handler
 * @Author: Kimi_Jin jcyfkimi@gmail.com
 * @Date: 2013-4-13 ÏÂÎç2:37:02
 *
 */
public class HandlerUsing extends Activity {

	
	private Button handlerusing_btn = null;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handlerusing_layout);
		handlerusing_btn = (Button) findViewById(R.id.handlerusing_btn);
		handlerusing_btn.setText("click and see what's happens!");
		handlerusing_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message msg = Message.obtain();
				msg.obj = "this message is from another activity";
				MainActivity.MAINACTIVITY.uiHandler.sendMessage(msg);
				finish();
			}
		});
	}
	
	
}
