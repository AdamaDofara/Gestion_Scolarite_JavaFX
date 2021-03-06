package com.gestion.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.base.donnees.Agentdescolarite;
import com.base.donnees.Etudiant;
import com.base.donnees.Niveau;
import com.base.donnees.Versement;
import com.base.donnees.VersementId;
import com.gestion.util.HibernateUtil;

public class VersementDao implements IVersementDao {

	@Override
	public List<Versement> getAllVersement() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List < Versement > versements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            versements = session.createQuery("from Agentdescolarite").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return versements;
	}

	@Override
	public Versement getVersementById(VersementId id) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Versement versement = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    versement= session.byId(Versement.class).getReference(id);
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
        return versement;	

	}

	@Override
	public void saveVersement(Versement versement) {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.save(versement);
	            
	            // commit the transaction
	            transaction.commit();
	            session.close();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	}

	@Override
	public List<Versement> getVersementOfAEtudiant(String s) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List<Versement> versements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            //SELECT  FROM VersementId AS v, Etudiant AS e, Agentdescolarite AS a "
            		//+ "WHERE v.matricule="+s+"v.idAgent=a.idAgent
            versements = session.createQuery("").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
              //  transaction.rollback();
            }
        }
        return versements;
	}

	@Override
	public List<Float> vermentsEtudiant(String s) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List<Float> versementsEtudiant = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            versementsEtudiant = session.createQuery("FROM versement v inner join v.matricule as mat with mat="+s).getResultList();
            // commit the transaction
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                
            }
        }
        return versementsEtudiant;
	}

	

	
	
}
