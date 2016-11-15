package com.project.POJO.result;

/**
 * Chứa các nhà hàng nằm trong lĩnh vực Đồ uống
 * Created by VietAnh on 11/14/2016.
 */
public class Drink {
    private ResultAPI restaurantCafeEvent;
    private ResultAPI restaurantGiaiKhat;
    private ResultAPI restaurantMoc;
    private ResultAPI restaurantBongDa;
    private ResultAPI restaurantSach;
    private ResultAPI restaurantThuCung;
    private ResultAPI restaurantPhim;

    public Drink(ResultAPI restaurantCafeEvent,
                 ResultAPI restaurantGiaiKhat,
                 ResultAPI restaurantMoc,
                 ResultAPI restaurantBongDa,
                 ResultAPI restaurantSach,
                 ResultAPI restaurantThuCung,
                 ResultAPI restaurantPhim){
        this.restaurantBongDa = restaurantBongDa;
        this.restaurantCafeEvent = restaurantCafeEvent;
        this.restaurantGiaiKhat = restaurantGiaiKhat;
        this.restaurantMoc = restaurantMoc;
        this.restaurantPhim = restaurantPhim;
        this.restaurantSach = restaurantSach;
        this.restaurantThuCung = restaurantThuCung;
    }

    public void setRestaurantCafeEvent(ResultAPI restaurantCafeEvent) {
        this.restaurantCafeEvent = restaurantCafeEvent;
    }

    public void setRestaurantGiaiKhat(ResultAPI restaurantGiaiKhat) {
        this.restaurantGiaiKhat = restaurantGiaiKhat;
    }

    public void setRestaurantMoc(ResultAPI restaurantMoc) {
        this.restaurantMoc = restaurantMoc;
    }

    public void setRestaurantBongDa(ResultAPI restaurantBongDa) {
        this.restaurantBongDa = restaurantBongDa;
    }

    public void setRestaurantSach(ResultAPI restaurantSach) {
        this.restaurantSach = restaurantSach;
    }

    public void setRestaurantThuCung(ResultAPI restaurantThuCung) {
        this.restaurantThuCung = restaurantThuCung;
    }

    public void setRestaurantPhim(ResultAPI restaurantPhim) {
        this.restaurantPhim = restaurantPhim;
    }

    public ResultAPI getRestaurantCafeEvent() {
        return restaurantCafeEvent;
    }

    public ResultAPI getRestaurantGiaiKhat() {
        return restaurantGiaiKhat;
    }

    public ResultAPI getRestaurantMoc() {
        return restaurantMoc;
    }

    public ResultAPI getRestaurantBongDa() {
        return restaurantBongDa;
    }

    public ResultAPI getRestaurantSach() {
        return restaurantSach;
    }

    public ResultAPI getRestaurantThuCung() {
        return restaurantThuCung;
    }

    public ResultAPI getRestaurantPhim() {
        return restaurantPhim;
    }
}
