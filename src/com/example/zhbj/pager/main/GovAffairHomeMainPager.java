package com.example.zhbj.pager.main;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * ��ҳ�����viewpager�еĵ��ĸ�(����)viewpager
 * @author Macintosh
 *
 */
public class GovAffairHomeMainPager extends BaseMainPager{

	public GovAffairHomeMainPager(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		tvTitle.setText("�˿ڹ���");
		
		setSlidingMenuEnable(true);
		TextView tvContent=new TextView(mActivity);
		tvContent.setText("����");
		tvContent.setTextColor(Color.RED);
		tvContent.setTextSize(30);
		tvContent.setGravity(Gravity.CENTER);
		
		//��FrameLayout�ж�̬���View
		flContent.addView(tvContent);
		
	}

}
