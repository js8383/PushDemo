package com.microsoft.firstapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class frag_social_login extends Fragment {

	private ImageButton googleBtn, fbBtn, twitterBtn, microsoftBtn;

	private int mPageNumber;
	public static final String ARG_PAGE = "page";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);

		ViewGroup v = (ViewGroup) inflater.inflate(R.layout.auth_login,
				container, false);
		googleBtn = (ImageButton) v.findViewById(R.id.googleBtn);
		fbBtn = (ImageButton) v.findViewById(R.id.fbBtn);
		twitterBtn = (ImageButton) v.findViewById(R.id.twitterBtn);
		microsoftBtn = (ImageButton) v.findViewById(R.id.microsoftBtn);

		return v;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mPageNumber = getArguments().getInt(ARG_PAGE);
	}

	public static Fragment create(int pageNumber) {
		frag_social_login fragment = new frag_social_login();
		Bundle args = new Bundle();
		args.putInt(ARG_PAGE, pageNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public int getPageNumber() {
		return mPageNumber;
	}

}
