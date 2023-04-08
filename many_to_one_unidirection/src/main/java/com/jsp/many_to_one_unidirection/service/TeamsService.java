package com.jsp.many_to_one_unidirection.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.jsp.many_to_one_unidirection.dao.TeamsDao;
import com.jsp.many_to_one_unidirection.dto.Competition;
import com.jsp.many_to_one_unidirection.dto.Teams;

public class TeamsService {
	TeamsDao dao = new TeamsDao();
	Scanner s = new Scanner(System.in);

	// insertTeams method
	public void insertTeams(List<Teams> list) {
		dao.insertTeams(list);
	}

	// searchTeams method
	public Teams searchTeams(int teamId) {
		return dao.searchTeams(teamId);
	}

	// updateTeams method
	public void updateTeams(int teamId) {

		Teams teams = dao.searchTeams(teamId);
		if (teams != null) {

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
			int competitionId = teams.getCompetition().getCompetitionId();
			competition.setCompetitionId(competitionId);

			teams.setCompetition(competition);
			dao.updateTeams(teams);

		} else {
			System.out.println("entered teamId is not present in database");
		}
	}

	// deleteTeams method
	public void deleteTeams(int teamId) {
		Teams teams = dao.searchTeams(teamId);
		if (teams != null) {
			dao.deleteTeams(teamId);
		} else {
			System.out.println("teamId is not present in database or already has been deleted");
		}
	}

	// displayTeams method
	public List<Teams> displayTeams() {
		return dao.displayTeams();
	}
}