package com.jsp.many_to_one_unidirection.service;

import java.util.List;

import com.jsp.many_to_one_unidirection.dao.CompetitionDao;
import com.jsp.many_to_one_unidirection.dto.Competition;

public class CompetitionService {

	CompetitionDao competitionDao = new CompetitionDao();

	// saveCompetition method
	public void saveCompetition(Competition competition) {
		competitionDao.saveCompetition(competition);
	}

	// searchCompetition method
	public Competition searchCompetition(int competitionId) {
		return competitionDao.searchCompetition(competitionId);
	}

	// updateCompetition method
	public void updateCompetition(Competition competition) {
		Competition competition2 = competitionDao.searchCompetition(competition.getCompetitionId());
		if (competition2 != null) {
			competitionDao.updateCompetition(competition);
		} else {
			System.out.println("you have passed wrong competitionId");
		}
	}

	// deleteCompetition method
	public void deleteCompetition(int competitionId) {
		competitionDao.deleteCompetition(competitionId);
	}

	// displayCompetition method
	public List<Competition> displayCompetition() {
		return competitionDao.displayCompetition();
	}

}
