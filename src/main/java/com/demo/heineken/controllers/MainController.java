package com.demo.heineken.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.heineken.auth.BeerAuth;
import com.demo.heineken.model.ShoppingCartModel;
import com.demo.heineken.utils.ShoppingCart;
import com.demo.heineken.wrapper.WebServiceResponse;


@Controller
@RequestMapping(value="/main")
public class MainController {
	
	@Autowired ShoppingCart shoppingCart;
	
	@RequestMapping(value="/buildshoppingcart", method=RequestMethod.POST)
	public @ResponseBody WebServiceResponse buildCart(HttpServletRequest r,  @RequestBody BeerAuth abarrote){
		
		this.shoppingCart.buildCart(r, "prueba");
		WebServiceResponse response = new WebServiceResponse();
		
		return response;
	}
	
	@RequestMapping(value="/addtocart", method=RequestMethod.POST)
	public @ResponseBody ShoppingCartModel addToCart(HttpServletRequest r,  @RequestBody BeerAuth beer){
		ShoppingCartModel cartModel = new ShoppingCartModel();
		
		this.shoppingCart.addToCart(r, "prueba", beer);
		System.out.println(""+this.shoppingCart.getCartObject(r, "prueba"));
		WebServiceResponse response = new WebServiceResponse();
		
		return this.shoppingCart.getCartObject(r, "prueba");
	}

}
