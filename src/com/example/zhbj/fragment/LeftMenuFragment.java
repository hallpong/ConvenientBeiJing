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
 * ������
 * 
 * @author Macintosh
 *
 */
public class LeftMenuFragment extends BaseFragment {

	private ArrayList<NewsMenuData> menuDataList;

	@ViewInject(R.id.lv_left_menu)
	private ListView lvMenu;

	private int mCurrentPosition;// ��ǰ����listview��itemλ��

	private MyListViewAdapter mAdapter;

	/**
	 * ��ʼ��Fragment����
	 */
	@Override
	public View initView() {
		View view = View.inflate(mActivity, R.layout.fragment_left_menu, null);
		ViewUtils.inject(this, view);
		return view;
	}

	/**
	 * ��ʼ������
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
				toggleSlidingMenu();// �л�SlidingMenu��ʾ������
			}
		});
	}

	/**
	 * ���õ�ǰmenu��ѡ������Ӧ���ŵ���ϸ��Ϣ
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
	 * ����SlidingMenu���ػ���ʾ
	 */
	protected void toggleSlidingMenu() {
		MainActivity mainUi = (MainActivity) mActivity;
		SlidingMenu slidingMenu = mainUi.getSlidingMenu();
		slidingMenu.toggle();// ��ʾ״̬���л������� �������л�����ʾ
	}

	/**
	 * ���������ȡ������
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
