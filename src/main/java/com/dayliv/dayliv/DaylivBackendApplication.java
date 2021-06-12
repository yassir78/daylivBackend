package com.dayliv.dayliv;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.dayliv.dayliv.dao.ProductImageDao;
import com.dayliv.dayliv.dao.StoreDao;
import com.dayliv.dayliv.dao.SubCategoryDao;
import com.dayliv.dayliv.dao.SuperAdminDao;
import com.dayliv.dayliv.model.CategoryProduct;
import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.CommandeItem;
import com.dayliv.dayliv.model.CommandeStatus;
import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.model.Product;

import com.dayliv.dayliv.model.ProductImage;
import com.dayliv.dayliv.model.Store;
import com.dayliv.dayliv.model.SubCategory;
import com.dayliv.dayliv.service.EmailService;

@SpringBootApplication(scanBasePackages = "com.dayliv")
public class DaylivBackendApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(DaylivBackendApplication.class, args);
	}

	@Autowired
    private EmailService emailService; 
	
	@Bean
	public CommandLineRunner demo(ConsumerDao consumerDao, DispatcherDao dispatcherDao, LivreurDao livreurDao,
			PartenaireDao partenaireDao, SuperAdminDao superAdminDao, ProductDao productDao,
			IngredientDao ingredientDao, CommentaireDao commentaireDao, CommandeDao commandeDao,
			CommandeItemDao commandeItemDao, CommandeStatusDao commandeStatusDao, PanierDao panierDao,
			StoreDao storeDao, PanierItemDao panierItemDao, CategoryProductDao categoryProductDao,ProductImageDao productImageDao,
			CategoryPartenaireDao categoryPartenaireDao, SubCategoryDao subCategoryDao) {
		return (args) -> {
		/*	Commande commande1 = new Commande();
			Commande commande2 = new Commande();
			commande1.setReference("MT-2938");
			commande1.setTotale_commande(4500F);
			commande1.setDate_commande(new Date());
			commande1.setLongitude(6.1431577F);
			commande1.setLatitude(46.2043907F);
			commande2.setLongitude(6.1431577F);
			commande2.setLatitude(46.2043907F);
			commande2.setReference("DF-9086");
			commande2.setTotale_commande(9877F);
			commande2.setDate_commande(new Date());
			Stream.of(commande1, commande2).forEach(commande -> {
				commandeDao.save(commande);
			});*/
			/* commande Item */
			/*CommandeItem commandeItem1 = new CommandeItem();
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
			});*/

			/* commande status */
			/*CommandeStatus commandeStatus1 = new CommandeStatus();
			CommandeStatus commandeStatus2 = new CommandeStatus();
			CommandeStatus commandeStatus3 = new CommandeStatus();
			commandeStatus1.setEtat_commande("En cours");
			commandeStatus2.setEtat_commande("Livrée");
			commandeStatus3.setEtat_commande("En cours");
			Stream.of(commandeStatus1, commandeStatus2, commandeStatus3).forEach(commandeStatus -> {
				commandeStatusDao.save(commandeStatus);
			});*/
			/*commande1.setCommandeStatus(commandeStatus1);
			commande2.setCommandeStatus(commandeStatus2);
			Stream.of(commande1, commande2).forEach(commande -> {
				commandeDao.save(commande);
			});
                */
			Stream.of("I2021", "P2021", "M2021", "XEHZJ8855").forEach(code -> {
				Store store = new Store();
				store.setCode(code);
				store.setPhone("06785521455");
				store.setName("SHOP-" + code);
				store.setCodePostal("500300");
				store.setInBusinessSince("2020");
				store.setLat(5278.555);
				store.setLg(56634.21);
				store.setEmail(code + "@gmail.com");
				store.setAddress("MA" + code);
				store.setCurrency("CH");
				store.setUseCache(true);
				store.setLogo("https://via.placeholder.com/150/0000ff/808080?Text="+store.getName());

				storeDao.save(store);
				
			Stream.of("pizza", "panini", "chawarma").forEach(libelle -> {
					CategoryProduct categoryProduct = new CategoryProduct();
					categoryProduct.setCategorie(libelle);
					categoryProduct.setStoreCode("XEHZJ8855");
					categoryProductDao.save(categoryProduct);
					Stream.of("s-pizza", "s-panini", "s-chawarma").forEach(nom->{
						SubCategory subCategory = new SubCategory();
						subCategory.setSousCategorie(nom);
						subCategory.setStoreCode("XEHZJ8855");
						subCategory.setCategoryProduct(categoryProduct);
						subCategoryDao.save(subCategory);
					});
				});
			});
			
			/*Stream.of("PC", "Imprimante", "Iphone", "Radio", "Clavier", "Clé USB", "Coffe", "Chaussures", "Table", "Chargeur", "Téléphone", "PC", "Imprimante", "Iphone", "Radio", "Clavier", "Clé USB", "Coffe", "Chaussures", "Table", "Chargeur", "Téléphone","PC", "Imprimante", "Iphone", "Radio", "Clavier", "Clé USB", "Coffe", "Chaussures", "Table", "Chargeur", "Téléphone", "PC", "Imprimante", "Iphone", "Radio", "Clavier", "Clé USB", "Coffe", "Chaussures", "Table", "Chargeur", "Téléphone").forEach(libelle->{
				Product product = new Product();
				product.setLibelle(libelle);
				product.setOrigine("Chine");
				product.setStoreCode("I2021");
			    product.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
			    product.setPrice((float) 58.6);
			    ProductImage pi = new ProductImage();
			    productDao.save(product);
			    pi.setPath("https://ma.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/39/358943/1.jpg?9484");
			    pi.setProduct(product);
			    productImageDao.save(pi);
			});*/
			

		};

	}

	@Override
	public void run(String... args) throws Exception {

          // emailService.sendMail("belkoweb9718@gmail.com", "Hi", "Ho ho ho");
    	
    	 //  emailService.sendPreConfiguredMail("Ho ho ho");
	}

}
