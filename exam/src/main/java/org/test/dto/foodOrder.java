package org.test.dto;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class foodOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String address,itemName;
	private double price;
	@CreationTimestamp
	private LocalDateTime del_time;
	@UpdateTimestamp
	private LocalDateTime ordered_time;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDateTime getDel_time() {
		return del_time;
	}
	public void setDel_time(LocalDateTime del_time) {
		this.del_time = del_time;
	}
	public LocalDateTime getOrdered_time() {
		return ordered_time;
	}
	public void setOrdered_time(LocalDateTime ordered_time) {
		this.ordered_time = ordered_time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}