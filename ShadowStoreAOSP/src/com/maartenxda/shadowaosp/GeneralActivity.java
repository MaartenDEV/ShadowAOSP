package com.maartenxda.shadowaosp;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.TwoStatePreference;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class GeneralActivity extends PreferenceActivity implements OnPreferenceChangeListener, OnPreferenceClickListener {
	
	
	
	TwoStatePreference arrows;
	TwoStatePreference bootsound;
	TwoStatePreference not;
	Preference coming_soon;
	
	
	 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		SharedPreferences prefs = PreferenceManager
			    .getDefaultSharedPreferences(GeneralActivity.this);
			 
			   String username = prefs.getString("username", "Shadow");
		
		setTitle(username + " General");
		
		
		addPreferencesFromResource(R.xml.general_prefs);
		
		arrows = (CheckBoxPreference) findPreference("arrows");
		arrows.setOnPreferenceClickListener(this);
		
		bootsound = (CheckBoxPreference) findPreference("bootsound");
		bootsound.setOnPreferenceClickListener(this);
		
		not = (CheckBoxPreference) findPreference("not");
		not.setOnPreferenceClickListener(this);
		
		coming_soon = (Preference) findPreference("coming_soon");
		coming_soon.setOnPreferenceClickListener(this);
		
		
		
		
		
	}
	
	
	@Override
	public boolean onPreferenceChange(Preference pref, Object newvalue) {
		// TODO Auto-generated method stub
		

		return false;
	}
	
	

	@Override
	public boolean onPreferenceClick(Preference pref) {
		// TODO Auto-generated method stub
		
		if (pref == coming_soon) {
			
			AlertDialog.Builder coming = new AlertDialog.Builder(this);
			
			coming.setTitle("Coming soon");
			coming.setMessage("More will come soon, but please request features in the main thread so I know what to add!");
			coming.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			coming.setIcon(R.drawable.about);
			coming.show();
			
			
		}
		
		
			if (pref == not) {
		            /*
		            * retrieve the state of the toggle ( true=ON / false=OFF)
		            */
					boolean value = not.isChecked();
					if(value == true) {
		        //Do something when the switch is toggled ON
						enableNot();
						
		            }
					if(value == false) {
						disableNot();
					}
					
			}
			
			if (pref == arrows) {
				
				boolean value1 = not.isChecked();
				if (value1 == true) {
					runArrowKeyboard();
					
				}
				if (value1 == false) {
					runStockKeyboard();
					
					
				}
				
				
				
			
			
		}
		
		
			if (pref == bootsound) {
				
				
				boolean value2 = bootsound.isChecked();
				if (value2 == true) {
					enableBoot();
					
				}
				
				if (value2 == false) {
					disableBoot();
					
				}
				
				
				
				
			}
			
		
		
		
		
		
		return false;
	}
	
	
	
	
    
     
    

	public void downloadFiles(View view) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fs1.d-h.st/download/00036/HEt/Resources.zip"));
		startActivity(browserIntent);
LayoutInflater inflater = getLayoutInflater();
		
		View layout = inflater.inflate(R.layout.custom_toast,
				  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Downloading resources, please wait");

				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
		
		}
	
	public void runStockKeyboard () {
		
		
		
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/Shadow/General/StockKeyboard.apk /system/app/HTC_IME.apk"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
LayoutInflater inflater = getLayoutInflater();
		
		View layout = inflater.inflate(R.layout.custom_toast,
				  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Installing stock keyboard, please wait");

				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
	}
	
	public void runArrowKeyboard () {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/Shadow/General/ArrowKeyboard.apk /system/app/HTC_IME.apk"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
LayoutInflater inflater = getLayoutInflater();
		
		View layout = inflater.inflate(R.layout.custom_toast,
				  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Installing keyboard with arrows, please wait");

				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
	}
	
	
	
	
	
	public void disableNot () {
		NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        
        notificationManager.cancel(Constants.NOTIFICATION_ID);
	
	
	
	}
	
	public void enableNot() {
		
			
			NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
	         
	        int icon = R.drawable.ic_launcher;
	        CharSequence text = "Shadow Store";
	        CharSequence contentTitle = "Shadow Store";
	        CharSequence contentText = "Press for quick access";
	        long when = System.currentTimeMillis();
	         
	        Intent intent = new Intent(this, SectionListActivity.class);
	        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
	        Notification notification = new Notification(icon,text,when);
	         
	        
	         
	        notification.flags = Notification.FLAG_ONGOING_EVENT;
	        //notification.flags |= Notification.FLAG_SHOW_LIGHTS;
	         
	        notification.setLatestEventInfo(this, contentTitle, contentText, contentIntent);
	         
	        notificationManager.notify(Constants.NOTIFICATION_ID, notification);
			
	}
        
	public void enableBoot() {
	    					
					try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
					catch (Exception ex) { ex.printStackTrace(); }
					try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/Shadow/General/htc_boot.mp3 /system/customize/resource/htc_boot.mp3"}); } 
					catch (Exception ex) { ex.printStackTrace(); }
			LayoutInflater inflater = getLayoutInflater();
					
					View layout = inflater.inflate(R.layout.custom_toast,
							  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

							// set a dummy image
							ImageView image = (ImageView) layout.findViewById(R.id.image);
							image.setImageResource(R.drawable.ic_launcher);

							// set a message
							TextView text = (TextView) layout.findViewById(R.id.text);
							text.setText("Enabling bootsound, please wait");

							// Toast...
							Toast toast = new Toast(getApplicationContext());
							toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
							toast.setDuration(Toast.LENGTH_LONG);
							toast.setView(layout);
							toast.show();
							
	}
	    
	    	
				public void disableBoot() {				
							
	    	try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
			catch (Exception ex) { ex.printStackTrace(); }
			try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox rm /system/customize/resource/htc_boot.mp3"}); } 
			catch (Exception ex) { ex.printStackTrace(); }
	LayoutInflater inflater1 = getLayoutInflater();
			
			View layout1 = inflater1.inflate(R.layout.custom_toast,
					  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

					// set a dummy image
					ImageView image1 = (ImageView) layout1.findViewById(R.id.image);
					image1.setImageResource(R.drawable.ic_launcher);

					// set a message
					TextView text1 = (TextView) layout1.findViewById(R.id.text);
					text1.setText("Disabling bootsound, please wait");

					// Toast...
					Toast toast1 = new Toast(getApplicationContext());
					toast1.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast1.setDuration(Toast.LENGTH_LONG);
					toast1.setView(layout1);
					toast1.show();
	    	
	    }











				
	}
	
	
	

