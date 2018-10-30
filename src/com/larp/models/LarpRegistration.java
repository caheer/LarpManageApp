package com.larp.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: LarpRegistration
 *
 */
@Entity

public class LarpRegistration implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public LarpRegistration() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_fk")
	private AppUser id_user;

	@ManyToOne
	@JoinColumn(name = "larp_fk")
	private Larp id_larp;

	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public AppUser getId_user() {
		return id_user;
	}

	public void setId_user(AppUser id_user) {
		this.id_user = id_user;
	}

	public Larp getId_larp() {
		return id_larp;
	}

	public void setId_larp(Larp id_larp) {
		this.id_larp = id_larp;
	}

	@Override
	public String toString() {
		return "LarpRegistration [id=" + id + ", id_user=" + id_user + ", id_larp=" + id_larp + ", registrationTime="
				+ registrationTime + "]";
	}

}
