package com.example.utsmcs.Model;

public class Article {
    String judul;
    String imgLink;
    String subjudul;
    String newsTanggal;

    public Article(String judul, String imgLink, String subjudul, String newsTanggal) {
        this.judul = judul;
        this.imgLink = imgLink;
        this.subjudul = subjudul;
        this.newsTanggal = newsTanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getSubjudul() {
        return subjudul;
    }

    public void setSubjudul(String subjudul) {
        this.subjudul = subjudul;
    }

    public String getNewsTanggal() {
        return newsTanggal;
    }

    public void setNewsTanggal(String newsTanggal) {
        this.newsTanggal = newsTanggal;
    }
}
