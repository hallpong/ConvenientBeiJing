package com.example.zhbj.fragment;

import com.example.zhbj.R;

import android.view.View;

/**
 * ��ҳ��
 * 
 * @author Macintosh
 *
 */
public class ContentFragment extends BaseFragment {

	@Override
	public View initView() {
		View view = View.inflate(mActivity, R.layout.fragment_content, null);
		return view;
	}

}
