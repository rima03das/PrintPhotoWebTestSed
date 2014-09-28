package testpkg;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.Action;

public class FirstAction implements Action {

	@Override
	public String execute() throws Exception {

		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		//Query  q = s.createQuery("from User where emailid = '"+emailid+"'");
		
		
		return SUCCESS;
	}

	
	
}
