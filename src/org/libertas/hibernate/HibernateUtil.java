package org.libertas.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.libertas.pojo.Cidade;
import org.libertas.pojo.Grupo;
import org.libertas.pojo.Pessoa;
import org.libertas.pojo.Produto;
import org.libertas.pojo.Venda;

/**
 * Java based configuration
 * 
 * @author ramesh Fadatare
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/ProjetoFinal2?useTimezone=true&serverTimezone=UTC");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "123");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			  /*<property name="hibernate.connection.CharSet">utf8</property>
				<property name="hibernate.connection.characterEncoding">utf8</property>
				<property name="hibernate.connection.useUnicode">true</property>
*/
				//settings.put(Environment.HBM2DDL_CHARSET_NAME, "utf8");
				settings.put(Environment.USE_NATIONALIZED_CHARACTER_DATA, "true");
				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Pessoa.class);
				configuration.addAnnotatedClass(Cidade.class);
				configuration.addAnnotatedClass(Grupo.class);
				configuration.addAnnotatedClass(Produto.class);
				configuration.addAnnotatedClass(Venda.class);
				

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
