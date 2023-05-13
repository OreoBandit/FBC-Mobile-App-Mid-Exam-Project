package com.example.utsmcs.Model;

public class Schedule {
    String matchname, opponentName, matchDate, imgLink;
    String matchID;
    String harga;



    public Schedule(String matchname, String opponentName, String matchDate, String imgLink, String matchID, String harga) {
        this.matchname = matchname;
        this.opponentName = opponentName;
        this.matchDate = matchDate;
        this.imgLink = imgLink;
        this.matchID = matchID;
        this.harga = harga;
    }

    public String getMatchname() {
        return matchname;
    }

    public void setMatchname(String matchname) {
        this.matchname = matchname;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
