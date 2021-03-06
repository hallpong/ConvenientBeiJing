package com.example.zhbj.pager.newscenter;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * 侧滑菜单栏互动选项所对应的布局
 * @author Macintosh
 *
 */
public class InteractPager extends NewsCenterBasePager{

	public InteractPager(Activity activity) {
		super(activity);
	}

	@Override
	public View initView() {
		TextView tvContent=new TextView(mActivity);
		tvContent.setText("互动页面");
		tvContent.setTextColor(Color.RED);
		tvContent.setTextSize(30);
		tvContent.setGravity(Gravity.CENTER);
		return tvContent;
	}
}
