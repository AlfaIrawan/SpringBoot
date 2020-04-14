package edu.havrelearning.springboot.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int price;
	
	/**
	 * @return the id
	 */
	public int getId() { return id; }
	/**
	 * @param id the id to set
	 */
	public void setId(int id) { this.id = id; }
	
	/**
	 * @return the name
	 */
	public String getName() { return name; }
	/**
	 * @param name the name to set
	 */
	public void setName(String name) { this.name = name; }
	
	/**
	 * @return the description
	 */
	public String getDescription() { return description; }
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) { this.description = description; }
	
	/**
	 * @return the price
	 */
	public int getPrice() { return price; }
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) { this.price = price; }

}
