package com.app.mvc.beans;import org.apache.http.NameValuePair;import org.apache.http.message.BasicNameValuePair;import java.util.ArrayList;import java.util.List;/** * Created by jimin on 15/12/11. */public class PostParameter {    private List<NameValuePair> nvps = new ArrayList();    public PostParameter() {    }    public List<NameValuePair> getNvps() {        return this.nvps;    }    public PostParameter put(String key, String value) {        this.nvps.add(new BasicNameValuePair(key, value));        return this;    }}