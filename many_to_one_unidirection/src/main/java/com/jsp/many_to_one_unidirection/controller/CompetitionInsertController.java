package com.jsp.many_to_one_unidirection.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.jsp.many_to_one_unidirection.dto.Competition;
import com.jsp.many_to_one_unidirection.service.CompetitionService;

public class CompetitionInsertController {

	public static void main(String[] args) {
		while (true) {
			Scanner s = new Scanner(System.in);
			CompetitionService competitionService = new CompetitionService();
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				Competition competition = new Competition();
				System.out.println("enter competitionName: ");
				String competitionName = s.next();
				competitionName += s.nextLine();
				competition.setCompetitionName(competitionName);
				int year = LocalDateTime.now().getYear();
				competition.setCompetitionYear(year);
				System.out.println("enter competitionChairman: ");
				String chairman = s.next();
				chairman += s.nextLine();
				competition.setCompetitionChairman(chairman);
				System.out.println("enter sponsorName: ");
				competition.setSponsorsName(s.nextLine());
				competitionService.saveCompetition(competition);
			}
				break;
			case 2: {
				System.out.println("enter competitionId: ");
				Competition competition = competitionService.searchCompetition(s.nextInt());
				if (competition != null) {
					System.out.println("----------------------competition details-----------------------------");
					System.out.println("competitionId: " + competition.getCompetitionId());
					System.out.println("competitionName: " + competition.getCompetitionName());
					System.out.println("competitionYear: " + competition.getCompetitionYear());
					System.out.println("competitionChairman: " + competition.getCompetitionChairman());
					System.out.println("competitionSponserName: " + competition.getSponsorsName());
				} else {
					System.out.println("entered competitionId not present in database");
				}

			}
				break;

			case 3: {
				Competition competition = new Competition();
				System.out.println("enter competitionId: ");
				int competitionId = s.nextInt();
				competition.setCompetitionId(competitionId);
				System.out.println("enter competitionName: ");
				String competitionName = s.next();
				competitionName += s.nextLine();
				competition.setCompetitionName(competitionName);
				int year = LocalDateTime.now().getYear();
				competition.setCompetitionYear(year);
				System.out.println("enter competitionChairman: ");
				String chairman = s.next();
				chairman += s.nextLine();
				competition.setCompetitionChairman(chairman);
				System.out.println("enter sponsorName: ");
				competition.setSponsorsName(s.nextLine());
				competitionService.updateCompetition(competition);

			}
				break;

			case 4: {
				System.out.println("enter competitionId: ");
				competitionService.deleteCompetition(s.nextInt());

			}
				break;

			case 5: {
				List<Competition> list = competitionService.displayCompetition();
				if (list != null) {
					System.out.println("-----------------------competition details------------------------------");
					for (Competition competition : list) {
						System.out.println("competitionId: " + competition.getCompetitionId());
						System.out.println("competitionName: " + competition.getCompetitionName());
						System.out.println("competitionYear: " + competition.getCompetitionYear());
						System.out.println("competitionChairman: " + competition.getCompetitionChairman());
						System.out.println("competitionSponserName: " + competition.getSponsorsName());
						System.out.println();
					}
				} else {
					System.out.println("table is empty in database");
				}

			}
				break;

			case 6: {
				System.out.println("system closed");
				System.exit(choice);
			}

			default: {
				System.out.println("invalid choice!!!");
			}
			}
		}
	}
}
