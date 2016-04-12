package com.example.zhbj.util;

import android.util.Log;

/**
 * �ṩ���Դ�ӡ�����Լ�����Ŀ��ɺ�һ�����ս��ӡ����
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
	private static final int NOTHING = 6;// �ڸü���ʱ������ӡ�κζ�����
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
