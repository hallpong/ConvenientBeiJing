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
 * 首页的五个viewpager中的第二个(新闻中心)viewpager
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
		tvTitle.setText("新闻");

		getDataFromServer();
		/*
		 * //向FrameLayout中动态添加View flContent.addView(tvContent);
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
						// 获取数据成功
						String result = responseInfo.result;
						parseData(result);
					}

					@Override
					public void onFailure(HttpException error, String msg) {
						// 获取数据失败
						Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT)
								.show();
						error.printStackTrace();
					}
				});
	}

	/**
	 * 解析从服务器返回的数据
	 * 
	 * @param result
	 *            从服务器返回的数据
	 */
	protected void parseData(String result) {
		Gson gson = new Gson();
		mNewsData = gson.fromJson(result, NewsData.class);
		Log.d("aaa", mNewsData.toString());

		// 刷新侧边栏
		MainActivity mainUi = (MainActivity) mActivity;
		LeftMenuFragment leftMenuFragment = mainUi.getLeftMenuFragment();
		leftMenuFragment.setMenuData(mNewsData);

		// 将四个Menu选项对应的页面添加到集合中
		mPager = new ArrayList<NewsCenterBasePager>();
		mPager.add(new NewsDetailPager(mActivity,
				mNewsData.data.get(0).children));
		mPager.add(new TopicPager(mActivity));
		mPager.add(new PhotoPager(mActivity));
		mPager.add(new InteractPager(mActivity));
		// 设置默认详情页面
		setCurrentMenuDetailPager(0);
	}

	/**
	 * 设置显示在前台的pager
	 * 
	 * @param position
	 *            显示的pager的位置
	 */
	public void setCurrentMenuDetailPager(int position) {
		NewsCenterBasePager pager = mPager.get(position);
		flContent.removeAllViews();// 将之前的布局清除掉
		flContent.addView(pager.mView);// 添加组件

		// 设置当前的标题页
		NewsMenuData menuData = mNewsData.data.get(position);
		tvTitle.setText(menuData.title);

		// 初始化当前页面数据
		pager.initData();
	}

}
