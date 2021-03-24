package fr.miage.car.myWatch.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import fr.miage.car.myWatch.ServicesImp.UserServiceImpl;
import fr.miage.car.myWatch.model.User;

@Controller
public class UserController extends HttpServlet {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	private String email;
	
	
	
	
	
	/*
	 * 
	 * crée un nouveau compte 
	 */
	 @PostMapping(path = "/newUser")
	 public ModelAndView addUser(@ModelAttribute("personne") User
			 personne ,Model model) {
		 
			
			userServiceImpl.saveUser(personne);
		 ModelAndView cnx = new ModelAndView("Inscreption");
		 
		 
		 return cnx;
	 }
	 /*
		 * 
		 * returne la page d'ainscription
		 */
	 @GetMapping("/inscreption")
		public ModelAndView ins(Model model) {
			
			ModelAndView ins = new ModelAndView("Inscreption");
			
			return  ins;
			
		}
		

}
