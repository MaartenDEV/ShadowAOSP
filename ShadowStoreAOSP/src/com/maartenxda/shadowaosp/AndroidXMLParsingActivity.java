package com.maartenxda.shadowaosp;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class AndroidXMLParsingActivity extends ListActivity {

	// All static variables
	static final String URL = "http://bitterrific.com/news.xml";
	// XML node keys
	static final String KEY_ITEM = "item"; // parent node
	static final String KEY_ID = "id";
	static final String KEY_NAME = "name";
	static final String KEY_DATE = "date";
	static final String KEY_DESC = "description";

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
			    .getDefaultSharedPreferences(AndroidXMLParsingActivity.this);
			 
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

			// adding HashList to ArrayList
			menuItems.add(map);
		}

		// Adding menuItems to ListView
		ListAdapter adapter = new SimpleAdapter(this, menuItems,
				R.layout.list_item,
				new String[] { KEY_NAME, KEY_DESC, KEY_DATE }, new int[] {
						R.id.name, R.id.desciption, R.id.date });

		setListAdapter(adapter);

		// selecting single ListView item
		ListView lv = getListView();

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
				String date = ((TextView) view.findViewById(R.id.date)).getText().toString();
				String description = ((TextView) view.findViewById(R.id.desciption)).getText().toString();
				
				// Starting new intent
				Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
				in.putExtra(KEY_NAME, name);
				in.putExtra(KEY_DATE, date);
				in.putExtra(KEY_DESC, description);
				startActivity(in);

			}
		});
	}
}