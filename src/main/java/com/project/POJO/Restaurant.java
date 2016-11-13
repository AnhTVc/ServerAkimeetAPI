package com.project.POJO;

import java.util.ArrayList;

/**
 * Created by knight_cs on 11/08/2016.
 */
public class Restaurant {
    private String id_restaurant;
    private String address;
    private ArrayList<Collection> collections;

    String extend;

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getExtend() {
        return extend;
    }

    public void setCollections(ArrayList<Collection> collections) {
        this.collections = collections;
    }

    public ArrayList<Collection> getCollections() {

        return collections;
    }

    public  Restaurant(){
    }

    public void setPoistion(Address poistion) {
        this.poistion = poistion;
    }

    public Address getPoistion() {

        return poistion;
    }

    private Address poistion;

    public String getPhone_number() {
        return phone_number;
    }

    public String getName_restaurant() {
        return name_restaurant;
    }

    private String name_restaurant;

    public void setId_restaurant(String id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName_restaurant(String name_restaurant) {
        this.name_restaurant = name_restaurant;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setGroupMenus(ArrayList<GroupMenu> groupMenus) {
        this.groupMenus = groupMenus;
    }

    public void setSales(ArrayList<Sale> sales) {
        this.sales = sales;
    }

    private String phone_number;
    private String introduce;//Mô tả nhà hàng
    private String avatar; //Url ảnh đại diện
    private String images;
    private ArrayList<GroupMenu> groupMenus; //Danh sách các món ăn

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public String getId_restaurant() {
        return id_restaurant;
    }

    public String getAddress() {
        return address;
    }

    public String getNameRestaurant() {
        return name_restaurant;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getAvatar() {
        return avatar;
    }

    public ArrayList<GroupMenu> getGroupMenus() {
        return groupMenus;
    }

    private ArrayList<Sale> sales; //Một nhà hàng có nhiều chương trình giảm giá



    public  Restaurant(String id_restaurant, String name_restaurant, String avatar){
        this.id_restaurant = id_restaurant;
        this.name_restaurant = name_restaurant;
        this.avatar = avatar;
    }

    public  Restaurant(String id_restaurant,String name_restaurant, String address, String avatar){
        this.id_restaurant = id_restaurant;
        this.name_restaurant = name_restaurant;
        this.address = address;
        this.avatar = avatar;
    }

    public Restaurant(String id_restaurant,  String name_restaurant, String avatar,String phone_number, String introduce, String images) {
        this.id_restaurant = id_restaurant;
        this.name_restaurant = name_restaurant;
        this.phone_number = phone_number;
        this.introduce = introduce;
        this.avatar = avatar;
        this.images = images;
    }

    public String getImages() {
        return images;
    }

    public Restaurant(String id_restaurant,  String name_restaurant, String address, String avatar,String phone_number, String introduce, String images) {
        this.id_restaurant = id_restaurant;
        this.address = address;
        this.name_restaurant = name_restaurant;
        this.phone_number = phone_number;
        this.introduce = introduce;
        this.avatar = avatar;
        this.images = images;

    }
}