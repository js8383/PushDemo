package com.microsoft.firstapp;
import android.os.AsyncTask;    
import com.google.android.gms.gcm.*;
import com.microsoft.windowsazure.messaging.*;
import com.microsoft.windowsazure.notifications.NotificationsManager;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class BaseActivity extends Activity {
	
	protected AuthService mAuthService;
	
	protected FragmentManager fragmentManager;
	
	private String SENDER_ID = "27973823198";
	private GoogleCloudMessaging gcm;
	private NotificationHub hub;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		AuthenticationApplication myApp = (AuthenticationApplication) getApplication();
		myApp.setCurrentActivity(this);
		mAuthService = myApp.getAuthService();
		
		fragmentManager = getFragmentManager();
		
	}
	

	
}
