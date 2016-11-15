package com.project.POJO.result;

import com.project.POJO.Restaurant;

import java.util.ArrayList;

/**
 * Created by knight_cs on 30/08/2016.
 */
public class SaleResult {

   /* private ArrayList<Campaign> campaigns;

    public SaleResult(ArrayList<Campaign> campaigns) {
        this.campaigns = campaigns;
    }*/

    private ArrayList<Restaurant> restaurants;
    public SaleResult(ArrayList<Restaurant> restaurants){
        this.restaurants = restaurants;
    }
}
