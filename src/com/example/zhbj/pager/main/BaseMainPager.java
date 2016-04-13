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
 * ��ҳ�����viewpagerҳ��Ļ���
 * 
 * @author Macintosh
 *
 */
public class BaseMainPager {

	public Activity mActivity;
	public View mRootView;// �����ֶ���
	public TextView tvTitle;// TextView����
	public ImageButton ibtMenu;// ImageButton����
	public FrameLayout flContent;// ��ȡFrameLayout����

	public BaseMainPager(Activity activity) {
		mActivity = activity;
		initView();
	}

	/**
	 * ��ʼ������
	 */
	public void initView() {
		mRootView = View.inflate(mActivity, R.layout.base_pager, null);
		tvTitle = (TextView) mRootView.findViewById(R.id.tv_title);
		ibtMenu = (ImageButton) mRootView.findViewById(R.id.ibt_menu);
		flContent = (FrameLayout) mRootView.findViewById(R.id.fl_content);

		ibtMenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ������رղ����
				toggleSlidingMenu();
			}
		});
	}

	/**
	 * ������رղ����
	 */
	protected void toggleSlidingMenu() {
		MainActivity mainUi=(MainActivity) mActivity;
		SlidingMenu slidingMenu=mainUi.getSlidingMenu();
		slidingMenu.toggle();//����SlidingMenu��ǰ״̬���ùرջ���
	}

	/**
	 * ��ʼ������
	 */
	public void initData() {

	}

	/**
	 * ���ò�������ܿ�����ر�
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
