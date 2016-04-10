package com.example.zhbj.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.example.zhbj.R;

/**
 * 引导页面
 * 
 * @author Macintosh
 *
 */
public class GuideActivity extends Activity {

	private final int[] IMAGE_IDS = new int[] { R.drawable.guide_1,
			R.drawable.guide_2, R.drawable.guide_3 };
	private ViewPager vpGuide;
	private ArrayList<ImageView> mImageViewList;
	private LinearLayout llPointGroup;
	private View redPoint;
	private int mWidth;
	private MyPageChangeListener listener;
	private Button btnEndGuide;
	private SharedPreferences mPref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_guide);

		mPref = getSharedPreferences("config", MODE_PRIVATE);

		btnEndGuide = (Button) findViewById(R.id.btn_endGuide);
		vpGuide = (ViewPager) findViewById(R.id.vp_guide);
		llPointGroup = (LinearLayout) findViewById(R.id.ll_point_group);
		redPoint = findViewById(R.id.point_red);
		initViews();
		vpGuide.setAdapter(new MyPagerAdapter());

		listener = new MyPageChangeListener();
		vpGuide.setOnPageChangeListener(listener);

		btnEndGuide.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mPref.edit().putBoolean("is_jump", true).apply();
				Intent intent = new Intent(GuideActivity.this,
						MainActivity.class);
				startActivity(intent);
				GuideActivity.this.finish();
			}
		});
	}

	/**
	 * 初始化ViewPager界面
	 */
	private void initViews() {
		mImageViewList = new ArrayList<ImageView>();
		for (int i = 0; i < IMAGE_IDS.length; i++) {
			ImageView image = new ImageView(this);
			image.setBackgroundResource(IMAGE_IDS[i]);
			mImageViewList.add(image);
		}

		for (int i = 0; i < IMAGE_IDS.length; i++) {
			View point = new View(this);
			point.setBackgroundResource(R.drawable.shape_point_gray);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					10, 10);
			if (i > 0)
				params.leftMargin = 10;
			point.setLayoutParams(params);
			llPointGroup.addView(point);
		}

		llPointGroup.getViewTreeObserver().addOnGlobalLayoutListener(
				new OnGlobalLayoutListener() {

					/**
					 * 完成绘制时调用此方法
					 */
					@Override
					public void onGlobalLayout() {
						mWidth = llPointGroup.getChildAt(1).getLeft()
								- llPointGroup.getChildAt(0).getLeft();
						llPointGroup.getViewTreeObserver()
								.removeGlobalOnLayoutListener(this);
					}
				});
		;
	}

	class MyPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mImageViewList.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(mImageViewList.get(position));
			return mImageViewList.get(position);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}

	class MyPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
			int len = (int) (positionOffset * mWidth) + position * mWidth;
			RelativeLayout.LayoutParams params = (LayoutParams) redPoint
					.getLayoutParams();
			params.leftMargin = len;

			redPoint.setLayoutParams(params);
		}

		@Override
		public void onPageSelected(int position) {
			if (position == mImageViewList.size() - 1) {
				btnEndGuide.setVisibility(View.VISIBLE);
			} else {
				btnEndGuide.setVisibility(View.INVISIBLE);
			}
		}

		@Override
		public void onPageScrollStateChanged(int state) {

		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
