package com.microsoft.firstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Aty1 extends Activity {

	private Button btnClose;

	// private TextView tvOut;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty1);

		// btnClose = (Button) findViewById(R.id.btnClose);
		// btnClose.setOnClickListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		//
		// // Intent i = new Intent();
		// // i.putExtra("result", "Hello MainActivity");
		// //
		// // setResult(0, i);
		//
		// //finish();
		// Intent i = new Intent(Aty1.this, SignUpActivity.class);
		// startActivity(i);
		// }
		// });

		// data transfer
		// tvOut = (TextView) findViewById(R.id.tvOut);
		// tvOut.setText(getIntent().getStringExtra("txt"));
		// Bundle data = getIntent().getExtras();
		// String txt = data.getString("txt");
		// tvOut.setText(txt);

//		ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//		if (conMgr.getActiveNetworkInfo() == null
//				&& !conMgr.getActiveNetworkInfo().isConnected()
//				&& !conMgr.getActiveNetworkInfo().isAvailable()) {
//			// No connectivity - Show alert
//			AlertDialog.Builder builder = new AlertDialog.Builder(this);
//			builder.setMessage(
//					"Unable to reach server, \nPlease check your connectivity.")
//					.setTitle("TD RSS Reader")
//					.setCancelable(false)
//					.setPositiveButton("Exit",
//							new DialogInterface.OnClickListener() {
//								@Override
//								public void onClick(DialogInterface dialog,
//										int id) {
//									finish();
//								}
//							});
//
//			AlertDialog alert = builder.create();
//			alert.show();
//
//		} else {
//			// Connected - Start parsing
//			// new AsyncLoadXMLFeed().execute();
//		}
		
		
	}
}
