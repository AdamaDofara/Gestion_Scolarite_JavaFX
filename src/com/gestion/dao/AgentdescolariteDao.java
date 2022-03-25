package com.gestion.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.base.donnees.Agentdescolarite;
import com.gestion.util.HibernateUtil;


public class AgentdescolariteDao implements IAgentdescolariteDao {

	@Override
	public void saveAgent(Agentdescolarite agent) {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
		 //final org.hibernate.SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.save(agent);
	            
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
	public List<Agentdescolarite> getAllAgents() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List < Agentdescolarite > agents = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            agents = session.createQuery("from Agentdescolarite").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return agents;
	}

	@Override
	public void SupprimerAgent(int id) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Agentdescolarite agent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            agent = session.get(Agentdescolarite.class, id);
            // get student object
            session.delete(agent);
            //student = session.load(Student.class, id);
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
	public Agentdescolarite getAgentScoById(int id) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Agentdescolarite agt = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    agt= session.byId(Agentdescolarite.class).getReference(id);
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
        
        
        return agt;
	}

}
