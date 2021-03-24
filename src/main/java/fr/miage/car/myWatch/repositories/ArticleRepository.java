package fr.miage.car.myWatch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.miage.car.myWatch.model.Article;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
