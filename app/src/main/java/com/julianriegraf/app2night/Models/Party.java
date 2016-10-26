package com.julianriegraf.app2night.Models;

/**
 * Created by Julian Riegraf on 25.10.2016.
 */

public class Party {

    // FIELDS
    private String partyName;
    private String hostId;
    private String partyDate;
    private User host;
    private int price;
    private int musicGenre;
    private PartyLocation location;
    private int partyType;
    private String description;


    // GETTER AND SETTER
    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(String partyDate) {
        this.partyDate = partyDate;
    }

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(int musicGenre) {
        this.musicGenre = musicGenre;
    }

    public PartyLocation getLocation() {
        return location;
    }

    public void setLocation(PartyLocation location) {
        this.location = location;
    }

    public int getPartyType() {
        return partyType;
    }

    public void setPartyType(int partyType) {
        this.partyType = partyType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String partId;


    public Party() {

    }

}
