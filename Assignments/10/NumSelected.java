package Assignment10;
/**
 * Name: Phuong Do (Joe)
 * Date: July 05 2017
 * Course: CS211
 * Assignment #10
 * Purpose: write the back end, or the data structures that work behind the scenes.
 * write a set of supporting classes for a simple shopping program.
 */ 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

public class NumSelected {
	private int quantity;
	private Sku sku;

	// Constructor that creates an order for the given sku and given quantity
	public NumSelected(Sku sku, int quantity) {
		this.quantity = quantity;
		this.sku = sku;
				
	}
	
	// Returns the cost for this order.
	public double getPrice(){
		return Sku.priceFor(quantity);
	}
	
	// Returns a reference (i.e. an Sku reference) to this order.
	public Sku getSku(){
		return sku;
	}

}
