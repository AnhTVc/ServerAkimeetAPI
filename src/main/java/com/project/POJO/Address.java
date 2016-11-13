package com.project.POJO;

/**
 * Created by knight_cs on 11/08/2016.
 */
public class Address {
    private String idAddress;
    private String detail;
    private String city;
    private String district;

    private String idCity;
    private String idDistrict;

    public String getIdAddress() {
        return idAddress;
    }
    public void setIdAddress(String idAdress) {
        this.idAddress = idAdress;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }

    public String getIdCity() {
        return idCity;
    }

    public String getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(String idDistrict) {
        this.idDistrict = idDistrict;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

}