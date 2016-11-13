package com.project.POJO.result;

/**
 * Created by VietAnh on 9/8/2016.
 */
public class AutoComplete {
    public void setIdAutoComplete(String idAutoComplete) {
        this.idAutoComplete = idAutoComplete;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public void setAvatarRestaurant(String avatarRestaurant) {
        this.avatarRestaurant = avatarRestaurant;
    }

    public void setAddressRestaurant(String addressRestaurant) {
        this.addressRestaurant = addressRestaurant;
    }

    public String getIdAutoComplete() {
        return idAutoComplete;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public String getAvatarRestaurant() {
        return avatarRestaurant;
    }

    public String getAddressRestaurant() {
        return addressRestaurant;
    }

    private String idAutoComplete;
    private String idRestaurant;
    private String nameRestaurant;
    private String avatarRestaurant;
    private String addressRestaurant;
}
