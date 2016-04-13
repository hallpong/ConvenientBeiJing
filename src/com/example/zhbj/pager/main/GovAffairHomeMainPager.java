package com.example.zhbj.pager.main;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * 首页的五个viewpager中的第四个(政务)viewpager
 * @author Macintosh
 *
 */
public class GovAffairHomeMainPager extends BaseMainPager{

	public GovAffairHomeMainPager(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		tvTitle.setText("人口管理");
		
		setSlidingMenuEnable(true);
		TextView tvContent=new TextView(mActivity);
		tvContent.setText("政务");
		tvContent.setTextColor(Color.RED);
		tvContent.setTextSize(30);
		tvContent.setGravity(Gravity.CENTER);
		
		//向FrameLayout中动态添加View
		flContent.addView(tvContent);
		
	}

}
