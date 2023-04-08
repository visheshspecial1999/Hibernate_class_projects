package com.jsp.many_to_one_unidirection.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.many_to_one_unidirection.dto.Competition;

public class CompetitionDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// saveCompetition method
	public void saveCompetition(Competition competition) {
		entityTransaction.begin();
		entityManager.persist(competition);
		entityTransaction.commit();
		System.out.println("data saved");
	}

	// searchCompetition method
	public Competition searchCompetition(int competitionId) {
		Competition competition = entityManager.find(Competition.class, competitionId);
		return competition;
	}

	// updateCompetition method
	public void updateCompetition(Competition competition) {
		entityTransaction.begin();
		entityManager.merge(competition);
		entityTransaction.commit();
		System.out.println("data updated");
	}

	// deleteCompetition method
	public void deleteCompetition(int competitionId) {
		Competition competition = entityManager.find(Competition.class, competitionId);
		if (competition != null) {
			entityTransaction.begin();
			entityManager.remove(competition);
			entityTransaction.commit();
			System.out.println("data deleted");
		} else {
			System.out.println("competitionId not found in database.please check again...");
		}
	}

	// displayCompetition method
	public List<Competition> displayCompetition() {
		String st = "select c from Competition c";
		Query query = entityManager.createQuery(st);
		return query.getResultList();
	}

}
