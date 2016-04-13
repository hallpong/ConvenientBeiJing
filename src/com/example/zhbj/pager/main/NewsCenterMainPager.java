package com.example.zhbj.pager.main;

import java.util.ArrayList;

import com.example.zhbj.activity.MainActivity;
import com.example.zhbj.domain.NewsData;
import com.example.zhbj.domain.NewsData.NewsMenuData;
import com.example.zhbj.fragment.LeftMenuFragment;
import com.example.zhbj.global.GlobalConstants;
import com.example.zhbj.pager.newscenter.InteractPager;
import com.example.zhbj.pager.newscenter.NewsCenterBasePager;
import com.example.zhbj.pager.newscenter.NewsDetailPager;
import com.example.zhbj.pager.newscenter.PhotoPager;
import com.example.zhbj.pager.newscenter.TopicPager;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ��ҳ�����viewpager�еĵڶ���(��������)viewpager
 * 
 * @author Macintosh
 *
 */
public class NewsCenterMainPager extends BaseMainPager {

	private NewsData mNewsData;
	private ArrayList<NewsCenterBasePager> mPager;

	public NewsCenterMainPager(Activity activity) {
		super(activity);
	}

	@Override
	public void initData() {
		tvTitle.setText("����");

		getDataFromServer();
		/*
		 * //��FrameLayout�ж�̬���View flContent.addView(tvContent);
		 */
		setSlidingMenuEnable(true);
	}

	private void getDataFromServer() {
		HttpUtils utils = new HttpUtils();

		Log.d("aaa", GlobalConstants.CATEGORIES_URL);
		utils.send(HttpMethod.GET, GlobalConstants.CATEGORIES_URL,
				new RequestCallBack<String>() {

					@Override
					public void onSuccess(ResponseInfo<String> responseInfo) {
						// ��ȡ���ݳɹ�
						String result = responseInfo.result;
						parseData(result);
					}

					@Override
					public void onFailure(HttpException error, String msg) {
						// ��ȡ����ʧ��
						Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT)
								.show();
						error.printStackTrace();
					}
				});
	}

	/**
	 * �����ӷ��������ص�����
	 * 
	 * @param result
	 *            �ӷ��������ص�����
	 */
	protected void parseData(String result) {
		Gson gson = new Gson();
		mNewsData = gson.fromJson(result, NewsData.class);
		Log.d("aaa", mNewsData.toString());

		// ˢ�²����
		MainActivity mainUi = (MainActivity) mActivity;
		LeftMenuFragment leftMenuFragment = mainUi.getLeftMenuFragment();
		leftMenuFragment.setMenuData(mNewsData);

		// ���ĸ�Menuѡ���Ӧ��ҳ����ӵ�������
		mPager = new ArrayList<NewsCenterBasePager>();
		mPager.add(new NewsDetailPager(mActivity,
				mNewsData.data.get(0).children));
		mPager.add(new TopicPager(mActivity));
		mPager.add(new PhotoPager(mActivity));
		mPager.add(new InteractPager(mActivity));
		// ����Ĭ������ҳ��
		setCurrentMenuDetailPager(0);
	}

	/**
	 * ������ʾ��ǰ̨��pager
	 * 
	 * @param position
	 *            ��ʾ��pager��λ��
	 */
	public void setCurrentMenuDetailPager(int position) {
		NewsCenterBasePager pager = mPager.get(position);
		flContent.removeAllViews();// ��֮ǰ�Ĳ��������
		flContent.addView(pager.mView);// ������

		// ���õ�ǰ�ı���ҳ
		NewsMenuData menuData = mNewsData.data.get(position);
		tvTitle.setText(menuData.title);

		// ��ʼ����ǰҳ������
		pager.initData();
	}

}
