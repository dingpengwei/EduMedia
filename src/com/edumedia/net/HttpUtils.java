package com.edumedia.net;

import org.apache.http.NameValuePair;

import android.content.Context;
import android.util.Log;

public class HttpUtils {
	// 网络连接部分
	public static String postByHttpURLConnection(String strUrl,NameValuePair... nameValuePairs) {
		return CustomHttpURLConnection.PostFromWebByHttpURLConnection(strUrl,nameValuePairs);
	}

	public static String getByHttpURLConnection(String strUrl,NameValuePair... nameValuePairs) {
		return CustomHttpURLConnection.GetFromWebByHttpUrlConnection(strUrl,nameValuePairs);
	}

	public static String postByHttpClient(Context context,String strUrl,NameValuePair... nameValuePairs) {
		return CustomHttpClient.PostFromWebByHttpClient(context,strUrl, nameValuePairs);
	}

	public static String getByHttpClient(Context context,String strUrl,NameValuePair... nameValuePairs) {
		return CustomHttpClient.getFromWebByHttpClient(context,strUrl, nameValuePairs);
	}

	// ------------------------------------------------------------------------------------------

	// 判断mobile网络是否可用
	public static boolean isMobileDataEnable(Context context) {
		try {
			return NetWorkHelper.isMobileDataEnable(context);
		} catch (Exception e) {
			return false;
		}
	}

	// 判断wifi网络是否可用
	public static boolean isWifiDataEnable(Context context) {
		String TAG = "httpUtils.isWifiDataEnable()";
		try {
			return NetWorkHelper.isWifiDataEnable(context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e(TAG, e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	// 设置Mobile网络开关
	public static void setMobileDataEnabled(Context context, boolean enabled) {
		String TAG = "httpUtils.setMobileDataEnabled";
		try {
			NetWorkHelper.setMobileDataEnabled(context, enabled);
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			e.printStackTrace();
		}
	}

	// 判断是否为漫游
	public static boolean isNetworkRoaming(Context context) {
		return NetWorkHelper.isNetworkRoaming(context);
	}
}
