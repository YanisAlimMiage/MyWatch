package fr.miage.car.myWatch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.miage.car.myWatch.model.Article;
import fr.miage.car.myWatch.model.Orders;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	
	
}
