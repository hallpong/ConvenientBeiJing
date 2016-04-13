package com.example.zhbj.pager.newscenter;

import android.app.Activity;
import android.view.View;
/**
 * NewsCenter内对应于侧边菜单栏不同的四个选项所显示于四个不同viewpager的基类
 * @author Macintosh
 *
 */
public abstract class NewsCenterBasePager {

	public Activity mActivity;
	public View mView;//填充NewsCenterPager内的FrameLayout布局
	
	public NewsCenterBasePager(Activity activity){
		mActivity=activity;
		mView=initView();
	}

	/**
	 * 更新界面
	 * @return 返回View对象，用来添加到NewsCenterPager中的FrameLayout布局内
	 */
	public abstract View initView();
	
	/**
	 * 更新数据
	 */
	public void initData(){
		
	};
}
