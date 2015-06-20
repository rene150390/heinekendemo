package com.demo.heineken.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.springframework.stereotype.Service;

import com.demo.heineken.auth.BeerAuth;
import com.demo.heineken.model.Beer;
import com.demo.heineken.model.ShoppingCartModel;

@Service
public class ShoppingCart {
public void buildCart(HttpServletRequest r, String username){
		
		@SuppressWarnings("deprecation")
		String location = r.getRealPath("/");
		System.out.println("Direccion: "+ location);
		try {
			
			String content = "";
			
			File files = new File(location+"/xml/shoppingcart/");
			if (!files.exists()) {
				if (files.mkdirs()) {
					System.out.println("Multiple directories are created!");
				} else {
					System.out.println("Failed to create multiple directories!");
				}
			}
			
			File file = new File(location+"/xml/shoppingcart/"+username+".xml");
			if (!file.exists()) {
				file.createNewFile();
			
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content);
				bw.close();
	 
			
				Element root = new Element("shoppingcart");
				Element beers = new Element("beers");
				Element totalPrice = new Element("totalprice");
				Element totalQuantity = new Element("totalquantity");
				
				root.addContent(beers);
				root.addContent(totalPrice);
				root.addContent(totalQuantity);
			
				Document doc = new Document(root);
				
				try {
					FileOutputStream out = new FileOutputStream(location+"/xml/shoppingcart/"+username+".xml");
				    XMLOutputter serializer = new XMLOutputter();	
				    serializer.output(doc, out);
				    out.flush();
				    out.close();
				}
				catch (IOException e) {
					System.err.println(e);
				}
			}
		  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addToCart(HttpServletRequest r, String username, BeerAuth beer){
		
		
		@SuppressWarnings("deprecation")
		String location = r.getRealPath("/");
		String xmlFilePath = location+"/xml/shoppingcart/"+username+".xml";
		SAXBuilder saxBuilder = new SAXBuilder();
		File xmlFile = new File(xmlFilePath);
		List<?> beersList;
		
		String name = beer.getBeer_name();
		String price = beer.getBeer_price();
		int quantity = Integer.parseInt(beer.getQuantity());
		String imgurl = beer.getUrlimg();
		int id_beer = beer.getId_beer();
		
		try {

			Document document = (Document) saxBuilder.build(xmlFile);
			
			Element rootElement = document.getRootElement();
			Element beers = rootElement.getChild("beers");
			Element totalQuantity = rootElement.getChild("totalquantity");
			beersList = beers.getChildren("beer");
			
			int size = beersList.size();
			int quantityAcum = 0;
			
			if( size == 0){
				
				Element beer_name = new Element("beer_name");
				Element beer_price = new Element("beer_price");
				Element beer_quantity = new Element("beer_quantity");
				Element img = new Element("img");
				Element id_b = new Element("id_beer");
				Element sinlgeBeer = new Element("beer");
				
				beer_name.setText(name);
				beer_price.setText(price);
				beer_quantity.setText(""+quantity+"");
				img.setText(imgurl);
				id_b.setText(id_beer+"");
				totalQuantity.setText(""+quantity+"");
				sinlgeBeer.addContent(id_b);
				sinlgeBeer.addContent(beer_name);
				sinlgeBeer.addContent(beer_price);
				sinlgeBeer.addContent(beer_quantity);
				sinlgeBeer.addContent(img);
				
				beers.addContent(sinlgeBeer);
			
			}else{
					Element nodo = (Element) beersList.get(0);
					
					if(size == 1 )
						quantityAcum = Integer.parseInt(nodo.getChild("beer_quantity").getText());
					boolean flag = true;
					
					for(int i = 0; i < size ; i++){
						Element producto = (Element) beersList.get(i);
						if(i > 0)
							quantityAcum += Integer.parseInt(producto.getChild("beer_quantity").getText());
						
						if(name.equals(producto.getChild("beer_name").getText())){
							int cantidad = Integer.parseInt(producto.getChild("beer_quantity").getText()) + quantity;
							
							producto.getChild("beer_quantity").setText(""+cantidad+"");
							totalQuantity.setText(""+quantityAcum+"");
							flag = false;
							break;
						}
					}
					if(flag == true){
						Element beer_name = new Element("beer_name");
						Element beer_price = new Element("beer_price");
						Element beer_quantity = new Element("beer_quantity");
						Element img = new Element("img");
						Element id_b = new Element("id_beer");
						Element sinlgeBeer1 = new Element("beer");
					
						beer_name.setText(name);
						beer_price.setText(price);
						beer_quantity.setText(""+quantity+"");
						img.setText(imgurl);
						id_b.setText(id_beer+"");
						
						quantityAcum += quantity;
						totalQuantity.setText(""+quantityAcum+"");
						sinlgeBeer1.addContent(id_b);
						sinlgeBeer1.addContent(beer_name);
						sinlgeBeer1.addContent(beer_price);
						sinlgeBeer1.addContent(beer_quantity);
						sinlgeBeer1.addContent(img);
						beers.addContent(sinlgeBeer1);
					}
				
			}
			
			try {
			      FileOutputStream out = new FileOutputStream(xmlFilePath);
			      XMLOutputter serializer = new XMLOutputter();
			      	
			      serializer.output(document, out);
			      out.flush();
			      out.close();
			    }catch (IOException e) {
			      System.err.println(e);
			    }
			document = (Document) saxBuilder.build(xmlFile);
			rootElement = document.getRootElement();
			beers = rootElement.getChild("beers");
			totalQuantity = rootElement.getChild("totalquantity");
			Element totalPrice = rootElement.getChild("totalprice");
			beersList = beers.getChildren("beer");
			size = beersList.size();
			  
		  	int suma = 0, factor = 1;
		  	float total = 0;
			for (int i = 0; i < size; i++){
				int id = i+1;
				Element singleBeer = (Element) beersList.get(i);
				singleBeer.setAttribute("id", ""+id+"");
				int cantidadNodo = Integer.parseInt(singleBeer.getChild("beer_quantity").getText());
				factor = cantidadNodo > 1 ? cantidadNodo : 1; 
				suma += cantidadNodo ;
				total += Float.parseFloat(singleBeer.getChild("beer_price").getText())* factor;
			}
			
			totalQuantity.setText(""+suma);
			totalPrice.setText(""+total);
			try {
			      FileOutputStream out = new FileOutputStream(xmlFilePath);
			      XMLOutputter serializer = new XMLOutputter();
			      
			      serializer.output(document, out);
			      out.flush();
			      out.close();
			}
			catch (IOException e) {
				System.err.println(e);
			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		
		
	}
	public ShoppingCartModel getCartObject(HttpServletRequest r, String username){
		@SuppressWarnings("deprecation")
		String location = r.getRealPath("/");
		String xmlFilePath = location+"/xml/shoppingcart/"+username+".xml";
		SAXBuilder saxBuilder = new SAXBuilder();
		File xmlFile = new File(xmlFilePath);
		ShoppingCartModel carritoCompras = new ShoppingCartModel();
		List<Beer> abas;
		try {

			Document document = (Document) saxBuilder.build(xmlFile);

			Element rootElement = document.getRootElement();
			Element beers = rootElement.getChild("beers");
			Element totalPrice = rootElement.getChild("totalprice");
			Element totalQuantity = rootElement.getChild("totalquantity");
			

			List<?> listElement = beers.getChildren("beer");
			abas = new ArrayList<Beer>();
			for (int i = 0; i < listElement.size(); i++) {
				
				
				Element node = (Element) listElement.get(i);
				Beer aba = new Beer(node);
				abas.add(aba);
			}
			carritoCompras.setBeers(abas);
			carritoCompras.setTotalQuantity(totalQuantity.getText().equals("") ? 0 : Integer.parseInt(totalQuantity.getText()));
			carritoCompras.setTotalPrice(totalPrice.getText().equals("") ? 0 : Float.parseFloat(totalPrice.getText()));
			
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		return carritoCompras;
	}/*
	public void setLocation(HttpServletRequest r, String username, String idlocation){
		@SuppressWarnings("deprecation")
		String location = r.getRealPath("/");
		String xmlFilePath = location+"/xml/shoppingcart/"+username+".xml";
		SAXBuilder saxBuilder = new SAXBuilder();
		File xmlFile = new File(xmlFilePath);
		try {

			Document document = (Document) saxBuilder.build(xmlFile);

			Element rootElement = document.getRootElement();
			Element productos = rootElement.getChild("productos");
			

			
			rootElement = document.getRootElement();
			productos = rootElement.getChild("productos");
			Element cantidadTotal = rootElement.getChild("cantidadtotal");
			Element precioTotal = rootElement.getChild("preciototal");
			Element idlocation1 = rootElement.getChild("idlocation");
			List<?> productoLista = productos.getChildren("producto");
			int size = productoLista.size();
			  
		  	int suma = 0, factor = 1;
		  	float total = 0;
			for (int i = 0; i < size; i++){
				int j = i+1;
				Element producto = (Element) productoLista.get(i);
				producto.setAttribute("id", ""+j+"");
				int cantidadNodo = Integer.parseInt(producto.getChild("cantidad").getText());
				factor = cantidadNodo > 1 ? cantidadNodo : 1; 
				suma += cantidadNodo ;
				total += Float.parseFloat(producto.getChild("precio").getText())* factor;
			}
			cantidadTotal.setText(""+suma);
			precioTotal.setText(""+total);
			idlocation1.setText(""+idlocation);
			 try {
			      FileOutputStream out = new FileOutputStream(xmlFilePath);
			      XMLOutputter serializer = new XMLOutputter();
			      
			      serializer.output(document, out);
			      out.flush();
			      out.close();
			    }
			    catch (IOException e) {
			      System.err.println(e);
			    }

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}*/
	/*public void deleteElement(HttpServletRequest r, String username, int id){
		@SuppressWarnings("deprecation")
		String location = r.getRealPath("/");
		String xmlFilePath = location+"/xml/shoppingcart/"+username+".xml";
		SAXBuilder saxBuilder = new SAXBuilder();
		File xmlFile = new File(xmlFilePath);
		try {

			Document document = (Document) saxBuilder.build(xmlFile);

			Element rootElement = document.getRootElement();
			Element productos = rootElement.getChild("productos");
			

			List<?> listElement = productos.getChildren("producto");

			for (int i = 0; i < listElement.size(); i++) {

				Element node = (Element) listElement.get(i);
				
				if(Integer.parseInt(node.getChild("idabarrote").getText()) == id){
					productos.removeContent(node);
					
				}
				
			

			}
			
			rootElement = document.getRootElement();
			productos = rootElement.getChild("productos");
			Element cantidadTotal = rootElement.getChild("cantidadtotal");
			Element precioTotal = rootElement.getChild("preciototal");
			List<?> productoLista = productos.getChildren("producto");
			int size = productoLista.size();
			  
		  	int suma = 0, factor = 1;
		  	float total = 0;
			for (int i = 0; i < size; i++){
				int j = i+1;
				Element producto = (Element) productoLista.get(i);
				producto.setAttribute("id", ""+j+"");
				int cantidadNodo = Integer.parseInt(producto.getChild("cantidad").getText());
				factor = cantidadNodo > 1 ? cantidadNodo : 1; 
				suma += cantidadNodo ;
				total += Float.parseFloat(producto.getChild("precio").getText())* factor;
			}
			cantidadTotal.setText(""+suma);
			precioTotal.setText(""+total);
			 try {
			      FileOutputStream out = new FileOutputStream(xmlFilePath);
			      XMLOutputter serializer = new XMLOutputter();
			      
			      serializer.output(document, out);
			      out.flush();
			      out.close();
			    }
			    catch (IOException e) {
			      System.err.println(e);
			    }

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}
	public void overwriteCantidad(HttpServletRequest r, String username, int id, int cantidad){
		@SuppressWarnings("deprecation")
		String location = r.getRealPath("/");
		String xmlFilePath = location+"/xml/shoppingcart/"+username+".xml";
		SAXBuilder saxBuilder = new SAXBuilder();
		File xmlFile = new File(xmlFilePath);
		try {

			Document document = (Document) saxBuilder.build(xmlFile);

			Element rootElement = document.getRootElement();
			Element productos = rootElement.getChild("productos");
			

			List<?> listElement = productos.getChildren("producto");

			for (int i = 0; i < listElement.size(); i++) {

				Element node = (Element) listElement.get(i);
				
				if(Integer.parseInt(node.getChild("idabarrote").getText()) == id){
					node.getChild("cantidad").setText(""+cantidad);
					
				}
				
			

			}
			
			rootElement = document.getRootElement();
			productos = rootElement.getChild("productos");
			Element cantidadTotal = rootElement.getChild("cantidadtotal");
			Element precioTotal = rootElement.getChild("preciototal");
			List<?> productoLista = productos.getChildren("producto");
			int size = productoLista.size();
			  
		  	int suma = 0, factor = 1;
		  	float total = 0;
			for (int i = 0; i < size; i++){
				int j = i+1;
				Element producto = (Element) productoLista.get(i);
				producto.setAttribute("id", ""+j+"");
				int cantidadNodo = Integer.parseInt(producto.getChild("cantidad").getText());
				factor = cantidadNodo > 1 ? cantidadNodo : 1; 
				suma += cantidadNodo ;
				total += Float.parseFloat(producto.getChild("precio").getText())* factor;
			}
			cantidadTotal.setText(""+suma);
			precioTotal.setText(""+total);
			 try {
			      FileOutputStream out = new FileOutputStream(xmlFilePath);
			      XMLOutputter serializer = new XMLOutputter();
			      
			      serializer.output(document, out);
			      out.flush();
			      out.close();
			    }
			    catch (IOException e) {
			      System.err.println(e);
			    }

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}
	
	public void deleteProducts(HttpServletRequest r, String username){
		@SuppressWarnings("deprecation")
		String location = r.getRealPath("/");
		String xmlFilePath = location+"/xml/shoppingcart/"+username+".xml";
		SAXBuilder saxBuilder = new SAXBuilder();
		File xmlFile = new File(xmlFilePath);
		try {

			Document document = (Document) saxBuilder.build(xmlFile);

			Element rootElement = document.getRootElement();
			Element productos = rootElement.getChild("productos");
			
			productos.removeContent();
			
			rootElement = document.getRootElement();
			productos = rootElement.getChild("productos");
			Element cantidadTotal = rootElement.getChild("cantidadtotal");
			Element precioTotal = rootElement.getChild("preciototal");
			List<?> productoLista = productos.getChildren("producto");
			int size = productoLista.size();
			  
		  	int suma = 0, factor = 1;
		  	float total = 0;
			for (int i = 0; i < size; i++){
				int j = i+1;
				Element producto = (Element) productoLista.get(i);
				producto.setAttribute("id", ""+j+"");
				int cantidadNodo = Integer.parseInt(producto.getChild("cantidad").getText());
				factor = cantidadNodo > 1 ? cantidadNodo : 1; 
				suma += cantidadNodo ;
				total += Float.parseFloat(producto.getChild("precio").getText())* factor;
			}
			cantidadTotal.setText(""+suma);
			precioTotal.setText(""+total);
			 try {
			      FileOutputStream out = new FileOutputStream(xmlFilePath);
			      XMLOutputter serializer = new XMLOutputter();
			      
			      serializer.output(document, out);
			      out.flush();
			      out.close();
			    }
			    catch (IOException e) {
			      System.err.println(e);
			    }

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}*/
	
}
