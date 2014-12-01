package com.example.parkuf;

import java.text.DecimalFormat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapzFragment extends Combine implements LocationListener {

	static final LatLng reitzUnion = new LatLng(29.644356, -82.347606);
	static final LatLng flavet = new LatLng(29.646684, -82.354460);
	static final LatLng shands = new LatLng(29.638619, -82.347743);
	static final LatLng cancer = new LatLng(29.640406, -82.341197);
	static final LatLng fifield = new LatLng(29.638065, -82.360944);
	static final LatLng criser = new LatLng(29.650191, -82.340855);
	static final LatLng murphree = new LatLng(29.651393, -82.347289);
	static final LatLng gator = new LatLng(29.653752, -82.347257);

	static final LatLng walmart = new LatLng(29.626366, -82.374121);// testing
																	// from
																	// Campus
																	// Club

	Location mLocation = new Location(""); // current location

	Location flavet_loc = new Location("");
	Location reitz_loc = new Location("");
	Location shands_loc = new Location("");
	Location cancer_loc = new Location("");
	Location fifield_loc = new Location("");
	Location criser_loc = new Location("");
	Location murphree_loc = new Location("");
	Location gator_loc = new Location("");

	Location walmart_loc = new Location("");// testing from Campus Club

	private GoogleMap map;

	private int loc_position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_map);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapid))
				.getMap();
		map.setMyLocationEnabled(true);
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

		// Zoom in, animating the camera.
		map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				120000, 10, this);

	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

		flavet_loc.setLatitude(29.646684);
		flavet_loc.setLongitude(-82.354460);
		reitz_loc.setLatitude(29.644356);
		reitz_loc.setLongitude(-82.347606);
		shands_loc.setLatitude(29.638619);
		shands_loc.setLongitude(-82.347743);
		cancer_loc.setLatitude(29.640406);
		cancer_loc.setLongitude(-82.341197);
		fifield_loc.setLatitude(29.638065);
		fifield_loc.setLongitude(-82.360944);
		criser_loc.setLatitude(29.650191);
		criser_loc.setLongitude(-82.340855);
		murphree_loc.setLatitude(29.651393);
		murphree_loc.setLongitude(-82.347289);
		gator_loc.setLatitude(29.653752);
		gator_loc.setLongitude(-82.347257);

		mLocation.setLatitude(location.getLatitude());
		mLocation.setLongitude(location.getLongitude());

		walmart_loc.setLatitude(29.626366);// testing from Campus Club
		walmart_loc.setLongitude(-82.374121);// testing from Campus Club

		int i = 0;
		DecimalFormat newFormat = new DecimalFormat("#.##");

		final Marker flavet1 = map.addMarker(new MarkerOptions()
				.position(flavet)
				.title("Flavet Parking")
				.snippet(
						String.valueOf(newFormat.format(mLocation
								.distanceTo(flavet_loc) * 0.000621371192))
								+ " miles"));
		final Marker reitz = map.addMarker(new MarkerOptions()
				.position(reitzUnion)
				.title("Reitz Union Parking")
				.snippet(
						String.valueOf(newFormat.format(mLocation
								.distanceTo(reitz_loc) * 0.000621371192))
								+ " miles")
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

		final Marker shands1 = map.addMarker(new MarkerOptions()
				.position(shands)
				.title("Shands Parking")
				.snippet(
						String.valueOf(newFormat.format(mLocation
								.distanceTo(shands_loc) * 0.000621371192))
								+ " miles")
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

		final Marker cancer1 = map.addMarker(new MarkerOptions()
				.position(cancer)
				.title("Cancer Center Parking")
				.snippet(
						String.valueOf(newFormat.format(mLocation
								.distanceTo(cancer_loc) * 0.000621371192))
								+ " miles")
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

		final Marker fifield1 = map.addMarker(new MarkerOptions()
				.position(fifield)
				.title("Fifield Hall Parking")
				.snippet(
						String.valueOf(newFormat.format(mLocation
								.distanceTo(fifield_loc) * 0.000621371192))
								+ " miles")
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

		final Marker criser1 = map.addMarker(new MarkerOptions()
				.position(criser)
				.title("Criser Hall Parking")
				.snippet(
						String.valueOf(newFormat.format(mLocation
								.distanceTo(criser_loc) * 0.000621371192))
								+ " miles")
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

		final Marker murphree1 = map.addMarker(new MarkerOptions()
				.position(murphree)
				.title("Murphree Parking")
				.snippet(
						String.valueOf(newFormat.format(mLocation
								.distanceTo(murphree_loc) * 0.000621371192))
								+ " miles")
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

		final Marker gator1 = map.addMarker(new MarkerOptions()
				.position(gator)
				.title("Gator Parking")
				.snippet(
						String.valueOf(newFormat.format(mLocation
								.distanceTo(gator_loc) * 0.000621371192))
								+ " miles")
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
		// testing from Campus Club
		final Marker walmart1 = map.addMarker(new MarkerOptions()
				.position(walmart)
				.title("Walmart Parking")
				.snippet(
						String.valueOf(newFormat.format(mLocation
								.distanceTo(walmart_loc) * 0.000621371192))
								+ " miles"));

		double[] nearest = new double[] { mLocation.distanceTo(flavet_loc),
				mLocation.distanceTo(reitz_loc),
				mLocation.distanceTo(shands_loc),
				mLocation.distanceTo(cancer_loc),
				mLocation.distanceTo(fifield_loc),
				mLocation.distanceTo(criser_loc),
				mLocation.distanceTo(murphree_loc),
				mLocation.distanceTo(gator_loc),
				mLocation.distanceTo(walmart_loc) };

		double min_dist = nearest[0];
		for (i = 0; i < nearest.length; i++) {
			if (nearest[i] < min_dist) {
				min_dist = nearest[i];
				loc_position = i;
			}
		}

		if (loc_position == 0 ) {
			alertbox("Flavet Parking", "0");
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(flavet, 15));

			flavet1.showInfoWindow();

		}

		if (loc_position == 1 ) {
			alertbox("Reitz Union Parking", "1");
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(reitzUnion, 15));
			reitz.showInfoWindow();
		}

		if (loc_position == 2 /* && min_dist <= 250 */) {
			alertbox("Shands Parking", "2");
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(shands, 15));

			// shands1.showInfoWindow();

			shands1.showInfoWindow();
		}

		if (loc_position == 3 ) {
			alertbox("Cancer Center Parking", "3");
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(cancer, 15));
			cancer1.showInfoWindow();
		}

		if (loc_position == 4 ) {
			alertbox("Fifield Hall Parking", "4");
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(fifield, 15));
			fifield1.showInfoWindow();
		}

		if (loc_position == 5 ) {
			alertbox("Criser Hall Parking", "5");
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(criser, 15));
			criser1.showInfoWindow();
		}

		if (loc_position == 6 ) {
			alertbox("Murphree Parking", "6");
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(murphree, 15));
			murphree1.showInfoWindow();
		}

		if (loc_position == 7 ) {
			alertbox("Gator Parking", "7");
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(gator, 15));
			gator1.showInfoWindow();
		}
		// testing from Campus Club
		if (loc_position == 8 ) {

			alertbox("Walmart Parking", "0");
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(walmart, 15));
			walmart1.showInfoWindow();

		}

		map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
			public void onInfoWindowClick(Marker marker) {
				if (marker.equals(flavet1)) {
					Intent intent = new Intent(getApplicationContext(),
							ZsonActivity.class);
					Bundle extras = new Bundle();
					extras.putString("areas", "0");
					intent.putExtras(extras);
					startActivity(intent);

				}
				if (marker.equals(reitz)) {
					Intent intent = new Intent(getApplicationContext(),
							ZsonActivity.class);
					Bundle extras = new Bundle();
					extras.putString("areas", "1");
					intent.putExtras(extras);
					startActivity(intent);

				}

				if (marker.equals(shands1)) {
					Intent intent = new Intent(getApplicationContext(),
							ZsonActivity.class);
					Bundle extras = new Bundle();
					extras.putString("areas", "2");
					intent.putExtras(extras);
					startActivity(intent);

				}

				if (marker.equals(cancer1)) {
					Intent intent = new Intent(getApplicationContext(),
							ZsonActivity.class);
					Bundle extras = new Bundle();
					extras.putString("areas", "3");
					intent.putExtras(extras);
					startActivity(intent);

				}

				if (marker.equals(fifield1)) {
					Intent intent = new Intent(getApplicationContext(),
							ZsonActivity.class);
					Bundle extras = new Bundle();
					extras.putString("areas", "4");
					intent.putExtras(extras);
					startActivity(intent);

				}
				if (marker.equals(criser1)) {
					Intent intent = new Intent(getApplicationContext(),
							ZsonActivity.class);
					Bundle extras = new Bundle();
					extras.putString("areas", "5");
					intent.putExtras(extras);
					startActivity(intent);

				}

				if (marker.equals(murphree1)) {
					Intent intent = new Intent(getApplicationContext(),
							ZsonActivity.class);
					Bundle extras = new Bundle();
					extras.putString("areas", "6");
					intent.putExtras(extras);
					startActivity(intent);

				}
				if (marker.equals(gator1)) {
					Intent intent = new Intent(getApplicationContext(),
							ZsonActivity.class);
					Bundle extras = new Bundle();
					extras.putString("areas", "7");
					intent.putExtras(extras);
					startActivity(intent);

				}
				if (marker.equals(walmart1)) {
					Intent intent = new Intent(getApplicationContext(),
							ZsonActivity.class);
					Bundle extras = new Bundle();
					extras.putString("areas", "0");
					intent.putExtras(extras);
					startActivity(intent);
				}
			}
		});
		return;
	}

	private void alertbox(String parking_lot, String its_number) {
		// TODO Auto-generated method stub
		String my_parking = parking_lot;
		final String area_number = its_number;

		AlertDialog.Builder builder = new AlertDialog.Builder(MapzFragment.this);
		builder.setMessage(
				"You are near " + my_parking + "."
						+ " Do you want to check parking availablity there?")
				.setCancelable(false)
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// if this button is clicked, just close
								// the dialog box and do nothing
								dialog.cancel();
							}
						})
				.setPositiveButton("Check",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// if this button is clicked, close
								// current activity
								dialog.dismiss();
								Intent intent = new Intent(
										getApplicationContext(),
										ZsonActivity.class);
								Bundle extras = new Bundle();
								extras.putString("areas", area_number);
								intent.putExtras(extras);
								startActivity(intent);
							}
						});
		AlertDialog alert = builder.create();
		builder.setCancelable(true);
		// WindowManager$BadTokenException will be caught and the app would not
		// display
		// the 'Force Close' message
		try {
			alert.show();
		} catch (Exception e) {

		}
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}
}