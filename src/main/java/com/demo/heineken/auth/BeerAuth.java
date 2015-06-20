package com.demo.heineken.auth;

public class BeerAuth extends Auth{
	
	private int id_beer;
	private String beer_name;	
	private String beer_price;
	private String urlimg;	
	private String quantity;
	
	public BeerAuth(){}
	
	public int getId_beer() {
		return id_beer;
	}
	public void setId_beer(int id_beer) {
		this.id_beer = id_beer;
	}
	public String getBeer_name() {
		return beer_name;
	}
	public void setBeer_name(String beer_name) {
		this.beer_name = beer_name;
	}
	public String getBeer_price() {
		return beer_price;
	}
	public void setBeer_price(String beer_price) {
		this.beer_price = beer_price;
	}
	public String getUrlimg() {
		return urlimg;
	}
	public void setUrlimg(String urlimg) {
		this.urlimg = urlimg;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
