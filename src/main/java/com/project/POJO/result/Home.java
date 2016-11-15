package com.project.POJO.result;

/**
 * Created by knight_cs on 11/08/2016.
 */
public class Home {
    private SaleResult care_sale;
    private SaleResult last_sale;
    private SaleResult special_sale;
    private SaleResult sale_addtion;
    private SaleResult sale_business;

    public Home( SaleResult special_sale, SaleResult last_sale, SaleResult care_sale, SaleResult sale_business) {
        this.care_sale = care_sale;
        this.last_sale = last_sale;
        this.special_sale = special_sale;
        this.sale_business = sale_business;
    }
    public Home(SaleResult sale_addtion) {
        this.sale_addtion = sale_addtion;
    }
}
