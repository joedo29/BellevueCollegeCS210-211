package Assignment10;
/**
 * Name: Phuong Do (Joe)
 * Date: July 05 2017
 * Course: CS211
 * Assignment #10
 * Purpose: write the back end, or the data structures that work behind the scenes.
 * write a set of supporting classes for a simple shopping program.
 */ 
import java.util.ArrayList;import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

public class ShoppingCart extends ArrayList<NumSelected>{
	private double totalPrice;
	
	// Constructor that creates an empty list of orders.
	public ShoppingCart(){
		super();
	}

	// Returns the total cost of the shopping cart.
	public double getTotal() {
		double totalPrice = 0;
		for (int i = 0; i < size(); i ++){
			NumSelected currentItem = get(i);
			totalPrice += currentItem.getPrice();
		}
		return totalPrice;
	}
	
	// Sets whether or not this order gets a discount (true means there is a discount, false means no discount).
	public void setDiscount(boolean selected) {
		if(selected = true){
			totalPrice = totalPrice * 0.9;
		}
	}
	
	// Adds an order to the list, replacing any previous order for this sku(s) with the new order. 
	//Return true when added successfully.
	public boolean add(NumSelected yes) {
		boolean hasFound = false;
		for( int i = 0; i < size(); i ++){
			NumSelected currentItem = get(i);
			if(currentItem.getSku().equals(yes.getSku())){
				set(i, yes);
				hasFound = true;
			} 
		}
		if (!hasFound){
			super.add(yes);
		}
			return true;
		
	}

}
