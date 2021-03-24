package fr.miage.car.myWatch.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import fr.miage.car.myWatch.Services.OrdersService;
import fr.miage.car.myWatch.ServicesImp.ArticleServiceImpl;
import fr.miage.car.myWatch.ServicesImp.OrdersServiceImpl;
import fr.miage.car.myWatch.ServicesImp.UserServiceImpl;
import fr.miage.car.myWatch.model.Article;
import fr.miage.car.myWatch.model.Orders;
import fr.miage.car.myWatch.model.User;
import fr.miage.car.myWatch.repositories.ArticleRepository;


@Controller
public class ArticleController {

	@Autowired
	private ArticleServiceImpl articleservices;
	
	@Autowired
	private OrdersServiceImpl oderservice;
	
	@Autowired
	private UserServiceImpl userservice;
	
	
	
	/*
	 * 
	 * returne la page d'accuil avec les articles proposer
	 */
	@GetMapping("/")
	public ModelAndView articles(Model model,WebRequest request) {
		List<Article> article=articleservices.getAllArticles();
		ModelAndView articlPage = new ModelAndView("Article");
		request.getAttribute("perso",WebRequest.SCOPE_SESSION);
		articlPage.addObject("article",article);;
		return  articlPage;
		
	}
	
	/*
	 * 
	 * ajoute les articles au panier
	 */
	@GetMapping(path ="/add/{id}/{idu}")
	public  String addPanier(@PathVariable int id,WebRequest request,@PathVariable int idu){
		List<Orders> orders = userservice.getById(idu).getOrders();
		for (Orders order:orders) {
			if (order.getSend()==false) {
				order.addArticle(articleservices.getById(id));
				oderservice.Update(order);
				return "redirect:/";
			}
			
		}
		
			Orders orderr = new Orders(false,userservice.getById(idu)) ;
			orderr.addArticle(articleservices.getById(id));
			oderservice.saveOrder(orderr);
			return "redirect:/";
		
	     
	
	
		
		
	}
	
	

	
	
}
