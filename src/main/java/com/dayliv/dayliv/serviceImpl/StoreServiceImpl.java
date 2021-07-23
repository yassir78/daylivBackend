package com.dayliv.dayliv.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.CategoryProductDao;
import com.dayliv.dayliv.dao.StoreDao;
import com.dayliv.dayliv.dao.SubCategoryDao;
import com.dayliv.dayliv.model.CategoryProduct;
import com.dayliv.dayliv.model.CategoryStore;
import com.dayliv.dayliv.model.Store;
import com.dayliv.dayliv.model.SubCategory;
import com.dayliv.dayliv.service.StoreService;
@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
   private StoreDao  storeDao;
   @Autowired
   private CategoryProductDao categoryProductDao;
   @Autowired
   private SubCategoryDao subCategoryDao;
	@Override
	public List<Store> findAll() {
		return storeDao.findAll();
	}

	@Override
	public Store createStore(Store store) {
		
		Store myStore = storeDao.save(store);
	     if(myStore != null) {
	    	 Map<String, Collection<String>> categories = new HashMap<>();			
				
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
			    
			    List <String> subCategoryList4 = new ArrayList<>();
			    subCategoryList4.add("Pneus");
			    subCategoryList4.add("Équipements auto");

			    subCategoryList4.add("Audio, son");

			    subCategoryList4.add("Navigation, GPS");

			    subCategoryList4.add("Transport et voyage");

			    subCategoryList4.add("Pièces auto");

			    subCategoryList4.add("Huiles et liquides de fonctionnemen");
			    subCategoryList4.add("Entretien et nettoyage");

			    subCategoryList4.add("Batteries voiture");

			    subCategoryList4.add("Accessoires auto");
			    categories.put("Auto", subCategoryList4);
               
			    List <String> subCategoryList5 = new ArrayList<>();
			    subCategoryList5.add("Pneus et accessoires pneus");
			    subCategoryList5.add("Casques moto");
			    subCategoryList5.add("Navigation, GPS");
			    subCategoryList5.add("Équipements motard");
			    subCategoryList5.add("Accessoires moto");
			    subCategoryList5.add("Pièces moto");
			    subCategoryList5.add("Huiles et lubrifiants");
			    subCategoryList5.add("Entretien et nettoyage");
			    subCategoryList5.add("Transport et voyage");
			    subCategoryList5.add("Audio, son");

			    categories.put("Moto", subCategoryList5);
			    
			    List <String> subCategoryList6 = new ArrayList<>();
			    subCategoryList6.add("Médicaments");
			    subCategoryList6.add("Rhume");
			    subCategoryList6.add("Douleurs");
			    subCategoryList6.add("Prévention");
			    subCategoryList6.add("Soin peau, cheveux");
			    subCategoryList6.add("Digestion");
			    subCategoryList6.add("Oreilles et yeux");
			    subCategoryList6.add("Soin visage");
			    subCategoryList6.add("Hygiène intime");
			    subCategoryList6.add("Parfums hommes");
			    subCategoryList6.add("Parfums femmes");
			    subCategoryList6.add("Parfums enfants");
			    subCategoryList6.add("Eau de parfum");
			    subCategoryList6.add("Crème solaire");
			    subCategoryList6.add("Nutrition, régime alimentaire");
			    subCategoryList6.add("Bandage divers");
			    subCategoryList6.add("Mère et bébé");
			    subCategoryList6.add("Remède naturel");
			    subCategoryList6.add("Orthopédie");
			    subCategoryList6.add("Entretien textile");
			    subCategoryList6.add("Masques et désinfectants");
                categories.put("Santé", subCategoryList6);
                
			    List <String> subCategoryList7 = new ArrayList<>();
			    
			    subCategoryList7.add("Vestes");
			    subCategoryList7.add("Doudounes");
			    subCategoryList7.add("T-shirts, débardeurs");
			    subCategoryList7.add("Pulls, sweat-shirts");
			    subCategoryList7.add("Bas techniques, thermiques");
			    subCategoryList7.add("Pantalons");
			    subCategoryList7.add("Joggings");
			    subCategoryList7.add("Shorts");
			    subCategoryList7.add("Collants");
			    subCategoryList7.add("Vêtements de pluie");
			    subCategoryList7.add("Maillots de bains");
			    subCategoryList7.add("Chaussettes");
			    subCategoryList7.add("Sous-vêtements");
			    subCategoryList7.add("Sneakers");
			    subCategoryList7.add("Semelles");
			    subCategoryList7.add("Accessoires fitness");
			    subCategoryList7.add("Nutrition sportive");
			    subCategoryList7.add("Drône et hoverboard");
			    subCategoryList7.add("Vélo");
			    subCategoryList7.add("Casques");
			    subCategoryList7.add("Rollers, patins");
			    subCategoryList7.add("Skateboards");
			    subCategoryList7.add("Chaussures de courses");
			    subCategoryList7.add("Chaussures outdoors, randonnée, trek");
			    subCategoryList7.add("Chaussures de football");
			    subCategoryList7.add("Chaussures de vélo");
			    subCategoryList7.add("Chaussures de ski de piste, de fond, snowboard");
			    subCategoryList7.add("Chaussures de fitne");
			    subCategoryList7.add("Chaussures de tennis");
			    subCategoryList7.add("Chaussures d’hiver");
			    subCategoryList7.add("Camping");
                
			    subCategoryList7.add("Skis et snowboards");
			    subCategoryList7.add("Chasse et pêche");
			    subCategoryList7.add("Outdoor");
			    subCategoryList7.add("Running et trail");
			    subCategoryList7.add("Fitness, musculation");
			    subCategoryList7.add("Basketball");
			    subCategoryList7.add("Boxe");
			    subCategoryList7.add("Hockey");
			    subCategoryList7.add("Natation");
			    subCategoryList7.add("Paddle");
			    subCategoryList7.add("Ping-pong");
			    subCategoryList7.add("Trottinette et trottinette électrique");
			    subCategoryList7.add("Volley-ball'");

			    categories.put("Sport",subCategoryList7);
 
			    List <String> subCategoryList8 = new ArrayList<>();

			    subCategoryList8.add("Maquillage");
			    subCategoryList8.add("Soin du visage");
			    subCategoryList8.add("Soin de corps");
			    subCategoryList8.add("Soin capillaires");
			    subCategoryList8.add("Coffrets et sets ");
			    subCategoryList8.add("Parfums femme");
			    subCategoryList8.add("Parfums homme");
			    subCategoryList8.add("Parfum enfants");
			    subCategoryList8.add("Manucure, pédicure");
			    subCategoryList8.add("Hygiène");
			    subCategoryList8.add("Cheveux");
			    subCategoryList8.add("Accessoires");
			    subCategoryList8.add("Marques");
			   
			    categories.put("Beauté et soins",subCategoryList8);
			    
			    List <String> subCategoryList9 = new ArrayList<>();
			    
			    subCategoryList9.add("Nourriture chiens");
			    subCategoryList9.add("Jouets chiens");
			    subCategoryList9.add("Vêtements chiens");
			    subCategoryList9.add("Accessoires chiens");
			    subCategoryList9.add("Lits, corbeilles, niches chiens");
			    subCategoryList9.add("Laisses, colliers, harnais chiens");
			    subCategoryList9.add("Sacs de transport chiens");
			    subCategoryList9.add("Hygiène chiens");
			    subCategoryList9.add("Nourriture chats");
			    subCategoryList9.add("Jouets chats");
			    subCategoryList9.add("Vêtements chats");
			    subCategoryList9.add("Accessoires chats");
			    subCategoryList9.add("Lits, corbeilles, niches chats");
			    subCategoryList9.add("Laisses, colliers, harnais chats");
			    subCategoryList9.add("Sacs de transport chats");
			    subCategoryList9.add("Hygiène chats");
			    subCategoryList9.add("Nourriture rongeurs");
			    subCategoryList9.add("Jouets, aires de jeu rongeurs");
			    subCategoryList9.add("Habitas rongeurs");
			    subCategoryList9.add("Litières rongeurs");
			    subCategoryList9.add("Gamelles rongeurs");
			    subCategoryList9.add("Accessoires rongeurs");
			    subCategoryList9.add("Transport rongeurs");
			    subCategoryList9.add("Nourriture poissons");
			    subCategoryList9.add("Aquariums et meubles poissons");
			    subCategoryList9.add("Materiel aquariophilie");
			    subCategoryList9.add("Décoration aquariums");
			    subCategoryList9.add("Traitements, médicaments poissons");
			    subCategoryList9.add("Nourriture reptiles");
			    subCategoryList9.add("Logements reptiles");
			    subCategoryList9.add("Décorations, aménagements reptiles");
			    subCategoryList9.add("Materiels terraristique");
			    subCategoryList9.add("Soins et médicaments reptiles");
			    subCategoryList9.add("Nourriture oiseaux");
			    subCategoryList9.add("Habitats oiseaux");
			    subCategoryList9.add("Jouets oiseaux");

			    subCategoryList9.add("Accessoires oiseaux");
			    categories.put("Animaux",subCategoryList9);
			    
			    
			    
			    List <String> subCategoryList10 = new ArrayList<>();

			    subCategoryList10.add("Siege-auto");
			    subCategoryList10.add("Poussettes");
			    subCategoryList10.add("Nacelles");
			    subCategoryList10.add("Porte-bébé");
			    subCategoryList10.add("Chambre bébé");
			    subCategoryList10.add("Literie bébé");
			    subCategoryList10.add("Gigoteuses");
			    subCategoryList10.add("Assises bébé");
			    subCategoryList10.add("Baignoires bébé");
			    subCategoryList10.add("Sacs à langer");
			    subCategoryList10.add("Biberons");
			    subCategoryList10.add("Robots cuisine");
			    subCategoryList10.add("Chaises haute");
			    subCategoryList10.add("Transats");
			    subCategoryList10.add("Tapis d’éveil");
			    subCategoryList10.add("Babyphone");
			    subCategoryList10.add("Jouets pour enfants");
			    subCategoryList10.add("Jouets pour bébé");
			    subCategoryList10.add("Livres enfants");
			    subCategoryList10.add("Déguisements et maquillages");
			    subCategoryList10.add("Prêt-à porter bébé");

			    categories.put("Bébé Enfants",subCategoryList9);
			    
			    
			    List <String> subCategoryList11 = new ArrayList<>();
			    subCategoryList11.add("TV, projecteurs");
			    subCategoryList11.add("Montres connectées");
			    subCategoryList11.add("Consoles de jeux, jeux");
			    subCategoryList11.add("Webcams");
			    subCategoryList11.add("Home Cinéma, barres de son");
			    subCategoryList11.add("Radios, chaines hif");
			    subCategoryList11.add("Tablettes");
			    subCategoryList11.add("Rétroprojecteurs");
			    subCategoryList11.add("Smartphones");
			    subCategoryList11.add("Iphones");
			    subCategoryList11.add("Casques et écouteurs");
			    subCategoryList11.add("Accessoires multimédia");
			    subCategoryList11.add("Ordinateurs portables");
			    subCategoryList11.add("Ordinateurs bureau");
			    subCategoryList11.add("Son");
			    subCategoryList11.add("Appareils photos");
			    subCategoryList11.add("Imprimantes, cartouches");
			    subCategoryList11.add("Téléphones fixes");

			    categories.put("Multimédia / Téléphonie",subCategoryList11);

			    List <String> subCategoryList12 = new ArrayList<>();
			    subCategoryList12.add("Littérature");
			    subCategoryList12.add("Livres pour enfants");
			    subCategoryList12.add("Livres scolaires");
			    subCategoryList12.add("Livres universitaires");
			    subCategoryList12.add("BD Humour");
			    subCategoryList12.add("Loisirs, vie pratique");
			    subCategoryList12.add("Sciences humaines");
			    subCategoryList12.add("Livres de voyage");
			    subCategoryList12.add("Livres de méditation, spiritualité");
			    subCategoryList12.add("Bien-être");
			    subCategoryList12.add("Ebooks");
			    subCategoryList12.add("Beaux Arts");
			    subCategoryList12.add("Création de bijoux");
			    subCategoryList12.add("Loisirs enfants");
			    subCategoryList12.add("Mercerie");
			    subCategoryList12.add("Poterie, modelage, moulage");
			    subCategoryList12.add("Scrapbooking");
			    subCategoryList12.add("Coloriages, feutres");
			    subCategoryList12.add("Organiser : classeur, pochettes, trieurs");
			    subCategoryList12.add("Ecrire : stylos, stylos à plume, surligneurs, os à plume, surligneurs ");
			    subCategoryList12.add("Créer : ciseaux, compas, rapporteurs");
			    subCategoryList12.add("Trousses, agendas");
			    
			    categories.put("Librairie / Papeterie",subCategoryList12);

			    List <String> subCategoryList13 = new ArrayList<>();
			    subCategoryList13.add("Instruments de musique");
			    subCategoryList13.add("Partitions");
			    subCategoryList13.add("CDs, DVDs, BluRays, cassettes");
			    subCategoryList13.add("Jeux de société, cartes");
			    subCategoryList13.add("Puzzles, jeux de construction");
			    subCategoryList13.add("Consoles de jeux");
			    subCategoryList13.add("Jeux vidéos");
			    subCategoryList13.add("Déguisements, animations");
               categories.put("Divertissements",subCategoryList13);
               
           
			    List <String> subCategoryList14 = new ArrayList<>();
			    subCategoryList14.add("Tapis, paillasson, revêtement sols");
			    subCategoryList14.add("Meubles salon, séjour");
			    subCategoryList14.add("Meubles de salle de bain, sanitaires");
			    subCategoryList14.add("Literie, coussins, housses");
			    subCategoryList14.add("Jardin et mobiliers extérieur");
			    subCategoryList14.add("Cuisine");
			    subCategoryList14.add("Art de la table");
			    subCategoryList14.add("Rangements, dressing");
			    subCategoryList14.add("Accessoires rangements");
			    subCategoryList14.add("Meubles d’appoint");
			    subCategoryList14.add("Luminaire");
			    subCategoryList14.add("Décoration");
			    subCategoryList14.add("Peinture, droguerie");
			    subCategoryList14.add("Chambre");
			    subCategoryList14.add("Accessoires salles de bain");
                categories.put("Maison / Déco",subCategoryList14);
                
                
			    List <String> subCategoryList15 = new ArrayList<>();
			    subCategoryList15.add("Electricité, domotique");
			    subCategoryList15.add("Plomberie");
			    subCategoryList15.add("Outillage");
			    subCategoryList15.add("Quincaillerie");
			    subCategoryList15.add("Matériaux, gros oeuvres");
			    subCategoryList15.add("Cuisine");
			    subCategoryList15.add("Salle de bains, WC, sanitaires");
			    subCategoryList15.add("Chauffage, climatisation, ventilation");
			    subCategoryList15.add("Menuiserie extérieure");
			    subCategoryList15.add("Revêtement mural, peinture, faïence");
			    subCategoryList15.add("Revêtement sol, carrelage, moquette, parquet");
			    subCategoryList15.add("Entretien du jardin");
	

			    categories.put("Bricolage",subCategoryList15);
			    
			    List <String> subCategoryList16 = new ArrayList<>();
			    subCategoryList16.add("Boulangerie - Patisserie");
			    subCategoryList16.add("Baguettes");
			    subCategoryList16.add("Pains complet");
			    subCategoryList16.add("Pains aux céréales");
			    categories.put("Boulangerie - Patisserie",subCategoryList16);
			   
			    List <String> subCategoryList17 = new ArrayList<>();

			    subCategoryList17.add("Steaks");
			    subCategoryList17.add("Biftecks");
			    subCategoryList17.add("Faux-filets");
			    categories.put("Boucherie - Charcuterie",subCategoryList17);

			    List <String> subCategoryList18 = new ArrayList<>();

			    subCategoryList18.add("Chocolaterie");
			    subCategoryList18.add("Création");
			    subCategoryList18.add("Tablettes de chocolat");
			    subCategoryList18.add("Confiserie");
			    categories.put("Chocolaterie",subCategoryList18);
			    
			    
			    List <String> subCategoryList19 = new ArrayList<>();
			    
			    subCategoryList19.add("Brebis");
			    subCategoryList19.add("Tommes");
			    subCategoryList19.add("Fetas");
			    subCategoryList19.add("Coeurs de Neufchâtel");
			    subCategoryList19.add("Buchettes");
			    subCategoryList19.add("Raclettes");
			    subCategoryList19.add("Fondues");
			    subCategoryList19.add("Camembert");
			    subCategoryList19.add("Crème laitière");
			    subCategoryList19.add("Crême crue");
			    subCategoryList19.add("Gruyère");
			    subCategoryList19.add("Comté");
			    subCategoryList19.add("Mimolettes");
			    subCategoryList19.add("Saint-Nectaire");
			    subCategoryList19.add("Reblochon");
			    subCategoryList19.add("Roquefort");
			    subCategoryList19.add("Oeufs frais");
			    subCategoryList19.add("Yaourts");
			    subCategoryList19.add("Beurres");
			    categories.put("Fromagerie - Crémerie",subCategoryList19);
			    
			    List <String> subCategoryList20 = new ArrayList<>();
			    subCategoryList20.add("Pantalons");
			    subCategoryList20.add("Jeans");
			    subCategoryList20.add("Robes");
			    subCategoryList20.add("Jupes");
			    subCategoryList20.add("Tops, t-shirts");
			    subCategoryList20.add("Vestes, blousons");
			    subCategoryList20.add("Pulls, gilets");
			    subCategoryList20.add("Manteaux, trenchs");
			    subCategoryList20.add("Tailleurs");
			    subCategoryList20.add("Maillots de bain");
			    subCategoryList20.add("Lingerie");
			    subCategoryList20.add("Chemises");
			    subCategoryList20.add("Chapeaux, casquette");
			    subCategoryList20.add("Shorts, corsaires");

			    categories.put("Prêt-à-porter Femme",subCategoryList20);
			    
			    List <String> subCategoryList21 = new ArrayList<>();
			    subCategoryList21.add("T-shirts, chemisiers fille");
			    subCategoryList21.add("Shorts fille");
			    subCategoryList21.add("Robes fille");
			    subCategoryList21.add("Pantalons, jeans fille");
			    subCategoryList21.add("Pulls, gilets fille");
			    subCategoryList21.add("Manteaux fille");
			    subCategoryList21.add("Accessoires fille");
			    subCategoryList21.add("T-shirts, polos, chemise garçon");
			    subCategoryList21.add("Pulls, sweats garçon");
			    subCategoryList21.add("Pantalons, jeans garçon");
			    subCategoryList21.add("Bermudas, shorts garçon");
			    subCategoryList21.add("Manteaux garçon");
			    subCategoryList21.add("Accessoires garçon");
			    categories.put("Prêt-à-porter Enfant",subCategoryList21);

			    List <String> subCategoryList22 = new ArrayList<>();
			    subCategoryList22.add("Manteaux, Doudounes");
			    subCategoryList22.add("Blousons, vestes");
			    subCategoryList22.add("Pulls, cardigans");
			    subCategoryList22.add("Sweats-shirt");
			    subCategoryList22.add("T-shirts, polos");
			    subCategoryList22.add("Costumes");
			    subCategoryList22.add("Casquettes, bonnets");
			    subCategoryList22.add("Maillots de bains");
			    subCategoryList22.add("Shorts, bermudas");
			    subCategoryList22.add("Petite maroquinerie");
             categories.put("Prêt-à-porter Homme",subCategoryList22);
             
             
			    List <String> subCategoryList23 = new ArrayList<>();
			    subCategoryList23.add("Sneakers");
			    subCategoryList23.add("Bottines");
			    subCategoryList23.add("Derby, Richelieus");
			    subCategoryList23.add("Mocassins");
			    subCategoryList23.add("Sandales");
			    subCategoryList23.add("Espadrilles");
			    subCategoryList23.add("Chaussons");
		
	             categories.put("Chaussures/Sneakers/Homme",subCategoryList23);

				    List <String> subCategoryList24 = new ArrayList<>();
				    
				    subCategoryList24.add("Sneakers");
				    subCategoryList24.add("Bottines, bottes, cuissardes");
				    subCategoryList24.add("Escarpins");
				    subCategoryList24.add("Derby, Richelieus");
				    subCategoryList24.add("Mocassins");
				    subCategoryList24.add("Sandales");
				    subCategoryList24.add("Espadrilles");
				    subCategoryList24.add("Chaussons");
	              categories.put("Chaussures/Sneakers/Femme",subCategoryList24);

				    List <String> subCategoryList25 = new ArrayList<>();
				    subCategoryList25.add("Sacs");
				    subCategoryList25.add("Petite maroquinerie");
				    subCategoryList25.add("Bagagerie");
				    subCategoryList25.add("Ceintures");
				    subCategoryList25.add("Echarpes, foulards, châles");
				    subCategoryList25.add("Lunettes de soleil, de vue");
				    subCategoryList25.add("Porte-clés");
				    subCategoryList25.add("Accessoires hi-tech");
				    subCategoryList25.add("Cravates, noeuds de papillon");
	              categories.put("Accessoires",subCategoryList25);

				    List <String> subCategoryList26 = new ArrayList<>();
				    subCategoryList26.add("Bagues");
				    subCategoryList26.add("Boucles d’oreilles");
				    subCategoryList26.add("Colliers");
				    subCategoryList26.add("Bracelets");
				    subCategoryList26.add("Pendentifs");
				    subCategoryList26.add("Chaines de cheville");
				    subCategoryList26.add("Piercings");
				    subCategoryList26.add("Montres de sport");
				    subCategoryList26.add("Montres vintage");
				    subCategoryList26.add("Montres squelettes");
				    subCategoryList26.add("Montres chronographes");
				    subCategoryList26.add("Montres à gousset");
				    subCategoryList26.add("Montres classiques");
				    subCategoryList26.add("Montres originales");

		              categories.put("Bijoux / Montres",subCategoryList26);

                         categories.entrySet().stream().parallel().forEach(e->{
			    	CategoryProduct catProduct = new CategoryProduct();
			    	catProduct.setCategorie(e.getKey());
			    	catProduct.setStoreCode(myStore.getCode());
					categoryProductDao.save(catProduct);
					
					e.getValue().forEach(val -> {
						SubCategory subCat = new SubCategory();
						subCat.setSousCategorie(val);
						subCat.setStoreCode(myStore.getCode());
						subCat.setCategoryProduct(catProduct);
						subCategoryDao.save(subCat);
			    });
					
			    });


			    
			    
	     }
				
		return myStore;
	}

	@Override
	public Store updateStore(long id, Store store) {
		Store myStore =  storeDao.findById(id).get();
		 if(store.getName() != null) {
			 myStore.setName(store.getName());
		 }
		 if(store.getAddress()!=null) {
			 myStore.setAddress(store.getAddress());
		 }
		 
		 if(store.getCode() != null) {
			 myStore.setCode(store.getCode());
		 }
			 
		 if(store.getEmail() != null) {
			 myStore.setEmail(store.getEmail());
		 }
		 if(store.getCodePostal() != null) {
			 myStore.setCodePostal(store.getCodePostal());
		 }
		if(store.getLat() !=  0) {
			myStore.setLat(store.getLat());
		}
		
		if(store.getLg() != 0) {
			myStore.setLg(store.getLg());
		}
		if(store.getLogo() != null) {
			myStore.setLogo(store.getLogo());
		}
		if(store.getDescription() != null)
		{
			myStore.setDescription(store.getDescription());
		}
		
		if(store.getCurrency() != null) {
			myStore.setCurrency(store.getCurrency());
		}
		
		if(store.getDefaultLanguage() !=null) {
			myStore.setDefaultLanguage(store.getDefaultLanguage());
		}
		return storeDao.save(myStore);
	}

	@Override
	public void deleteStore(Long id) {
	 storeDao.deleteById(id);
	}

	@Override
	public Store findById(Long id) {
		return storeDao.findById(id).get();
	}

	@Override
	public Store findByCode(String code) {
		return storeDao.findByCode(code);
	}

	@Override
	public Map<String, Object> getAllStores(String name, int page, int size) {
		 List<Store> stores = new ArrayList<Store>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Store> pagecats;
	      if (name == null)
	    	  pagecats = storeDao.findAll(paging);
	      else
	    	  pagecats = storeDao.findByNameContaining(name, paging);

	      stores = pagecats.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("stores", stores);
	      response.put("currentPage", pagecats.getNumber());
	      response.put("totalItems", pagecats.getTotalElements());
	      response.put("totalPages", pagecats.getTotalPages());

		return response;

	}
	
			public String findAddressByCode(String code) {
				// TODO Auto-generated method stub$
				Store store = storeDao.findByCode(code);
				if(store != null && !store.getAddress().equals("")) {
					return store.getAddress();
				}
				return "";
	}

			@Override
			public List<Store> findAllByCategoryStoreLink(String link) {
				return storeDao.findAllByCategoryStoreLink(link);
			}
}
