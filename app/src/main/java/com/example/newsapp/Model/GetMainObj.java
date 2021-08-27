package com.example.newsapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetMainObj {
    @SerializedName("status")
    private String status;
    @SerializedName("totalresult")
    private String totalresult;
    @SerializedName("articles")
    private ArrayList <GetModel> articles;
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

    public ArrayList<GetModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<GetModel> articles) {
        this.articles = articles;
    }
}
