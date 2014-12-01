package com.example.parkuf;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

//import android.widget.ListView;

public class ZsonActivity extends ListActivity {
	String areas;
	int temp;
	private ProgressDialog pDialog;
	public static final String ARG_AREA_NUMBER = "area_number";

	// URL to get contacts JSON
	private static String url = "http://54.148.158.124/json";

	private static final String TAG_NUMBER = "number";
	private static final String TAG_NAME = "name";
	private static final String TAG_DECAL = "decal";
	private static final String TAG_SPOTSOPEN = "spotsOpen";
	private static final String TAG_SPOTSTOTAL = "spotsTotal";
	private static final String TAG_BEGINENFORCEMENT = "beginEnforcement";
	private static final String TAG_ENDENFORCEMENT = "endEnforcement";

	// Hashmap for ListView
	ArrayList<HashMap<String, String>> jsonList;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		/*
		 * Intent i = new Intent(getApplicationContext(),MainActivity.class);
		 * startActivity(i);
		 */
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_json);
		// 1. get passed intent
		Intent intent = getIntent();

		// 2. get message value from intent
		areas = intent.getStringExtra("areas");
		temp = Integer.parseInt(areas);

		jsonList = new ArrayList<HashMap<String, String>>();

		// Calling async task to get json
		new GetContacts(this).execute((Void) null);
		
	}

	/**
	 * Async task class to get json by making HTTP call
	 **/
	private class GetContacts extends AsyncTask<Void, Void, Void> {

		private final WeakReference<ZsonActivity> zsonActivityWeakRef;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			pDialog = new ProgressDialog(ZsonActivity.this);
			pDialog.setMessage("Please wait...");
			pDialog.setCancelable(false);
			pDialog.show();
		}

		public GetContacts(ZsonActivity zsonActivity) {
			super();
			this.zsonActivityWeakRef = new WeakReference<ZsonActivity>(
					zsonActivity);			
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// Creating service handler class instance
			ServiceHandler sh = new ServiceHandler();

			// Making a request to url and getting response
			String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

			JSONArray jArray = null;

			// Log.d("Response: ", "> " + jsonStr);

			if (jsonStr != null) {
				try {
					jArray = new JSONArray(jsonStr);

					// Getting JSON Array node
					// contacts = jsonObj.getJSONArray(TAG_CONTACTS);

					// looping through All Contacts
					for (int i = 0; i < jArray.length(); i++) {

						if (i == temp) {
							JSONObject c = jArray.getJSONObject(i);

							String number = c.getString(TAG_NUMBER);
							String name = c.getString(TAG_NAME);
							String decal = c.getString(TAG_DECAL);
							String spotsOpen = c.getString(TAG_SPOTSOPEN);
							String spotsTotal = c.getString(TAG_SPOTSTOTAL);
							String beginEnforcement = c
									.getString(TAG_BEGINENFORCEMENT);
							String endEnforcement = c
									.getString(TAG_ENDENFORCEMENT);

							// tmp hashmap for single conta

							HashMap<String, String> map = new HashMap<String, String>();
							// Add child node to HashMap key & value
							map.put(TAG_NUMBER, number);
							map.put(TAG_NAME, name);
							map.put(TAG_DECAL, decal);
							map.put(TAG_SPOTSOPEN, spotsOpen);
							map.put(TAG_SPOTSTOTAL, spotsTotal);
							map.put(TAG_BEGINENFORCEMENT, beginEnforcement);
							map.put(TAG_ENDENFORCEMENT, endEnforcement);
							jsonList.add(map);
							break;
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				Log.e("ServiceHandler", "Couldn't get any data from the url");
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			// Dismiss the progress dialog
			if (pDialog.isShowing())
				pDialog.dismiss();
			/**
			 * Updating parsed JSON data into ListView
			 * */
			
			ListAdapter adapter = new SimpleAdapter(ZsonActivity.this,
					jsonList, R.layout.list_item, new String[] { TAG_NUMBER,
							TAG_NAME, TAG_DECAL, TAG_SPOTSOPEN, TAG_SPOTSTOTAL,
							TAG_BEGINENFORCEMENT, TAG_ENDENFORCEMENT },
					new int[] { R.id.number, R.id.name, R.id.decal,
							R.id.spotsOpen, R.id.spotsTotal,
							R.id.beginEnforcement, R.id.endEnforcement });
			setListAdapter(adapter);

		}
	}
}
