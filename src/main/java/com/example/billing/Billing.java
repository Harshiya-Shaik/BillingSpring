package com.example.billing;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Billing {
	private Long id;
	private String name;
	private int date;
	private double balance;
	private String mobileno;

	protected Billing() {
	}
	
	
	public Billing(Long id, String name, int date, double balance, String mobileno) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.balance = balance;
		this.mobileno = mobileno;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDate() {
		return date;
	}


	public void setDate(int date) {
		this.date = date;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
}

	