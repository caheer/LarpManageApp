package com.larp.ejbs;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.larp.models.AppUser;
import com.larp.models.Larp;
import com.larp.models.LarpRegistration;

/**
 * Session Bean implementation class RegistrationService
 */
@Stateless
@LocalBean
public class RegistrationService {

	@PersistenceContext(unitName = "larp")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public RegistrationService() {
		// TODO Auto-generated constructor stub
	}

	public void addLarpRegistration(String userId, String larpId) {

		LarpRegistration lr = new LarpRegistration();

		Integer larpId_int = Integer.parseInt(larpId);
		Integer userId_int = Integer.parseInt(userId);

		Larp larp = em.find(Larp.class, larpId_int);
		AppUser appuser = em.find(AppUser.class, userId_int);

		java.util.Date date = new java.util.Date();
		Timestamp ts = new Timestamp(date.getTime());

		lr.setId_larp(larp);
		lr.setId_user(appuser);
		lr.setRegistrationTime(ts);

		em.persist(lr);
	}
	
	public void removeLarpRegistration(String registid) {
		
		
		Integer registidvalue = Integer.parseInt(registid);

		LarpRegistration registration = em.find(LarpRegistration.class, registidvalue);

		em.remove(registration);
		
	}


	public List<LarpRegistration> getLarpRegistrations() {

		TypedQuery<LarpRegistration> query = em.createQuery("SELECT lr FROM LarpRegistration lr",
				LarpRegistration.class);

		List<LarpRegistration> lrList = query.getResultList();

		return lrList;
	}

}