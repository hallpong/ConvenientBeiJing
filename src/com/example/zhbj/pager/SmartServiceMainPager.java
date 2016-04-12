package com.example.zhbj.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * ��ҳ�����viewpager�еĵ�����(�ǻ۷���)viewpager
 * @author Macintosh
 *
 */
public class SmartServiceMainPager extends BaseMainPager{

	public SmartServiceMainPager(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		tvTitle.setText("����");
		
		TextView tvContent=new TextView(mActivity);
		tvContent.setText("�ǻ۷���");
		tvContent.setTextColor(Color.RED);
		tvContent.setTextSize(30);
		tvContent.setGravity(Gravity.CENTER);
		
		//��FrameLayout�ж�̬���View
		flContent.addView(tvContent);
		
	}

}
