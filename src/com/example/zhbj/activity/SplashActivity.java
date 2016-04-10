package com.example.zhbj.activity;

import com.example.zhbj.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

/**
 * …¡∆¡“≥
 * 
 * @author Macintosh
 *
 */
public class SplashActivity extends Activity {

	private RelativeLayout rlSplash;
	private SharedPreferences mPref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);

		mPref = getSharedPreferences("config", MODE_PRIVATE);
		rlSplash = (RelativeLayout) findViewById(R.id.rl_splash);
		startAnimation();
	}

	private void startAnimation() {
		AnimationSet set = new AnimationSet(false);

		RotateAnimation rotate = new RotateAnimation(0, 360,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		rotate.setDuration(3000);
		rotate.setFillAfter(true);

		ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		scale.setDuration(3000);
		scale.setFillAfter(true);

		AlphaAnimation alpha = new AlphaAnimation(0, 1);
		alpha.setDuration(3000);
		alpha.setFillAfter(true);

		set.addAnimation(rotate);
		set.addAnimation(scale);
		set.addAnimation(alpha);

		rlSplash.startAnimation(set);

		set.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				jumpToNextActivity();
			}
		});
	}

	protected void jumpToNextActivity() {
		Intent intent;
		if(mPref.getBoolean("is_jump", false)){
			intent=new Intent(this, MainActivity.class);
		}else{
			intent = new Intent(this, GuideActivity.class);			
		}
		startActivity(intent);
		finish();
	}

}
