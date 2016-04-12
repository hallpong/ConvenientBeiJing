package com.example.zhbj.fragment;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.zhbj.R;
import com.example.zhbj.pager.BaseMainPager;
import com.example.zhbj.pager.GovAffairHomeMainPager;
import com.example.zhbj.pager.HomeMainPager;
import com.example.zhbj.pager.NewsCenterMainPager;
import com.example.zhbj.pager.SettingMainPager;
import com.example.zhbj.pager.SmartServiceMainPager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 主页面内容
 * 
 * @author Macintosh
 *
 */
public class ContentFragment extends BaseFragment {

	@ViewInject(R.id.rg_home)
	private RadioGroup rgMain;
	
	@ViewInject(R.id.vp_content)
	private ViewPager vpContent;
	
	private ArrayList<BaseMainPager> mViewPagerList;

	@Override
	public View initView() {
		View view = View.inflate(mActivity, R.layout.fragment_content, null);
		//rgMain = (RadioGroup) view.findViewById(R.id.rg_home);
		ViewUtils.inject(this, view);
		return view;
	}
	
	@Override
	public void initData() {
		rgMain.check(R.id.rb_home);//设置默认项目
		
		mViewPagerList=new ArrayList<BaseMainPager>();
		//将各个viewpager加入集合当中
		mViewPagerList.add(new HomeMainPager(mActivity));
		mViewPagerList.add(new NewsCenterMainPager(mActivity));
		mViewPagerList.add(new SmartServiceMainPager(mActivity));
		mViewPagerList.add(new GovAffairHomeMainPager(mActivity));
		mViewPagerList.add(new SettingMainPager(mActivity));
		
		vpContent.setAdapter(new MyViewPagerAdapter());
		
		rgMain.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_home:
					vpContent.setCurrentItem(0, false);
					break;

				case R.id.rb_news:
					vpContent.setCurrentItem(1, false);
					break;
				case R.id.rb_smart:
					vpContent.setCurrentItem(2, false);
					break;
				case R.id.rb_gov:
					vpContent.setCurrentItem(3, false);
					break;
				case R.id.rb_setting:
					vpContent.setCurrentItem(4, false);
					break;
				default:
					break;
				}
			}
		});
		
		vpContent.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				mViewPagerList.get(arg0).initData();
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
		mViewPagerList.get(0).initData();
	}

	class MyViewPagerAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return mViewPagerList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			BaseMainPager pager=mViewPagerList.get(position);
			container.addView(pager.mRootView);
			return pager.mRootView;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}
}
