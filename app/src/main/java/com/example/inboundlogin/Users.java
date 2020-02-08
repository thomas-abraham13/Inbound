package com.example.inboundlogin;

public class Users {

    String emailid;
    String pass;
    String fullname;
    String id;


    public Users(){

    }

    public Users(String emailid, String pass, String fullname, String id) {
        this.emailid = emailid;
        this.pass = pass;
        this.fullname = fullname;
        this.id = id;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getPass() {
        return pass;
    }

    public String getFullname() { return fullname; }

    public String getId() {
        return id;
    }
}
