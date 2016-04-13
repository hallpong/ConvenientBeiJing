package com.example.zhbj.pager.newscenter;

import java.util.ArrayList;

import com.example.zhbj.R;
import com.example.zhbj.domain.NewsData.NewsTabData;
import com.example.zhbj.pager.TabDetailPager;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 侧滑菜单栏新闻选项所对应的布局
 * 
 * @author Macintosh
 *
 */
public class NewsDetailPager extends NewsCenterBasePager {

	private ViewPager mViewPager;
	private ArrayList<TabDetailPager> mPagerList;
	private ArrayList<NewsTabData> mNewsTabaData;

	public NewsDetailPager(Activity activity, ArrayList<NewsTabData> children) {
		super(activity);
		mNewsTabaData = children;
	}

	@Override
	public View initView() {
		View view = View.inflate(mActivity, R.layout.news_menu_detail, null);
		mViewPager = (ViewPager) view.findViewById(R.id.vp_menu_detail);
		return view;
	}

	@Override
	public void initData() {
		mPagerList = new ArrayList<TabDetailPager>();

		for (int i = 0; i < mNewsTabaData.size(); i++) {
			TabDetailPager pager = new TabDetailPager(mActivity,
					mNewsTabaData.get(i));
			mPagerList.add(pager);
		}

		mViewPager.setAdapter(new MenuDetailPageAdapter());

	}

	class MenuDetailPageAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mNewsTabaData.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			TabDetailPager pager=mPagerList.get(position);
			container.addView(pager.mView);
			pager.initData();
			return pager.mView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}
}
