package com.jsp.one_to_many_uni_direction.service;

import java.util.List;

import com.jsp.one_to_many_uni_direction.dao.BranchDao;
import com.jsp.one_to_many_uni_direction.dao.CollageDao;
import com.jsp.one_to_many_uni_direction.dto.Branch;
import com.jsp.one_to_many_uni_direction.dto.Collage;

public class BranchService {

	BranchDao dao = new BranchDao();

	// insertBranch method
	public void insertBranch(Branch branch) {
		dao.insertBranch(branch);
	}

	// searchBranch method
	public Branch searchBranch(int branchId) {
		return dao.searchBranch(branchId);
	}

	// updateBranch method
	public void updateBarnch(Branch branch) {
		Branch branch2 = dao.searchBranch(branch.getBranchId());
		if (branch2 != null) {
			dao.updateBarnch(branch);
		} else {
			System.out.println("branchId is not present in database");
		}
	}

	// deleteBranch method
	public void deleteBranch(int branchId) {
		Branch branch = dao.searchBranch(branchId);
		if (branch != null) {
			dao.deleteBranch(branchId);
		} else {
			System.out.println("branchId is not found or already has been deleted");
		}
	}

	// displayBranch method
	public List<Branch> displayBranch() {
		return dao.displayBranch();
	}
}