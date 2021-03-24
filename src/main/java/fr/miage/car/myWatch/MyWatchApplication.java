package fr.miage.car.myWatch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.miage.car.myWatch.model.Article;
import fr.miage.car.myWatch.model.Orders;
import fr.miage.car.myWatch.model.User;
import fr.miage.car.myWatch.repositories.ArticleRepository;
import fr.miage.car.myWatch.repositories.OrdersRepository;
import fr.miage.car.myWatch.repositories.UserRepository;

@SpringBootApplication
public class MyWatchApplication  implements CommandLineRunner{
	
@Autowired
private ArticleRepository articleRepository;
@Autowired
private UserRepository userrepository;
@Autowired
private OrdersRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyWatchApplication.class, args);
	}
	/*
	 * 
	 * ajouter des donnée a notre base de donnéeq lors du lancement de l'application
	 */
	@Override
	public void run(String... args) throws Exception {
		
		Article article =new Article("huawei gt watch 2e",119,10,"Avec ses nombreux fonds d'écran2, couleurs et animations, la HUAWEI WATCH GT 2e habillera votre poignet avec élégance. .","gt2e.jpg");
		Article article2 =new Article("huawei gt watch 2 pro",199,10,"La HUAWEI WATCH GT 2 Pro vous immerge au plus près de la nature. A la levée de votre poignet.","gt2pro.jpg");
		Article article3 =new Article("samsung active 2",249,10,"La Galaxy Watch Active2 s en acier inoxydable. Le choix vous appartient.","act2.jpg");
		Article article4 =new Article("samsung galaxy watch",199,10,"La Galaxy Watch vous propose, avec sa forme arrondie et le bruit si particulier d'une trotteuse de profiter des codes d'une authentique montre.","galaxy-w.jpg");
		Article article5 =new Article("Apple Watch Series 6",499,10,"Extrêmement léger, le boîtier en aluminium est constitué d’un alliage de qualité aérospatiale 100 % recyclé.","appelS6.jpg");
		Article article6 =new Article("Apple Watch Series 5",499,10,"ne montre comme vous n'en avez jamais vu. Cette montre a un écran toujours activé. Avec le nouvel écran Retina toujours activé","appelS5.jpg");
		Article article7 =new Article("Apple Watch SE",329,10,"Extrêmement léger, le boîtier en aluminium est constitué d’un alliage de qualité aérospatiale 100 % recyclé.","appelse.jpg");
		User user=new User("yanis","alim","alimyanis7@gmail.com","password", null);
		User user2=new User("nacim","alim","alimyanis@gmail.com","password", null);
		
		Orders order =new Orders(true, user);
		Orders order3 =new Orders(false, user);
		Orders order2 =new Orders(false, user2);
		order2.addArticle(article2);
		order2.addArticle(article3);
		order.addArticle(article7);
	    order.addArticle(article6);
		order.addArticle(article4);
		
		
		
		orderRepository.save(order);
		orderRepository.save(order2);
		
		userrepository.save(user);
		userrepository.save(user2);
		articleRepository.save(article);
		articleRepository.save(article2);
		articleRepository.save(article3);
		articleRepository.save(article4);
		articleRepository.save(article5);
		articleRepository.save(article6);
		articleRepository.save(article7);
		
	//	
		
		
		
		
	}

}
