package us.codecraft.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * @author code4crafter@gmail.com
 *         Date: 17/5/7
 *         Time: 上午11:06
 */
public class Hibernate {

	public static void main(String[] args) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery( "from Event" ).list();
	}
}
