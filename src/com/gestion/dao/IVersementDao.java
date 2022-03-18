 package com.gestion.dao;

import java.util.List;


import com.base.donnees.Versement;
import com.base.donnees.VersementId;

public interface IVersementDao {
	List<Versement> getAllVersement();
	Versement getVersementById(VersementId id);
	public void saveVersement(Versement versement);
	List<Versement> getVerementOfAEtudiant(String s);
}
