package com.dayliv.dayliv;

import java.util.Date;
import java.util.stream.Collectors;
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
import com.dayliv.dayliv.model.CategoryPartenaire;
import com.dayliv.dayliv.model.CategoryProduct;
import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.CommandeItem;
import com.dayliv.dayliv.model.CommandeStatus;
import com.dayliv.dayliv.model.Commentaire;
import com.dayliv.dayliv.model.Consumer;
import com.dayliv.dayliv.model.Dispatcher;
import com.dayliv.dayliv.model.Ingredient;
import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.model.Panier;
import com.dayliv.dayliv.model.PanierItem;
import com.dayliv.dayliv.model.Partenaire;
import com.dayliv.dayliv.model.Product;
import com.dayliv.dayliv.model.SuperAdmin;

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
			/* Consumers */
			Consumer cons1 = new Consumer();
			Consumer cons2 = new Consumer();
			Consumer cons3 = new Consumer();
			Consumer cons4 = new Consumer();
			cons1.setNom("Robert");
			cons1.setPrenom("Gray");
			cons1.setNum_tel("609-364-4617");
			cons1.setEmail("whomcide0@bones.hk");
			cons1.setPassword("TYlpDChshPaxdZmJ");
			cons1.setC_password("TYlpDChshPaxdZmJ");
			cons1.setImage_profile("https://picsum.photos/200/300");
			cons1.setEnabled(true);
			cons1.setLogin("Dougherty");
			//
			cons2.setNom("Alejandra");
			cons2.setPrenom("Bowne");
			cons2.setNum_tel("032-992-53-47");
			cons2.setEmail("ealembratorel34kp@additive.center");
			cons2.setPassword("vxcCwtgeKwImUbor");
			cons2.setC_password("vxcCwtgeKwImUbor");
			cons2.setImage_profile("https://picsum.photos/200/300");
			cons2.setEnabled(true);
			cons2.setLogin("Hammons");
			//
			cons3.setNom("Brenda");
			cons3.setPrenom("Carney");
			cons3.setNum_tel("032-992-53-47");
			cons3.setEmail("gabb@pg77789.com");
			cons3.setPassword("MPJQyBgDxlOBITri");
			cons3.setC_password("MPJQyBgDxlOBITri");
			cons3.setImage_profile("https://picsum.photos/200/300");
			cons3.setEnabled(true);
			cons3.setLogin("Middlebrooks");
			//
			cons4.setNom("Joseph");
			cons4.setPrenom("Lytle");
			cons4.setNum_tel("06-82000981");
			cons4.setEmail("oihssan.ih@mainstreethost.company");
			cons4.setPassword("veVuWumHZrxxCQRT");
			cons4.setC_password("veVuWumHZrxxCQRT");
			cons4.setImage_profile("https://picsum.photos/200/300");
			cons4.setEnabled(true);
			cons4.setLogin("Middlebrooks");
			Stream.of(cons1, cons2, cons3, cons4).forEach(consumer -> {
				consumerDao.save(consumer);
			});
			/* Dsipatchers */
			Dispatcher dis1 = new Dispatcher();
			Dispatcher dis2 = new Dispatcher();
			Dispatcher dis3 = new Dispatcher();
			dis1.setNom("Cynthia");
			dis1.setPrenom("Mitchell");
			dis1.setNum_tel("213-465-1744");
			dis1.setEmail("4beatriz.mart@scottpetersondaniel.us");
			dis1.setPassword("ievRFDHabiPTEfsL");
			dis1.setC_password("ievRFDHabiPTEfsL");
			dis1.setImage_profile("https://picsum.photos/200/300");
			dis1.setEnabled(true);
			dis1.setLogin("Palos");
			//
			dis2.setNom("Sallie");
			dis2.setPrenom("Barfield");
			dis2.setNum_tel("484-200-8165");
			dis2.setEmail("zmostafaels@sempakk.com");
			dis2.setPassword("Rpb2$57]VL?UcPB(");
			dis2.setC_password("Rpb2$57]VL?UcPB(");
			dis2.setImage_profile("https://picsum.photos/200/300");
			dis2.setEnabled(true);
			dis2.setLogin("Napolitano");
			//
			dis3.setNom("Anthony");
			dis3.setPrenom("Roberts");
			dis3.setNum_tel("276-445-3126");
			dis3.setEmail("valiemad1999s@camaloon.mobi");
			dis3.setPassword("IxgtgdwfQGegbSeQ");
			dis3.setC_password("IxgtgdwfQGegbSeQ");
			dis3.setImage_profile("https://picsum.photos/200/300");
			dis3.setEnabled(true);
			dis3.setLogin("Dyson");
			Stream.of(dis1, dis2, dis3).forEach(dispatcher -> {
				dispatcherDao.save(dispatcher);
			});
			/* Livreur */
			Livreur liv1 = new Livreur();
			Livreur liv2 = new Livreur();
			Livreur liv3 = new Livreur();
			liv1.setNom("Deborah");
			liv1.setPrenom("Neal");
			liv1.setNum_tel("803-777-1455");
			liv1.setEmail("radel.salaho6@ziplb.biz");
			liv1.setPassword("oqtvvFAXXqKhTJtk");
			liv1.setC_password("oqtvvFAXXqKhTJtk");
			liv1.setImage_profile("https://picsum.photos/200/300");
			liv1.setEnabled(true);
			liv1.setLogin("Payne");
			liv1.setCard_id("ER-26384");
			liv1.setMobility("voiture");
			//
			liv2.setNom("Angella");
			liv2.setPrenom("Deer");
			liv2.setNum_tel("515-361-6667");
			liv2.setEmail("llal@gdian39.com");
			liv2.setPassword("jyCyurZFqSlcdvUn");
			liv2.setC_password("jyCyurZFqSlcdvUn");
			liv2.setImage_profile("https://picsum.photos/200/300");
			liv2.setEnabled(true);
			liv2.setLogin("Abbott");
			liv1.setCard_id("TG-22224");
			liv1.setMobility("vélo");
			//
			liv3.setNom("Linh");
			liv3.setPrenom("Stone");
			liv3.setNum_tel("515-361-6667");
			liv3.setEmail("hr.amtd@boatparty.today");
			liv3.setPassword("RUKNgMbisOhXDMQE");
			liv3.setC_password("RUKNgMbisOhXDMQE");
			liv3.setImage_profile("https://picsum.photos/200/300");
			liv3.setEnabled(true);
			liv3.setLogin("Austin");
			liv1.setCard_id("ZQ-12347");
			liv1.setMobility("voiture");
			Stream.of(liv1, liv2, liv3).forEach(livreur -> {
				livreurDao.save(livreur);
			});
			/* Partenaire */
			Partenaire part1 = new Partenaire();
			Partenaire part2 = new Partenaire();
			Partenaire part3 = new Partenaire();
			part1.setNom("Muriel");
			part1.setPrenom("Cooper");
			part1.setNum_tel("973-258-2670");
			part1.setEmail("xyoussaf.toto2d@patriciasalvo.com");
			part1.setPassword("yzdTHdeCyYqUIaMm");
			part1.setC_password("yzdTHdeCyYqUIaMm");
			part1.setImage_profile("https://picsum.photos/200/300");
			part1.setEnabled(true);
			part1.setLogin("Arroyo");
			part1.setDescription("Black, straight hair awkwardly hangs over a furrowed");
			part1.setBanniere("banniere1");
			//
			part2.setNom("Kristin");
			part2.setPrenom("Stahl");
			part2.setNum_tel("912-202-4367");
			part2.setEmail("1moun@pigsstep.com");
			part2.setPassword("quXIpcyjGQygZnyg");
			part2.setC_password("quXIpcyjGQygZnyg");
			part2.setImage_profile("https://picsum.photos/200/300");
			part2.setEnabled(true);
			part2.setLogin("Stevens");
			part2.setDescription(
					"Blonde, perfectly groomed hair tight in a ponytail reveals a furrowed, lived-in face");
			part2.setBanniere("banniere2");
			//
			part3.setNom("Dennis");
			part3.setPrenom("Porter");
			part3.setNum_tel("228-851-3155");
			part3.setEmail("1moun@pigsstep.com");
			part3.setPassword("vOGwSIuOLqhEdSPK");
			part3.setC_password("vOGwSIuOLqhEdSPK");
			part3.setImage_profile("https://picsum.photos/200/300");
			part3.setEnabled(true);
			part3.setLogin("Emery");
			part3.setDescription("White, frizzy hair awkwardly hangs over a furrowed, time-worn face.");
			part3.setBanniere("bannier3");
			Stream.of(part1, part2, part3).forEach(partenaire -> {
				partenaireDao.save(partenaire);
			});
			/* Super Admin */
			SuperAdmin superAdmin = new SuperAdmin();
			superAdmin.setNom("Jenny");
			superAdmin.setPrenom("Irvin");
			superAdmin.setNum_tel("330-922-6542");
			superAdmin.setEmail("7hhaa123_o@pardis.shop");
			superAdmin.setPassword("IrgUZCsPbwDBHnJD");
			superAdmin.setC_password("IrgUZCsPbwDBHnJD");
			superAdmin.setImage_profile("https://picsum.photos/200/300");
			superAdmin.setEnabled(true);
			superAdmin.setLogin("Rego");
			superAdminDao.save(superAdmin);
			/* Products */
			Product p1 = new Product();
			Product p2 = new Product();
			Product p3 = new Product();
			Product p4 = new Product();
			p1.setLibelle("Standard Hamburger");
			p1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum pellentesque arcu");
			p1.setOrigine("états-uni");
			p1.setPoids(200F);
			p1.setPrice(15F);
			p1.setCaloris(1000);
			p1.setStock_quantity(3);
			p1.setImage("https://picsum.photos/200/300");
			//
			p2.setLibelle("Mini Rouleaux de printemps au poulet");
			p2.setDescription("feugiat ut ante sit amet, rutrum accumsan enim. Aliquam erat volutpat.");
			p2.setOrigine("chinois");
			p2.setPoids(300F);
			p2.setPrice(20.3F);
			p2.setCaloris(3000);
			p2.setStock_quantity(5);
			p2.setImage("https://picsum.photos/200/300");
			//
			p3.setLibelle("Mini Rouleaux de printemps au poulet");
			p3.setDescription("In faucibus, felis et tincidunt tempus, dui turpis pellentesque arcu.");
			p3.setOrigine("japonais");
			p3.setPoids(500F);
			p3.setPrice(40.4F);
			p3.setCaloris(5000);
			p3.setStock_quantity(9);
			p3.setImage("https://picsum.photos/200/300");
			//
			p4.setLibelle("raviolis de crevettes");
			p4.setDescription("Sed ut lacinia nisi. Vivamus rutrum feugiat dolor");
			p4.setOrigine("chinois");
			p4.setPoids(600F);
			p4.setPrice(60F);
			p4.setCaloris(6000);
			p4.setStock_quantity(13);
			p4.setImage("https://picsum.photos/200/300");
			Stream.of(p1, p2, p3, p4).forEach(product -> {
				productDao.save(product);
			});
			/* Ingredient */
			Ingredient ing1 = new Ingredient();
			Ingredient ing2 = new Ingredient();
			Ingredient ing3 = new Ingredient();
			Ingredient ing4 = new Ingredient();
			Ingredient ing5 = new Ingredient();
			ing1.setLibelle("avocat");
			ing2.setLibelle("fromage");
			ing3.setLibelle("pain à l’ail");
			ing4.setLibelle("épinards");
			ing5.setLibelle("gaufre");
			// link ingredients to products
			ing1.setProduct(p1);
			ing2.setProduct(p2);
			ing3.setProduct(p3);
			ing4.setProduct(p4);
			ing5.setProduct(p1);
			Stream.of(ing1, ing2, ing3, ing4, ing5).forEach(ingredient -> {
				ingredientDao.save(ingredient);
			});
			/* Commentaire */
			Commentaire com1 = new Commentaire();
			Commentaire com2 = new Commentaire();
			Commentaire com3 = new Commentaire();
			com1.setText("comment 1");
			com2.setText("comment 2");
			com3.setText("comment 3");
			com1.setProduct(p1);
			com2.setProduct(p1);
			com2.setProduct(p2);
			com2.setProduct(p3);
			com3.setProduct(p3);
			com3.setProduct(p4);
			Stream.of(com1, com2, com3).forEach(commentaire -> {
				commentaireDao.save(commentaire);
			});

			/* Commande */
			Commande commande1 = new Commande();
			Commande commande2 = new Commande();
			commande1.setReference("MT-2938");
			commande1.setTotale_commande(4500F);
			commande1.setDate_commande(new Date());
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
			p1.setCommandeItem(commandeItem1);
			p2.setCommandeItem(commandeItem2);
			p3.setCommandeItem(commandeItem3);
			commandeItem1.setProduct(p1);
			commandeItem2.setProduct(p2);
			commandeItem3.setProduct(p3);

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
			Stream.of(commande1, commande2).forEach(commande -> {
				commandeDao.save(commande);
			});
			/* Panier */
			Panier panier1 = new Panier();
			panier1.setTotale(400F);
			panierDao.save(panier1);
			/* Panier Iitem */
			PanierItem panierItem1 = new PanierItem();
			panierItem1.setQte(23);
			panierItem1.setTotal_panier(2300F);
			panierItem1.setProduit(p1);
			p1.setPanierItem(panierItem1);
			panierItem1.setPanier(panier1);
			panierItemDao.save(panierItem1);
			Stream.of(p1, p2, p3, p4).forEach(product -> {
				productDao.save(product);
			});
			cons1.setPanier(panier1);
			panier1.setConsumer(cons1);
			panierDao.save(panier1);
			consumerDao.save(cons1);
			// product category
			CategoryProduct catprod1 = new CategoryProduct();
			CategoryProduct catprod2 = new CategoryProduct();
			CategoryProduct catprod3 = new CategoryProduct();
			catprod1.setCategory_name("conserve");
			catprod2.setCategory_name("surgelé");
			catprod3.setCategory_name("patisserie");
			Stream.of(catprod1, catprod2, catprod3).forEach(categoryProduct -> {
				categoryProductDao.save(categoryProduct);
			});
			catprod1.setProducts(Stream.of(p1, p2).collect(Collectors.toList()));
			catprod2.setProducts(Stream.of(p3, p4).collect(Collectors.toList()));
			catprod3.setProducts(Stream.of(p1, p3).collect(Collectors.toList()));
			p1.setCategoryProducts(Stream.of(catprod1, catprod3).collect(Collectors.toList()));
			p2.setCategoryProducts(Stream.of(catprod1).collect(Collectors.toList()));
			p3.setCategoryProducts(Stream.of(catprod2,catprod3).collect(Collectors.toList()));
			Stream.of(catprod1, catprod2, catprod3).forEach(categoryProduct -> {
				categoryProductDao.save(categoryProduct);
			});
			Stream.of(p1, p2, p3, p4).forEach(product -> {
				productDao.save(product);
			});
			// category partenaire
			CategoryPartenaire categoryPart1 = new CategoryPartenaire();
			CategoryPartenaire categoryPart2 = new CategoryPartenaire();
			categoryPart1.setCaregory_partenaire_name("epicerie");
			categoryPart2.setCaregory_partenaire_name("epicerie");
            Stream.of(categoryPart1,categoryPart2).forEach(categoryPart->{
            	  categoryPartenaireDao.save(categoryPart);
            });
            categoryPart1.setPartenaires(Stream.of(part1,part2).collect(Collectors.toList()));
            categoryPart2.setPartenaires(Stream.of(part2,part3).collect(Collectors.toList()));
            part1.setCategoryPartenaires(Stream.of(categoryPart1).collect(Collectors.toList()));
            part2.setCategoryPartenaires(Stream.of(categoryPart2,categoryPart1).collect(Collectors.toList()));
            part3.setCategoryPartenaires(Stream.of(categoryPart2).collect(Collectors.toList()));
            Stream.of(part1, part2, part3).forEach(partenaire -> {
				partenaireDao.save(partenaire);
			});
            Stream.of(categoryPart1,categoryPart2).forEach(categoryPart->{
          	  categoryPartenaireDao.save(categoryPart);
          });
		};
	}
}
