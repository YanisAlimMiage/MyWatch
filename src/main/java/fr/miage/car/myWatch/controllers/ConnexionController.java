package fr.miage.car.myWatch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import fr.miage.car.myWatch.ServicesImp.UserServiceImpl;
import fr.miage.car.myWatch.model.Article;
import fr.miage.car.myWatch.model.Orders;
import fr.miage.car.myWatch.model.User;

@Controller
public class ConnexionController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/connexion")
	public ModelAndView cnx(Model model) {
		
		ModelAndView cnx = new ModelAndView("Connexion");
		
		return  cnx;
		
	}
	
	/*
	 * 
	 * fonction qui nous permet de nous connecter a notre compte et ajouter et mettre a jours nos commandes et panier
	 */
	@PostMapping("/compte")
	public ModelAndView connexion(@ModelAttribute("personne") User personne,
			BindingResult result, Model model, WebRequest request) {
		User user=userServiceImpl.findByNomAndPassword(personne.getEmail(), personne.getPassword());
	
		
			
		if(user != null) {
			List<Orders> orders= user.getOrders();
			
			request.setAttribute("connected", true, WebRequest.SCOPE_SESSION);
			request.setAttribute("commande", orders,  WebRequest.SCOPE_SESSION);
			request.setAttribute("user", user,  WebRequest.SCOPE_SESSION);

			ModelAndView ins = new ModelAndView("compte");
			
			
			ins.addObject("orders",orders);
			ins.addObject("user",user);
			return ins;
		}
		ModelAndView ins = new ModelAndView("Inscreption");
		return ins;
		
	}
	
	/*
	 * 
	 * returne la page du compte
	 */
	@GetMapping("/compte")
	public ModelAndView compte(Model model) {
		ModelAndView ins = new ModelAndView("compte");
		return ins;
	}
	
	/*
	 * 
	 * deconnecter de notre compte ( de la session)
	 */
	@GetMapping("/deconnect")
	public ModelAndView leave(WebRequest request) {
		ModelAndView ins = new ModelAndView("Connexion");
	request.setAttribute("connected", false, WebRequest.SCOPE_SESSION);
	request.removeAttribute("perso", WebRequest.SCOPE_SESSION);
	return ins;
	}
	
	


}
