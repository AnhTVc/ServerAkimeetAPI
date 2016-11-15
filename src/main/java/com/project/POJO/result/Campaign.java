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

    public Campaign(Restaurant restaurant) {
        this.restaurant = restaurant;
    }



    public Campaign( Restaurant restaurant, ArrayList<GroupMenu> group_menus) {
        this.restaurant = restaurant;
    }
}
