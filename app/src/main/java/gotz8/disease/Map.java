package gotz8.disease;

/**
 * Created by Gotz8 on 2/1/2018.
 */

import android.app.Dialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.ui.IconGenerator;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import gotz8.disease.model.Disease;
import gotz8.disease.model.Extension;

public class Map extends BaseGoogleMapsAdapter implements GoogleMap.OnInfoWindowClickListener {
    public static final int DIALOG_DOWNLOAD_JSON_PROGRESS = 0;
    private static ArrayList<AreaClass> data;
    private ProgressDialog mProgressDialog;
    private ClusterManager<Disease> mClusterManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Uri targetUri = null;
        for (int i = 0; i < data.size(); i++) {
            AreaClass currentData = data.get(i);
            if(marker.getTitle().contains(currentData.getCountry()))
            {
                try{
                    targetUri = currentData.getUrl();
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    builder.setToolbarColor(ContextCompat.getColor(Map.this,R.color.colorPrimary));
                    builder.setShowTitle(true);
                    builder.setActionButton(BitmapFactory.decodeResource(getResources(),R.drawable.arrow),"Share", Extension.createPendingShareIntent(Map.this));
                    builder.build().launchUrl(Map.this, targetUri);
                }catch (Exception ex){
                    Log.d("Exception",ex.getMessage() + "\n" + ex.getCause().toString());
                    Toast.makeText(Map.this,"Can't find the proper URL", Toast.LENGTH_SHORT).show();
                }finally{
                    return;
                }

            }
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        setupMap(googleMap);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(0, 0), 3));

        mClusterManager = new ClusterManager<>(this, googleMap);

        googleMap.setOnCameraIdleListener(mClusterManager);
        googleMap.setOnCameraIdleListener(mClusterManager);
        googleMap.setOnMarkerClickListener(mClusterManager);
        /*
        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener(){
            @Override
            public boolean onMarkerClick(Marker marker){
                Toast.makeText(Map.this,"Marker clicked",Toast.LENGTH_LONG).show();
                return false;
            }

        });
        */
        googleMap.setOnInfoWindowClickListener(this);
        addDiseaseItems();

        mClusterManager.cluster();


    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_DOWNLOAD_JSON_PROGRESS:
                mProgressDialog = new ProgressDialog(this);

                mProgressDialog.setMessage("Please Wait...");
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                mProgressDialog.setCancelable(true);
                mProgressDialog.show();

                return mProgressDialog;
            default:
                return null;
        }
    }

    private void addDiseaseItems() {
        String url = "http://vacciknowlogy.org/VaccineWatch/nvi/function/getTweetType2.php?filterout=NA&lastid=1&limit=150&type=keyword&wordsquery=";
        AreaClass areaInstance = new AreaClass();
        showDialog(DIALOG_DOWNLOAD_JSON_PROGRESS);
        try {
            areaInstance.execute(url).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        dismissDialog(DIALOG_DOWNLOAD_JSON_PROGRESS);
        data = areaInstance.getAreaJson();
        for (int i = 0; i < data.size(); i++) {
            AreaClass currentData = data.get(i);
            mClusterManager.addItem(new Disease(currentData.getLatitude(), currentData.getLongitude(), currentData.getDate(), currentData.getCountry(), currentData.getKeyword(),currentData.getUrl()));
        }
        mClusterManager.cluster();
    }


    private class RenderClusterInfoWindow extends DefaultClusterRenderer<Disease> {

        RenderClusterInfoWindow(Context context, GoogleMap map, ClusterManager<Disease> clusterManager) {
            super(context, map, clusterManager);
        }

        @Override
        protected void onClusterRendered(Cluster<Disease> cluster, Marker marker) {
            super.onClusterRendered(cluster, marker);
        }

        @Override
        protected void onBeforeClusterItemRendered(Disease item, MarkerOptions markerOptions) {
            BitmapDescriptor markerDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE);

            markerOptions.icon(markerDescriptor).snippet(item.getTitle());
            super.onBeforeClusterItemRendered(item, markerOptions);
        }


    }
}
