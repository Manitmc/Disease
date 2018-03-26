package gotz8.disease.model;

/**
 * Created by Gotz8 on 2/1/2018.
 */

import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by Peter-John on 2017-04-11.
 * GoogleMapsTutorial
 */

public class Disease implements ClusterItem {

    private final LatLng mPosition;
    private String name;
    private String twitterHandle;
    private String date_time;
    private Uri url;
    private double latitude;
    private double longitude;
    public Disease(double lat, double lng, String date, String name, String twitterHandle ,Uri url) {
        this.latitude = lat;
        this.longitude = lng;
        this.name = name;
        this.url =url;
        this.date_time = date;
        this.twitterHandle = twitterHandle;

        mPosition = new LatLng(lat, lng)
       ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public LatLng getPosition() {
        return mPosition;
    }

    @Override
    public String getTitle() {
        return name + " (" + date_time + ")";
    }

    @Override
    public String getSnippet() {
        return twitterHandle;
    }
}
