package li.tmj.db.hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import li.tmj.db.dao.GenericDAO;
import li.tmj.db.model.Address;
import li.tmj.db.model.Data;
import li.tmj.db.model.Person;

public class DataHiberDAO implements GenericDAO<Data>{
//	protected Class<?> objectClass;
	
//	public DataHiberDAO(Class<?> objectClass) {
//		this.objectClass=objectClass;
//	}
	
//	@SuppressWarnings("unchecked")
//	public List<Person> findAll(){
//		Session session=HibernateUtil.getSessionFactory().openSession();
//		//User bezieht sich auf Klasse User, nicht Tabellenfeld oder -spalte!
//		Query q=session.createQuery("From Person");// wie select * from...
//		return q.list();
//	}

	@SuppressWarnings("unchecked")
	public List<Data> read(Data d) {
		Session session=HibernateUtil.createSessionFactory().openSession();
//		Query q=session.createQuery("From "+objectClass.getName());// wie select * from...
//		System.out.println("read: d.getClass()="+d.getClass().getName());
		Criteria criteria = session.createCriteria(d.getClass());//Criteria criteria = session.createCriteria(objectClass);
		Example example = Example.create(d);
		criteria.add(example);
		return criteria.list();//		return q.list();
	}
	
//	public List<Data> readRelative(Data d){
//		Session session=HibernateUtil.getSessionFactory().openSession();
//		Query q=session.createQuery("From "+d.getClass().getName());// wie select * from...
//		
//	}
	
//	public List<Address> readRelative(Person d){
//		Session session=HibernateUtil.getSessionFactory().openSession();
////		Query q=session.createQuery("From "+d.getClass().getName());// wie select * from...
//		Query q=session.createQuery("From Address where "+d.getClass().getName());// wie select * from...
//		
//		Query q=session.createQuery("from Address as a left join PersonXaddress as pxa with a.id=pxa.referentId where pxa.personId=?");
//		
//		
//		String qu="select * from address left join personxaddress on address.id=personxaddress.addressid where personxaddress.personid=?";
//		
//	}
	
	

	public boolean save(Data d) {
		Session session=HibernateUtil.createSessionFactory().openSession();
		Transaction tr=session.beginTransaction();
		session.save(d);
		tr.commit(); // erst jetzt wird in die DB geschrieben.
		return true;
	}
	
//	@Override
//	protected boolean save(List<T> dataList) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
	@Override
	public boolean remove(Data d) {
		Session session = HibernateUtil.createSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
//		Data d = (Data) session.get(Data.class, id);  // session.load(...) -> ObjectNotFoundException/ get(...) -> null
		if(null!=d) {
			session.delete(d);
			tr.commit();
		}
		return true;
	}
	
	
	
//	@Override
//	public boolean remove(int[] ids) {//public void deleteUser(int id) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction tr = session.beginTransaction();
//		Data d = (Data) session.get(Data.class, id);  // session.load(...) -> ObjectNotFoundException/ get(...) -> null
//			if(u!=null) {
//				session.delete(u);
//				tr.commit();
//			}
//		}
//		return false;
//		
//		
//		
//	
//		try {
//		  // your code
//		  String hql = "delete from students where joinDate= :joinDate";
//		  Query query = session.createQuery(hql);
//		  System.out.println(user.getUid() + " and pid: " + pid);
//		  query.setDate("joinDate", student.getJoinDate());
//		  System.out.println(query.executeUpdate());
//		  // your code end
//
//		  transaction.commit();
//		} catch (Throwable t) {
//		  transaction.rollback();
//		  throw t;
//		}
//		
//		
//		
//	}

	@Override
	public boolean update(Data d) {//		public void updatePasswort(int id, String newPasswort) {
		Session session = HibernateUtil.createSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.update(d);  // saveOrUpdate(...)- funktioniert nur als update, wenn 
		tr.commit();
		return true;
	}

//	@Override
//	public boolean update(T[] objs) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	

	
	
//	public void attachUser(User u) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction tr = session.beginTransaction();
//		session.save(u);
//		tr.commit();  // hier wird gespeichert!
//		
//		session.close();
//	}
//	
//	
//	/*
//	 * HQL - HibernateSQL
//	 * User, nicht user
//	 */
//	@SuppressWarnings("unchecked")
//	public List<User> findAll(){
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Query q = session.createQuery("From User");// SELECT * FROM user
//		return q.list();
//	}
//	
//	//Native SQL - nur Ausnahmefall
//	public List<User> findAllNative(){
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Query q = session.createSQLQuery("SELECT * FROM user");
//		
//		return q.list();
//	}
//	
//	// HQL
//	public List<User> findByNachnam(String nachname){
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Query q =session.createQuery("FROM User WHERE nachname =:n ");
//		q.setParameter("n", nachname);
//		//session.close();
//		return q.list();
//	}
	
	
	
	
//	public User findByUsernameAndPasswort(String usr, String pwd) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Criteria criteria = session.createCriteria(User.class);
//		criteria.add(Restrictions.eq("username", usr)).add(Restrictions.eq("passwort", pwd));
//		
//		User u = (User) criteria.uniqueResult();
//		
//		return u;
//	}
	


}
