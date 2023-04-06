package com.jsp.com.jsp.one_to_one_uni_direction.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.com.jsp.one_to_one_uni_direction.dto.College;
import com.jsp.com.jsp.one_to_one_uni_direction.service.CollegeService;

public class CollegeController {

	public static void main(String[] args) {
		while (true) {
			CollegeService collegeService = new CollegeService();
			Scanner scanner = new Scanner(System.in);

			System.out.println("1.Insert\n2.Search\n3.Delete\n4.Update\n5.Display\n6.Exit");
			System.out.print("enter your choice: ");
			int choice = scanner.nextInt();
			switch (choice) {

			case 1: {
				College college = new College();

				System.out.println("Enter the collegeId");

				college.setCollegeId(scanner.nextInt());

				System.out.println("Enter the collegeName");

				college.setCollegeName(scanner.next());

				System.out.println("Enter the collegeAddress");

				college.setCollegeAddress(scanner.next());

				System.out.println("Enter the collegeType");

				college.setCollegeType(scanner.next());

				collegeService.saveCollege(college);
			}
				break;

			case 2: {
				College college1 = collegeService.getByCollegeId(scanner.nextInt());

				if (college1 != null) {
					System.out.println("collegeId = " + college1.getCollegeId());
					System.out.println("collegeAddress = " + college1.getCollegeAddress());
					System.out.println("collegeName = " + college1.getCollegeName());
					System.out.println("collegeType = " + college1.getCollegeType());
				} else {
					System.out.println("please check collageId you have passed");
				}
			}
				break;
			case 3: {
				System.out.println("Enter the collegeId to delete Data");

				collegeService.deleteCollegeById(scanner.nextInt());
			}
				break;
			case 4: {
				System.out.println("Enter the collegeId");

				int id = scanner.nextInt();

				System.out.println("Enter the collegeName");

				String name = scanner.next();

				name += scanner.nextLine();

				System.out.println("Enter the collegeAddress");

				String address = scanner.next();

				collegeService.updateCollegeById(id, name, address);

			}
				break;
			case 5: {
				List<College> colleges = collegeService.displayCollege();
				System.out.println("-----------------------collage Details--------------------------");
				for (College college2 : collegeService.displayCollege()) {
					System.out.println("collageId:" + college2.getCollegeId());
					System.out.println("collageName:" + college2.getCollegeName());
					System.out.println("collageAddress:" + college2.getCollegeAddress());
					System.out.println("collageType:" + college2.getCollegeType());
					System.out.println("..............................................................");

				}
			}
				break;
			case 6: {
				System.out.println("system closed successfully...");
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