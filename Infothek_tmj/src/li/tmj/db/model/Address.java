package li.tmj.db.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Address extends Data {
	private static final long serialVersionUID = 1L;
	private String house;
	private String village;
	private String postcode;
	private State state;
	private String street_box;
	private String appartement;
	private Collection<Person> persons=new ArrayList<>();
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) //@Override
	public int getId() {
		return id;
	}

	public Address() {
		
	}
	
	public Address(int id) {
		setId(id);
	}

	@ManyToMany(mappedBy="addresses")
	public Collection<Person> getPersons() {
		return persons;
	}

	@ManyToOne
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String town) {
		this.village = town;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStreet_box() {
		return street_box;
	}

	public void setStreet_box(String street_box) {
		this.street_box = street_box;
	}

	public String getAppartement() {
		return appartement;
	}

	public void setAppartement(String appartement) {
		this.appartement = appartement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((appartement == null) ? 0 : appartement.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((persons == null) ? 0 : persons.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street_box == null) ? 0 : street_box.hashCode());
		result = prime * result + ((village == null) ? 0 : village.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Address [house=" + house + ", village=" + village + ", postcode=" + postcode + ", street_box=" + street_box
				+ ", appartement=" + appartement + ", persons=" + persons + ", state=" 
				+ state
				+ "]";
	}



	
}
