package gotz8.disease;

/**
 * Created by Gotnpd on 30/9/2560.
 */

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

import gotz8.disease.model.Extension;


public class News extends AppCompatActivity {
    public static final int DIALOG_DOWNLOAD_JSON_PROGRESS = 0;
    private ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> MyArrList;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        // Permission StrictMode
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

            new DownloadSearchFileAsync().execute();

    }
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_DOWNLOAD_JSON_PROGRESS:
                mProgressDialog = new ProgressDialog(this);

                mProgressDialog.setMessage("กรุณารอสักครู่...");
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                mProgressDialog.setCancelable(true);
                mProgressDialog.show();

                return mProgressDialog;
            default:
                return null;
        }
    }
    public class DownloadSearchFileAsync extends AsyncTask<String, Void, Void> {

            protected void onPreExecute() {
                super.onPreExecute();
                showDialog(DIALOG_DOWNLOAD_JSON_PROGRESS);
            }

        @Override
        protected Void doInBackground(String... arg) {
            // TODO Auto-generated method stub


            String url = "http://vacciknowlogy.org/VaccineWatch/nvi/function/getTweetType2.php?filterout=NA&lastid=1&limit=100&type=keyword&wordsquery=";

            List<NameValuePair> params = new ArrayList<>();
            try {
                JSONArray data = new JSONArray(getJSON(url, params));

                MyArrList = new ArrayList<>();
                HashMap<String, String> map;

                for (int i = 0; i < data.length(); i++) {
                    JSONObject c = data.getJSONObject(i);

                    map = new HashMap<>();
                    map.put("userscreen", c.getString("userscreen"));
                    map.put("tdate", c.getString("tdate"));
                    map.put("keyword", c.getString("keyword"));
                    map.put("text", c.getString("text"));
                    map.put("url",c.getString("url"));
                    MyArrList.add(map);

                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            return null;
        }

        protected void onPostExecute(Void unused) {
            ShowSearchData(); // When Finish Show Content

            dismissDialog(DIALOG_DOWNLOAD_JSON_PROGRESS);
            removeDialog(DIALOG_DOWNLOAD_JSON_PROGRESS);
        }

    }
    public void ShowSearchData()
    {
        ListView listViewMovies = (ListView) findViewById(R.id.listView1);
        SimpleAdapter simpleAdapterData;
        simpleAdapterData = new SimpleAdapter(News.this, MyArrList, R.layout.activity_list, new String[]{"userscreen", "tdate", "keyword", "text"}, new int[]{R.id.userscreen, R.id.tdate, R.id.keyword, R.id.text});
        listViewMovies.setAdapter(simpleAdapterData);
        listViewMovies.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
               String url = MyArrList.get(position).get("url");
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(News.this,R.color.colorPrimary));
                builder.setShowTitle(true);
                builder.setActionButton(BitmapFactory.decodeResource(getResources(),R.drawable.arrow),"Share", Extension.createPendingShareIntent(News.this));
                CustomTabsIntent customTabsIntent = builder.build();

                customTabsIntent.launchUrl(News.this, Uri.parse(url));
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse(test));
                //startActivity(Intent.createChooser(intent, "Open with"));



                //TextView tvTitle = (TextView) view.findViewById(R.id.userscreen);
                //TextView tvUrl = (TextView) view.findViewById(R.id.text);


            }
        }
        );




    }




    public String getJSON(String url,List<NameValuePair> params) {
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
