package fr.miage.car.myWatch.ServicesImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import fr.miage.car.myWatch.Services.UserService;
import fr.miage.car.myWatch.model.User;
import fr.miage.car.myWatch.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public ArrayList<User> getAllArticles() {
		
		return (ArrayList) userRepository.findAll();
	}

	@Override
	public User getById(int idUser) {
		
		return userRepository.getOne(idUser);
	}

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User Update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteUser(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByNomAndPassword(String email, String password) {
		ArrayList<User> users=(ArrayList<User>) userRepository.findAll();
		for(User user:users) {
			
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				System.out.println("ddd");
				return user;
				
			}
			
		}
		return null;
	}

}
