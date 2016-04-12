package com.example.zhbj.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * 首页的五个viewpager中的第三个(智慧服务)viewpager
 * @author Macintosh
 *
 */
public class SmartServiceMainPager extends BaseMainPager{

	public SmartServiceMainPager(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		tvTitle.setText("生活");
		
		TextView tvContent=new TextView(mActivity);
		tvContent.setText("智慧服务");
		tvContent.setTextColor(Color.RED);
		tvContent.setTextSize(30);
		tvContent.setGravity(Gravity.CENTER);
		
		//向FrameLayout中动态添加View
		flContent.addView(tvContent);
		
	}

}
