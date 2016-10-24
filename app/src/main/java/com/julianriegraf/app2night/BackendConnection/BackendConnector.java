package com.julianriegraf.app2night.BackendConnection;

/**
 * Created by Julian Riegraf on 21.10.2016.
 */

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class BackendConnector {
    private static final String USER_URL = "http://app2nightapi.azurewebsites.net/api/User";
    private static final String PARTY_URL = "http://app2nightapi.azurewebsites.net/api/Party";
    private static final String VALUES_URL = "http://app2nightapi.azurewebsites.net/api/Values";

    /**
     *
     * Sendet einen Request zum Server und returnt die Antwort.
     *
     */
    private String runHTTP(String json, int response, String type, String URL) {

        StringBuilder sb = new StringBuilder();
        HttpURLConnection httpURLConnection = null;
        try {
            java.net.URL url = new URL(URL);
            httpURLConnection = (HttpURLConnection) url.openConnection();

            // Verbindung konfigurieren
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            httpURLConnection.setRequestMethod(type);
            byte[] data = json.getBytes();
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=" + Charset.defaultCharset().name());
            httpURLConnection.setFixedLengthStreamingMode(data.length);

            // Daten senden
            httpURLConnection.getOutputStream().write(data);
            httpURLConnection.getOutputStream().flush();

            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == response) {
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                int i;
                while ((i = bufferedReader.read()) != -1) {
                    sb.append((char) i);
                }
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    // ein Fehler beim Schließen wird bewusst ignoriert
                }
            } else {
                return "failed;" + responseCode;
            }
        } catch (Throwable tr) { // MalformedURLException, IOException,
            // NullPointerException,
            // UnsupportedEncodingException
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return sb.toString().trim();
    }


    public String createUser(String name, String pw) {
        JSONObject json = new JSONObject();
        try {
            json.put("username", name);
            json.put("password", pw);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return runHTTP(json.toString(), 201, "POST", USER_URL);
    }

    public String removeUser(String id) {
        JSONObject json = new JSONObject();
        try {
            json.put("UserID", id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return runHTTP(json.toString(), 200, "POST", USER_URL);
    }

    public String getParties(){
        return runHTTP(" ", 200, "GET", PARTY_URL);
    }

    public String createParty(){
        return null;
    }

    public String removeParty(){
        return null;
    }
}