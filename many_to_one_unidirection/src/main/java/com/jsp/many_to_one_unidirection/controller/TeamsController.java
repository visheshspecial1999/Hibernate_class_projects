package com.jsp.many_to_one_unidirection.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.many_to_one_unidirection.dto.Competition;
import com.jsp.many_to_one_unidirection.dto.Teams;
import com.jsp.many_to_one_unidirection.service.TeamsService;

public class TeamsController {

	public static void main(String[] args) {
		while (true) {
			Scanner s = new Scanner(System.in);
			TeamsService service = new TeamsService();
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				Teams teams = new Teams();
				System.out.print("enter teamName: ");
				String teamName = s.next();
				teamName += s.nextLine();
				teams.setTeamName(teamName);
				System.out.println("enter teamCoach: ");
				teams.setTeamCoach(s.nextLine());
				System.out.println("enter teamCaption: ");
				teams.setTeamCaption(s.nextLine());
				System.out.println("enter teamSize: ");
				teams.setTeamSize(s.nextInt());

				Teams teams1 = new Teams();
				System.out.print("enter teamName: ");
				String teamName1 = s.next();
				teamName += s.nextLine();
				teams1.setTeamName(teamName1);
				System.out.println("enter teamCoach: ");
				teams1.setTeamCoach(s.nextLine());
				System.out.println("enter teamCaption: ");
				teams1.setTeamCaption(s.nextLine());
				System.out.println("enter teamSize: ");
				teams1.setTeamSize(s.nextInt());

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

				teams.setCompetition(competition);
				teams1.setCompetition(competition);
				List<Teams> list = new ArrayList<Teams>();
				list.add(teams);
				list.add(teams1);
				service.insertTeams(list);
			}
				break;

			case 2: {
				System.out.println("enter teamId: ");
				int teamId = s.nextInt();
				Teams teams = service.searchTeams(teamId);
				System.out
						.println("...................................teams details...................................");
				if (teams != null) {
					System.out.println("teamId: " + teams.getTeamId());
					System.out.println("teamName: " + teams.getTeamName());
					System.out.println("teamCoach: " + teams.getTeamCoach());
					System.out.println("teamCaption: " + teams.getTeamCaption());
					System.out.println("teamSize: " + teams.getTeamSize());
					System.out.println(
							"..............................competition details...............................");
					System.out.println("competitionId: " + teams.getCompetition().getCompetitionId());
					System.out.println("competitionName: " + teams.getCompetition().getCompetitionName());
					System.out.println("competitionYear" + teams.getCompetition().getCompetitionYear());
					System.out.println("competitionSponsor" + teams.getCompetition().getSponsorsName());
					System.out.println("competitionChairman" + teams.getCompetition().getCompetitionChairman());
				} else {
					System.out.println("invalid teamId please check again...");
				}
			}
				break;

			case 3: {
				System.out.println("enter teamId: ");
				int teamId = s.nextInt();
				service.updateTeams(teamId);
			}
				break;

			case 4: {
				System.out.println("enter teamId: ");
				int teamId = s.nextInt();
				service.deleteTeams(teamId);

			}
				break;

			case 5: {
				List<Teams> list = service.displayTeams();
				if (list != null) {
					for (Teams teams : list) {
						System.out.println(
								"===============================================teams details====================================");
						System.out.println("teamId: " + teams.getTeamId());
						System.out.println("teamName: " + teams.getTeamName());
						System.out.println("teamCoach: " + teams.getTeamCoach());
						System.out.println("teamCaption: " + teams.getTeamCaption());
						System.out.println("teamSize: " + teams.getTeamSize());
						System.out.println(
								"...............................................competition details............................");
						System.out.println("competitionId: " + teams.getCompetition().getCompetitionId());
						System.out.println("competitionName: " + teams.getCompetition().getCompetitionName());
						System.out.println("competitionYear" + teams.getCompetition().getCompetitionYear());
						System.out.println("competitionSponsor" + teams.getCompetition().getSponsorsName());
						System.out.println("competitionChairman" + teams.getCompetition().getCompetitionChairman());
						System.out.println();
					}
				} else {
					System.out.println("table is empty in database");
				}

			}
				break;

			case 6: {
				System.out.println("System closed successfully!!!");
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
