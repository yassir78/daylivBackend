package com.dayliv.dayliv;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dayliv.dayliv.dao.CategoryPartenaireDao;
import com.dayliv.dayliv.dao.CategoryProductDao;
import com.dayliv.dayliv.dao.CommandeDao;
import com.dayliv.dayliv.dao.CommandeItemDao;
import com.dayliv.dayliv.dao.CommandeStatusDao;
import com.dayliv.dayliv.dao.CommentaireDao;
import com.dayliv.dayliv.dao.ConsumerDao;
import com.dayliv.dayliv.dao.DispatcherDao;
import com.dayliv.dayliv.dao.IngredientDao;
import com.dayliv.dayliv.dao.LivreurDao;
import com.dayliv.dayliv.dao.PanierDao;
import com.dayliv.dayliv.dao.PanierItemDao;
import com.dayliv.dayliv.dao.PartenaireDao;
import com.dayliv.dayliv.dao.ProductDao;
import com.dayliv.dayliv.dao.SuperAdminDao;
import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.CommandeItem;
import com.dayliv.dayliv.model.CommandeStatus;
import com.dayliv.dayliv.model.Livreur;

@SpringBootApplication(scanBasePackages = "com.dayliv.dayliv")
public class DaylivBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaylivBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ConsumerDao consumerDao, DispatcherDao dispatcherDao, LivreurDao livreurDao,
			PartenaireDao partenaireDao, SuperAdminDao superAdminDao, ProductDao productDao,
			IngredientDao ingredientDao, CommentaireDao commentaireDao, CommandeDao commandeDao,
			CommandeItemDao commandeItemDao, CommandeStatusDao commandeStatusDao, PanierDao panierDao,
		PanierItemDao panierItemDao, CategoryProductDao categoryProductDao,CategoryPartenaireDao categoryPartenaireDao) {
		return (args) -> {
			Commande commande1 = new Commande();
			Commande commande2 = new Commande();
			commande1.setReference("MT-2938");
			commande1.setTotale_commande(4500F);
			commande1.setDate_commande(new Date());
			commande2.setLongitude(6.1431577F);
			commande2.setLatitude(46.2043907F);
			commande2.setReference("DF-9086");
			commande2.setTotale_commande(9877F);
			commande2.setDate_commande(new Date());
			Stream.of(commande1, commande2).forEach(commande -> {
				commandeDao.save(commande);
			});
			/* commande Item */
			CommandeItem commandeItem1 = new CommandeItem();
			CommandeItem commandeItem2 = new CommandeItem();
			CommandeItem commandeItem3 = new CommandeItem();
			commandeItem1.setQuantity(4);
			commandeItem1.setTotal(4000F);
			commandeItem1.setCommande(commande1);
			commandeItem2.setQuantity(2);
			commandeItem2.setTotal(35000F);
			commandeItem2.setCommande(commande2);
			commandeItem3.setQuantity(10);
			commandeItem3.setTotal(7000F);
			commandeItem3.setCommande(commande1);
			Stream.of(commandeItem1, commandeItem2, commandeItem3).forEach(commandeItem -> {
				commandeItemDao.save(commandeItem);
			});
			Stream.of(commandeItem1, commandeItem2).forEach(commandeItem -> {
				commandeItemDao.save(commandeItem);
			});
			/* commande status */
			CommandeStatus commandeStatus1 = new CommandeStatus();
			CommandeStatus commandeStatus2 = new CommandeStatus();
			CommandeStatus commandeStatus3 = new CommandeStatus();
			commandeStatus1.setEtat_commande("En cours");
			commandeStatus2.setEtat_commande("Livrée");
			commandeStatus3.setEtat_commande("En cours");
			Stream.of(commandeStatus1, commandeStatus2, commandeStatus3).forEach(commandeStatus -> {
				commandeStatusDao.save(commandeStatus);
			});
			commande1.setCommandeStatus(commandeStatus1);
			commande2.setCommandeStatus(commandeStatus2);
			Stream.of(commande1, commande2).forEach(commande -> {
				commandeDao.save(commande);
			});
			
			
		};

}
	
}
