package com.larp.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.larp.models.LarpRegistration;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity
public class AppUser implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public AppUser() {
		super();
	}

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String login;

	private String firstName;

	private String lastName;

	private String password;

	private String email;

	private String nickname;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private UserStatus userstatus;

	@OneToMany(mappedBy = "id_user", cascade = CascadeType.ALL)
	private List<LarpRegistration> userlarpregistrations;

	@ManyToMany(mappedBy = "larp_players")
	private List<Larp> larps;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public UserStatus getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(UserStatus userstatus) {
		this.userstatus = userstatus;
	}

	public List<LarpRegistration> getUserlarpregistrations() {
		return userlarpregistrations;
	}

	public void setUserlarpregistrations(List<LarpRegistration> userlarpregistrations) {
		this.userlarpregistrations = userlarpregistrations;
	}

	public List<Larp> getLarps() {
		return larps;
	}

	public void setLarps(List<Larp> larps) {
		this.larps = larps;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", login=" + login + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", email=" + email + ", nickname=" + nickname + ", gender=" + gender
				+ ", userstatus=" + userstatus + ", userlarpregistrations=" + userlarpregistrations + ", larps=" + larps
				+ "]";
	}

}
