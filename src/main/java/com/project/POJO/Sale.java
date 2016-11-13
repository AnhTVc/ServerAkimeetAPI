package com.project.POJO;



/**
 * Created by knight_cs on 11/08/2016.
 */
public class Sale {
    private String id_sale;
    private int sale_off; //Giảm giá theo % ví dụ 10 <=> 10%
    private String time_sale;
    private String from_date;
    private String to_date;

    public Sale(String id_sale, int sale_off, String time_sale, String from_date, String to_date) {
        this.id_sale = id_sale;
        this.sale_off = sale_off;
        this.time_sale = time_sale;
        this.from_date = from_date;
        this.to_date = to_date;
    }
}
