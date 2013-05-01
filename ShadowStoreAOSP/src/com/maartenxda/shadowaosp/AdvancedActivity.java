package com.maartenxda.shadowaosp;

import java.io.File;
import java.io.FileNotFoundException;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;





public class AdvancedActivity extends PreferenceActivity implements OnPreferenceClickListener {
	
	
	
	
	
	Preference mount_system;
	Preference custom_font;
	Preference android42;
	Preference ubuntu;
	
	
	
	
	@Override
    public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		SharedPreferences prefs = PreferenceManager
			    .getDefaultSharedPreferences(AdvancedActivity.this);
			 
			   String username = prefs.getString("username", "Shadow");
		
		setTitle(username + " Advanced");
        
        addPreferencesFromResource(R.xml.advanced_prefs);
        
        mount_system = (Preference) findPreference("mount_system");
        mount_system.setOnPreferenceClickListener(this);
        
        custom_font = (Preference) findPreference("custom_font");
        custom_font.setOnPreferenceClickListener(this);
        
        android42 = (Preference) findPreference("android42");
        android42.setOnPreferenceClickListener(this);
        
        ubuntu = (Preference) findPreference("ubuntu");
        ubuntu.setOnPreferenceClickListener(this);
        
        
    

    }
	
	
	@Override
	public boolean onPreferenceClick(Preference pref) {
		// TODO Auto-generated method stub
		if (pref == mount_system) {
			
			
			mountSystem();
			
			
		}
		
		if (pref == custom_font) {
			
			runCustomFont();
			
		}
		
		if (pref == android42) {
			
			android42();
			
		}
		
		if (pref == ubuntu) {
			
			ubuntu();
			
			// execute this when the downloader must be fired
			
		}
		
		
		return false;
	}
	
	
	
	
	
	public void mountSystem() {
		

		
		
		
	
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }

	}
	
	Context context = this;
	
	public void runCustomFont () {
		
		final File file = new File(Environment.getExternalStorageDirectory() + "/Shadow/fonts");
		
			if (file.exists()) {
			
			AlertDialog.Builder sure = new AlertDialog.Builder(this);
			
			sure.setTitle("Are you sure?")
				.setMessage("You are now installing your custom font, are you sure you want to?")
				.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						
						try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
						catch (Exception ex) { ex.printStackTrace(); }
						try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp -r /sdcard/Shadow/fonts/ /system/"}); } 
						catch (FileNotFoundException e){
							// do stuff here..
							
							AlertDialog.Builder s = new AlertDialog.Builder(context);
							s.setTitle("SSS");
							s.show();
							
							}
							catch(Exception e){
							// do stuff here..
							AlertDialog.Builder a = new AlertDialog.Builder(context);
							a.setTitle("AAA");
							a.show();
							}
						
						
				LayoutInflater inflater = getLayoutInflater();
						
						View layout = inflater.inflate(R.layout.custom_toast,
								  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

								// set a dummy image
								ImageView image = (ImageView) layout.findViewById(R.id.image);
								image.setImageResource(R.drawable.ic_launcher);

								// set a message
								TextView text = (TextView) layout.findViewById(R.id.text);
								text.setText("Installing custom font, please wait and remember to reboot!");

								// Toast...
								Toast toast = new Toast(getApplicationContext());
								toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
								toast.setDuration(Toast.LENGTH_LONG);
								toast.setView(layout);
								toast.show();
						
						
					}
					
					
					
					
					
				})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						
						
						
					}
					
					
					
				})
				.show();
		
		} else {
			
			AlertDialog.Builder notfound = new AlertDialog.Builder(this);
			
			notfound.setTitle("Not found");
			notfound.setMessage("I'm sorry, but the font files weren't found." + "\n" + "Please check if you have placed the font files in /sdcard/Shadow/fonts/");
			
			notfound.show();
		}
	}
	
	
	
	
	
	public void android42() {
		
		File file = new File(Environment.getExternalStorageDirectory()+"/Shadow","android42.zip");
		
		if (file.exists()) { 
			
			AlertDialog.Builder download = new AlertDialog.Builder(this);
			
			download.setTitle("Already downloaded");
			download.setMessage("You have already downloaded this file, you can find it in /sdcard/Shadow/.");
			download.setNegativeButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
				}
				
				
			});
			download.show();
			
			
		} else {
		
		AlertDialog.Builder android42 = new AlertDialog.Builder(this);
		
		android42.setMessage("This will download a flashable zip, flash it to install the Android 4.2 font.");
		android42.setTitle("Android 4.2 font");
		
		android42.setPositiveButton("Download", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog,int id) {
				
				
				
				String url = "http://fs1.d-h.st/download/00037/aAR/font.zip";
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
				request.setDescription("Downloading Android 4.2 font");
				request.setTitle("Downloading...");
				// in order for this if to run, you must use the android 3.2 to compile your app
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
				    request.allowScanningByMediaScanner();
				    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
				}
				request.setDestinationInExternalPublicDir("/Shadow/" , "android42.zip");

				// get download service and enqueue file
				DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				manager.enqueue(request);
				
				
			}
		});

		android42.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				
				
				
			}
			
		});
		
		android42.show();
		
		} 
		
		
		
		
	}
	
	


	



	public void ubuntu() {
		
		
		
		
		File file = new File(Environment.getExternalStorageDirectory()+"/Shadow","ubuntu.zip");
		
		if (file.exists()) { 
			
			AlertDialog.Builder download = new AlertDialog.Builder(this);
			
			download.setTitle("Already downloaded");
			download.setMessage("You have already downloaded this file, you can find it in /sdcard/Shadow/.");
			download.setNegativeButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
				}
				
				
			});
			download.show();
			
			
		} else {
		
		
		
		
		
		
		AlertDialog.Builder ubuntu = new AlertDialog.Builder(this);
		
		ubuntu.setMessage("This will download a flashable zip, flash it to install the Ubuntu font.");
		ubuntu.setTitle("Ubuntu font");
		
		ubuntu.setPositiveButton("Download", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog,int id) {
				
				
				
				String url = "http://fs1.d-h.st/download/00038/rbi/font_ubuntu.zip";
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
				request.setDescription("Downloading Ubuntu font");
				request.setTitle("Downloading...");
				// in order for this if to run, you must use the android 3.2 to compile your app
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
				    request.allowScanningByMediaScanner();
				    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
				}
				request.setDestinationInExternalPublicDir("/Shadow/" , "ubuntu.zip");

				// get download service and enqueue file
				DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				manager.enqueue(request);
			}
		});
		ubuntu.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				
				
				
			}
			
		});
		
		ubuntu.show();
		
		}
		
	}







	
	
	
	


    
}



