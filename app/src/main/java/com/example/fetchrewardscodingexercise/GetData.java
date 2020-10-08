package com.example.fetchrewardscodingexercise;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetData extends AsyncTask<Void, Void, Void> {
    String data = "";
    String singleParse = "";
    String parsedData = "";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://fetch-hiring.s3.amazonaws.com/hiring.json");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
            
            JSONArray JA = new JSONArray(data);
            for(int i=0; i<JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);

                if(JO.get("name").toString().equals("") || JO.get("name").toString().equals("null")) {
                    continue;
                }

                singleParse = "ID: " + JO.get("id").toString() + "\n" +
                        "listID: " + JO.get("listId").toString() + "\n" +
                        "Name: " + JO.get("name").toString() + "\n";

                parsedData = parsedData + singleParse + "\n";

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.textView.setText(this.parsedData);
    }

}
