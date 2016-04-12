package com.example.zhbj.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * 首页的五个viewpager中的第二个(新闻中心)viewpager
 * @author Macintosh
 *
 */
public class NewsCenterMainPager extends BaseMainPager{

	public NewsCenterMainPager(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		tvTitle.setText("新闻");
		
		TextView tvContent=new TextView(mActivity);
		tvContent.setText("新闻中心");
		tvContent.setTextColor(Color.RED);
		tvContent.setTextSize(30);
		tvContent.setGravity(Gravity.CENTER);
		
		//向FrameLayout中动态添加View
		flContent.addView(tvContent);
		
	}

}
