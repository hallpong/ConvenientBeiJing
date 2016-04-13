package com.example.zhbj.fragment;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhbj.R;
import com.example.zhbj.activity.MainActivity;
import com.example.zhbj.domain.NewsData;
import com.example.zhbj.domain.NewsData.NewsMenuData;
import com.example.zhbj.pager.main.NewsCenterMainPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 左侧边栏
 * 
 * @author Macintosh
 *
 */
public class LeftMenuFragment extends BaseFragment {

	private ArrayList<NewsMenuData> menuDataList;

	@ViewInject(R.id.lv_left_menu)
	private ListView lvMenu;

	private int mCurrentPosition;// 当前处在listview的item位置

	private MyListViewAdapter mAdapter;

	/**
	 * 初始化Fragment布局
	 */
	@Override
	public View initView() {
		View view = View.inflate(mActivity, R.layout.fragment_left_menu, null);
		ViewUtils.inject(this, view);
		return view;
	}

	/**
	 * 初始化数据
	 */
	@Override
	public void initData() {
		lvMenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				mCurrentPosition = position;
				mAdapter.notifyDataSetChanged();
				setCurrentMenuDetail(position);
				toggleSlidingMenu();// 切换SlidingMenu显示或隐藏
			}
		});
	}

	/**
	 * 设置当前menu的选项所对应新闻的详细信息
	 * @param position
	 */
	protected void setCurrentMenuDetail(int position) {
		MainActivity MainUi = (MainActivity) mActivity;
		ContentFragment contentFragment = MainUi.getContentFragment();
		NewsCenterMainPager mainPager = contentFragment
				.getNewsCenterMainPager();
		mainPager.setCurrentMenuDetailPager(position);

	}

	/**
	 * 设置SlidingMenu隐藏或显示
	 */
	protected void toggleSlidingMenu() {
		MainActivity mainUi = (MainActivity) mActivity;
		SlidingMenu slidingMenu = mainUi.getSlidingMenu();
		slidingMenu.toggle();// 显示状态则切换成隐藏 隐藏则切换成显示
	}

	/**
	 * 设置网络获取的数据
	 * 
	 * @param data
	 */
	public void setMenuData(NewsData data) {
		menuDataList = data.data;
		mAdapter = new MyListViewAdapter();
		lvMenu.setAdapter(mAdapter);
	}

	/**
	 * adapter
	 * 
	 * @author Macintosh
	 *
	 */
	class MyListViewAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return menuDataList.size();
		}

		@Override
		public NewsMenuData getItem(int position) {
			return menuDataList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = View.inflate(mActivity,
					R.layout.list_view_items_leftmenu, null);
			TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
			tvTitle.setText(getItem(position).title);
			if (mCurrentPosition == position) {
				tvTitle.setEnabled(true);
			}else{
				tvTitle.setEnabled(false);
			}
			return view;
		}
	}

}
