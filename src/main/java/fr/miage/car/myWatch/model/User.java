package fr.miage.car.myWatch.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idusers;
	private String name;
	private String lastname;
	private String email;
	private String password;
	
	@OneToMany(targetEntity=Orders.class,mappedBy = "user",cascade = CascadeType.ALL)
	private List<Orders> orders =new ArrayList();

	public int getIdusers() {
		return idusers;
	}

	public void setIdusers(int idusers) {
		this.idusers = idusers;
	}

	public User(String name, String lastname, String email, String password, List<Orders> orders) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.orders = orders;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Orders order) {
		if (this.orders==null) {
			List<Orders> orderss =new ArrayList();
			orderss.add(order);
			this.orders=orderss;
		}
		else {
		this.orders.add(order);
	}
}
}