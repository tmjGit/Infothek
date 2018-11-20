package li.tmj.db.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Fone extends Data {
	private static final long serialVersionUID = 1L;
	private String device;
	private String areaCode;//Ortsnetzkennziffer ONKZ
//	private int stateId;
	private String subscriberCallNumber;//Rufnummer
	
	private Collection<Person> persons=new ArrayList<>();
	private State state; // ManyToOne
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Override
	public int getId() {
		return id;
	}
	
	public Fone() {
		
	}
	
	public Fone(int id) {
		setId(id);
	}

	@ManyToMany(mappedBy="fones")
	public Collection<Person> getPersons() {
		return persons;
	}

	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String onkz) {
		this.areaCode = onkz;
	}

	public String getSubscriberCallNumber() {
		return subscriberCallNumber;
	}

	public void setSubscriberCallNumber(String subscriberCallNumber) {
		this.subscriberCallNumber = subscriberCallNumber;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((device == null) ? 0 : device.hashCode());
		result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
		result = prime * result + ((persons == null) ? 0 : persons.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((subscriberCallNumber == null) ? 0 : subscriberCallNumber.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Fone [device=" + device + ", areaCode=" + areaCode + ", subscriberCallNumber=" + subscriberCallNumber
				+ ", persons=" + persons 
				+ ", state=" + state 
				+ "]";
	}


}
