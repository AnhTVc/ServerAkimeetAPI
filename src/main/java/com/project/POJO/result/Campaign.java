package com.project.POJO.result;

import com.project.POJO.Sale;
import com.project.POJO.GroupMenu;
import com.project.POJO.Restaurant;

import java.util.ArrayList;

/**
 * Created by knight_cs on 16/08/2016.
 */
public class Campaign {

    private Restaurant restaurant;
    private Sale sale;
    private ArrayList<GroupMenu> group_menus;

    public Campaign(Restaurant restaurant, Sale sale) {
        this.sale = sale;
        this.restaurant = restaurant;
    }



    public Campaign( Restaurant restaurant,Sale sale, ArrayList<GroupMenu> group_menus) {
        this.sale = sale;
        this.restaurant = restaurant;
        this.group_menus = group_menus;
    }
}
