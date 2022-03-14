package com.gestion.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.base.donnees.Agentdescolarite;
import com.base.donnees.Directeur;
import com.base.donnees.Etudiant;
import com.base.donnees.Filiere;
import com.base.donnees.Niveau;
import com.base.donnees.Versement;

public class HibernateUtil {
	    private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            try {
	                Configuration configuration = new Configuration();

	                // Hibernate settings equivalent to hibernate.cfg.xml's properties
	                Properties settings = new Properties();
	                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/gestion_scolarite_javafx?useSSL=false");
	                settings.put(Environment.USER, "root");
	                settings.put(Environment.PASS, "");
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

	                settings.put(Environment.SHOW_SQL, "true");

	                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	               // settings.put(Environment.HBM2DDL_AUTO, "create-drop");

	                configuration.setProperties(settings);

	                configuration.addAnnotatedClass(Agentdescolarite.class);
	                configuration.addAnnotatedClass(Directeur.class);
	                configuration.addAnnotatedClass(Etudiant.class);
	                configuration.addAnnotatedClass(Filiere.class);
	                configuration.addAnnotatedClass(Niveau.class);
	                configuration.addAnnotatedClass(Versement.class);

	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();

	                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionFactory;
	    }
	    
	   
	}

