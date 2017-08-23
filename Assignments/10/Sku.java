package Assignment10;
/**
 * Name: Phuong Do (Joe)
 * Date: July 05 2017
 * Course: CS211
 * Assignment #10
 * Purpose: write the back end, or the data structures that work behind the scenes.
 * write a set of supporting classes for a simple shopping program.
 */ 
import java.text.*; // to construct a String representation of the price. (see REQ)
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Sku{
	private String name;
	private static double singleSkuPrice;
	private static double bulkPrice;
	private static int bulkQuantity;
	private int quantity;
	
	// Constructor that takes a name and a single-sku price and a bulk quantity and a bulk price as arguments.
	public Sku(String name, double singleSkuPrice, int bulkQuantity, double bulkPrice) {
		this.name = name;
		Sku.singleSkuPrice = singleSkuPrice;
		Sku.bulkPrice = bulkPrice;
		Sku.bulkQuantity = bulkQuantity;
		if (singleSkuPrice < 0 || bulkQuantity < 0 || bulkPrice < 0){
			throw new IllegalArgumentException(" Number can not be negative.");
		}
	}

	// Constructor that takes a name and a price as arguments.
	public Sku(String name, double singleSkuPrice) { 
		this.name = name;
		Sku.singleSkuPrice = singleSkuPrice;
		if (singleSkuPrice < 0){
			throw new IllegalArgumentException(" Price can not be negative.");
		}
	}
	
	
	// Returns the price for a given quantity of the item (taking into account bulk price, if applicable).
	public static double priceFor(int quantity) {
		//this.quantity  = quantity;
		if (quantity < 0){
			throw new IllegalArgumentException("Quantity can not be negative.");
		}
		else if (quantity < bulkQuantity){
			return Sku.singleSkuPrice * quantity;
		} else {
			return (quantity / bulkQuantity) * bulkPrice + (quantity % bulkQuantity) * singleSkuPrice;
		}
	}
	
	// Returns a String representation of this sku (taking into account bulk price, if applicable).
    public String toString() {
    	if (this.quantity < Sku.bulkQuantity){
    		return this.name + ", " + Sku.singleSkuPrice;
    	} else { // 10 for $10.99
    		return this.name + ", " + Sku.singleSkuPrice + " (" + Sku.bulkQuantity + " for " + Sku.bulkPrice + ")";
    	}
    }
    
    //Returns a Boolean that helps us know if two Sku’s are really the same.
    public boolean equals(Sku other){
    	return((other.name).equals(this.name));
    }

}