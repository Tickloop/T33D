package com.tickloop.t33d.model;

import android.net.Uri;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;

import com.mongodb.stitch.android.core.Stitch;
import com.mongodb.stitch.android.core.StitchAppClient;
import com.mongodb.stitch.core.*;
import com.tickloop.t33d.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmConfiguration;

public interface UserAccountDao<realm> {


    RealmConfiguration config = new RealmConfiguration.Builder()
            .allowQueriesOnUiThread(true)
            .allowWritesOnUiThread(true)
            .build();

    Realm realm = Realm.getInstance(config);
    //return realm;

    /*class getDataTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) throws IOException {
            URL url = new URL(params[0]);
            StringBuilder result = new StringBuilder();
            HttpURLConnection httpConnect = (HttpURLConnection) url.openConnection();
            httpConnect.setReadTimeout(1000);
            httpConnect.setConnectTimeout(1000);
            httpConnect.setRequestMethod("GET");
            httpConnect.setRequestProperty("user", "application/json");
            httpConnect.connect();
            InputStream input = httpConnect.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(input));
            String line = read.readLine();
            while((line != null)){
                result.append(line);
                line = read.readLine();
            }

            return line.toString();
        }

        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);

        }
    }*/
}
