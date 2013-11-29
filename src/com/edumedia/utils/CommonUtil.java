package com.edumedia.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
/**
 * @date 2013-06-04
 * @author DingPengwei
 * 
 */
public class CommonUtil {

	/**
	 * @date 2013-06-04
	 * @author DingPengwei
	 * @return 日期时间字符串
	 */
	public static String getDateTime(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String dateTime = format.format(date);
		return dateTime;
	}
	
	/**
	 * @date 2013-06-05
	 * @author DingPengwei
	 * @return SDCARD是否可用
	 */
	public static boolean sdCardIsAvailable() {
		String status = Environment.getExternalStorageState();
		if (!status.equals(Environment.MEDIA_MOUNTED)){
			return false;
		}
		return true;
	}
	
	/**
	 * @date 2013-06-05
	 * @author DingPengwei
	 * @param updateSize
	 * @return SDCARD是否有足够的空间，空间不足或SDCARD不可读写返回返回false
	 */
	public static boolean enoughSpaceOnSdCard(long updateSize) {
		String status = Environment.getExternalStorageState();
		if (!status.equals(Environment.MEDIA_MOUNTED))
			return false;
		return (updateSize < getRealSizeOnSdcard());
	}
	/**
	 * @date 2013-06-05
	 * @author DingPengwei
	 * @return SDCARD可用空间
	 */
	public static long getRealSizeOnSdcard() {
		File path = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();
		return availableBlocks * blockSize;
	}
	
	/**
	 * @date 2013-06-05
	 * @author DingPengwei
	 * @param updateSize
	 * @return 手机ROM是否有足够的空间
	 */
	public static boolean enoughSpaceOnPhone(long updateSize) {
		return getRealSizeOnPhone() > updateSize;
	}
	/**
	 * @date 2013-06-05
	 * @author DingPengwei
	 * @return ROM可用空间
	 */
	public static long getRealSizeOnPhone() {
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();
		long realSize = blockSize * availableBlocks;
		return realSize;
	}
	
	/**
	 * @date 2013-06-05
	 * @author DingPengwei
	 * @param context
	 * @param dpValue
	 * @return 手机分辨率从DP转成PX
	 */
	public static  int dip2px(Context context, float dpValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  
	  
	/**
	 * @date 2013-06-05
	 * @author DingPengwei
	 * @param context
	 * @param pxValue
	 * @return 手机分辨率从PX转成DP
	 */
	public static  int px2dip(Context context, float pxValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f)-15;  
    }  

}
