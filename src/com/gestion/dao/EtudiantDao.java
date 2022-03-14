package com.gestion.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.base.donnees.Etudiant;
import com.gestion.util.HibernateUtil;



public class EtudiantDao implements IEtudiantDao {

	@Override
	public void saveEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.save(etudiant);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	}

	@Override
	public void updateEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.saveOrUpdate(etudiant);

            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
	}

	@Override
	public Etudiant getEtudiantByMatricule(String matricule) {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
	        Etudiant etudiant = null;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    // start the transaction
				    transaction = session.beginTransaction();

				    // get student object
				    etudiant= session.byId(Etudiant.class).getReference(matricule);
				     // or student = session.get(Student.class, id);
				    //or student = session.load(Student.class, id);
				   //or commit the transaction
				    transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
				
			}
	        
	        
	        return etudiant;
	}

	@Override
	public List<Etudiant> getAllEtudiant() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List < Etudiant > etudiants = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            etudiants = session.createQuery("from Etudiant").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return etudiants;
	}

	@Override
	public void deleteEtudiant(String matricule) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Etudiant etudiant = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            etudiant = session.get(Etudiant.class, matricule);
            // get student object
            session.delete(etudiant);
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
	}
	
	 

}
