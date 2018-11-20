//package li.tmj.db.hibernate;
//
//import java.util.List;
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.criterion.Example;
//import li.tmj.db.model.Address;
//import li.tmj.db.model.Data;
//import li.tmj.db.model.Email;
//import li.tmj.db.model.Person;
//import li.tmj.db.model.PersonXaddress;
//import li.tmj.db.model.PersonXperson;
//import li.tmj.db.model.PersonXphone;
//import li.tmj.db.model.Fone;
//import li.tmj.db.model.State;
//
//public class HiberDAO extends DataHiberDAO {
//	@SuppressWarnings("unchecked")
//	public List<Address> read(Address a){
//		return (List<Address>) read(a);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<Email> read(Email e){
//		return (List<Email>) readData(e);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<Person> read(Person p){
//		return (List<Person>) readData(p);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<PersonXaddress> read(PersonXaddress p){
//		return (List<PersonXaddress>) readData(p);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<PersonXperson> read(PersonXperson p){
//		return (List<PersonXperson>) readData(p);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<PersonXphone> read(PersonXphone p){
//		return (List<PersonXphone>) readData(p);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<Fone> read(Fone p){
//		return (List<Fone>) readData(p);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<State> read(State s){
//		return (List<State>) readData(s);
//	}
//}
