package com.example.inboundlogin;

public class Teams {
    String teamid;
    String teamname;
    String coachname;
    String nplayers;

    public Teams(){

    }

    public Teams(String teamid, String teamname, String coachname, String nplayers) {
        this.teamid = teamid;
        this.teamname = teamname;
        this.coachname = coachname;
        this.nplayers = nplayers;
    }

    public String getTeamid() {
        return teamid;
    }

    public String getTeamname() {
        return teamname;
    }

    public String getCoachname() {
        return coachname;
    }

    public String getNplayers() {
        return nplayers;
    }
}




