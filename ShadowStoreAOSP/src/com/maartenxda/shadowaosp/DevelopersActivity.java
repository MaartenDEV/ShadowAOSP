package com.maartenxda.shadowaosp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;

public class DevelopersActivity extends PreferenceActivity implements OnPreferenceClickListener {
	
	
	
	
	
	Preference maartenxda;
	Preference xpirt;
	Preference tam;
	Preference scg;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		SharedPreferences prefs = PreferenceManager
			    .getDefaultSharedPreferences(DevelopersActivity.this);
			 
			   String username = prefs.getString("username", "Shadow");
		
		setTitle(username + " Developers");
		
		addPreferencesFromResource(R.xml.developers);
		
		maartenxda = (Preference) findPreference("maartenxda");
		maartenxda.setOnPreferenceClickListener(maartenxda1);
		
		xpirt = (Preference) findPreference("xpirt");
		xpirt.setOnPreferenceClickListener(xpirt1);
		
		tam = (Preference) findPreference("tam");
		tam.setOnPreferenceClickListener(tam1);
		
		scg = (Preference) findPreference("scg");
		scg.setOnPreferenceClickListener(scg1);
		
		
		
	}

	
	
	final OnPreferenceClickListener maartenxda1 = new OnPreferenceClickListener() {

		@Override
		public boolean onPreferenceClick(Preference pref) {
			// TODO Auto-generated method stub
			
			AlertDialog.Builder builder2 = new AlertDialog.Builder(DevelopersActivity.this);
			builder2.setIcon(R.drawable.about)
					.setTitle("MaartenXDA")
					.setItems(R.array.select_dialog_items,
		new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int id) {
		@SuppressWarnings("unused")
		String[] items = getResources().getStringArray(R.array.select_dialog_items);

		if (id == 0){

			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=MQHE27S38LEV2&lc=NL&item_name=XDA%20Developers&currency_code=EUR&bn=PP%2dDonationsBF%3abtn_donate_LG%2egif%3aNonHosted"));
			startActivity(browserIntent);
			
		}else if(id == 1){
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://forum.xda-developers.com/member.php?u=4877873"));
			startActivity(browserIntent);
		}else if(id == 2){
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://forum.xda-developers.com/showthread.php?t=2149318"));
			startActivity(browserIntent);
			}
				}
					}).create();
				builder2.show();
			 
		
			
			return false;
			      

			
			
			
		}
       
        	
        	
        };
        
        final OnPreferenceClickListener xpirt1 = new OnPreferenceClickListener() {

    		@Override
    		public boolean onPreferenceClick(Preference pref) {
    			// TODO Auto-generated method stub
    			
    			AlertDialog.Builder builder2 = new AlertDialog.Builder(DevelopersActivity.this);
    			builder2.setIcon(R.drawable.about)
    					.setTitle("Xpirt")
    					.setItems(R.array.select_dialog_items,
    		new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int id) {
    		@SuppressWarnings("unused")
    		String[] items = getResources().getStringArray(R.array.select_dialog_items);

    		if (id == 0){

    			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/it/cgi-bin/webscr?cmd=_flow&SESSION=FT0UadH4ZpR9sIB9WLeAlzHbaJwigH-GJxT4BnFzjfpCQdK9be9j-OR8Pfm&dispatch=5885d80a13c0db1f8e263663d3faee8d96fc0752e9614158f04872d2f2ae25dc"));
    			startActivity(browserIntent);
    			
    		}else if(id == 1){
    			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://forum.xda-developers.com/member.php?u=5132229"));
    			startActivity(browserIntent);
    		}else if(id == 2){
    			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
    			startActivity(browserIntent);
    			}
    				}
    					}).create();
    				builder2.show();
    			
    			
    			
    			
    			 return false;
    		
    			
    			
    			      

    			
    			
    			
    		}
           
            	
            	
            };
            
            
            final OnPreferenceClickListener tam1 = new OnPreferenceClickListener() {

        		@Override
        		public boolean onPreferenceClick(Preference pref) {
        			// TODO Auto-generated method stub
        			
        			AlertDialog.Builder builder2 = new AlertDialog.Builder(DevelopersActivity.this);
        			builder2.setIcon(R.drawable.about)
        					.setTitle("The Android Manual")
        					.setItems(R.array.select_dialog_items,
        		new DialogInterface.OnClickListener() {
        		public void onClick(DialogInterface dialog, int id) {
        		@SuppressWarnings("unused")
        		String[] items = getResources().getStringArray(R.array.select_dialog_items);

        		if (id == 0){

        			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/ph/cgi-bin/webscr?cmd=_flow&SESSION=YqGyogl2Udet7GJW51b0O9dd-N153zAs4eAjo4MuVaX7Tp1COahPZqWnIwy&dispatch=5885d80a13c0db1f8e263663d3faee8d96fc0752e9614158f04872d2f2ae25dc"));
        			startActivity(browserIntent);
        			
        		}else if(id == 1){
        			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://forum.xda-developers.com/member.php?u=4662845"));
        			startActivity(browserIntent);
        		}else if(id == 2){
        			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
        			startActivity(browserIntent);
        			}
        				}
        					}).create();
        				builder2.show();
        			
        			
        			
        			
        			 
        		
        			
        			return false;
        			      

        			
        			
        			
        		}
               
                	
                	
                };
	
                
                
                final OnPreferenceClickListener scg1 = new OnPreferenceClickListener() {

            		@Override
            		public boolean onPreferenceClick(Preference pref) {
            			// TODO Auto-generated method stub
            			
            			AlertDialog.Builder builder2 = new AlertDialog.Builder(DevelopersActivity.this);
            			builder2.setIcon(R.drawable.about)
            					.setTitle("ShadowCodeGaming")
            					.setItems(R.array.select_dialog_items,
            		new DialogInterface.OnClickListener() {
            		public void onClick(DialogInterface dialog, int id) {
            		@SuppressWarnings("unused")
            		String[] items = getResources().getStringArray(R.array.select_dialog_items);

            		if (id == 0){

            			AlertDialog.Builder builder2 = new AlertDialog.Builder(DevelopersActivity.this);
            			builder2.setIcon(R.drawable.about)
            					.setTitle("ShadowCodeGaming")
            					.setPositiveButton("Okay", null)
            					.setMessage("ShadowCodeGaming doesn't have a donation link yet.")
            					.setTitle("No donation link");
            					
            		}else if(id == 1){
            			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://forum.xda-developers.com/member.php?u=4261894"));
            			startActivity(browserIntent);
            		}else if(id == 2){
            			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
            			startActivity(browserIntent);
            			}
            				}
            					}).create();
            				builder2.show();
            			
            			
            			
            			
            			 
            		
            			return false;
            			
            			      

            			
            			
            			
            		}
                   
                    	
                    	
                    };

				@Override
				public boolean onPreferenceClick(Preference arg0) {
					// TODO Auto-generated method stub
					return false;
				}

	
		
		
		

}
