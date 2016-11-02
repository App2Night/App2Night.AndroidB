package com.julianriegraf.app2night.BackendConnection;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.julianriegraf.app2night.Models.Party;
import com.julianriegraf.app2night.Models.User;

/**
 * Created by Julian Riegraf on 25.10.2016.
 */

public class BackendTasks {

    private static final String USER_URL = "http://app2nightapi.azurewebsites.net/api/User/";
    private static final String PARTY_URL = "http://app2nightapi.azurewebsites.net/api/Party/";
    private static final String VALUES_URL = "http://app2nightapi.azurewebsites.net/api/Values/";
    private static final String CONNECT_URL = "http://app2nightuser.azurewebsites.net/connect/token";

    private static String CONNECTION_TYPE_JSON = "application/json";
    private static String CONNECTION_TYPE_URL = "application/x-www-form-urlencoded";

    BackendConnector bc = new BackendConnector();

    public void setToken(String token) {
        bc.setToken(token);
    }

    /**
     * Lädt einen neuen User auf den Server.
     *
     * @param user Der User, welche in die Datenbank geschrieben werden soll.
     * @return Die ID des erstellten Users.
     */
    public String createUser(User user) {
        String id = bc.runHttpPost(new Gson().toJson(user), 201, USER_URL, CONNECTION_TYPE_JSON);
        return id;
    }

    /**
     * Ändert die User Daten.
     *
     * @param user Das User-Objekt, welches die Änderungen enthält.
     * @return Den HTTP ResponseCode.
     */
    public String updateUser(User user) {
        String json = new Gson().toJson(user);
        int response = bc.runHttpPut(json, 200, PARTY_URL, "id=" + user.getHostId());
        return String.valueOf(response);
    }

    public String deleteUser(String id) {
        //TODO: Implementieren, wenn Schnittstelle bereitsteht
        return null;
    }

    public String login(String username, String password) {
        String body = "client_id=nativeApp&client_secret=secret&grant_type=password&username=" + username
                + "&password=" + password + "&scope=App2NightAPI offline_access&offline_access=true";
        String token = bc.runHttpPost(body, 200, CONNECT_URL, CONNECTION_TYPE_URL);
        token = new Gson().fromJson(token, JsonObject.class).get("access_token").getAsString();
        return token;
    }

    public String revokeToken(){
        // TODO: Implementieren, wenn Serverfunktionalität steht
        return null;
    }

    public String logout(){
        //TODO: Implementieren, wenn Serverfunktionalität steht
        return null;
    }

    /**
     * Ruft alle Parties vom Server ab.
     *
     * @return Einen Array, welcher die Parties enthält.
     */
    public Party[] getParties() {
        Party[] parties = new Gson().fromJson(bc.runHttpGet(200, PARTY_URL, null), Party[].class);
        return parties;
    }

    /**
     * Ruft eine Party vom Server ab.
     *
     * @param id ID der Party.
     * @return Die Party.
     */
    public Party getParty(String id) {
        String json = bc.runHttpGet(200, PARTY_URL, "id=" + id);
        if (json.trim().startsWith("[")) {
            Party[] p = new Gson().fromJson(json, Party[].class);
            return p[0];
        } else {
            Party p = new Gson().fromJson(json, Party.class);
            return p;
        }
    }

    /**
     * Löscht eine Party.
     *
     * @param party Das Party-Objekt, welches gelöscht werden soll.
     * @return Den HTTP ResponseCode.
     */
    public int deleteParty(Party party) {
        int response = bc.runHttpDelete(PARTY_URL, "id=" + party.getPartId());
        return response;
    }

    /**
     * Lädt eine neue Party auf den Server.
     *
     * @param party Die Party, welche in die Datenbank geschrieben werden soll.
     * @return Die ID der erstellten Party.
     */
    public String createParty(Party party) {
        String id = bc.runHttpPost(new Gson().toJson(party), 201, PARTY_URL, CONNECTION_TYPE_JSON);
        return id;
    }

    /**
     * Ändert eine Party.
     *
     * @param party Das Party-Objekt, welches die Änderungen enthält.
     * @return Den HTTP ResponseCode.
     */
    public String updateParty(Party party) {
        String json = new Gson().toJson(party);
        int response = bc.runHttpPut(json, 200, PARTY_URL, "id=" + party.getPartId());
        return String.valueOf(response);
    }
}
