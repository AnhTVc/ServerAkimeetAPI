package com.project.POJO;

import java.util.ArrayList;

/**
 * Created by knight_cs on 29/08/2016.
 */
public class GroupMenu {
    private String name;
    private ArrayList<Menu> menu;

    public GroupMenu(String name, ArrayList<Menu> menu) {
        this.name = name;
        this.menu = menu;
    }
}
