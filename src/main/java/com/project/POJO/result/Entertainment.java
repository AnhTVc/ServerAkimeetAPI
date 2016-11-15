package com.project.POJO.result;

/**
 * Chuc các nhà hàng nằm trong lĩnh vực giải trí
 * Created by VietAnh on 11/14/2016.
 */
public class Entertainment {
    private ResultAPI restaurantKaraoke;
    private ResultAPI restaurantHatChoNhauNghe;
    private ResultAPI restaurantRapChieuPhim;
    private ResultAPI restaurantKhuVuiChoi;

    public Entertainment(ResultAPI restaurantKaraoke,
                         ResultAPI restaurantHatChoNhauNghe,
                         ResultAPI restaurantRapChieuPhim,
                         ResultAPI restaurantKhuVuiChoi){
        this.restaurantHatChoNhauNghe = restaurantHatChoNhauNghe;
        this.restaurantKaraoke = restaurantKaraoke;
        this.restaurantKhuVuiChoi = restaurantKhuVuiChoi;
        this.restaurantRapChieuPhim = restaurantRapChieuPhim;
    }

    public void setRestaurantKaraoke(ResultAPI restaurantKaraoke) {
        this.restaurantKaraoke = restaurantKaraoke;
    }

    public void setRestaurantHatChoNhauNghe(ResultAPI restaurantHatChoNhauNghe) {
        this.restaurantHatChoNhauNghe = restaurantHatChoNhauNghe;
    }

    public void setRestaurantRapChieuPhim(ResultAPI restaurantRapChieuPhim) {
        this.restaurantRapChieuPhim = restaurantRapChieuPhim;
    }

    public void setRestaurantKhuVuiChoi(ResultAPI restaurantKhuVuiChoi) {
        this.restaurantKhuVuiChoi = restaurantKhuVuiChoi;
    }

    public ResultAPI getRestaurantKaraoke() {
        return restaurantKaraoke;
    }

    public ResultAPI getRestaurantHatChoNhauNghe() {
        return restaurantHatChoNhauNghe;
    }

    public ResultAPI getRestaurantRapChieuPhim() {
        return restaurantRapChieuPhim;
    }

    public ResultAPI getRestaurantKhuVuiChoi() {
        return restaurantKhuVuiChoi;
    }
}
