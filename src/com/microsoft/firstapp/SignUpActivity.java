package com.microsoft.firstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.microsoft.windowsazure.mobileservices.*;

import java.net.MalformedURLException;

public class SignUpActivity extends BaseActivity {

	private Button signUp;
	private final String TAG = "SignUpActivity";

	private MobileServiceClient mClient;
	private MobileServiceTable<UserAccount> mUserAccountTable;

	private EditText signName, signPassword, signEmail;

	private Activity mActivity;

	private Animation shake;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in_screen);
		mActivity = this;

		// AnimationUtils.loadAnimation(getApplicationContext(), R.anim.)
		signUp = (Button) findViewById(R.id.btnSignUp2);
		signName = (EditText) findViewById(R.id.signUpName);
		signPassword = (EditText) findViewById(R.id.signUpPass);
		signEmail = (EditText) findViewById(R.id.signUpEmail);
		shake = AnimationUtils.loadAnimation(this, R.anim.shake);

	}

	// public void addItem() {
	//
	// // Create a new item
	// UserAccount newUser = new UserAccount();
	//
	// newUser.setEmail(signEmail.getText().toString());
	// newUser.setPassword(signPassword.getText().toString());
	// newUser.setUsername(signName.getText().toString());
	//
	// mUserAccountTable.insert(newUser,
	// new TableOperationCallback<UserAccount>() {
	//
	// public void onCompleted(UserAccount entity,
	// Exception exception, ServiceFilterResponse response) {
	//
	// if (exception == null) {
	//
	// } else {
	// createAndShowDialog(exception.getCause()
	// .getMessage(), "Invalid");
	// }
	//
	// signEmail.setText("");
	// signPassword.setText("");
	// signName.setText("");
	// signEmail.setEnabled(true);
	// signPassword.setEnabled(true);
	// signName.setEnabled(true);
	// signUp.setEnabled(true);
	// }
	// });
	// }

	public void signUp2(View view) {
		signEmail.setEnabled(false);
		signPassword.setEnabled(false);
		signName.setEnabled(false);
		signUp.setEnabled(false);

		String txt1 = signName.getText().toString();
		String txt2 = signPassword.getText().toString();
		String txt3 = signEmail.getText().toString();

		if (txt1.equals("") || txt2.equals("") || txt3.equals("")) {
			// Log.w(TAG, "You must enter username and password!");

			signEmail.setText("");
			signPassword.setText("");
			signName.setText("");
			signEmail.setEnabled(true);
			signPassword.setEnabled(true);
			signName.setEnabled(true);
			signUp.setEnabled(true);

			if (txt1.equals(""))
				signName.startAnimation(shake);
			if (txt2.equals(""))
				signPassword.startAnimation(shake);
			if (txt3.equals(""))
				signEmail.startAnimation(shake);

			Toast tmp1 = Toast.makeText(getApplicationContext(),
					"You must enter all fileds", Toast.LENGTH_SHORT);
			tmp1.setGravity(Gravity.BOTTOM, 0, -10);
			tmp1.show();
			return;
		} else {
			mAuthService.registerUser(signName.getText().toString(),
					signPassword.getText().toString(), signPassword.getText()
							.toString(), signEmail.getText().toString(),
					new TableJsonOperationCallback() {
						@Override
						public void onCompleted(JsonObject jsonObject,
								Exception exception,
								ServiceFilterResponse response) {
							signEmail.setText("");
							signPassword.setText("");
							signName.setText("");
							signEmail.setEnabled(true);
							signPassword.setEnabled(true);
							signName.setEnabled(true);
							signUp.setEnabled(true);

							if (exception == null) {
								Toast tmp2 = Toast.makeText(
										getApplicationContext(),
										"Successful...Redirecting to login...",
										Toast.LENGTH_SHORT);
								tmp2.setGravity(Gravity.BOTTOM, 0, -10);
								tmp2.show();
								// If that was successful, set and save the user
								// data
								mAuthService.setUserAndSaveData(jsonObject);
								// Finish this activity and run the logged in
								// activity
								mActivity.finish();

								Intent newLogin = new Intent(
										getApplicationContext(),
										LogInActivity.class);
								newLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
										| Intent.FLAG_ACTIVITY_NEW_TASK);
								startActivity(newLogin);
								overridePendingTransition(R.anim.fade_in,
										R.anim.fade_out);
							} else {
								// Log.e(TAG,
								// "There was an error registering the user: " +
								// exception.getMessage());
								String erroMs = response.getContent();
								Toast tmp3 = Toast.makeText(
										getApplicationContext(),
										"Error loggin in: "
												+ erroMs,
										Toast.LENGTH_SHORT);
								tmp3.setGravity(Gravity.BOTTOM, 0, -10);
								tmp3.show();
							}
						}
					});
		}

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	}

	public void cancel(View view) {
		this.finish();
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	}

	private void createAndShowDialog(String message, String title) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setMessage(message);
		builder.setTitle(title);
		builder.create().show();
	}
}
