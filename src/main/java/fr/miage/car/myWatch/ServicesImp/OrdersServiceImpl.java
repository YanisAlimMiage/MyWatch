package fr.miage.car.myWatch.ServicesImp;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import fr.miage.car.myWatch.Services.OrdersService;
import fr.miage.car.myWatch.model.Article;
import fr.miage.car.myWatch.model.Orders;
import fr.miage.car.myWatch.repositories.OrdersRepository;
@Service
public class OrdersServiceImpl implements OrdersService{


	@Autowired
	private OrdersRepository orderRepository; 
	@Override
	public ArrayList<Orders> getAllArticles() {

		return  (ArrayList) orderRepository.findAll();
	}

	@Override
	public Orders getById(int idOrders) {
		
		return orderRepository.getOne(idOrders);
	}

	@Override
	public Orders saveOrder(Orders orders) {
		
		return orderRepository.save(orders);
	}

	@Override
	public Orders Update(Orders orders) {
		Orders Order = orderRepository.getOne(orders.getIdcommande());
		if (Order!=null) {
			Order=orders;
			return orderRepository.save(Order);
			
		}
		return orderRepository.save(orders);
	}

	@Override
	public Boolean deleteArticle(int idOrders) {
		Orders order =orderRepository.getOne(idOrders);
	
		
		return true;
	}
//	@Override
//	public Orders addPanier(Article article) {
//		ArrayList<Orders> orders =(ArrayList) orderRepository.findAll();
//		for (Orders order:orders) {
//			if (order.getSend()==false) {
//				return order;
//			//	order.addArticle(article);
//			}
//		}
//		return null;
//		
//		
//	}

}
