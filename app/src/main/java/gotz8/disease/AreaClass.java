package gotz8.disease;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.maps.CameraUpdateFactory;



/**
 * Created by Gotz8 on 2/1/2018.
 */

public class AreaClass extends AsyncTask<String, Void, Void> {
    private String tdate;
    private String country;
    private double lat;
    private double lng;
    private Uri url;
    private String keyword;

    private ArrayList<AreaClass> returnData;
    public  AreaClass(){

    }



    @Override

    protected Void doInBackground(String... strings) {
        returnData = new ArrayList<>();
        List<NameValuePair> params = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(getJSON(strings[0],params));
            for(int i = 0;i<data.length();i++){
                AreaClass n = new AreaClass();
                JSONObject c = data.getJSONObject(i);
                n.setDate(c.getString("tdate"));
                n.setCountry(c.getString("country"));
                n.setKeyword(c.getString("keyword"));
                n.setUrl(c.getString("url"));
                n.setLatitude(Double.parseDouble(c.getString("lat")));
                n.setLongitude(Double.parseDouble(c.getString("lng")));
                returnData.add(n);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void setDate(String value){
        tdate = value;
    }
    public void setCountry(String value){
        country = value;
    }
    public Uri getUrl(){
        return url;
    }
    public void setUrl(String value) {
        url = Uri.parse(value);
    }
    public void setKeyword(String value){
        keyword = value;
    }
    public void setLatitude(double value){
        lat = value;
    }
    public void setLongitude(double value){
        lng = value;
    }
    public String getDate(){
        return tdate;
    }
    public String getCountry(){
        return country;
    }
    public double getLatitude(){
        return lat;
    }
    public double getLongitude(){
        return lng;
    }
    public String getKeyword(){
        return keyword;
    }
    public ArrayList<AreaClass> getAreaJson(){
        return returnData;
    }
    private String getJSON(String url,List<NameValuePair> params) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = client.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader_buffer = new BufferedReader
                        (new InputStreamReader(content));

                String line;
                while ((line = reader_buffer.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download file..");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

}
