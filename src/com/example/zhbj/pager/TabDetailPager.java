package com.example.zhbj.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.zhbj.domain.NewsData.NewsTabData;
import com.example.zhbj.pager.newscenter.NewsCenterBasePager;

public class TabDetailPager extends NewsCenterBasePager{

	public NewsTabData mTabData;
	private TextView tvText;
	
	public TabDetailPager(Activity activity, NewsTabData tabData) {
		super(activity);
		mTabData=tabData;
	}

	@Override
	public View initView() {
		tvText = new TextView(mActivity);
		tvText.setText("ÐÂÎÅÒ³Ç©ÏêÇéÒ³");
		tvText.setTextColor(Color.RED);
		tvText.setTextSize(30);
		tvText.setGravity(Gravity.CENTER);
		return tvText;
	}

	@Override
	public void initData() {
		tvText.setText(mTabData.title);
	}
}
