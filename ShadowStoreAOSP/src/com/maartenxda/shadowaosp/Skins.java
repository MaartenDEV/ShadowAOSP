package com.maartenxda.shadowaosp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.preference.TwoStatePreference;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Skins extends ListActivity {
	String name;
	
	
	
	
	
	Context context = this;

	// All static variables
	static final String URL = "http://bitterrific.com/skins.xml";
	// XML node keys
	static final String KEY_ITEM = "item"; // parent node
	static final String KEY_ID = "id";
	static final String KEY_NAME = "name";
	static final String KEY_DATE = "date";
	static final String KEY_URL = "url";
	static final String KEY_DESC = "description";
	
	TwoStatePreference scrollbar;
	File outputfile;

	
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	}
    
    
    
    
    
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        
        case R.id.refresh:
        	recreate();
            
        	return true;
        case R.id.about:
        	
        	
        	
        	
        	
        	SharedPreferences prefs = PreferenceManager
		    .getDefaultSharedPreferences(Skins.this);
		 
		   String username = prefs.getString("username", "Shadow");
            
        	AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

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
        	
            return true;
            
        case R.id.appreciation:
        	
        	AlertDialog.Builder dlgAlert1  = new AlertDialog.Builder(this);

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
        	
            return true;
            
        case R.id.devs:
        	
        	intent(DevelopersActivity.class);
	        return true;
	       
	        
       
	        
	        
	        
	        
	        
	        
        case R.id.files:

        	
        	
        	intent(FilesActivity.class);
	        
	        
	        
	        return true;
	        
        case R.id.personalize:
        	
        	Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setClassName("com.htc.home.personalize",
                    "com.htc.home.personalize.main.PersonalizeCarouselMainActivity");

            startActivity(i);
            
            return true;
	        
        case R.id.prefs:
        	
        	intent(PreferencesActivity.class);
        	
        	
        	
        	return true;
        
        
	    
	        
        
        
        
        	
        	
            
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    public void intent (Class activity) {
    	
    	Intent intent=new Intent(this, activity);
        startActivity(intent);
    	
    	
    }
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		
		SharedPreferences prefs = PreferenceManager
			    .getDefaultSharedPreferences(Skins.this);
			 
			   String username = prefs.getString("username", "Shadow");
		
		setTitle(username + " News");

		ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(URL); // getting XML
		Document doc = parser.getDomElement(xml); // getting DOM element

		NodeList nl = doc.getElementsByTagName(KEY_ITEM);
		// looping through all item nodes <item>
		for (int i = 0; i < nl.getLength(); i++) {
			// creating new HashMap
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(i);
			// adding each child node to HashMap key => value
			map.put(KEY_ID, parser.getValue(e, KEY_ID));
			map.put(KEY_NAME, parser.getValue(e, KEY_NAME));
			map.put(KEY_DATE, parser.getValue(e, KEY_DATE));
			map.put(KEY_DESC, parser.getValue(e, KEY_DESC));
			map.put(KEY_URL, parser.getValue(e, KEY_URL));

			// adding HashList to ArrayList
			menuItems.add(map);
		}

		// Adding menuItems to ListView
		ListAdapter adapter = new SimpleAdapter(this, menuItems,
				R.layout.list_item,
				new String[] { KEY_NAME, KEY_DESC, KEY_DATE, KEY_URL }, new int[] {
						R.id.name, R.id.desciption, R.id.date, R.id.url });
		
		setListAdapter(adapter);

		// selecting single ListView item
		ListView lv = getListView();
		

		
		
		
		
		boolean checkBox = prefs.getBoolean("scrollbars", false);
		
		
		
		if (String.valueOf(checkBox) == "false") {
		
		lv.setVerticalScrollBarEnabled(false);
		lv.setHorizontalScrollBarEnabled(false);
		
		}
		
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
				String date = ((TextView) view.findViewById(R.id.date)).getText().toString();
				String description = ((TextView) view.findViewById(R.id.desciption)).getText().toString();
				
			   
				
				
				AlertDialog.Builder longclick = new AlertDialog.Builder(context);
				longclick.setTitle(name);
				longclick.setMessage(description+"\n"+"\n"+date);
				longclick.show();
				
				outputfile = new File("/sdcard/Shadow/Downloads/", name+"");
				
				return false;
				
				
				
			}
			
			
			
		});

		
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			
			

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				name = ((TextView) view.findViewById(R.id.name)).getText().toString();
				final String date = ((TextView) view.findViewById(R.id.date)).getText().toString();
				final String url = ((TextView) view.findViewById(R.id.url)).getText().toString();
				final String description = ((TextView) view.findViewById(R.id.desciption)).getText().toString();
				
				File file = new File(Environment.getExternalStorageDirectory()+"/Shadow/Downloads/", name+".apk");
				
				if (file.exists()) {
					
					AlertDialog.Builder downloaded = new AlertDialog.Builder(context);
					downloaded.setTitle("Already downloaded");
					downloaded.setMessage("The file '"+name+"' has already been downloaded, do you want to install it now?");
					downloaded.setNegativeButton("No", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							
							
						}
						
						
						
					});
					
					final File download = new File("/sdcard/Shadow/Downloads/", name+".apk");
					
					downloaded.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							
							Intent intent = new Intent(Intent.ACTION_VIEW);
						 	  intent.setDataAndType(Uri.fromFile(download), "application/vnd.android.package-archive");
						 	  context.startActivity(intent);
							
						}
						
					});
					
					downloaded.show();
					
					
				} else {
				
				AlertDialog.Builder download = new AlertDialog.Builder(context);
				
				download.setTitle("Do you want to download this?");
				download.setMessage("You are now downloading "+name+". Do you want to continue?");
				download.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						
						DownloadMapAsync mew = new DownloadMapAsync();
				    	mew.execute(url);
						
						
						
						
					}
					
					
					
				});
				download.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						
						
					}
					
				});
				
				download.show();
				
				}
				
				
				
				
				// Starting new intent
				
				
				

			}
		});
	
	}
	
	class DownloadMapAsync extends AsyncTask<String, String, String> {
		
		File outputfile;
		
		
		ProgressDialog mProgressDialog;
		
	    String result ="";
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressDialog = new ProgressDialog(context);			
			mProgressDialog.setTitle("Downloading...");
			mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			mProgressDialog.setCancelable(false);
			mProgressDialog.show();
			
		
		}

		@Override
		protected String doInBackground(String... aurl) {
			int count;

		try {

			
			outputfile = new File("/sdcard/Shadow/Downloads/", name+".apk");
			   
		
		URL url = new URL(aurl[0]);
		URLConnection conexion = url.openConnection();
		conexion.connect();
		int lenghtOfFile = conexion.getContentLength();
		InputStream input = new BufferedInputStream(url.openStream());
		
		OutputStream output = new FileOutputStream(outputfile);

		byte data[] = new byte[1024];
		long total = 0;

			while ((count = input.read(data)) != -1) {
				total += count;
				publishProgress(""+(int)((total*100)/lenghtOfFile));
				output.write(data, 0, count);
			}
			output.close();
			input.close();
			result = "true";

		} catch (Exception e) {
			
			result = "false";
		}
		return null;

		}
		protected void onProgressUpdate(String... progress) {
			 Log.d("ANDRO_ASYNC",progress[0]);
			 mProgressDialog.setProgress(Integer.parseInt(progress[0]));
		}

		@Override
		protected void onPostExecute(String unused) {
			mProgressDialog.dismiss();
			if(result.equalsIgnoreCase("true")){
				
				
				final File download = new File("/sdcard/Shadow/Downloads/", name+".apk");
	     	
				AlertDialog.Builder install = new AlertDialog.Builder(context);
				install.setTitle("Finished downloading");
				install.setMessage("The download is completed, would you like to install '"+name+"' now?");
				install.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						
						Intent intent = new Intent(Intent.ACTION_VIEW);
					 	  intent.setDataAndType(Uri.fromFile(download), "application/vnd.android.package-archive");
					 	  context.startActivity(intent);
					}
					
				});
				install.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						
						
					}
					
				});
				install.show();
			
			}
			else{
				
			}
		}
	}
	
	
	
	
	
	
}

