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

public class LogInActivity extends BaseActivity {

	private final String TAG = "Main Login";

	private TextView head;

//	private frag_custom_login customLogin;

	private static final int NUM_PAGES = 2;
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //?
		setContentView(R.layout.activity_main);

		head = (TextView) findViewById(R.id.loginHead1);
		Typeface typeFace = Typeface.createFromAsset(getAssets(),
				"fonts/samplefont.ttf");
		head.setTypeface(typeFace);


		mPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new ScreenSlidePagerAdapter(fragmentManager);
		mPager.setAdapter(mPagerAdapter);
		
	}

	private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

		public ScreenSlidePagerAdapter(FragmentManager fm) {
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
		   if (arg0==0) return frag_custom_login.create(arg0);
		   else return frag_social_login.create(arg0);
//			return frag_custom_login.create(arg0);
		}
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

//	private void setTabSelection(int index) {
//
//		FragmentTransaction transaction = fragmentManager.beginTransaction();
//
//		hideFragments(transaction);
//		if (index == 0) {
//			// 当点击了消息tab时，改变控件的图片和文字颜色
//
//			if (customLogin == null) {
//				// 如果MessageFragment为空，则创建一个并添加到界面上
//				customLogin = new frag_custom_login();
//				transaction.add(R.id.content, customLogin);
//
//			} else {
//				// 如果MessageFragment不为空，则直接将它显示出来
//				transaction.show(customLogin);
//			}
//
//		}
//		transaction.commit();
//	}
//
//	/**
//	 * 清除掉所有的选中状态。
//	 */
//
//	/**
//	 * 将所有的Fragment都置为隐藏状态。
//	 * 
//	 * @param transaction
//	 *            用于对Fragment执行操作的事务
//	 */
//	private void hideFragments(FragmentTransaction transaction) {
//		if (customLogin != null) {
//			transaction.hide(customLogin);
//		}
//	}

}
