package com.jsp.one_to_many_uni_direction.service;

import java.util.List;

import com.jsp.one_to_many_uni_direction.dao.CollageDao;
import com.jsp.one_to_many_uni_direction.dto.Collage;

public class CollageService {

	CollageDao dao = new CollageDao();

	// insertCollage method
	public void insertCollage(Collage collage) {
		dao.insertCollage(collage);
	}

	// searchCollage method
	public Collage searchCollage(int collageId) {
		return dao.searchCollage(collageId);
	}

	// updateCollage method
	public void updateCollage(Collage collage) {
		Collage collage2 = dao.searchCollage(collage.getCollageId());
		if (collage2 != null) {
			dao.updateCollage(collage);
		} else {
			System.out.println("collageId not found please check you have passed");
		}
	}

	// deleteCollage method
	public void deleteCollage(int collageId) {
		Collage collage = dao.searchCollage(collageId);
		if (collage != null) {
			dao.deleteCollage(collageId);
		} else {
			System.out.println("collageId not present or already has been deleted from database");
		}
	}

	// displayCollage method
	public List<Collage> displayCollage() {
		return dao.displayCollage();
	}
}
