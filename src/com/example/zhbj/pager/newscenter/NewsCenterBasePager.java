package com.example.zhbj.pager.newscenter;

import android.app.Activity;
import android.view.View;
/**
 * NewsCenter�ڶ�Ӧ�ڲ�߲˵�����ͬ���ĸ�ѡ������ʾ���ĸ���ͬviewpager�Ļ���
 * @author Macintosh
 *
 */
public abstract class NewsCenterBasePager {

	public Activity mActivity;
	public View mView;//���NewsCenterPager�ڵ�FrameLayout����
	
	public NewsCenterBasePager(Activity activity){
		mActivity=activity;
		mView=initView();
	}

	/**
	 * ���½���
	 * @return ����View����������ӵ�NewsCenterPager�е�FrameLayout������
	 */
	public abstract View initView();
	
	/**
	 * ��������
	 */
	public void initData(){
		
	};
}
