package com.julianriegraf.app2night;

/**
 * Created by robin on 23.10.2016.
 */

public class PartyDataProvider {

    private int party_banner_resource;
    private String Veranstaltungsname;
    private String Veranstaltungszeitpunkt;
    private String Veranstaltungsort;
    private String Veranstalter;
    private String Veranstaltungseintritt;

    public PartyDataProvider(int party_banner_resource, String Veranstaltungsname, String Veranstaltungszeitpunkt, String Veranstaltungsort, String Veranstalter, String Veranstaltungseintritt)
    {
        this.setParty_banner_resource(party_banner_resource);
        this.setVeranstaltungsname(Veranstaltungsname);
        this.setVeranstaltungszeitpunkt(Veranstaltungszeitpunkt);
        this.setVeranstaltungsort(Veranstaltungsort);
        this.setVeranstalter(Veranstalter);
        this.setVeranstaltungseintritt(Veranstaltungseintritt);
    }

    public int getParty_banner_resource() {
        return party_banner_resource;
    }

    public void setParty_banner_resource(int party_banner_resource) {
        this.party_banner_resource = party_banner_resource;
    }

    public String getVeranstaltungsname() {
        return Veranstaltungsname;
    }

    public void setVeranstaltungsname(String veranstaltungsname) {
        Veranstaltungsname = veranstaltungsname;
    }

    public String getVeranstaltungszeitpunkt() {
        return Veranstaltungszeitpunkt;
    }

    public void setVeranstaltungszeitpunkt(String veranstaltungszeitpunkt) {
        Veranstaltungszeitpunkt = veranstaltungszeitpunkt;
    }

    public String getVeranstaltungsort() {
        return Veranstaltungsort;
    }

    public void setVeranstaltungsort(String veranstaltungsort) {
        Veranstaltungsort = veranstaltungsort;
    }

    public String getVeranstalter() {
        return Veranstalter;
    }

    public void setVeranstalter(String veranstalter) {
        Veranstalter = veranstalter;
    }

    public String getVeranstaltungseintritt() {
        return Veranstaltungseintritt;
    }

    public void setVeranstaltungseintritt(String veranstaltungseintritt) {
        Veranstaltungseintritt = veranstaltungseintritt;
    }
}
