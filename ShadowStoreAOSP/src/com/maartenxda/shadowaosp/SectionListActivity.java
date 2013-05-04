package com.maartenxda.shadowaosp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.espiandev.showcaseview.ShowcaseView;
import com.slidingmenu.lib.SlidingMenu;

/**
 * An activity representing a list of Sections. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link SectionDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link SectionListFragment} and the item details (if present) is a
 * {@link SectionDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link SectionListFragment.Callbacks} interface to listen for item
 * selections.
 */
public class SectionListActivity extends FragmentActivity implements
		SectionListFragment.Callbacks {

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;

	
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	}
    
    
    
     
     
     Context context = this;
     
     View.OnClickListener about = new View.OnClickListener() {
    	    public void onClick(View v) {
    	      // MY QUESTION STARTS HERE!!!
    	      // IF b1 do this
    	      // IF b2 do this
    	      // MY QUESTION ENDS HERE!!!
    	    	SharedPreferences prefs = PreferenceManager
    	    		    .getDefaultSharedPreferences(SectionListActivity.this);
    	    		 
    	    		   String username = prefs.getString("username", "Shadow");
    	                
    	            	AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(context);

    	        		dlgAlert.setMessage(R.string.about_shadow);
    	        		dlgAlert.setTitle("Hey there "+username +"!");
    	        		dlgAlert.setPositiveButton("Go to the ROM's thread", new DialogInterface.OnClickListener() {
    	        			public void onClick(DialogInterface dialog,int id) {
    	        				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
    	        				startActivity(browserIntent);
    	        			}
    	        		});
    	        		dlgAlert.setCancelable(true);
    	        		dlgAlert.create().show();
    	    }
    	  };
    	  
    	  View.OnClickListener appreciation = new View.OnClickListener() {
      	    public void onClick(View v) {
      	    	AlertDialog.Builder dlgAlert1  = new AlertDialog.Builder(context);

      			dlgAlert1.setMessage(R.string.appreciation);
      			dlgAlert1.setTitle("Appreciation");
      			dlgAlert1.setPositiveButton("Donate", new DialogInterface.OnClickListener() {
      				public void onClick(DialogInterface dialog,int id) {
      					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=MQHE27S38LEV2&lc=NL&item_name=XDA%20Developers&currency_code=EUR&bn=PP%2dDonationsBF%3abtn_donate_LG%2egif%3aNonHosted"));
      					startActivity(browserIntent);
      				}
      			});
      			dlgAlert1.setCancelable(true);
      			dlgAlert1.create().show();
      	    }
      	  };
      	  
      	View.OnClickListener devs = new View.OnClickListener() {
      	    public void onClick(View v) {
      	      intent(DevelopersActivity.class);
      	    }
      	  };
    
   
    
      	View.OnClickListener files = new View.OnClickListener() {
      	    public void onClick(View v) {
      	    	intent(FilesActivity.class);
      	    }
      	  };
    
      	View.OnClickListener personalize = new View.OnClickListener() {
      	    public void onClick(View v) {
      	    	Intent i = new Intent();
      	        i.setAction(Intent.ACTION_VIEW);
      	        i.setClassName("com.htc.home.personalize",
      	                "com.htc.home.personalize.main.PersonalizeCarouselMainActivity");

      	        startActivity(i);
      	    }
      	  };
      	  
      	View.OnClickListener prefs = new View.OnClickListener() {
      	    public void onClick(View v) {
      	    	intent(PreferencesActivity.class);
      	    }
      	  };
    
    
    
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        
        case R.id.refresh:
        	recreate();
            
        	return true;
        
        	
            
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    public void intent (Class activity) {
    	
    	Intent intent=new Intent(this, activity);
        startActivity(intent);
    	
    	
    }
	LinearLayout layout;	
	Button button;
	ShowcaseView sv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_section_list);
		layout = new LinearLayout(this);
		layout.setOrientation(1);
		
		ShowcaseView.ConfigOptions co = new ShowcaseView.ConfigOptions();
		co.hideOnClickOutside = true;
		
		button = new Button(this);
		button.setWidth(390);
		button.setOnClickListener(about);
		button.setHeight(100);
		button.setText("About");
		button.setTextAppearance(this, android.R.style.TextAppearance_Large);
		
		Button appr = new Button(this);
		appr.setWidth(390);
		appr.setOnClickListener(appreciation);
		appr.setHeight(100);
		appr.setText("Appreciation");
		appr.setTextAppearance(this, android.R.style.TextAppearance_Large);
		
		Button members = new Button(this);
		members.setWidth(390);
		members.setOnClickListener(devs);
		members.setHeight(100);
		members.setText("Team members");
		members.setTextAppearance(this, android.R.style.TextAppearance_Large);
		
		Button file = new Button(this);
		file.setWidth(390);
		file.setOnClickListener(files);
		file.setHeight(100);
		file.setText("Downloaded files");
		file.setTextAppearance(this, android.R.style.TextAppearance_Large);
		
		Button personalizes = new Button(this);
		personalizes.setWidth(390);
		personalizes.setOnClickListener(personalize);
		personalizes.setHeight(100);
		personalizes.setText("Personalize");
		personalizes.setTextAppearance(this, android.R.style.TextAppearance_Large);

		Button pref = new Button(this);
		pref.setWidth(390);
		pref.setOnClickListener(prefs);
		pref.setHeight(100);
		pref.setText("Preferences");
		pref.setTextAppearance(this, android.R.style.TextAppearance_Large);
		
		
		layout.addView(button);
		layout.addView(appr);
		layout.addView(members);
		layout.addView(file);
		layout.addView(personalizes);
		layout.addView(pref);
		
		sv = ShowcaseView.insertShowcaseView(file, this, "Swipable menu", "You can swipe from the left to the right to show the menu, in which you can choose what you want to do.", co);
		sv.animateGesture(-200, 350, 400, 350);
		
		
		SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setShadowWidth(50);
        menu.setFadeDegree(0.9f);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        
        
        menu.setBehindWidth(400);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(layout);
		
		SharedPreferences prefs = PreferenceManager
			    .getDefaultSharedPreferences(SectionListActivity.this);
			 
			   String username = prefs.getString("username", "Shadow");
		
		setTitle(username + " Store");
		

		if (findViewById(R.id.section_detail_container) != null) {
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			mTwoPane = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			((SectionListFragment) getSupportFragmentManager()
					.findFragmentById(R.id.section_list))
					.setActivateOnItemClick(true);
		}

		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method from {@link SectionListFragment.Callbacks} indicating
	 * that the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(SectionDetailFragment.ARG_ITEM_ID, id);
			SectionDetailFragment fragment = new SectionDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.section_detail_container, fragment).commit();

		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			
			
			Intent detailIntent = new Intent(this, SectionDetailActivity.class);
			detailIntent.putExtra(SectionDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
