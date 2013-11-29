package com.edumedia.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.Toast;

import com.edumedia.net.NetWorkHelper;
import com.edumedia.utils.Looogger;

public class BaseActivity extends Activity {
	private static final String TAG = "BaseActivity ";

	private NetWrokBroadcastReceiver netWrokBroadcastReceiver = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.netWrokBroadcastReceiver = new NetWrokBroadcastReceiver();
		if(this.netWrokBroadcastReceiver != null){
			Looogger.info(TAG + "初始化基类注册网络监听器" );
			this.registerReceiver(netWrokBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, null);
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
	
	@Override
	protected void onDestroy() {
		if(this.netWrokBroadcastReceiver != null){
			Looogger.info(TAG + "销毁基类移除网络监听器" );
			this.unregisterReceiver(netWrokBroadcastReceiver);
		}
		super.onDestroy();
	}
	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		return super.onCreateDialog(id, args);
	}
	
	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		super.onPrepareDialog(id, dialog);
	}
	private class NetWrokBroadcastReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			
		}
	}
	protected boolean checkNetWork(){
		try {
			if(NetWorkHelper.isWifiDataEnable(this)){
				Toast.makeText(this, "WIfI可用", Toast.LENGTH_SHORT).show();
				Looogger.info(TAG + "检测到已经连接到WIfI数据源" );
				return true;
			}
			if(NetWorkHelper.isMobileDataEnable(this)){
				Toast.makeText(this, "MOBIL可用", Toast.LENGTH_SHORT).show();
				Looogger.info(TAG + "检测到已经连接到蜂窝数据源");
				return true;
			}else {
				Toast.makeText(this, "网络不可用", Toast.LENGTH_SHORT).show();
				Looogger.info(TAG + "检测到网络不可用");
				return false;
			}
		} catch (Exception e) {
			Looogger.error(e.getStackTrace());
		}
		return false;
	}
	
	protected Handler baseHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			
		};
	};
}
