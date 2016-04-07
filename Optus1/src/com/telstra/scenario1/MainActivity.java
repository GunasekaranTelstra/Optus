package com.telstra.scenario1;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	ProjectAdapter adapter;
	ViewPager pager;
	TextView horizontal_item1, horizontal_item2, horizontal_item3,
			horizontal_item4, horizontal_item5, layer4_textview_item;
	RelativeLayout layer5_color;
	Button redBtn, greenBtn, blueBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		List<Fragment> fragment = getFragments();

		adapter = new ProjectAdapter(getSupportFragmentManager(), fragment);

		pager = (ViewPager) findViewById(R.id.viewpager);
		pager.setAdapter(adapter);

		horizontal_item1 = (TextView) findViewById(R.id.horizontal_item1);
		horizontal_item2 = (TextView) findViewById(R.id.horizontal_item2);
		horizontal_item3 = (TextView) findViewById(R.id.horizontal_item3);
		horizontal_item4 = (TextView) findViewById(R.id.horizontal_item4);
		horizontal_item5 = (TextView) findViewById(R.id.horizontal_item5);
		layer4_textview_item = (TextView) findViewById(R.id.layer4_textview_item);
		layer5_color = (RelativeLayout) findViewById(R.id.layer5_color);
		redBtn = (Button) findViewById(R.id.redBtn);
		greenBtn = (Button) findViewById(R.id.greenBtn);
		blueBtn = (Button) findViewById(R.id.blueBtn);

		blueBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				layer5_color.setBackgroundColor(getResources().getColor(
						R.color.blue));
			}
		});

		redBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				layer5_color.setBackgroundColor(getResources().getColor(
						R.color.red));
			}
		});

		greenBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				layer5_color.setBackgroundColor(getResources().getColor(
						R.color.green));
			}
		});

		horizontal_item1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				layer4_textview_item.setText("Item 1");
			}
		});

		horizontal_item2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				layer4_textview_item.setText("Item 2");
			}
		});

		horizontal_item3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				layer4_textview_item.setText("Item 3");
			}
		});

		horizontal_item4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				layer4_textview_item.setText("Item 4");
			}
		});

		horizontal_item5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				layer4_textview_item.setText("Item 5");
			}
		});

		pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				int val = pager.getCurrentItem() + 1;
				final Toast t = Toast.makeText(MainActivity.this,
						"Fragment Page " + val, Toast.LENGTH_SHORT);
				t.show();
				
				Handler handler = new Handler();
		        handler.postDelayed(new Runnable() {
		           @Override
		           public void run() {
		               t.cancel(); 
		           }
		    }, 500);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	public List<Fragment> getFragments() {
		List<Fragment> fList = new ArrayList<Fragment>();

		fList.add(PageFragment.newInstance("Page 1"));
		fList.add(PageFragment.newInstance("Page 2"));
		fList.add(PageFragment.newInstance("Page 3"));

		return fList;
	}

	private class ProjectAdapter extends FragmentPagerAdapter {
		private List<Fragment> fragment;

		public ProjectAdapter(FragmentManager fm, List<Fragment> fragment) {
			super(fm);
			this.fragment = fragment;
		}

		@Override
		public Fragment getItem(int position) {
			return this.fragment.get(position);
		}

		@Override
		public int getCount() {
			return this.fragment.size();
		}

	}

}
