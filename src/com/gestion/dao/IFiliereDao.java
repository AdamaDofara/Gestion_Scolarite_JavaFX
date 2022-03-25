package com.gestion.dao;

import java.util.List;
import com.base.donnees.Filiere;

public interface IFiliereDao {
	  List<Filiere> getAllFiliere();
	  Filiere getFiliereById(int i);
}
