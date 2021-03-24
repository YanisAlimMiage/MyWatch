package fr.miage.car.myWatch.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Orders {
	public Orders(   Boolean send,User user ) {
		
		
		
		this.user =user;
		
		this.send = send;
	}
	public Orders() {
		
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idcommande")
    private List<Article> articles =new ArrayList(); 
	
    
    private Boolean send;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcommande;
	

	
	@Override
	public String toString() {
		return "Orders [articles=" + articles + ", send=" + send + ", idcommande=" + idcommande + ", user=" + user
				+ "]";
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idusers", nullable=false)
	private User user;
	
    public int getIdcommande() {
		return idcommande;
	}

	public void setIdcommande(int idcommande) {
		this.idcommande = idcommande;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Boolean getSend() {
		return send;
	}

	public void setSend(Boolean send) {
		this.send = send;
	}
	public void addArticle(Article article) {
		if(this.articles == null) {
			List<Article> art =new ArrayList();
			art.add(article);
			
		}
		else {
		this.articles.add(article);
	}}
	
	public void removeArticle(Article articles) {
		this.articles.remove(articles);
	}

	
	
}

