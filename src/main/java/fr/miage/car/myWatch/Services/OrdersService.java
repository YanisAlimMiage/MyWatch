package fr.miage.car.myWatch.Services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.miage.car.myWatch.model.Article;
import fr.miage.car.myWatch.model.Orders;
@Service
public interface OrdersService {
	public ArrayList<Orders> getAllArticles() ;
	  
	  public Orders getById(int idOrders);
	  public Orders saveOrder(Orders orders);
	  public Orders Update(Orders article);
	  public Boolean deleteArticle(int idOrders);
	//  public Orders addPanier(Article article);
}
