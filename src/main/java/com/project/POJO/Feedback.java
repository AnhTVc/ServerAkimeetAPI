package com.project.POJO;

import java.util.Date;

public class Feedback {
	private Customer customer;
	private Date timeCreate;
	private String title;
	private String content;
	private String idRestaurant;
	private String images;
	private Rate rate;
	public Rate getRate() {
		return rate;
	}
	public void setRate(Rate rate) {
		this.rate = rate;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(String idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getTimeCreate() {
		return timeCreate;
	}
	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
