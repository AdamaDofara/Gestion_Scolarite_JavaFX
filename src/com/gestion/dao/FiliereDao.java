package com.gestion.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.base.donnees.Etudiant;
import com.base.donnees.Filiere;
import com.gestion.util.HibernateUtil;

public class FiliereDao implements IFiliereDao {

	@Override
	public List<Filiere> getAllFiliere() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List < Filiere > filieres = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            filieres = session.createQuery("from Filiere").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return filieres;
	}

	@Override
	public Filiere getFiliereById(int i) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Filiere filiere = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    filiere= session.byId(Filiere.class).getReference(i);
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
        return filiere;
        
}
}
