package com.gestion.dao;

import java.util.List;

import com.base.donnees.Niveau;

public interface INiveauDao {
	List<Niveau> getAllNiveau();
	Niveau getNiveauBylibelle(String s);
}
