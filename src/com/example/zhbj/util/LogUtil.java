package com.example.zhbj.util;

import android.util.Log;

/**
 * 提供调试打印服务，以及在项目完成后一次性终结打印服务。
 * 
 * @author Macintosh
 *
 */
public class LogUtil {

	private static final int VERBOSE = 1;
	private static final int DEBUG = 2;
	private static final int INFO = 3;
	private static final int WARN = 4;
	private static final int ERROR = 5;
	private static final int NOTHING = 6;// 在该级别时将不打印任何东西；
	private static final int LEVEL = 0;

	public static void v(String tag, String msg) {
		if (LEVEL < VERBOSE)
			Log.v(tag, msg);
	}
	
	public static void d(String tag, String msg) {
		if (LEVEL < DEBUG)
			Log.d(tag, msg);
	}
	
	public static void i(String tag, String msg) {
		if (LEVEL < INFO)
			Log.i(tag, msg);
	}
	
	public static void w(String tag, String msg) {
		if (LEVEL < WARN)
			Log.w(tag, msg);
	}
	
	public static void e(String tag, String msg) {
		if (LEVEL < ERROR)
			Log.e(tag, msg);
	}
	
	
}
