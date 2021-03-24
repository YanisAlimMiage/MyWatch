package fr.miage.car.myWatch.Services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.miage.car.myWatch.model.Article;
@Service
public interface ArticleService {

  public ArrayList<Article> getAllArticles() ;
  
  public Article getById(int idArticle);
  public Article saveArticle(Article article);
  public Article Update(Article article);
  public Boolean deleteArticle(int idArticle);
	
}
