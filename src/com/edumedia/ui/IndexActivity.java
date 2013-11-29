package com.edumedia.ui;

import java.io.File;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class IndexActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_index);
		
	}
	
	public void cast(View view){
		boolean checkNetWork = this.checkNetWork();
		Intent intent = new Intent(this,MediaActivity.class);
		intent.setData(Uri.parse("file:///mnt/sdcard/哦哦哦。/哦哦哦.mp4"));
		this.startActivity(intent);
	}
}
