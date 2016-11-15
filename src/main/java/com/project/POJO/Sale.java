package com.project.POJO;



/**
 * Created by knight_cs on 11/08/2016.
 */
public class Sale {
    private String id_sale;
    private int sale_off; //Giảm giá theo % ví dụ 10 <=> 10%
    private String time;
    private String from_date;
    private String to_date;
    private int business;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setId_sale(String id_sale) {
        this.id_sale = id_sale;
    }

    public void setSale_off(int sale_off) {
        this.sale_off = sale_off;
    }


    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public void setBusiness(int business) {
        this.business = business;
    }

    public String getId_sale() {
        return id_sale;
    }

    public int getSale_off() {
        return sale_off;
    }


    public String getFrom_date() {
        return from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public int getBusiness() {
        return business;
    }

    public Sale(){

    }

    public Sale(String id_sale, int sale_off, String time_sale, String from_date, String to_date) {
        this.id_sale = id_sale;
        this.sale_off = sale_off;
        this.time = time_sale;
        this.from_date = from_date;
        this.to_date = to_date;
    }
}
