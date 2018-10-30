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

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService {

	@PersistenceContext(unitName = "larp")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public void addUser(AppUser u) {
		em.persist(u);

	}

	public void editUser(AppUser u) {
		em.merge(u);

	}

	public List<AppUser> getUsers() {

		TypedQuery<AppUser> query = em.createQuery("SELECT u FROM AppUser u", AppUser.class);

		List<AppUser> auList = query.getResultList();

		return auList;
	}

	public void removeUser(String userId) {

		Integer userId_int = Integer.parseInt(userId);

		AppUser appUser = em.find(AppUser.class, userId_int);

		em.remove(appUser);

	}

	public AppUser getUser(String userId) {

		CriteriaBuilder builder = em.getCriteriaBuilder();

		builder = em.getCriteriaBuilder();

		CriteriaQuery<AppUser> cqUser = builder.createQuery(AppUser.class);

		Root<AppUser> uRoot = cqUser.from(AppUser.class);

		cqUser.select(uRoot).where(builder.equal(uRoot.get("id").as(Integer.class), userId));

		TypedQuery<AppUser> uQuery = em.createQuery(cqUser);

		AppUser u = uQuery.getSingleResult();

		return u;

	}

	public List<Larp> getLarpsInUser(int user_id) {

		CriteriaBuilder builder = em.getCriteriaBuilder();

		builder = em.getCriteriaBuilder();

		CriteriaQuery<AppUser> cqAppUser = builder.createQuery(AppUser.class);

		Root<AppUser> auRoot = cqAppUser.from(AppUser.class);

		cqAppUser.select(auRoot).where(builder.equal(auRoot.get("id").as(Integer.class), user_id));

		TypedQuery<AppUser> auQuery = em.createQuery(cqAppUser);

		AppUser u = auQuery.getSingleResult();

		List<Larp> larps_in_users = u.getLarps();

		return larps_in_users;
	}

	public void removeLarpFromUser(String userId, String larpId) {

		Integer larpId_int = Integer.parseInt(larpId);

		Larp larp = em.find(Larp.class, larpId_int);

		CriteriaBuilder builder = em.getCriteriaBuilder();

		builder = em.getCriteriaBuilder();

		CriteriaQuery<AppUser> cqAppUser = builder.createQuery(AppUser.class);

		Root<AppUser> auRoot = cqAppUser.from(AppUser.class);

		cqAppUser.select(auRoot).where(builder.equal(auRoot.get("id").as(Integer.class), userId));

		TypedQuery<AppUser> auQuery = em.createQuery(cqAppUser);

		AppUser u = auQuery.getSingleResult();

		List<Larp> larps_in_users = u.getLarps();

		larps_in_users.remove(larp);

		u.setLarps(larps_in_users);

		larp.getLarp_players().remove(u);

	}

}
