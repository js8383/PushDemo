package com.microsoft.firstapp;

import com.google.gson.JsonObject;
import com.microsoft.windowsazure.mobileservices.*;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class frag_custom_login extends Fragment {
	private Button signBtn, loginBtn;
	private LinearLayout loginWindow;
	private EditText passWord, userName;
	private Animation shake;

	private int mPageNumber;
    public static final String ARG_PAGE = "page";
    private ViewGroup v;
	
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//View v = inflater.inflate(R.layout.custom_login, container, false);
    	super.onCreateView(inflater, container, savedInstanceState);
		v = (ViewGroup) inflater.inflate(
				R.layout.custom_login, container, false);

		loginWindow = (LinearLayout) v.findViewById(R.id.loginWindow1);
		loginBtn = (Button) v.findViewById(R.id.btnLogIn);
		signBtn = (Button) v.findViewById(R.id.btnSignUp1);

		passWord = (EditText) v.findViewById(R.id.loginPassWord);
		userName = (EditText) v.findViewById(R.id.loginUserName);
		shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);

		loginBtn.setOnClickListener(new View.OnClickListener() {
			LogInActivity a = (LogInActivity) getActivity();

			@Override
			public void onClick(View arg0) {
				if (userName.getText().toString().equals("")
						&& passWord.getText().toString().equals("")) {
					Toast.makeText(getActivity(), "Redirecting...",
							Toast.LENGTH_SHORT).show();

					Intent i = new Intent(a, menu_main.class);
					startActivity(i);
					a.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

				} else if (userName.getText().toString().equals("1")
						|| passWord.getText().toString().equals("")) {
					// We're just logging this here, we should show something to
					// the
					// user
					// Log.w(TAG, "Username or password not entered");
					Toast tmp1 = Toast.makeText(a,
							"Empty username or password", Toast.LENGTH_SHORT);
					tmp1.setGravity(Gravity.BOTTOM, 0, -10);
					tmp1.show();
					loginBtn.startAnimation(shake);
					loginWindow.startAnimation(shake);
					return;
				} else {
					Toast tmp2 = Toast.makeText(a, "Redirecting...",
							Toast.LENGTH_SHORT);
					tmp2.setGravity(Gravity.BOTTOM, 0, -10);
					tmp2.show();
					userName.setEnabled(false);
					passWord.setEnabled(false);
					loginBtn.setEnabled(false);
					signBtn.setEnabled(false);

					a.mAuthService.login(userName.getText().toString(),
							passWord.getText().toString(),
							new TableJsonOperationCallback() {
								@Override
								public void onCompleted(JsonObject jsonObject,
										Exception exception,
										ServiceFilterResponse response) {

									userName.setEnabled(true);
									passWord.setEnabled(true);
									userName.setText("");
									passWord.setText("");
									loginBtn.setEnabled(true);
									signBtn.setEnabled(true);

									if (exception == null) {
										// If they've registered successfully,
										// we'll save and
										// set the userdata and then
										// show the logged in activity
										Toast tmp3 = Toast.makeText(a,
												"You're logged in",
												Toast.LENGTH_SHORT);
										tmp3.setGravity(Gravity.BOTTOM, 0, -10);
										tmp3.show();

										a.mAuthService
												.setUserAndSaveData(jsonObject);
										Intent loggedInIntent = new Intent(a,
												Aty1.class);
										startActivity(loggedInIntent);
										a.overridePendingTransition(
												R.anim.fade_in, R.anim.fade_out);
									} else {
										String errorMs = response.getContent();
										// Log.e(TAG, "Error loggin in: " +
										// exception.getMessage());
										loginBtn.startAnimation(shake);
										loginWindow.startAnimation(shake);
										Toast tmp4 = Toast.makeText(
												getActivity(),
												"Error loggin in: " + errorMs,
												Toast.LENGTH_SHORT);
										tmp4.setGravity(Gravity.BOTTOM, 0, -10);
										tmp4.show();

									}
								}
							});

				}
			}
		});

		signBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(getActivity(), SignUpActivity.class);
				startActivity(i);
				getActivity().overridePendingTransition(R.anim.fade_in,
						R.anim.fade_out);

			}
		});
		return v;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mPageNumber = getArguments().getInt(ARG_PAGE);
	}
	
	public static Fragment create(int pageNumber) {
	    System.out.println("pagenumber is -------------------" + pageNumber);
		frag_custom_login fragment = new frag_custom_login();
		Bundle args = new Bundle();
		args.putInt(ARG_PAGE, pageNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public int getPageNumber() {
		return mPageNumber;
	}

}
