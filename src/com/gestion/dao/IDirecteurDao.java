package com.gestion.dao;

import java.util.List;

import com.base.donnees.Directeur;




public interface IDirecteurDao {
	 List<Directeur> getAllDirecteur();
	 Directeur getDirecteurByMatricule(String s);
	 
}
