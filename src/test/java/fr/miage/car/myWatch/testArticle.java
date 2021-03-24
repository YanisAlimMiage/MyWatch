package fr.miage.car.myWatch;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import fr.miage.car.myWatch.ServicesImp.ArticleServiceImpl;
import fr.miage.car.myWatch.model.Article;
import fr.miage.car.myWatch.repositories.ArticleRepository;

@SpringBootTest
public class testArticle {
@Autowired
private ArticleRepository articleRepository;
	@Autowired
	private ArticleServiceImpl articleServiceImpl;
	
	
}
