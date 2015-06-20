package com.demo.heineken.model;

import java.util.List;

import org.jdom.Element;

public class ShoppingCartModel {
	
	private List<Beer> beers;
	private int totalQuantity;
	private float totalPrice;
	
	

	
	public ShoppingCartModel(){}
	
	
	
	public List<Beer> getBeers() {
		return beers;
	}
	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}



	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}



	public float getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
}
