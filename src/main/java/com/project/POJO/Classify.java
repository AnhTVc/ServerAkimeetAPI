package com.project.POJO;

/**
 * Created by knight_cs on 11/08/2016.
 */

import java.util.ArrayList;

/**
 * Class classify chia thành nhóm ẩm thực: như món ăn Á, món ăn âu, món ăn nhanh...
 * @author VietAnh
 *
 */
public class Classify {
    private String idClassify;
    private String name;
    private ArrayList<Menu> menus;
    public String getIdClassify() {
        return idClassify;
    }
    public void setIdClassify(String idClassify) {
        this.idClassify = idClassify;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Menu> getMenus() {
        return menus;
    }
    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

}
