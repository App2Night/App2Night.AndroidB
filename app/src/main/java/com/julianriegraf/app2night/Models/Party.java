package com.julianriegraf.app2night.Models;

/**
 * Created by Julian Riegraf on 25.10.2016.
 */

public class Party {

    public String getPartId() {
        return PartId;
    }

    public void setPartId(String partId) {
        PartId = partId;
    }

    public String getPartyName() {
        return PartyName;
    }

    public void setPartyName(String partyName) {
        PartyName = partyName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getPartyDate() {
        return PartyDate;
    }

    public void setPartyDate(String partyDate) {
        PartyDate = partyDate;
    }

    public PartyLocation getLocation() {
        return Location;
    }

    public void setLocation(PartyLocation location) {
        Location = location;
    }

    public int getMusicGenre() {
        return MusicGenre;
    }

    public void setMusicGenre(int musicGenre) {
        MusicGenre = musicGenre;
    }

    public int getPartyType() {
        return PartyType;
    }

    public void setPartyType(int partyType) {
        PartyType = partyType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public User getHost() {
        return Host;
    }

    public void setHost(User host) {
        Host = host;
    }

    private String PartId;
    private String PartyName;
    private int Price;
    private String PartyDate;
    private PartyLocation Location;
    private int MusicGenre;
    private int PartyType;
    private String Description;
    private User Host;

    public Party() {

    }

}
