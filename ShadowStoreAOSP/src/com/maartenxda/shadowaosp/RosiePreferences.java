package com.maartenxda.shadowaosp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RosiePreferences extends PreferenceActivity implements OnPreferenceChangeListener {
	
	
	
	Context context = this;
	
	ListPreference appdrawer;
	ListPreference panels;
	EditTextPreference username;
	
	

	
	
	
	
		
		
	
	
	
	
		
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		SharedPreferences prefs = PreferenceManager
			    .getDefaultSharedPreferences(RosiePreferences.this);
			 
			   String username1 = prefs.getString("username", "Shadow");
		
		setTitle(username1 + " Sense");
		
		
		addPreferencesFromResource(R.xml.prefs);
		
		
		 appdrawer = (ListPreference) findPreference("appdrawer");
		appdrawer.setOnPreferenceChangeListener(this);
		

				
				 panels = (ListPreference) findPreference("panels");
				panels.setOnPreferenceChangeListener(this);
				
				username = (EditTextPreference) findPreference("username");
				
				
				
				
		
		
	}
	
	
	@Override
	public boolean onPreferenceChange(Preference pref, Object newvalue) {
		// TODO Auto-generated method stub
                /*
                * we can't use the case statement here, but we can get the "clicked" item using the IF statement
                */
		
		
		if (pref == username) {
			
			
			
		}
		
		
		
		if(pref == appdrawer) {
			
			
			if (newvalue.equals("1")) {
				
				runRosie5();
				
				
				
			}
			
			if (newvalue.equals("2")) {
				
				runRosie4x5();
				
			}
			
			if (newvalue.equals("3")) {
				
				runRosie5x4();
				
			}
			
			if (newvalue.equals("4")) {
				
				runRosie5x5();
				
			}
			
			

		}
		
		if(pref == panels) {
			
			
			if (newvalue.equals("1")) {
				
				runRosie5();
				
				
			}
			
			if (newvalue.equals("2")) {
				
				runRosie7();
				
			}
			
			
			
			

		}
		

		return false;
	}
	
	
	
	
	
	
	
	private void displaySharedPreferences() {
		   SharedPreferences prefs = PreferenceManager
		    .getDefaultSharedPreferences(RosiePreferences.this);
		 
		   String username = prefs.getString("username", "Shadow");
		   String passw = prefs.getString("password", "Default Password");
		   boolean checkBox = prefs.getBoolean("checkBox", false);
		   String listPrefs = prefs.getString("listpref", "Default list prefs");
		 
		  
		 
		   
		   
		   
		   		
			   
			   Toast.makeText(getApplicationContext(), "Checkbox: "+String.valueOf(checkBox), Toast.LENGTH_SHORT).show();
			   
		   		
		   		
		   		
		 		   
		 		   Toast.makeText(getApplicationContext(), "Your password is: "+ passw, Toast.LENGTH_SHORT).show();
		 		   
		 		  Toast.makeText(getApplicationContext(), "List preference:  "+ listPrefs, Toast.LENGTH_SHORT).show();
		 		   
		 		 Toast.makeText(getApplicationContext(), "Your username is:  "+ username, Toast.LENGTH_SHORT).show();
		 		   
		 	   		
			   
			   
		   
		}
	
	
	
	
	
	
	
	public void runRosie5 () {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/Shadow/Launcher/Rosie5.apk /system/app/Rosie.apk"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
LayoutInflater inflater = getLayoutInflater();
		
		View layout = inflater.inflate(R.layout.custom_toast,
				  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Installing 5 Screen Rosie, please wait");

				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
		
		
	}
	
	public void runRosie7 () {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/Shadow/Launcher/Rosie7.apk /system/app/Rosie.apk"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
LayoutInflater inflater = getLayoutInflater();
		
		View layout = inflater.inflate(R.layout.custom_toast,
				  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Installing 7 Screen Rosie, please wait");

				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
	}
	
	
	public void runRosie4x5 () {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/Shadow/Launcher/Rosie4x5.apk /system/app/Rosie.apk"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		LayoutInflater inflater = getLayoutInflater();
		
		View layout = inflater.inflate(R.layout.custom_toast,
				  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Installing 4x5 Rosie, please wait");

				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
	}
	
	public void runRosie5x4 () {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/Shadow/Launcher/Rosie5x4.apk /system/app/Rosie.apk"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		LayoutInflater inflater = getLayoutInflater();
		
		View layout = inflater.inflate(R.layout.custom_toast,
				  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Installing 5x4 Rosie, please wait");

				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
	}
	
	public void runRosie5x5 () {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/Shadow/Launcher/Rosie5x5.apk /system/app/Rosie.apk"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		LayoutInflater inflater = getLayoutInflater();
		 
		View layout = inflater.inflate(R.layout.custom_toast,
		  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

		// set a dummy image
		ImageView image = (ImageView) layout.findViewById(R.id.image);
		image.setImageResource(R.drawable.ic_launcher);

		// set a message
		TextView text = (TextView) layout.findViewById(R.id.text);
		text.setText("Installing 5x5 Rosie, please wait");

		// Toast...
		Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);
		toast.show();
	}
	
	
	
	
	 
}
