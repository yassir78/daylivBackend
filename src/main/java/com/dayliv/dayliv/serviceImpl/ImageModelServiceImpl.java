package com.dayliv.dayliv.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.ImageModelDao;
import com.dayliv.dayliv.model.ImageModel;
import com.dayliv.dayliv.service.ImageModelService;

@Service
public class ImageModelServiceImpl implements ImageModelService {
	@Autowired
	private ImageModelDao imageModelDao;

	@Override
	public ImageModel save(ImageModel imageModel) {
		// TODO Auto-generated method stub
		return imageModelDao.save(imageModel);
	}

}
