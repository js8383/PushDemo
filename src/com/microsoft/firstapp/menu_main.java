package com.microsoft.firstapp;

import java.net.MalformedURLException;

import com.google.gson.JsonObject;
import com.microsoft.windowsazure.mobileservices.*;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class menu_main extends BaseActivity {

	private final String TAG = "Main Login";

	private TextView head;

//	private frag_custom_login customLogin;

	private static final int NUM_PAGES = 2;
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;
//	protected FragmentManager fragmentManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE); //?
		setContentView(R.layout.menu);

//        fragmentManager = getFragmentManager();
		mPager = (ViewPager) findViewById(R.id.pager1);
		mPagerAdapter = new ScreenSlidePagerTwoAdapter(fragmentManager);
		mPager.setAdapter(mPagerAdapter);
		
		
	}

	private class ScreenSlidePagerTwoAdapter extends FragmentStatePagerAdapter {

		public ScreenSlidePagerTwoAdapter(FragmentManager fm) {
			super(fm);
		}

		

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return NUM_PAGES;
		}



		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
		   if (arg0==0) return menu_one.create(arg0);
		   else return menu_two.create(arg0);
		}
		
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	}

}
