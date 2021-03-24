package fr.miage.car.myWatch.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Article  implements Serializable{
	

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idarticle;
private String name;
private int price;
private int quantity;
private String description;
private String img;

@ManyToMany(cascade = CascadeType.ALL)
@JoinColumn(name="idarticle")
private List<Orders> orders = new ArrayList();








public Article() {

}




public Article( String name, int price, int quantity, String description,String img) {
	super();

	this.name = name;
	this.price = price;
	this.quantity = quantity;
	this.description = description;
	this.img=img;
}




public int getIdarticle() {
	return idarticle;
}




public void setIdarticle(int idarticle) {
	this.idarticle = idarticle;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}




public String getImg() {
	return img;
}




public void setImg(String img) {
	this.img = img;
}





}
