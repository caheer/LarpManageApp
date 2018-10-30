package com.larp.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.larp.models.LarpRegistration;

/**
 * Entity implementation class for Entity: Larp
 *
 */
@Entity
public class Larp implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Larp() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String larpTitle;

	@Temporal(TemporalType.TIMESTAMP)
	private Date larpTime;

	private String larpPlace;

	@Column(name = "LARPDESCRIPTION", length = 2048)
	private String larpDescription;

	private Integer max_participants_no;

	private Integer current_participants_no;

	@Enumerated(EnumType.STRING)
	private LarpRegistrStatus larp_reg_stat;

	@OneToMany(mappedBy = "id_larp", cascade = CascadeType.ALL)
	private List<LarpRegistration> gamelarpregistrations;

	@ManyToMany
	@JoinTable(name = "larp_players_join", joinColumns = @JoinColumn(name = "larp_fk"), inverseJoinColumns = @JoinColumn(name = "larp_player_fk"))
	private List<AppUser> larp_players;

	private String larp_authors;

	private String addedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLarpTitle() {
		return larpTitle;
	}

	public void setLarpTitle(String larpTitle) {
		this.larpTitle = larpTitle;
	}

	public Date getLarpTime() {
		return larpTime;
	}

	public void setLarpTime(Date larpTime) {
		this.larpTime = larpTime;
	}

	public String getLarpPlace() {
		return larpPlace;
	}

	public void setLarpPlace(String larpPlace) {
		this.larpPlace = larpPlace;
	}

	public String getLarpDescription() {
		return larpDescription;
	}

	public void setLarpDescription(String larpDescription) {
		this.larpDescription = larpDescription;
	}

	public Integer getMax_participants_no() {
		return max_participants_no;
	}

	public void setMax_participants_no(Integer max_participants_no) {
		this.max_participants_no = max_participants_no;
	}

	public Integer getCurrent_participants_no() {
		return current_participants_no;
	}

	public void setCurrent_participants_no(Integer current_participants_no) {
		this.current_participants_no = current_participants_no;
	}

	public LarpRegistrStatus getLarp_reg_stat() {
		return larp_reg_stat;
	}

	public void setLarp_reg_stat(LarpRegistrStatus larp_reg_stat) {
		this.larp_reg_stat = larp_reg_stat;
	}

	public List<LarpRegistration> getGamelarpregistrations() {
		return gamelarpregistrations;
	}

	public void setGamelarpregistrations(List<LarpRegistration> gamelarpregistrations) {
		this.gamelarpregistrations = gamelarpregistrations;
	}

	public List<AppUser> getLarp_players() {
		return larp_players;
	}

	public void setLarp_players(List<AppUser> larp_players) {
		this.larp_players = larp_players;
	}

	public String getLarp_authors() {
		return larp_authors;
	}

	public void setLarp_authors(String larp_authors) {
		this.larp_authors = larp_authors;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	@Override
	public String toString() {
		return "Larp [id=" + id + ", larpTitle=" + larpTitle + ", larpTime=" + larpTime + ", larpPlace=" + larpPlace
				+ ", id_os_aut=" + ", larpDescription=" + larpDescription + ", max_participants_no="
				+ max_participants_no + ", current_participants_no=" + current_participants_no + ", larp_reg_stat="
				+ larp_reg_stat + ", gamelarpregistrations=" + gamelarpregistrations + ", larp_players=" + larp_players
				+ ", larp_authors=" + larp_authors + ", addedBy=" + addedBy + "]";
	}

}
