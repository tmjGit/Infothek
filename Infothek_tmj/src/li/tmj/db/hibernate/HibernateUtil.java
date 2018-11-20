package li.tmj.db.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import li.tmj.app.Application;
import li.tmj.db.model.Address;
import li.tmj.db.model.Email;
import li.tmj.db.model.Fone;
import li.tmj.db.model.Person;
import li.tmj.db.model.State;

public class HibernateUtil {
	public static Session createSession() {
		SessionFactory factory = null;
		try {
			factory = createSessionFactory(); // createSessionFactoryOLD();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return factory.openSession();
	}

	public static SessionFactory createSessionFactory() {
		Configuration configuration = getConfiguration();// getFileConfiguration();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		return factory;
	}

	public static SessionFactory createSessionFactoryOLD() {
		Configuration configuration = getConfiguration();

		// Properties p=configuration.getProperties();
		// ServiceRegistryBuilder serviceRegistryBuilder=new ServiceRegistryBuilder();
		// serviceRegistryBuilder.applySettings(p);
		// ServiceRegistry serviceRegistry=
		// serviceRegistryBuilder.buildServiceRegistry();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();

		configuration.setSessionFactoryObserver(new SessionFactoryObserver() {
			private static final long serialVersionUID = 1L;

			@Override
			public void sessionFactoryCreated(SessionFactory factory) {
			}

			@Override
			public void sessionFactoryClosed(SessionFactory factory) {
				ServiceRegistryBuilder.destroy(serviceRegistry);
			}
		});
		return configuration.buildSessionFactory(serviceRegistry);

	}

	private static Configuration getFileConfiguration() {
		return new Configuration().configure();
	}

	private static Configuration getConfiguration() {
		Configuration cfg = new Configuration();
		// Mapping
		cfg.addAnnotatedClass(Address.class);
		cfg.addAnnotatedClass(Email.class);
		cfg.addAnnotatedClass(Fone.class);
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(State.class);
		
		cfg.setProperty("hibernate.bytecode.use_reflection_optimizer", "false");
		cfg.setProperty("hibernate.connection.driver_class", Application.confMainGet("dbdriver"));
		String dbname = Application.confMainGet("dbname");
		if ("".equals(dbname)) {
			dbname = Application.NAME.toLowerCase();
		}
		cfg.setProperty("hibernate.connection.url",
				Application.confMainGet("connection_driver") + "://" 
						+ Application.confMainGet("dbhost") + ":"
						+ Application.confMainGet("dbport") + "/" + dbname
						+ "?zeroDateTimeBehavior=convertToNull&createDatabaseIfNotExist=true");
		cfg.setProperty("hibernate.connection.username", Application.confMainGet("dbuser"));
		cfg.setProperty("hibernate.connection.password", Application.confMainGet("dbpassword"));
		cfg.setProperty("hibernate.show_sql", Application.confMainGet("sqllogging")); // Logging
		cfg.setProperty("hibernate.dialect", Application.confMainGet("hibernate.dialect"));
		cfg.setProperty("hibernate.search.autoregister_listeners", "false");

		cfg.setProperty("hibernate.hbm2ddl.auto", "update");// "create-drop");
		/*
		 * e.g. validate | update | create | create-drop So the list of possible options
		 * are, validate: validate the schema, makes no changes to the database. update:
		 * update the schema. create: creates the schema, destroying previous data.
		 * create-drop: drop the schema at the end of the session.
		 */

		cfg.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
		cfg.setProperty("hibernate.current_session_context_class", "thread");
		cfg.setProperty("hibernate.validator.apply_to_ddl", "false");

		return cfg;
	}
}