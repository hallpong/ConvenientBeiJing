package com.example.zhbj.pager.main;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
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
		
		ibtMenu.setVisibility(View.GONE);//���ز˵���ť
		setSlidingMenuEnable(false);//�رղ��������
		
		TextView tvContent=new TextView(mActivity);
		tvContent.setText("����");
		tvContent.setTextColor(Color.RED);
		tvContent.setTextSize(30);
		tvContent.setGravity(Gravity.CENTER);
		
		//��FrameLayout�ж�̬���View
		flContent.addView(tvContent);
		
	}

}
