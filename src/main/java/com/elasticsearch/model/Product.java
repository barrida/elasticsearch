/**
 * 
 */

package com.elasticsearch.model;

/**
 * Entity
 * 
 * @author suleyman.yildirim
 *
 */

public class Product {

	private String name;
	private int price;
	private String currency;

	public Product(String name, int price, String currency) {
		this.name = name;
		this.price = price;
		this.currency = currency;
	}
	
	/*--- GETTERS & SETTERS---*/
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
