package com.jsp.com.jsp.one_to_one_uni_direction.service;

import java.util.List;

import com.jsp.com.jsp.one_to_one_uni_direction.dao.CollegeDao;
import com.jsp.com.jsp.one_to_one_uni_direction.dto.College;

public class CollegeService {

	CollegeDao dao = new CollegeDao();

	// saveCollage method
	public void saveCollege(College college) {
		dao.saveCollege(college);
	}

	// getByCollageId method
	public College getByCollegeId(int collegeId) {
		return dao.getByCollegeId(collegeId);
	}

	// updateCollage method
	public void updateCollegeById(int collegeId, String collegeName, String collegeAddress) {
		College college = dao.getByCollegeId(collegeId);

		if (college != null) {
			dao.updateCollegeById(collegeId, collegeName, collegeAddress);
		} else {
			System.out.println("you have passed invalid collageId");
		}
	}

	// deleteCollage method
	public void deleteCollegeById(int collegeId) {
		College college = dao.getByCollegeId(collegeId);
		if (college != null) {
			dao.deleteCollegeById(collegeId);
		} else {
			System.out.println("collegeId not found in database or already has been deleted");
		}
	}

	// displayCollage method
	public List<College> displayCollege() {
		return dao.displayCollege();
	}
}