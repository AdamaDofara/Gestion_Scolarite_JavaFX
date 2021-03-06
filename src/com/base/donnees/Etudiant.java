package com.base.donnees;
// Generated 24 mars 2022 ? 09:24:39 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Etudiant generated by hbm2java
 */
@Entity
@Table(name = "etudiant", catalog = "gestion_scolarite_javafx")
public class Etudiant implements java.io.Serializable {

	private String matricule;
	private Filiere filiere;
	private Niveau niveau;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String mail;
	private String genre;
	private Set<Versement> versements = new HashSet<Versement>(0);

	public Etudiant() {
	}

	public Etudiant(String matricule, Filiere filiere, Niveau niveau, String nom, String prenom, Date dateNaissance,
			String mail, String genre) {
		this.matricule = matricule;
		this.filiere = filiere;
		this.niveau = niveau;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mail = mail;
		this.genre = genre;
	}

	public Etudiant(String matricule, Filiere filiere, Niveau niveau, String nom, String prenom, Date dateNaissance,
			String mail, String genre, Set<Versement> versements) {
		this.matricule = matricule;
		this.filiere = filiere;
		this.niveau = niveau;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mail = mail;
		this.genre = genre;
		this.versements = versements;
	}

	@Id

	@Column(name = "matricule", unique = true, nullable = false, length = 50)
	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_filiere", nullable = false)
	public Filiere getFiliere() {
		return this.filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_niveau", nullable = false)
	public Niveau getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	@Column(name = "nom", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false, length = 50)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance", nullable = false, length = 10)
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Column(name = "mail", nullable = false, length = 50)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "genre", nullable = false, length = 50)
	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "etudiant")
	public Set<Versement> getVersements() {
		return this.versements;
	}

	public void setVersements(Set<Versement> versements) {
		this.versements = versements;
	}

}
