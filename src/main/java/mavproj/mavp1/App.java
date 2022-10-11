package mavproj.mavp1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory fac = cfg.buildSessionFactory();
		Student st = new Student();
		st.setId(101);
		st.setName("Sourabh");
		st.setLocation("Rohtak");
		System.out.println(st);
		Student st1 = new Student();
		st1.setId(102);
		st1.setName("Savin");
		st1.setLocation("Bhuna");
		System.out.println(st1);
		Session session = fac.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(st1);
		tx.commit();
		session.close();

	}
}
