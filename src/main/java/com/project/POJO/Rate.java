package com.project.POJO;

public class Rate {
	private int price;
	private int quality;
	private int service;
	private int space;
	public Rate(){

	}
	public Rate(int price,
			int quality,
			int service,
			int space){
		this.price = price;
		this.quality = quality;
		this.service = service;
		this.space = space;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getService() {
		return service;
	}
	public void setService(int service) {
		this.service = service;
	}
	public int getSpace() {
		return space;
	}
	public void setSpace(int space) {
		this.space = space;
	}
}
