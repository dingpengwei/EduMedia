package com.edumedia.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.util.Log;

@SuppressWarnings("unused")
public class Looogger {
	private static String LOG_TAG = "Looogger";
	private static final String DEVELOP = "0";
	private static final String RELEASE = "1";
	private static String FLAG = DEVELOP;
	
	private static String PATH = "mnt/sdcard/EduMedia.txt";
	private static final File file  = new File(PATH);
	private static FileWriter writer = null;
	static{
		try {
			writer = new FileWriter(file, true);
		} catch (Exception e) {
			Log.i(LOG_TAG, "初始化日志文件异常");
		}
	}
	
	public static void error(String... infos){
		if(DEVELOP.equals(FLAG)){
			synchronized (file) {
				try {
					writer.write("\r\n\r\n---------------------Error---------------------【" + CommonUtil.getDateTime() + "】\r\n");
					for(String info:infos){
						writer.write(info);
					}
					writer.write("\r\n\r\n");
					writer.flush();
				} catch (Exception e) {
					Log.i(LOG_TAG, "写入错误日志文件异常");
				}
			}
		}
	}
	public static void error(StackTraceElement[] stackTrace){
		if(DEVELOP.equals(FLAG)){
			synchronized (file) {
				try {
					writer.write("\r\n\r\n---------------------Error---------------------【" + CommonUtil.getDateTime() + "】\r\n");
					for(StackTraceElement info:stackTrace){
						writer.write(info.toString());
					}
					writer.write("\r\n\r\n");
					writer.flush();
				} catch (Exception e) {
					Log.i(LOG_TAG, "写入错误日志文件异常");
				}
			}
		}
	}
	
	public static void info(String... infos){
		if(DEVELOP.equals(FLAG)){
			synchronized (file) {
				for(String info:infos){
					try {
						writer.write("【" + CommonUtil.getDateTime() + "】" + info + "\r\n");
						writer.flush();
					} catch (IOException e) {
						Log.i(LOG_TAG, "写入信息日志文件异常");
					}
				}
			}
		}
	}
	
}
