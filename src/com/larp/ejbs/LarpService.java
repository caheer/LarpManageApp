package com.larp.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.larp.models.AppUser;
import com.larp.models.Larp;
import com.larp.models.LarpRegistrStatus;

/**
 * Session Bean implementation class LarpService
 */
@Stateless
@LocalBean
public class LarpService {

	@PersistenceContext(unitName = "larp")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public LarpService() {
		// TODO Auto-generated constructor stub
	}

	public void addLarp(Larp l) {
		em.persist(l);
	}

	public void editLarp(Larp l) {
		em.merge(l);
	}

	public void addUserToLarp(String userId, String larpId) {

		CriteriaBuilder builder = em.getCriteriaBuilder();

		CriteriaQuery<AppUser> cqAppUser = builder.createQuery(AppUser.class);

		Root<AppUser> auRoot = cqAppUser.from(AppUser.class);

		cqAppUser.select(auRoot).where(builder.equal(auRoot.get("id").as(Integer.class), userId));

		TypedQuery<AppUser> auQuery = em.createQuery(cqAppUser);

		AppUser au = auQuery.getSingleResult();

		builder = em.getCriteriaBuilder();

		CriteriaQuery<Larp> cqLarp = builder.createQuery(Larp.class);

		Root<Larp> lRoot = cqLarp.from(Larp.class);

		cqLarp.select(lRoot).where(builder.equal(lRoot.get("id").as(Integer.class), larpId));

		TypedQuery<Larp> lQuery = em.createQuery(cqLarp);

		Larp l = lQuery.getSingleResult();

		List<AppUser> auList = l.getLarp_players();

		Integer currentusers = l.getCurrent_participants_no();

		currentusers = ++currentusers;

		l.setCurrent_participants_no(currentusers);

		auList.add(au);

		l.setLarp_players(auList);

		au.getLarps().add(l);

	}

	public void removeUserFromLarp(String userId, String larpId) {

		Integer userId_int = Integer.parseInt(userId);

		AppUser appUser = em.find(AppUser.class, userId_int);

		CriteriaBuilder builder = em.getCriteriaBuilder();

		builder = em.getCriteriaBuilder();

		CriteriaQuery<Larp> cqLarp = builder.createQuery(Larp.class);

		Root<Larp> lRoot = cqLarp.from(Larp.class);

		cqLarp.select(lRoot).where(builder.equal(lRoot.get("id").as(Integer.class), larpId));

		TypedQuery<Larp> lQuery = em.createQuery(cqLarp);

		Larp l = lQuery.getSingleResult();

		List<AppUser> auList = l.getLarp_players();

		Integer currentusers = l.getCurrent_participants_no();

		currentusers = --currentusers;

		l.setCurrent_participants_no(currentusers);

		auList.remove(appUser);

		l.setLarp_players(auList);

		appUser.getLarps().remove(l);

	}

	public List<Larp> getLarps() {

		TypedQuery<Larp> query = em.createQuery("SELECT l FROM Larp l", Larp.class);

		List<Larp> lList = query.getResultList();

		return lList;
	}

	public List<Larp> getActiveLarps() {

		CriteriaBuilder builder = em.getCriteriaBuilder();

		builder = em.getCriteriaBuilder();

		CriteriaQuery<Larp> cqLarp = builder.createQuery(Larp.class);

		Root<Larp> lRoot = cqLarp.from(Larp.class);

		cqLarp.select(lRoot)
				.where(builder.equal(lRoot.get("larp_reg_stat").as(Enum.class), LarpRegistrStatus.Registration_active));

		TypedQuery<Larp> lQuery = em.createQuery(cqLarp);

		List<Larp> lList = lQuery.getResultList();

		return lList;
	}

	public List<AppUser> getUsersInLarp(int larp_id) {

		CriteriaBuilder builder = em.getCriteriaBuilder();

		builder = em.getCriteriaBuilder();

		CriteriaQuery<Larp> cqLarp = builder.createQuery(Larp.class);

		Root<Larp> lRoot = cqLarp.from(Larp.class);

		cqLarp.select(lRoot).where(builder.equal(lRoot.get("id").as(Integer.class), larp_id));

		TypedQuery<Larp> lQuery = em.createQuery(cqLarp);

		Larp l = lQuery.getSingleResult();

		List<AppUser> users_in_larp = l.getLarp_players();

		return users_in_larp;
	}

	public void removeLarp(String larpId) {

		Integer larpId_int = Integer.parseInt(larpId);

		Larp larp = em.find(Larp.class, larpId_int);

		em.remove(larp);

	}

	public Larp getLarp(String larpId) {

		CriteriaBuilder builder = em.getCriteriaBuilder();

		builder = em.getCriteriaBuilder();

		CriteriaQuery<Larp> cqLarp = builder.createQuery(Larp.class);

		Root<Larp> lRoot = cqLarp.from(Larp.class);

		cqLarp.select(lRoot).where(builder.equal(lRoot.get("id").as(Integer.class), larpId));

		TypedQuery<Larp> lQuery = em.createQuery(cqLarp);

		Larp l = lQuery.getSingleResult();

		return l;

	}

}
