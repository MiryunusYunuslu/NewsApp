package com.example.newsapp.Model;

import com.example.newsapp.Model.getModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class getMainObj {
    @SerializedName("status")
    private String status;
    @SerializedName("totalresult")
    private String totalresult;
    @SerializedName("articles")
    private ArrayList <getModel> articles;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalresult() {
        return totalresult;
    }

    public void setTotalresult(String totalresult) {
        this.totalresult = totalresult;
    }

    public ArrayList<getModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<getModel> articles) {
        this.articles = articles;
    }
}
