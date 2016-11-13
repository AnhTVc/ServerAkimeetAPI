package com.project.POJO;

/**
 * Created by knight_cs on 11/08/2016.
 */
public class Menu {
    private String id_menu;
    private String name; //Tên món ăn
    private String nameRestaurant; //Lưu tên, địa chỉ nhà hàng, để hỗ trợ tìm kiếm nhanh.
    private String price; //Giá món ăn
    private String sale; // phần trăm giảm giá: 30%
    private String image; //Url ảnh

    public Menu(String id_menu, String name, String price, String sale, String image) {
        this.id_menu = id_menu;
        this.name = name;
        this.price = price;
        this.sale = sale;
        this.image = image;
    }

    public String getIdMenu() {
        return id_menu;
    }

    public String getName() {
        return name;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public String getPrice() {
        return price;
    }

    public String getSale() {
        return sale;
    }

    public String getImage() {
        return image;
    }
}
