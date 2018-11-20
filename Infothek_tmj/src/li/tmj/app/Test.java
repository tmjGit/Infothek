package li.tmj.app;

import java.util.List;
import org.hibernate.Session;
import li.tmj.db.hibernate.DataHiberDAO;
import li.tmj.db.hibernate.HibernateUtil;
import li.tmj.db.model.Address;
import li.tmj.db.model.Fone;
import li.tmj.db.model.Data;
import li.tmj.db.model.Person;

public class Test {

	public static void main(String[] args) {
		li.tmj.app.Application.init();
		
		 Person person=new Person();
	        person.setNameIndividual("81-7808-137-7");
	        person.setNameFamily("Fundamentals of Database System");
	        
//	        Publisher pub=new Publisher();
//	        pub.setPublisherName("Pearson");
	        
	        Address add=new Address();
	        add.setStreet_box("123 ABC Street");
	        add.setVillage("XYZ");
	        add.setAppartement("9282736446");
//	        add.setEmail("info@pearson.com");
	        add.setPostcode("1010101");
	        
//	        pub.setPublisheAddress(add);
	        
//	        person.setPublisher(pub);
	        
	        Fone a1=new Fone();
	        a1.setDevice("Elmasri");
	        a1.setSubscriberCallNumber("bio not available");
	        
	        Fone a2=new Fone();
	        a2.setDevice("Navathe");
	        a2.setSubscriberCallNumber("bio not available");
	        
//	        person.getFones().add(a1);
//	        person.getFones().add(a2);
	        
//	        Category c1=new Category();        
//	        c1.setCategoryName("Database");
//	        c1.setDescription("not Available");
//	        
//	        Category c2=new Category();
//	        c2.setCategoryName("Computer");
//	        c2.setDescription("not Available");
	        
//	        person.getCategories().add(c1);
//	        person.getCategories().add(c2);
	                
	        
	        Session session=HibernateUtil.createSession();
	        session.beginTransaction();
//	        session.save(pub);
	        session.save(a1);
	        session.save(a2);
//	        session.save(c1);
//	        session.save(c2);
	        session.save(person);
	        session.getTransaction().commit();
	        session.close();

//		Person person=new Person();
//		person.setNameIndividual("Harry");
//		DataHiberDAO dao=new DataHiberDAO();
//		List<Data> persons=dao.read(person);
//		person=(Person) persons.get(0);//erster Datensatz mit Harry
//		nameIndivFld.setText(person.getNameIndividual());
////		nameFamPreCb.set
//		nameFamFld.setText(person.getNameFamily());
//		birthDayFld.setText(Integer.toString(person.getBirthDay()));
//		birthMonthFld.setText(Integer.toString(person.getBirthMonth()));
//		birthYearFld.setText(Integer.toString(person.getBirthYear()));

	}

}
