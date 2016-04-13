package com.example.zhbj.pager.main;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * 首页的五个viewpager中的第五个(设置)viewpager
 * @author Macintosh
 *
 */
public class SettingMainPager extends BaseMainPager{

	public SettingMainPager(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		tvTitle.setText("设置");
		
		ibtMenu.setVisibility(View.GONE);//隐藏菜单按钮
		setSlidingMenuEnable(false);//关闭侧边栏功能
		
		TextView tvContent=new TextView(mActivity);
		tvContent.setText("设置");
		tvContent.setTextColor(Color.RED);
		tvContent.setTextSize(30);
		tvContent.setGravity(Gravity.CENTER);
		
		//向FrameLayout中动态添加View
		flContent.addView(tvContent);
		
	}

}
