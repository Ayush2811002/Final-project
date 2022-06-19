package com.example.finalproject;

import android.icu.text.CaseMap;

public class mode {
    String Info, Title, Purul;

    mode() {

    }

    public mode(String info, String title, String purul) {
        Info = info;
        Title = title;
        Purul = purul;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPurul() {
        return Purul;
    }

    public void setPurul(String purul) {
        Purul = purul;
    }
}