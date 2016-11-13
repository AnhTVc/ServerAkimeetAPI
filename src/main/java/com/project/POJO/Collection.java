package com.project.POJO;

/**
 * Created by VietAnh on 10/3/2016.
 * Collection của nhà hàng
 */
public class Collection {
    private String idCollection;
    private String idRestaurant;
    private String type;

    public void setIdCollection(String idCollection) {
        this.idCollection = idCollection;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdCollection() {
        return idCollection;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public String getType() {
        return type;
    }
}
