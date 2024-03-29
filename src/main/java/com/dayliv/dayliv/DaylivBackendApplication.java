package com.dayliv.dayliv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.Collection;  
import com.dayliv.dayliv.dao.CategoryPartenaireDao;
import com.dayliv.dayliv.dao.CategoryProductDao;
import com.dayliv.dayliv.dao.CategoryStoreDao;
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
import com.dayliv.dayliv.model.CategoryStore;
import com.dayliv.dayliv.model.NotificationEmail;
import com.dayliv.dayliv.model.Product;
import com.dayliv.dayliv.model.ProductImage;
import com.dayliv.dayliv.model.Store;
import com.dayliv.dayliv.model.SubCategory;
import com.dayliv.dayliv.service.SendMailService;

@SpringBootApplication(scanBasePackages = "com.dayliv")
@EnableAsync
public class DaylivBackendApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DaylivBackendApplication.class, args);
	}

	
	@Autowired
    private  SendMailService mailService;

	@Bean
	public CommandLineRunner demo(ConsumerDao consumerDao, DispatcherDao dispatcherDao, LivreurDao livreurDao,
			PartenaireDao partenaireDao, SuperAdminDao superAdminDao, ProductDao productDao,
			IngredientDao ingredientDao, CommentaireDao commentaireDao, CommandeDao commandeDao,
			CommandeItemDao commandeItemDao, CommandeStatusDao commandeStatusDao, PanierDao panierDao,
			StoreDao storeDao, PanierItemDao panierItemDao, CategoryProductDao categoryProductDao,
			ProductImageDao productImageDao, CategoryPartenaireDao categoryPartenaireDao,
			SubCategoryDao subCategoryDao, CategoryStoreDao categoryStoreDao) {
		return (args) -> {
			
			Stream.of("Luxe", "Electroménagers", "Auto Moto","Santé", "Sport", "Beauté et soins", "Animaux", 
					"Bébé Enfants", "Multimédia / Téléphonie","Librairie / Papeterie", "Divertissements", "Maison / Déco", "Bricolage", "Epicerie fine / Gourmet", "Mode", "Chaussures / Sneakers","Accessoires","Bijoux / Montres").forEach(categorie->{
				CategoryStore categoryStore = new CategoryStore();
				categoryStore.setNom(categorie);

				categoryStoreDao.save(categoryStore);
			});
		/*	Map<String, Collection<String>> categories = new HashMap<>();			
			
		    List <String> subCategoryList1 = new ArrayList<>();
		    subCategoryList1.add("Haute de game");
		    subCategoryList1.add("Haute couture");
		    subCategoryList1.add("Maison de luxe");
		    subCategoryList1.add("Voyage");
		    categories.put("Luxe", subCategoryList1);
		    
		    
		    List <String> subCategoryList2 = new ArrayList<>();

		    subCategoryList2.add("Aspirateurs");
		    subCategoryList2.add("Nettoyeurs à vapeur");
		    subCategoryList2.add("Accessoires, nettoyage du sol");
		    subCategoryList2.add("Appareils à raclette, fondue, crêpes");
		    subCategoryList2.add("Micro-ondes et mini-fours");
		    subCategoryList2.add("Cuiseurs vapeurs");
		    subCategoryList2.add("Barbecue, grill et plancha");
		    subCategoryList2.add("Autres appareils de cuisson");
		    subCategoryList2.add("Bouilloires, machines à café");
		    subCategoryList2.add("Capsules à café et accessoires");
		    subCategoryList2.add("Sèches cheveux, lisseurs, boucleurs");
		    subCategoryList2.add("Rasoirs et tondeuses");
		    subCategoryList2.add("Brosses à dents électriques");
		    subCategoryList2.add("Machines fitness et sport");
		    categories.put("Petits électroménagers",subCategoryList2);

		    
		    List <String> subCategoryList3 = new ArrayList<>();
		    
		    subCategoryList3.add("Cuisinières");
		    subCategoryList3.add("Plaques de cuisson");
		    subCategoryList3.add("Hottes");
		    subCategoryList3.add("Fours encastrables");
		    subCategoryList3.add("Réfrigérateurs");
		    subCategoryList3.add("Congélateurs");
		    subCategoryList3.add("Caves à vins");
		    subCategoryList3.add("Sèches linges");
		    subCategoryList3.add("Lavantes-séchantes");
		    subCategoryList3.add("Lave-linge");
		    subCategoryList3.add("Lave-vaisselle");
		    subCategoryList3.add("Lave-vaisselle encastrable");
		    categories.put("Gros électroménagers", subCategoryList3);
		    
		    
		    categories.entrySet().stream().parallel().forEach(e->{
		    	CategoryProduct catProduct = new CategoryProduct();
		    	catProduct.setCategorie(e.getKey());
				//categoryProduct.setStoreCode("XEHZJ8855");
				categoryProductDao.save(catProduct);
				
				e.getValue().forEach(val -> {
					SubCategory subCat = new SubCategory();
					subCat.setSousCategorie(val);
					//subCategory.setStoreCode("XEHZJ8855");
					subCat.setCategoryProduct(catProduct);
					subCategoryDao.save(subCat);
		    });
				
		    });


		    */
		    
		    
			/*
			 * Commande commande1 = new Commande(); Commande commande2 = new Commande();
			 * commande1.setReference("MT-2938"); commande1.setTotale_commande(4500F);
			 * commande1.setDate_commande(new Date()); commande1.setLongitude(6.1431577F);
			 * commande1.setLatitude(46.2043907F); commande2.setLongitude(6.1431577F);
			 * commande2.setLatitude(46.2043907F); commande2.setReference("DF-9086");
			 * commande2.setTotale_commande(9877F); commande2.setDate_commande(new Date());
			 * Stream.of(commande1, commande2).forEach(commande -> {
			 * commandeDao.save(commande); });
			 */
			/* commande Item */
			/*
			 * CommandeItem commandeItem1 = new CommandeItem(); CommandeItem commandeItem2 =
			 * new CommandeItem(); CommandeItem commandeItem3 = new CommandeItem();
			 * commandeItem1.setQuantity(4); commandeItem1.setTotal(4000F);
			 * commandeItem1.setCommande(commande1); commandeItem2.setQuantity(2);
			 * commandeItem2.setTotal(35000F); commandeItem2.setCommande(commande2);
			 * commandeItem3.setQuantity(10); commandeItem3.setTotal(7000F);
			 * commandeItem3.setCommande(commande1); Stream.of(commandeItem1, commandeItem2,
			 * commandeItem3).forEach(commandeItem -> { commandeItemDao.save(commandeItem);
			 * }); Stream.of(commandeItem1, commandeItem2).forEach(commandeItem -> {
			 * commandeItemDao.save(commandeItem); });
			 */

			/* commande status */
			/*
			 * CommandeStatus commandeStatus1 = new CommandeStatus(); CommandeStatus
			 * commandeStatus2 = new CommandeStatus(); CommandeStatus commandeStatus3 = new
			 * CommandeStatus(); commandeStatus1.setEtat_commande("En cours");
			 * commandeStatus2.setEtat_commande("Livrée");
			 * commandeStatus3.setEtat_commande("En cours"); Stream.of(commandeStatus1,
			 * commandeStatus2, commandeStatus3).forEach(commandeStatus -> {
			 * commandeStatusDao.save(commandeStatus); });
			 */
			/*
			 * commande1.setCommandeStatus(commandeStatus1);
			 * commande2.setCommandeStatus(commandeStatus2); Stream.of(commande1,
			 * commande2).forEach(commande -> { commandeDao.save(commande); });
			 */
			Stream.of("I2021", "P2021", "M2021", "XEHZJ8855").forEach(code -> {
				String[] categories = {"Luxe", "Electroménagers", "Auto Moto","Santé", "Sport", "Beauté et soins", "Animaux",};
				String random = (categories[new Random().nextInt(categories.length)]);
				CategoryStore cs = new CategoryStore();
				cs.setNom(random);
				categoryStoreDao.save(cs);
				
				Store store = new Store();
				store.setCode(code);
				store.setCategoryStore(cs);
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
				store.setLogo("https://via.placeholder.com/150/0000ff/808080?Text=" + store.getName());
				storeDao.save(store);
			
				
				Stream.of("pizza", "panini", "chawarma").forEach(libelle -> {
					CategoryProduct categoryProduct = new CategoryProduct();
					categoryProduct.setCategorie(libelle);
					categoryProduct.setStoreCode("XEHZJ8855");
					categoryProductDao.save(categoryProduct);
					Stream.of("s-pizza", "s-panini", "s-chawarma").forEach(nom -> {
						SubCategory subCategory = new SubCategory();
						subCategory.setSousCategorie(nom);
						subCategory.setStoreCode("XEHZJ8855");
						subCategory.setCategoryProduct(categoryProduct);
						subCategoryDao.save(subCategory);
					});
				});
			});
			
			
			
           /*
			Stream.of("PC1", "Imprimante2", "Iphone3", "Radio4", "Clavier5", "Clé USB6", "Coffe7", "Chaussures8",
					"Table9", "Chargeur10", "Téléphone11", "PC12", "Imprimante13", "Iphone14", "Radio15", "Clavier16",
					"Clé USB17", "Coffe18", "Chaussures19", "Table20", "Chargeur21", "Téléphone22", "PC23",
					"Imprimante24", "Iphone25", "Radio26", "Clavier27", "Clé USB28", "Coffe29", "Chaussures30",
					"Table31", "Chargeur32", "Téléphone33", "PC34", "Imprimante35", "Iphone36", "Radio37", "Clavier38",
					"Clé USB39", "Coffe40", "Chaussures41", "Table42", "Chargeur43", "Téléphone44").forEach(libelle -> {
						Product product = new Product();
						product.setLibelle(libelle);
						product.setOrigine("Chine");
						product.setStoreCode("I2021");
						product.setDescription(
								"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
						product.setPrice((float) 58.6);
						CategoryProduct pizza = categoryProductDao.findById((long) 2).get();
						SubCategory sub = subCategoryDao.findById((long) 3).get();
						product.setSubCategory(sub);
						product.setCategoryProduct(pizza);
						ProductImage pi = new ProductImage();
						productDao.save(product);
						pi.setPath(
								"https://ma.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/39/358943/1.jpg?9484");
						pi.setProduct(product);
						productImageDao.save(pi);
					});*/
			
			//Send account creation notification email
			/*mailService.sendMail(new NotificationEmail("Please Activate your Account",
					"belkoweb9718@gmail.com", "Thank you for signing up to Spring Dayliv, " +
	                "please click on the below url to activate your account : " +
	                "http://localhost:8080/api/auth/accountVerification/"+"token"));*/

		};
}
	
}
