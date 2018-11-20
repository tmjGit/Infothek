//package li.tmj.db.model.structure;
//
//import java.util.List;
//import li.tmj.db.hibernate.DataHiberDAO;
//import li.tmj.db.model.Address;
//import li.tmj.db.model.Data;
//import li.tmj.db.model.Email;
//import li.tmj.db.model.Person;
//import li.tmj.db.model.PersonXaddress;
//import li.tmj.db.model.PersonXperson;
//import li.tmj.db.model.PersonXphone;
//import li.tmj.db.model.Fone;
//
//public class Services {
////	protected Class<T> objectClass;
////	public DataHiberDAO(Class<T> objectClass) {
////		this.objectClass=objectClass;
////	}
//
////	public List<T> read(T t) {
////		Session session=HibernateUtil.getSessionFactory().openSession();
//////			Query q=session.createQuery("From "+objectClass.getName());// wie select * from...
////		Criteria criteria = session.createCriteria(objectClass);
////		Example example = Example.create(t);
////		criteria.add(example);
////		return criteria.list();//		return q.list();
////	}
//	
//	
//
////	public boolean save(T t) {
////		Session session=HibernateUtil.getSessionFactory().openSession();
////		Transaction tr=session.beginTransaction();
////		session.save(t);
////		tr.commit(); // erst jetzt wird in die DB geschrieben.
////		return true;
////	}
//
//	
//	public boolean removePerson(Person p) {
//		int id=p.getId();
//		DataHiberDAO dao=new DataHiberDAO();
////		DataHiberDAO<Data> dao=new DataHiberDAO<>(Data.class);
//		boolean b;
////		b=new DataHiberDAO<Person>(Person.class).remove(p);
//		b=dao.remove(p);
//		
//		Email email=new Email(); // Person:Email = 1:n => remove that Persons Emails
//		email.setPersonId(id);
////		b=new DataHiberDAO<Email>(Email.class).remove(email);
//		b=dao.remove(email);
//		
//		PersonXperson pXp=new PersonXperson(); // Remove relations to Persons. The Persons itself remain untouched. 
//		pXp.setPersonId(id);
////		b=new DataHiberDAO<PersonXperson>(PersonXperson.class).remove(pXp);
//		b=dao.remove(pXp);
//		pXp=new PersonXperson();
//		pXp.setReferentId(id);
//		b=dao.remove(pXp);//b=new DataHiberDAO<PersonXperson>(PersonXperson.class).remove(pXp);
//		
//		PersonXaddress pXa=new PersonXaddress(); // Remove address relations
//		pXa.setPersonId(id);
////		DataHiberDAO<PersonXaddress> pXaDAO=new DataHiberDAO<>(PersonXaddress.class); // We check if the related addresses belong to other Persons, too.
//		List<Data> pXaList=dao.read(pXa); // address relations of the removed Person
////		List<PersonXaddress> pXaList=pXaDAO.read(pXa); // address relations of the removed Person
////		for(PersonXaddress pXa2:pXaList) { // pXa2 has the id of the removed Person and the id of an address
//		for(Data d:pXaList) { // pXa2 has the id of the removed Person and the id of an address
//			pXa=new PersonXaddress();
//			PersonXaddress pXa2=(PersonXaddress) d;
//			pXa.setReferentId(pXa2.getReferentId());
//			List<Data> pXaList2=dao.read(pXa);// all relations to this Address, the removed Person was also related to.
////			List<PersonXaddress> pXaList2=pXaDAO.read(pXa);// all relations to this Address, the removed Person was also related to.
//			if( 2 > pXaList2.size() ) { // There are not more relations than the obsolete one, so we remove the abandoned Address, too. 
//				Address a=new Address(pXa2.getReferentId());
//				dao.remove(a);
//			}
//		}
//		b=dao.remove(pXa); // Now remove all abandoned address relations from the removed Person.
//		
//		PersonXphone pXf=new PersonXphone(); // Remove phone relations
//		pXf.setPersonId(id);
////		DataHiberDAO<PersonXphone> pXfDAO=new DataHiberDAO<>(PersonXphone.class); // We check if the related phones belong to other Persons, too.
////		List<PersonXphone> pXfList=pXfDAO.read(pXf); // phone relations of the removed Person
//		List<Data> pXfList=dao.read(pXf); // phone relations of the removed Person
//		for(Data d:pXfList) { // pXf2 has the id of the removed Person and the id of a phone
//			pXf=new PersonXphone();
//			PersonXphone pXf2=(PersonXphone) d;
//			pXf.setReferentId(pXf2.getReferentId());
//			List<Data> pXfList2=dao.read(pXf);//all relations to this phone, the removed Person was also related to.
//			if( 2> pXfList2.size() ) {//There are not more relations than the obsolete one, so we remove the abandoned Fone, too.
//				Fone f=new Fone(pXf2.getReferentId());
//				dao.remove(f);
//			}
//		}
//		b=dao.remove(pXf); // Now remove all abandoned phone relations from the removed Person.
//		
//		return b;
//	}
//	
//
////	@Override
////	public boolean update(T t) {//		public void updatePasswort(int id, String newPasswort) {
////		Session session = HibernateUtil.getSessionFactory().openSession();
////		Transaction tr = session.beginTransaction();
////		session.update(t);  // saveOrUpdate(...)- funktioniert nur als update, wenn 
////		tr.commit();
////		return true;
////	}
//	
//	public static void main(String[] args) {
//		DataHiberDAO daoP=new DataHiberDAO();
//		Person p=new Person();
//		p.setNameIndividual("Harry");
//		System.out.println("main 1: p="+p);
//		List<Data> listP=daoP.read(p);
//		for(Data p2:listP) {
//			System.out.println("main 2:p2="+p2);
//		}
//
//		DataHiberDAO dao=new DataHiberDAO();
//		p=new Person();
//		p.setNameIndividual("Harry");
//		System.out.println("main 3: p="+p);
//		listP=dao.read(p);
//		for(Data p2:listP) {
//			System.out.println("main 4:p2="+p2);
//		}
//
////		DataHiberDAO<Data> dao=new DataHiberDAO<>(Data.class);
////		Person d=new Person();
////		d.setNameIndividual("Harry");
////		System.out.println("main 3: d="+d);
////		List<Data> list=dao.read(d);
////		for(Data d2:list) {
////			System.out.println("main 4:d2="+d2);
////		}
//		
//		
//		
////		PersonHiberDAO dao=new PersonHiberDAO();
////		p.setNameFamily("Harrison");
////		p.setSex("männlich");
////		System.out.println("DataHiberDAO.main: p="+p);
////		boolean b=dao.save(p);
////		System.out.println("DataHiberDAO.main: b="+b);
////		p=new Person();
////		p.setNameIndividual("Harry");
////		System.out.println("DataHiberDAO.main: p="+p);
////		List<Person> list=dao.read(p);
////		p=list.get(0);
////		System.out.println("DataHiberDAO.main: p="+p);
//	}
//}