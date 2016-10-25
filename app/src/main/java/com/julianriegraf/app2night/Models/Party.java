package com.julianriegraf.app2night.Models;

/**
 * Created by Julian Riegraf on 25.10.2016.
 */

public class Party {

    // FIELDS
    private String partId;
    private String name;
    private String hostId;



    // GETTER AND SETTER
    public String getName() {
        return name;
    }

    public String getPartId() {
        return partId;
    }

    public String getHostId() {
        return hostId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }




    // CONSTRUCTOR
    public Party(String id){
        this.partId = id;
    }

}
