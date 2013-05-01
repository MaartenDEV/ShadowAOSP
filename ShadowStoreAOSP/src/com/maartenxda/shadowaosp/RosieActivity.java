package com.maartenxda.shadowaosp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RosieActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rosie);
	}
	
	public void runRosie5 (View view) {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/SkyDragon/Launcher/Rosie5.apk /system/app/Rosie.apk"}); } 
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
	
	public void runRosie7 (View view) {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/SkyDragon/Launcher/Rosie7.apk /system/app/Rosie.apk"}); } 
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
	
	
	public void runRosie4x5 (View view) {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/SkyDragon/Launcher/Rosie4x5.apk /system/app/Rosie.apk"}); } 
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
	
	public void runRosie5x4 (View view) {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/SkyDragon/Launcher/Rosie5x4.apk /system/app/Rosie.apk"}); } 
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
	
	public void runRosie5x5 (View view) {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/SkyDragon/Launcher/Rosie5x5.apk /system/app/Rosie.apk"}); } 
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
