package com.project.POJO;

public class Rate {
	private Customer customer;
	private String rating;
	private String idRestaurant;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(String idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
}
