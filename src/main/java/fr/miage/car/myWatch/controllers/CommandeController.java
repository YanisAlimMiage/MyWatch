package fr.miage.car.myWatch.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import fr.miage.car.myWatch.ServicesImp.ArticleServiceImpl;
import fr.miage.car.myWatch.ServicesImp.OrdersServiceImpl;
import fr.miage.car.myWatch.ServicesImp.UserServiceImpl;
import fr.miage.car.myWatch.model.Article;
import fr.miage.car.myWatch.model.Orders;
import fr.miage.car.myWatch.model.User;

@Controller
public class CommandeController {
	
	@Autowired
	private OrdersServiceImpl orderservice;
	
	@Autowired
	private ArticleServiceImpl articleservice;
	
	@Autowired
	private UserServiceImpl userservice;
	
	
	/*
	 * 
	 * returne la page des commandes et du panier pour l'utilisateur connecter
	 */	

@GetMapping("{id}")
public ModelAndView commande(WebRequest request,HttpSession session,@PathVariable int id) {
		
		List<Orders> orders = userservice.getById(id).getOrders();
		request.setAttribute("commande", orders,  WebRequest.SCOPE_SESSION);
		
		
		ModelAndView ins = new ModelAndView("Commande");
		return ins;
		
	}

/*
 * 
 * elle permet de commander de tronfsormer le panier on commande
 */

@GetMapping("/comptee/{id}")
public String addOrder(@ModelAttribute("orderss") Orders order,
		BindingResult result, Model model, WebRequest request,@PathVariable int id) {
    
	Orders orders=  orderservice.getById(id);
	
	orders.setSend(true);
	
	 orderservice.Update(orders);
	 for(Article article:orders.getArticles()) {
		 article.setQuantity(article.getQuantity()-1);
		 articleservice.Update(article);
		
	 }
	
	
	ModelAndView ins = new ModelAndView("Commande");
	return "redirect:/";

	
		
	
}

/*
 * 
 * supprime un article du panier
 */
@GetMapping("/removeArticle/{id}/{idc}")
public String removeArticle(@ModelAttribute("orderss") Orders order,
		BindingResult result, Model model, WebRequest request,@PathVariable int id,@PathVariable int idc) {
	Article article= articleservice.getById(id);
	Orders orders=  orderservice.getById(idc);
	
		orders.removeArticle(article);	
		orderservice.Update(orders);
	
	
	
	
			return "redirect:/";
	



}
}