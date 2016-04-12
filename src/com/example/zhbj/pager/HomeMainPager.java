package com.example.zhbj.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * ��ҳ�����viewpager�еĵ�һ��(Ĭ��)viewpager
 * @author Macintosh
 *
 */
public class HomeMainPager extends BaseMainPager{

	public HomeMainPager(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		tvTitle.setText("�ǻ۱���");
		
		TextView tvContent=new TextView(mActivity);
		tvContent.setText("��ҳ");
		tvContent.setTextColor(Color.RED);
		tvContent.setTextSize(30);
		tvContent.setGravity(Gravity.CENTER);
		
		//��FrameLayout�ж�̬���View
		flContent.addView(tvContent);
		
	}

}
