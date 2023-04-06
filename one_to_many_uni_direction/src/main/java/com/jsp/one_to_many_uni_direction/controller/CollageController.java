package com.jsp.one_to_many_uni_direction.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.one_to_many_uni_direction.dto.Branch;
import com.jsp.one_to_many_uni_direction.dto.Collage;
import com.jsp.one_to_many_uni_direction.service.CollageService;

public class CollageController {

	public static void main(String[] args) {
		while (true) {
			Scanner s = new Scanner(System.in);
			CollageService service = new CollageService();
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {

			case 1: {
				Collage collage = new Collage();
				collage.setCollageId(114);
				collage.setCollageName("BBEC LUCKNOW");
				collage.setCollageType("Engineering");
				collage.setCollageAddress("Faizabad Road Lucknow");

				Branch branch = new Branch();
				branch.setBranchId(112);
				branch.setBranchName("CSE");
				branch.setBranchBuilding("F-Block");

				Branch branch2 = new Branch();
				branch2.setBranchId(113);
				branch2.setBranchName("Information-Technology");
				branch2.setBranchBuilding("G-Block");
				List<Branch> list = new ArrayList<Branch>();
				list.add(branch);
				list.add(branch2);
				collage.setBranchs(list);
				service.insertCollage(collage);
			}
				break;

			case 2: {
				System.out.println("enter branchId: ");
				int branchId = s.nextInt();
				Collage collage = service.searchCollage(branchId);
				if (collage != null) {
					System.out.println(".............collage-details..................");
					System.out.println("collageId: " + collage.getCollageId());
					System.out.println("collageName: " + collage.getCollageName());
					System.out.println("collageType: " + collage.getCollageType());
					System.out.println("collageAddress: " + collage.getCollageAddress());
					List<Branch> list = collage.getBranchs();
					System.out.println("...............branch-details..................");
					for (Branch branch : list) {
						System.out.println("branchId: " + branch.getBranchId());
						System.out.println("branchName: " + branch.getBranchName());
						System.out.println("branchBuilding: " + branch.getBranchBuilding());
						System.out.println();
					}
				} else {
					System.out.println("hey please check  collageId you have passed");
				}
			}
				break;

			case 3: {
				Collage collage = new Collage();
				System.out.println("enter collageId: ");
				collage.setCollageId(s.nextInt());
				System.out.println("enter collageName");
				String collageName = s.next();
				collageName += s.nextLine();
				collage.setCollageName(collageName);
				System.out.println("enter collageType");
				collage.setCollageType(s.nextLine());
				System.out.println("enter collageAddress");
				collage.setCollageAddress(s.nextLine());

				Branch branch = new Branch();
				System.out.println("enter branchId");
				int branchId = s.nextInt();
				branch.setBranchId(branchId);
				System.out.println("enter branchName: ");
				String branchName = s.next();
				branchName += s.nextLine();
				branch.setBranchName(branchName);
				System.out.println("enter branchBuilding: ");
				branch.setBranchBuilding(s.nextLine());
				List<Branch> list = new ArrayList<Branch>();
				list.add(branch);
				collage.setBranchs(list);
				service.updateCollage(collage);
			}
				break;

			case 4: {
				System.out.println("enter collageId: ");
				service.deleteCollage(s.nextInt());
			}
				break;

			case 5: {
				List<Collage> list = service.displayCollage();
				if (list != null) {
					System.out.println(".....................collage-details....................");
					for (Collage collage : list) {
						System.out.println("collageId: " + collage.getCollageId());
						System.out.println("collageName: " + collage.getCollageName());
						System.out.println("collageType: " + collage.getCollageType());
						System.out.println("collageAddress: " + collage.getCollageAddress());

						List<Branch> list1 = collage.getBranchs();
						System.out.println("...................branch-details......................");
						for (Branch branch : list1) {
							System.out.println("branchId: " + branch.getBranchId());
							System.out.println("branchName: " + branch.getBranchName());
							System.out.println("branchBuilding: " + branch.getBranchBuilding());
							System.out.println();
						}
					}
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
