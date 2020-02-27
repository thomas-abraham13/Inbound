package com.example.inboundlogin;

public class Players {
    String name;
    String number;
    String instagram;
    String playerid;

    public Players(){

    }

    public Players(String name, String number, String instagram, String playerid) {
        this.name = name;
        this.number = number;
        this.instagram = instagram;
        this.playerid = playerid;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getPlayerid() {
        return playerid;
    }
}


