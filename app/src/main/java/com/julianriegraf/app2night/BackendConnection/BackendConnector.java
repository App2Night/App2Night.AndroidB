package com.julianriegraf.app2night.BackendConnection;

/**
 * Created by Julian Riegraf on 21.10.2016.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class BackendConnector {

    /**
     * Sendet einen Request zum Server und returnt die Antwort.
     */
    public String runHttpPost(String json, int response, String URL) {

        StringBuilder sb = new StringBuilder();
        HttpURLConnection httpURLConnection = null;
        try {
            java.net.URL url = new URL(URL);
            httpURLConnection = (HttpURLConnection) url.openConnection();

            // Verbindung konfigurieren
            httpURLConnection.setDoInput(true);

            httpURLConnection.setRequestMethod("POST");
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

    public String runHttpGet(int response, String URL, String parameters) {

        StringBuilder sb = new StringBuilder();
        HttpURLConnection httpURLConnection = null;
        try {
            java.net.URL url;
            if (parameters != null) {
                url = new URL(URL + parameters);
            } else {
                url = new URL(URL);
            }

            httpURLConnection = (HttpURLConnection) url.openConnection();

            // Verbindung konfigurieren
            httpURLConnection.setDoInput(true);

            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=" + Charset.defaultCharset().name());

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
                return null;
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


    public int runHttpDelete(String URL, String parameters) {

        StringBuilder sb = new StringBuilder();
        HttpURLConnection httpURLConnection = null;
        try {
            java.net.URL url;
            if (parameters != null) {
                url = new URL(URL + parameters);
            } else {
                url = new URL(URL);
            }

            httpURLConnection = (HttpURLConnection) url.openConnection();

            // Verbindung konfigurieren
            httpURLConnection.setDoInput(true);

            httpURLConnection.setRequestMethod("DELETE");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=" + Charset.defaultCharset().name());

            return httpURLConnection.getResponseCode();

        } catch (Throwable tr) { // MalformedURLException, IOException,
            // NullPointerException,
            // UnsupportedEncodingException
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return -1;
    }


    public String runHttpPut(String json, int response, String URL, String parameters) {

        StringBuilder sb = new StringBuilder();
        HttpURLConnection httpURLConnection = null;
        try {
            java.net.URL url;
            if (parameters != null) {
                url = new URL(URL + parameters);
            } else {
                url = new URL(URL);
            }
            httpURLConnection = (HttpURLConnection) url.openConnection();

            // Verbindung konfigurieren
            httpURLConnection.setDoInput(true);

            httpURLConnection.setRequestMethod("PUT");
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
}