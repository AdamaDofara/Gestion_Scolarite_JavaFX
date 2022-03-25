package com.gestion.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.base.donnees.Filiere;
import com.base.donnees.Niveau;
import com.gestion.util.HibernateUtil;

import javafx.collections.ObservableList;

public class NiveauDao implements INiveauDao {

	@Override
	public List<Niveau> getAllNiveau() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List < Niveau > niveaux = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            niveaux = session.createQuery("from Niveau").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return niveaux;
	}

	@Override
	public Niveau getNiveauById(int i) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Niveau niveau = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    niveau= session.byId(Niveau.class).getReference(i);
			     // or student = session.get(Student.class, id);
			    //or student = session.load(Student.class, id);
			   //or commit the transaction
			    transaction.commit();
			    session.close();
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
		}
			
	}
        return niveau;	
	}

	

	

	
}
