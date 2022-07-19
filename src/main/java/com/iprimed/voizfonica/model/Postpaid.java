package com.iprimed.voizfonica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Postpaid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String packname;
	private String packbenefits;
	private String validity;
	private int price;
	
	
	
	
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Postpaid() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Postpaid(long id, String packname, String packbenefits, String validity, int price) {
		super();
		this.id = id;
		this.packname = packname;
		this.packbenefits = packbenefits;
		this.validity = validity;
		this.price=price;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPackname() {
		return packname;
	}
	public void setPackname(String packname) {
		this.packname = packname;
	}
	public String getPackbenefits() {
		return packbenefits;
	}
	public void setPackbenefits(String packbenefits) {
		this.packbenefits = packbenefits;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}

}
