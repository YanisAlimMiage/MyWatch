package fr.miage.car.myWatch.Services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.miage.car.myWatch.model.User;
@Service
public interface UserService {
	public ArrayList<User> getAllArticles() ;
	  
	  public User getById(int idUser);
	  public User saveUser(User user);
	  public User Update(User user);
	  public Boolean deleteUser(int idUser);
	  public User findByNomAndPassword(String name,String Password);
}
