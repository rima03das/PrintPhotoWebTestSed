package testpkg;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.Action;

public class FirstAction implements Action {

	String emailId;
	String password;

	public String checkUser() throws Exception {

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();

		s.beginTransaction();
		Query q = s.createQuery("from User where emailid = '" + emailId + "'");

		List l = q.list();

		s.getTransaction().commit();
		s.close();

		if (l.size() == 0) {
			System.out.println("NEW USER");
			return "newuser";
		} else {
			System.out.println("OLD USER");
			return "olduser";
		}

	}

	public String loginUser() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();

		s.beginTransaction();
		Query q = s.createQuery("from User where emailid = '" + emailId
				+ "' and password = '" + password + "'");

		List l = q.list();

		if (l.size() == 0) {
			System.out.println("invalid userid or password");
			return "invalid";
		} else {
			System.out.println("VALID USER");
			return "valid";
		}
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
