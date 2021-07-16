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
			    categories.put("Moto", subCategoryList5);
			    
			    
			    
			    
			    
			    
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
	public Store updateStore(Store store) {
		return storeDao.save(store);
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
}
