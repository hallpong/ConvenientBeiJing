package com.example.zhbj.pager;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zhbj.R;
/**
 * ��ҳ�����viewpagerҳ��Ļ���
 * @author Macintosh
 *
 */
public class BaseMainPager {

	public Activity mActivity;
	public View mRootView;//�����ֶ���
	public TextView tvTitle;//TextView����
	public ImageButton ibtMenu;//ImageButton����
	public FrameLayout flContent;//��ȡFrameLayout����
	
	public BaseMainPager(Activity activity){
		mActivity=activity;
		initView();
	}
	
	/**
	 * ��ʼ������
	 */
	public void initView(){
		mRootView = View.inflate(mActivity, R.layout.base_pager, null);
		tvTitle = (TextView) mRootView.findViewById(R.id.tv_title);
		ibtMenu=(ImageButton) mRootView.findViewById(R.id.ibt_menu);
		flContent=(FrameLayout) mRootView.findViewById(R.id.fl_content);
		
		ibtMenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//���������
				
			}
		});
	}
	
	/**
	 * ��ʼ������
	 */
	public void initData(){
		
	}
}
