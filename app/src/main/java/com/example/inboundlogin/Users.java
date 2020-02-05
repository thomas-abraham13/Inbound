package com.example.inboundlogin;

public class Users {

    String emailid;
    String pass;
    String id;


    public Users(){

    }

    public Users(String emailid, String pass, String id) {
        this.emailid = emailid;
        this.pass = pass;
        this.id = id;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getPass() {
        return pass;
    }

    public String getId() {
        return id;
    }
}
