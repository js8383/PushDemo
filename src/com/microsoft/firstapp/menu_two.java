package com.microsoft.firstapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.android.gms.R.color;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class menu_two extends Fragment {
	private GridView mGridView; // MyGridView

	private int[] imageRes = {R.drawable.weather, R.drawable.travel,R.drawable.science};
	private String[] itemName = {"weather","traval","science"};
	ViewGroup v;
	private int mPageNumber;
	public static final String ARG_PAGE = "page";


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Activity menu = getActivity();

		v = (ViewGroup) inflater.inflate(R.layout.menu2, container, false);

		mGridView = (GridView) v.findViewById(R.id.MyGridView2);

		GridviewAdapter gAdapter = new GridviewAdapter(menu, itemName, imageRes);
		mGridView.setAdapter(gAdapter);
		

		mGridView.setOnItemClickListener(new GridViewItemOnClick());
		return v;
	}

	public class GridViewItemOnClick implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> arg0, View view, int position,
				long arg3) {
			Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT)
					.show();
			
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mPageNumber = getArguments().getInt(ARG_PAGE);
	}

	public static Fragment create(int pageNumber) {
		menu_two fragment = new menu_two();
		Bundle args = new Bundle();
		args.putInt(ARG_PAGE, pageNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public int getPageNumber() {
		return mPageNumber;
	}
}
