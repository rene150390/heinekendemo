package com.demo.heineken.model;
import org.jdom.Element;

public class Beer implements java.io.Serializable{
	
	
	private static final long serialVersionUID = 8273113041817597723L;
	
	
	private int id_beer;
	private String beer_name;	
	private String beer_price;
	private String urlimg;	
	private int quantity;
	
	public Beer(){}
	
	public Beer(Element nodo){
		setId_beer(Integer.parseInt(nodo.getChild("id_beer").getText()));
		setBeer_name(nodo.getChild("beer_name").getText());
		setBeer_price(nodo.getChild("beer_price").getText());
		setQuantity(Integer.parseInt(nodo.getChild("beer_quantity").getText()));
		setUrlimg(nodo.getChild("img").getText());
	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
