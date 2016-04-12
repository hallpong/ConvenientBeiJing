package com.example.zhbj.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * ��ҳ�����viewpager�еĵ����(����)viewpager
 * @author Macintosh
 *
 */
public class SettingMainPager extends BaseMainPager{

	public SettingMainPager(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		tvTitle.setText("����");
		
		TextView tvContent=new TextView(mActivity);
		tvContent.setText("����");
		tvContent.setTextColor(Color.RED);
		tvContent.setTextSize(30);
		tvContent.setGravity(Gravity.CENTER);
		
		//��FrameLayout�ж�̬���View
		flContent.addView(tvContent);
		
	}

}
