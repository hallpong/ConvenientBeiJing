package com.example.zhbj.pager.main;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zhbj.R;
import com.example.zhbj.activity.MainActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * 首页的五个viewpager页面的基类
 * 
 * @author Macintosh
 *
 */
public class BaseMainPager {

	public Activity mActivity;
	public View mRootView;// 根布局对象
	public TextView tvTitle;// TextView对象
	public ImageButton ibtMenu;// ImageButton对象
	public FrameLayout flContent;// 获取FrameLayout对象

	public BaseMainPager(Activity activity) {
		mActivity = activity;
		initView();
	}

	/**
	 * 初始化布局
	 */
	public void initView() {
		mRootView = View.inflate(mActivity, R.layout.base_pager, null);
		tvTitle = (TextView) mRootView.findViewById(R.id.tv_title);
		ibtMenu = (ImageButton) mRootView.findViewById(R.id.ibt_menu);
		flContent = (FrameLayout) mRootView.findViewById(R.id.fl_content);

		ibtMenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 开启或关闭侧边栏
				toggleSlidingMenu();
			}
		});
	}

	/**
	 * 开启或关闭侧边栏
	 */
	protected void toggleSlidingMenu() {
		MainActivity mainUi=(MainActivity) mActivity;
		SlidingMenu slidingMenu=mainUi.getSlidingMenu();
		slidingMenu.toggle();//根据SlidingMenu当前状态设置关闭或开启
	}

	/**
	 * 初始化数据
	 */
	public void initData() {

	}

	/**
	 * 设置侧边栏功能开启或关闭
	 * @param enable
	 */
	public void setSlidingMenuEnable(boolean enable) {
		MainActivity mainUi = (MainActivity) mActivity;
		SlidingMenu slidingMenu = mainUi.getSlidingMenu();
		if (enable) {
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		} else {
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		}
	}
}
