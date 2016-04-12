package com.example.zhbj.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * 首页的五个viewpager中的第一个(默认)viewpager
 * @author Macintosh
 *
 */
public class HomeMainPager extends BaseMainPager{

	public HomeMainPager(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		tvTitle.setText("智慧北京");
		
		TextView tvContent=new TextView(mActivity);
		tvContent.setText("首页");
		tvContent.setTextColor(Color.RED);
		tvContent.setTextSize(30);
		tvContent.setGravity(Gravity.CENTER);
		
		//向FrameLayout中动态添加View
		flContent.addView(tvContent);
		
	}

}
