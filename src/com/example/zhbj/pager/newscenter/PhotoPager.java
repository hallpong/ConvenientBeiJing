package com.example.zhbj.pager.newscenter;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * �໬�˵�����ͼѡ������Ӧ�Ĳ���
 * @author Macintosh
 *
 */
public class PhotoPager extends NewsCenterBasePager{

	public PhotoPager(Activity activity) {
		super(activity);
	}

	@Override
	public View initView() {
		TextView tvContent=new TextView(mActivity);
		tvContent.setText("��ͼҳ��");
		tvContent.setTextColor(Color.RED);
		tvContent.setTextSize(30);
		tvContent.setGravity(Gravity.CENTER);
		return tvContent;
	}
}
