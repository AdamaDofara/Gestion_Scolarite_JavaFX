package com.gestion.dao;


import java.util.List;

import com.base.donnees.Etudiant;


public interface IEtudiantDao {
	
	 void saveEtudiant(Etudiant student);

	  void updateEtudiant(Etudiant student);

	  Etudiant getEtudiantByMatricule(String matricule);
	 
	  List<Etudiant> getAllEtudiant();

	  void deleteEtudiant(String matricule);
	  
	  
}
