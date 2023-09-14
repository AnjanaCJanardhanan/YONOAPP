package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="customer")
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerid")
	private Integer id;
	
	@Column(name="accountno",nullable=false,length=60)
	private String accountno;
	
	@Column(name="customername",nullable=false,length=60)
	private String customername;
	
	@Column(name="accounttype",nullable=false,length=60)
	private String accounttype;
	
	@Column(name="balance")
	private int balance;
	
	@Column(name="minbalance")
	private int minbalance;
	
	@Column(name="mobileno")
	private String mobileno;
	
	@Column(name="email",nullable=false,length=60)
	private String email;
	
	@Column(name="atmpin",nullable=false,length=60)
	private String atmpin;
	@Column(name="is_active")
	private boolean is_active;
	private int userid;
	@OneToOne
	@JoinColumn(name="userid",insertable=false,updatable=false)
	private User user;

	public Customer() {
		
	}

	public Customer(Integer id, String accountno, String customername, String accounttype, int balance, int minbalance,
			String mobileno, String email, String atmpin,boolean is_active,int userid, User user) {
		super();
		this.id = id;
		this.accountno = accountno;
		this.customername = customername;
		this.accounttype = accounttype;
		this.balance = balance;
		this.minbalance = minbalance;
		this.mobileno = mobileno;
		this.email = email;
		this.atmpin = atmpin;
		this.is_active=is_active;
		this.userid=userid;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getMinbalance() {
		return minbalance;
	}

	public void setMinbalance(int minbalance) {
		this.minbalance = minbalance;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAtmpin() {
		return atmpin;
	}

	public void setAtmpin(String atmpin) {
		this.atmpin = atmpin;
	}

	

	public void setUser(User user) {
		this.user = user;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	
	
}
