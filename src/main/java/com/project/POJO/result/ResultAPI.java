package com.project.POJO.result;

import com.project.POJO.Restaurant;

import java.util.ArrayList;

public class ResultAPI {
	private ArrayList<Restaurant> restaurants;
	public ResultAPI(ArrayList<Restaurant> restaurants){
		this.restaurants = restaurants;
	}

	public ArrayList<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(ArrayList<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
}
