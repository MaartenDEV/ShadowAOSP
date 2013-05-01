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

public class StatusbarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statusbar);
	}


	
	public void runStock (View view) {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/SkyDragon/Statusbar/StockSystemUI.apk /system/app/SystemUI.apk"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
LayoutInflater inflater = getLayoutInflater();
		
		View layout = inflater.inflate(R.layout.custom_toast,
				  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Installing Stock statusbar, please wait");

				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
	}
	
	public void runSkyDragon (View view) {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/SkyDragon/Statusbar/SkyDragonSystemUI.apk /system/app/SystemUI.apk"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
LayoutInflater inflater = getLayoutInflater();
		
		View layout = inflater.inflate(R.layout.custom_toast,
				  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Installing SkyDragon statusbar, please wait");

				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
	}
	
	public void runBlue (View view) {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/SkyDragon/Statusbar/SystemUIBlue.apk /system/app/SystemUI.apk"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
LayoutInflater inflater = getLayoutInflater();
		
		View layout = inflater.inflate(R.layout.custom_toast,
				  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Installing Blue battery icons, please wait");

				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
	}
	
	public void runRed (View view) {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/SkyDragon/Statusbar/SystemUIRed.apk /system/app/SystemUI.apk"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
LayoutInflater inflater = getLayoutInflater();
		
		View layout = inflater.inflate(R.layout.custom_toast,
				  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Installing Red battery icons, please wait");

				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
	}
	
	
	public void runGreen (View view) {
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "mount -o remount,rw -t yaffs2 /dev/block/mmcblk0p25 /system"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
		try { Process process = Runtime.getRuntime().exec(new String[]{ "su", "-c", "busybox cp /sdcard/SkyDragon/Statusbar/SystemUIGreen.apk /system/app/SystemUI.apk"}); } 
		catch (Exception ex) { ex.printStackTrace(); }
LayoutInflater inflater = getLayoutInflater();
		
		View layout = inflater.inflate(R.layout.custom_toast,
				  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Installing Green battery icons, please wait");

				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
	}
	




	
}
