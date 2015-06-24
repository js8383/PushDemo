package com.microsoft.firstapp;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class GridviewAdapter extends BaseAdapter {

	private String[] listText;
	private int[] listImage;
	private Activity activity;

	public GridviewAdapter(Activity activity, String[] listText, int[] listImage) {
		super();
		this.listText = listText;
		this.listImage = listImage;
		this.activity = activity;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listImage.length;
	}

	@Override
	public String getItem(int arg0) {
		// TODO Auto-generated method stub
		return listText[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static class ViewHolder {
		public ImageView imageView;
		public TextView textView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder view;
		LayoutInflater inflator = activity.getLayoutInflater();

		if (convertView == null) {
			view = new ViewHolder();
			convertView = inflator.inflate(R.layout.grid, null);

			view.textView = (TextView) convertView
					.findViewById(R.id.ItemTextView);
			view.imageView = (ImageView) convertView
					.findViewById(R.id.ItemImageView);

			switch (position) {
			case 0:
				view.imageView.setBackgroundResource(R.drawable.grid_image_1);
				break;
			case 1:
				view.imageView.setBackgroundResource(R.drawable.grid_image_1);
				break;
			case 2:
				view.imageView.setBackgroundResource(R.drawable.grid_image_2);
				break;
			case 3:
				view.imageView.setBackgroundResource(R.drawable.grid_image_2);
				break;
			case 4:
				view.imageView.setBackgroundResource(R.drawable.grid_image_3);
				break;
			case 5:
				view.imageView.setBackgroundResource(R.drawable.grid_image_3);
				break;
			default:
				break;
			}
			convertView.setTag(view);

		} else {
			view = (ViewHolder) convertView.getTag();
		}

		view.textView.setText(listText[position]);
		view.imageView.setImageResource(listImage[position]);

		return convertView;
	}

}
