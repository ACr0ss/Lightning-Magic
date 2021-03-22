package com.cross.magic;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cross.magic.db.DBHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;


public class SplashScreen extends AppCompatActivity {

    Gson gson;
    String ft, fn, fc, fts, fo, fp, fr, furl;
    Intent i;
    private ProgressDialog pDialog;
    public static final int progress_bar_type = 0;
    public static final int dbprogress = 1;
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    final Context mycon = this.getBaseContext();



    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type: // we set this to 0
                pDialog = new ProgressDialog(this);
                pDialog.setMessage("Working on the database. Please wait...");
                pDialog.setIndeterminate(false);
                pDialog.setMax(100);
                pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pDialog.setCancelable(false);
                pDialog.show();
                return pDialog;
            default:
                return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        final SharedPreferences prefs = getApplicationContext().getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            }
        }

        final DBHelper h = new DBHelper(getBaseContext());
        RequestQueue queue = VolleySingleton.getInstance(this.getApplicationContext()).
                getRequestQueue();


        try {
            final Context act = this;
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setDateFormat("M/d/yy hh:mm a");
            gson = gsonBuilder.create();
            i = new Intent(SplashScreen.this, MainActivity.class);

            final String url = "https://api.scryfall.com/cards/random?q=has:flavor%20unique:prints";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                //String rawJSON = response.toString();
                                ft = response.getString("flavor_text");// .getJSONObject("flavor_text").toString();
                                fn = response.getString("name");
                                fc = response.getString("mana_cost");
                                fts = response.getString("type_line");
                                fo = response.getString("oracle_text");
                                if (response.has("power") && response.has("toughness")) {
                                    fp = response.getString("power");
                                    fr = response.getString("toughness");
                                } else {
                                    fp = "";
                                    fr = "";
                                }
                                JSONObject ob = response.getJSONObject("image_uris");

                                /*
                                 *
                                 * JSONObject object = airportArray.getJSONObject(j);
                                 * idDep = object.getString("country_id");
                                 *
                                 * */
                                furl = ob.getString("png");

                                //Card card2 = gson.fromJson(rawJSON, Card.class);
                                i.putExtra("text", ft);
                                i.putExtra("name", fn);
                                i.putExtra("cost", fc);
                                i.putExtra("types", fts);
                                i.putExtra("oracle", fo);
                                i.putExtra("power", fp);
                                i.putExtra("toughness", fr);
                                i.putExtra("url", furl);

                            } catch (Exception e) {
                                e.printStackTrace();

                            }

                            String jsondownload = "https://api.scryfall.com/bulk-data";
                            final JsonObjectRequest jsonbulkObjectRequest = new JsonObjectRequest
                                    (Request.Method.GET, jsondownload, null, new Response.Listener<JSONObject>() {
                                        @Override
                                        public void onResponse(JSONObject response) {
                                            try {
                                                String lastupdated = "";
                                                String bulkurl = "";
                                                JSONArray bulk = (JSONArray) response.get("data");
                                                for (int i = 0; i < bulk.length(); i++) {
                                                    JSONObject object = bulk.optJSONObject(i);
                                                    Iterator<String> iterator = object.keys();
                                                    while (iterator.hasNext()) {
                                                        String currentKey = iterator.next();
                                                        if (currentKey.equals("name")) {
                                                            if (object.getString("name").equals("Oracle Cards")) {
                                                                lastupdated = object.getString("updated_at");
                                                                bulkurl = object.getString("download_uri");
                                                            }
                                                        }
                                                    }
                                                }
                                                if (!lastupdated.equals(prefs.getString("UPDATE_DATE", null))) {
                                                    AlertDialog.Builder builder = new AlertDialog.Builder(act);
                                                    builder.setMessage("New cards have been detected, \nwould you like to download the cards?");
                                                    builder.setCancelable(false);
                                                    final String finalBulkurl = bulkurl;
                                                    final String finalLastupdated = lastupdated;
                                                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            try {
                                                                editor.clear();
                                                                editor.putString("UPDATE_DATE", finalLastupdated).commit();
                                                                new DownloadFileFromURL().execute(finalBulkurl);
                                                            } catch (Exception e) {
                                                                e.printStackTrace();
                                                            }
                                                        }
                                                    });
                                                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            startActivity(i);
                                                            finish();
                                                        }
                                                    });
                                                    AlertDialog dialog = builder.create();
                                                    dialog.show();
                                                } else {
                                                    startActivity(i);
                                                    finish();
                                                }
                                            } catch (JSONException e) {
                                                Toast.makeText(SplashScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                                e.printStackTrace();
                                            }
                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Log.d("ERRORJSONDEP", "No working" + error.getMessage());
                                            startActivity(i);
                                            finish();
                                        }
                                    });
                            VolleySingleton.getInstance(mycon).addToRequestQueue(jsonbulkObjectRequest);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            startActivity(i);
                            finish();
                        }
                    });
            VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class DownloadFileFromURL extends AsyncTask<String, String, String> {

        public String f = "";
        final DBHelper h = new DBHelper(getBaseContext());

        /**
         * Before starting background thread Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progress_bar_type);
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            int count;

            try {
                URL url = new URL(f_url[0]);
                URLConnection conection = url.openConnection();
                conection.connect();

                // this will be useful so that you can show a tipical 0-100%
                // progress bar
                int lenghtOfFile = conection.getContentLength();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream(),
                        8192);

                // Output
                File out = new File(Environment
                        .getExternalStorageDirectory().toString()
                        + "/cards.json");
                OutputStream output = new FileOutputStream(out);
                f = out.getAbsolutePath();

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            try {
                h.parseJSON(f);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * Updating progress bar
         */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }


        /**
         * After completing background task Dismiss the progress dialog
         **/
        @Override
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after the file was downloaded
            dismissDialog(progress_bar_type);

            startActivity(i);
            finish();
        }

    }


}
