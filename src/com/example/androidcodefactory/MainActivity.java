package com.example.androidcodefactory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView main_text = null;
	private Button main_btn = null;
	public static MainActivity MAINACTIVITY = null;
	
	public Handler uiHandler = new Handler(){
		public void handleMessage(Message msg) {
			main_text.setText((String) msg.obj);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MAINACTIVITY = this;
		main_text = (TextView) findViewById(R.id.main_text);
		main_btn = (Button) findViewById(R.id.main_btn);
		main_btn.setText("test handler using!");
		main_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, HandlerUsing.class);
				MainActivity.this.startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
