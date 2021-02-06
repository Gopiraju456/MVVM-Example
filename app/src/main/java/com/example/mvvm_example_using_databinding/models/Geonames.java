package com.example.mvvm_example_using_databinding.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Geonames {

    @SerializedName("geonames")
    @Expose
    private List<Geoname> geonames = null;

    public List<Geoname> getGeonames() {
        return geonames;
    }

    public void setGeonames(List<Geoname> geonames) {
        this.geonames = geonames;
    }
}


