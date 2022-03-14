package com.gestion.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.base.donnees.Directeur;
import com.gestion.util.HibernateUtil;


public class DirecteurDao implements IDirecteurDao {

	@Override
	public List<Directeur> getAllDirecteur() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List < Directeur > directeurs = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            directeurs = session.createQuery("from Directeur").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return directeurs;
	}

	@Override
	public Directeur getDirecteurByMatricule(String matricule) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Directeur directeur = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    directeur= session.byId(Directeur.class).getReference(matricule);
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
        
        
        return directeur;
	}
	
}
