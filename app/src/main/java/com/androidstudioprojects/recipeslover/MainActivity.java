package com.androidstudioprojects.recipeslover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
				implements ListFragment.OnRecipeSelectedInterface,
				GridFragment.OnRecipeSelectedInterface {
	
	public static final String LIST_FRAGMENT = "list_fragment";
	public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
		
		if (!isTablet){
			ListFragment savedFragment =
							(ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
			
			if (savedFragment == null){
				ListFragment fragment = new ListFragment();
				FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction fragmentTransaction =
								fragmentManager.beginTransaction();
				
				// add fragment into its place holder
				fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);
				
				fragmentTransaction.commit();
			}
		}
		else {
			GridFragment savedFragment =
							(GridFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
			
			if (savedFragment == null){
				GridFragment fragment = new GridFragment();
				FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction fragmentTransaction =
								fragmentManager.beginTransaction();
				
				// add fragment into its place holder
				fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);
				
				fragmentTransaction.commit();
			}
		}
		
		
	}
	
	@Override
	public void onListRecipeSelected(int index) {
		
		ViewPagerFragment fragment = new ViewPagerFragment();
		
		Bundle bundle = new Bundle();
		bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
		fragment.setArguments(bundle);
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction =
						fragmentManager.beginTransaction();
		
		// replace fragment to its place holder
		fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}
	
	@Override
	public void onGridRecipeSelected(int index) {
		DualPaneFragment fragment = new DualPaneFragment();
		
		Bundle bundle = new Bundle();
		bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
		fragment.setArguments(bundle);
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction =
						fragmentManager.beginTransaction();
		
		// replace fragment to its place holder
		fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}
}
