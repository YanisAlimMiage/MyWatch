package fr.miage.car.myWatch.ServicesImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.miage.car.myWatch.Services.ArticleService;
import fr.miage.car.myWatch.model.Article;
import fr.miage.car.myWatch.repositories.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService{
@Autowired
	private ArticleRepository articleRepository;

@Override
public ArrayList<Article> getAllArticles() {
	// TODO Auto-generated method stub
	return (ArrayList) articleRepository.findAll();
}

@Override
public Article getById(int idArticle) {
	// TODO Auto-generated method stub
	return articleRepository.getOne(idArticle);
}

@Override
public Article saveArticle(Article article) {
	return articleRepository.save(article);
}

@Override
public Article Update(Article article) {
	Article articlee = articleRepository.getOne(article.getIdarticle());
	if (articlee!=null) {
		articlee= article;
	articleRepository.save(articlee);}
	return articleRepository.getOne(article.getIdarticle());

}

@Override
public Boolean deleteArticle(int idArticle) {
	// TODO Auto-generated method stub
	return null;
}
	
}
