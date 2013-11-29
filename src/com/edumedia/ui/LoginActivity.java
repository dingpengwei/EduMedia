package com.edumedia.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.SeekBar;

public class LoginActivity extends BaseActivity {
	
	SeekBar sb_activity_login_login = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_login);
		this.sb_activity_login_login = (SeekBar) this.findViewById(R.id.sb_activity_login_login);
//		Intent intent = new Intent(this,WebActivity.class);
//		this.startActivity(intent);
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<100;i++){
					Message message = new Message();
					message.what = i;
					subHandler.sendMessage(message);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
	}
	
	int index = 0;
	 @Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		System.out.println("================" + index);
		index ++;
	}
	 @Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		System.out.println("------------" + index);
		index ++ ;
	}

	/**
	 * 登陆
	 * @param view
	 */
	public void login(View view){
		this.checkNetWork();
	}
	
	private Handler subHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			sb_activity_login_login.setProgress(msg.what);
			sb_activity_login_login.setSecondaryProgress(msg.what * 2);
		};
	};
}
