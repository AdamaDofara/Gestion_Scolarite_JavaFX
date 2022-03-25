package application;

public class TestEtudiant {
private String matricule;
private String nom;
private String prenom;
private String filiere;
private String niveau;
private Double paye;
private Double restant;


public TestEtudiant(String matricule, String nom, String prenom, String filiere, String niveau, Double paye,
		Double restant) {
	super();
	this.matricule = matricule;
	this.nom = nom;
	this.prenom = prenom;
	this.filiere = filiere;
	this.niveau = niveau;
	this.paye = paye;
	this.restant = restant;
}


public String getMatricule() {
	return matricule;
}


public void setMatricule(String matricule) {
	this.matricule = matricule;
}


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public String getPrenom() {
	return prenom;
}


public void setPrenom(String prenom) {
	this.prenom = prenom;
}


public String getFiliere() {
	return filiere;
}


public void setFiliere(String filiere) {
	this.filiere = filiere;
}


public String getNiveau() {
	return niveau;
}


public void setNiveau(String niveau) {
	this.niveau = niveau;
}


public Double getPaye() {
	return paye;
}


public void setPaye(Double paye) {
	this.paye = paye;
}


public Double getRestant() {
	return restant;
}


public void setRestant(Double restant) {
	this.restant = restant;
}



}
