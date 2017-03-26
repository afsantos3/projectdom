package com.example.lukem.dom;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by MLH on 3/26/2017.
 */

public class HTTPPostAsyncTask extends AsyncTask<URL, Void, String> {

    @Override
    protected String doInBackground(URL... urls) {
        String response;
        if (urls.length < 1) {
            Log.e("Warning", "Passed zero urls to asynctask");
            return null;
        }
        try {
            response = makeHttpReq(urls[0]);
        } catch (IOException ioecx) {
            Log.e("Error", "Couldn't make request", ioecx);
            return null;
        }
        Log.v("RESPONSE", response);
        return response;
    }

    /**
     * Update the screen with the resulting data
     */
    @Override
    protected void onPostExecute(String response) {
        if (response.isEmpty()) {
            return;
        }
    }

    private String makeHttpReq(URL url) throws IOException {
        String response = "";
        HttpURLConnection urlCon = null;
        InputStream inStr = null;
        try {
            urlCon = (HttpURLConnection) url.openConnection();
            urlCon.setRequestMethod("GET");
            urlCon.setReadTimeout(10000 /* milliseconds */);
            urlCon.setConnectTimeout(15000 /* milliseconds */);
            urlCon.connect();
            inStr = urlCon.getInputStream();
            if (urlCon.getResponseCode() == 200) {
                inStr = urlCon.getInputStream();
                response = readFromStream(inStr);
            }
        } catch (IOException e) {
            Log.e("Error", "Error getting response from web server.", e);
        } finally {
            if (urlCon != null) {
                urlCon.disconnect();
            }
            if (inStr != null) {
                // function must handle java.io.IOException here
                inStr.close();
            }
        }
        return response;
    }

    /**
     * Convert InputStream into a String with JSON response from HTTP Request.
     */
    private String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    static URL makeUrl(String urlString) {
        URL res_url;
        try {
            res_url = new URL(urlString);
        } catch (MalformedURLException exc) {
            Log.e("Error", "Couldn't make url from string", exc);
            return null;
        }
        return res_url;
    }
}
