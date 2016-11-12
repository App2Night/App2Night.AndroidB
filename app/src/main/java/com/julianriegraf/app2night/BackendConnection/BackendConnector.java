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

    private String token;
    private static BackendConnector instance;

    private BackendConnector() {

    }

    public static BackendConnector getInstance(){
        if (instance == null) {
            return instance = new BackendConnector();
        }else{
            return instance;
        }
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Sendet einen Request zum Server und returnt die Antwort.
     */
    public String runHttpPost(String json, int response, String URL, String contentType) {

        StringBuilder sb = new StringBuilder();
        HttpURLConnection connection = null;
        try {
            java.net.URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();

            // Verbindung konfigurieren
            connection.setDoInput(true);
            if (token != null) {
                connection.setRequestProperty("Authorization", "Bearer " + token);
            }
            connection.setRequestMethod("POST");
            byte[] data = json.getBytes();
            connection.setRequestProperty("Content-Type", contentType + "; charset=" + Charset.defaultCharset().name());
            connection.setFixedLengthStreamingMode(data.length);

            // Daten senden
            connection.getOutputStream().write(data);
            connection.getOutputStream().flush();

            int responseCode = connection.getResponseCode();
            if (responseCode == response) {
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
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
            if (connection != null) {
                connection.disconnect();
            }
        }
        return sb.toString().trim();
    }

    public String runHttpGet(int response, String URL, String parameters) {

        StringBuilder sb = new StringBuilder();
        HttpURLConnection connection = null;
        try {
            java.net.URL url;
            if (parameters != null) {
                url = new URL(URL + parameters);
            } else {
                url = new URL(URL);
            }

            connection = (HttpURLConnection) url.openConnection();

            // Verbindung konfigurieren
            connection.setDoInput(true);
            if (token != null) {
                connection.setRequestProperty("Authorization", "Bearer " + token);
            }
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; charset=" + Charset.defaultCharset().name());

            int responseCode = connection.getResponseCode();
            if (responseCode == response) {
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
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
            if (connection != null) {
                connection.disconnect();
            }
        }

        return sb.toString().trim();
    }


    public int runHttpDelete(String URL, String parameters) {

        StringBuilder sb = new StringBuilder();
        HttpURLConnection connection = null;
        try {
            java.net.URL url;
            if (parameters != null) {
                url = new URL(URL + parameters);
            } else {
                url = new URL(URL);
            }

            connection = (HttpURLConnection) url.openConnection();

            // Verbindung konfigurieren
            connection.setDoInput(true);
            if (token != null) {
                connection.setRequestProperty("Authorization", "Bearer " + token);
            }
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", "application/json; charset=" + Charset.defaultCharset().name());

            return connection.getResponseCode();

        } catch (Throwable tr) { // MalformedURLException, IOException,
            // NullPointerException,
            // UnsupportedEncodingException
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return -1;
    }


    public int runHttpPut(String json, int response, String URL, String parameters) {

        StringBuilder sb = new StringBuilder();
        HttpURLConnection connection = null;
        try {
            java.net.URL url;
            if (parameters != null) {
                url = new URL(URL + parameters);
            } else {
                url = new URL(URL);
            }
            connection = (HttpURLConnection) url.openConnection();

            if (token != null) {
                connection.setRequestProperty("Authorization", "Bearer " + token);
            }
            connection.setDoInput(true);

            connection.setRequestMethod("PUT");
            byte[] data = json.getBytes();
            connection.setRequestProperty("Content-Type", "application/json; charset=" + Charset.defaultCharset().name());
            connection.setFixedLengthStreamingMode(data.length);

            // Daten senden
            connection.getOutputStream().write(data);
            connection.getOutputStream().flush();

            return connection.getResponseCode();

        } catch (Throwable tr) { // MalformedURLException, IOException,
            // NullPointerException,
            // UnsupportedEncodingException
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return -1;
    }
}