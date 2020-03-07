package com.example.inboundlogin;

public class ScoreDB {
    String scoreid;
    String score1;
    String score2;
    String minutes;
    String seconds;

    public ScoreDB()
    {

    }

    public ScoreDB(String scoreid, String score1, String score2, String minutes, String seconds) {
        this.scoreid = scoreid;
        this.score1 = score1;
        this.score2 = score2;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String getScoreid() {
        return scoreid;
    }

    public String getScore1() {
        return score1;
    }

    public String getScore2() {
        return score2;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getSeconds() {
        return seconds;
    }
}

