package com.jsp.one_to_many_uni_direction.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.one_to_many_uni_direction.dto.Branch;
import com.jsp.one_to_many_uni_direction.service.BranchService;

public class BranchController {

	public static void main(String[] args) {

		while (true) {
			Scanner s = new Scanner(System.in);
			BranchService service = new BranchService();
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("Enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				Branch branch = new Branch();
				branch.setBranchId(105);
				branch.setBranchName("ME");
				branch.setBranchBuilding("E-Block");
				service.insertBranch(branch);
			}
				break;

			case 2: {
				System.out.println("enter branchId");
				int branchId = s.nextInt();
				Branch branch = service.searchBranch(branchId);
				if (branch != null) {
					System.out.println("...............Branch_Deatils...................");
					System.out.println("BranchId: " + branch.getBranchId());
					System.out.println("BranchName: " + branch.getBranchName());
					System.out.println("BranchBuilding: " + branch.getBranchBuilding());
				} else {
					System.out.println("please check your branchId you have passed");
				}
			}
				break;

			case 3: {
				Branch branch = new Branch();
				System.out.println("enter branchId: ");
				branch.setBranchId(s.nextInt());
				System.out.println("enter branchName: ");
				String branchName=s.next();
				branchName+=s.nextLine();
				branch.setBranchName(branchName);
				System.out.println("enter buildingName: ");
				branch.setBranchBuilding(s.nextLine());
				service.updateBarnch(branch);
			}
				break;

			case 4: {
				System.out.println("enter branchId");
				int branchId = s.nextInt();
				service.deleteBranch(branchId);
			}
				break;

			case 5: {
				List<Branch> list = service.displayBranch();
				if (list != null) {
					System.out.println("...............Branch_Deatils...................");
					for (Branch branch : list) {
						System.out.println("BranchId: " + branch.getBranchId());
						System.out.println("BranchName: " + branch.getBranchName());
						System.out.println("BranchBuilding: " + branch.getBranchBuilding());
						System.out.println();
					}
				} else {
					System.out.println("table is empty in database");
				}
			}
				break;

			case 6: {
				System.out.println("System closed");
				System.exit(choice);
			}
				break;

			default: {
				System.out.println("invalid choice!!!");
			}
			}
		}
	}
}
