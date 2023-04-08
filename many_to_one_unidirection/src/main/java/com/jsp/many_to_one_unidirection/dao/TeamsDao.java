package com.jsp.many_to_one_unidirection.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.many_to_one_unidirection.dto.Competition;
import com.jsp.many_to_one_unidirection.dto.Teams;

public class TeamsDao {
	EntityManager entityManager = Persistence.createEntityManagerFactory("vishesh").createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// insertTeams method
	public void insertTeams(List<Teams> list) {

		for (Teams teams : list) {
			entityTransaction.begin();
			entityManager.persist(teams);
			entityTransaction.commit();
		}
		System.out.println("data saved");
	}

	// searchTeams method
	public Teams searchTeams(int teamId) {
		Teams teams = entityManager.find(Teams.class, teamId);
		return teams;
	}

	// updateTeams method
	public void updateTeams(Teams teams) {
		entityTransaction.begin();
		entityManager.merge(teams);
		entityTransaction.commit();
		System.out.println("data updated");
	}

	/*
	 * here delete method can not delete the competition who are mapped with more
	 * than one teams.beacuse this project has many to one uni direction flow.so
	 * from Competition entity class compailer can not select next Teams which is
	 * mapped with Competition class. so this is limitation of delete method for
	 * many to one uni direction.
	 */
	// deleteTeams method
	public void deleteTeams(int teamId) {
		Teams teams = entityManager.find(Teams.class, teamId);
		entityTransaction.begin();
		entityManager.remove(teams);
		entityTransaction.commit();
		System.out.println("data deleted");
	}

	// displayTeams method
	public List<Teams> displayTeams() {
		String st = "SELECT c FROM Teams c";
		Query query = entityManager.createQuery(st);
		return query.getResultList();
	}

}