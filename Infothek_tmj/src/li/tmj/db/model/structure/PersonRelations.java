//package li.tmj.db.model.structure;
//
//import java.util.List;
//
//import li.tmj.db.hibernate.DataHiberDAO;
//import li.tmj.db.model.Address;
//import li.tmj.db.model.Person;
//import li.tmj.db.model.PersonXaddress;
//
//public class PersonRelations {
//	private Person person;
//	
//	public PersonRelations(Person person) {
//		this.person=person;
//	}
//	
//	public Person getPerson() {
//		return person;
//	}
//	
//	public List<Address> addresses(){
//		PersonXaddress pXa=new PersonXaddress();
//		pXa.setPersonId(person.getId());
//		DataHiberDAO dao=new DataHiberDAO();
//		dao.read(pXa);
//		
//		Address address=new Address();
//		address.s
//	}
//}
