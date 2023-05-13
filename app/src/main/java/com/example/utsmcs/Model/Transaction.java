package com.example.utsmcs.Model;

public class Transaction {
    String matchName, matchDate, username, ImgUrl;

    public Transaction(String matchName, String matchDate, String username, String imgUrl) {
        this.matchName = matchName;
        this.matchDate = matchDate;
        this.username = username;
        ImgUrl = imgUrl;
    }

    public Transaction(){

    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }
}
