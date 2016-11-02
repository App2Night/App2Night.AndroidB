package com.julianriegraf.app2night.Models;

/**
 * Created by Julian Riegraf on 25.10.2016.
 */

public class User {

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String Username) {
        this.UserName = Username;
    }


    public String getHostId() {
        return HostId;
    }

    public void setHostId(String UserId) {
        this.HostId = UserId;
    }

    private String HostId;
    private String UserName;
}
