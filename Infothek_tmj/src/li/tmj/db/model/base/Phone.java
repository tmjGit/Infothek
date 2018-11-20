package li.tmj.db.model.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone extends Data {
	private String device;
	private String onkz;
	private int stateId;
	private String subscriberCallNumber;
//	protected int id=0; // id generated by the external DB and then always >0
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Override
	public int getId() {
		return id;
	}
//	@Override
//	public void setId(int id) {
//		this.id = id;
//	}

	public Phone() {
		
	}
	
	public Phone(int id) {
		setId(id);
	}

	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getOnkz() {
		return onkz;
	}
	public void setOnkz(String onkz) {
		this.onkz = onkz;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getSubscriberCallNumber() {
		return subscriberCallNumber;
	}
	public void setSubscriberCallNumber(String subscriberCallNumber) {
		this.subscriberCallNumber = subscriberCallNumber;
	}
	
	@Override
	public String toString() {
		return "Fone [id=" + id + ", changed=" + changed + ", created=" + created + ", device=" + device + ", onkz="
				+ onkz + ", stateId=" + stateId + ", subscriberCallNumber=" + subscriberCallNumber + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((changed == null) ? 0 : changed.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((device == null) ? 0 : device.hashCode());
		result = prime * result + id;
		result = prime * result + ((onkz == null) ? 0 : onkz.hashCode());
		result = prime * result + stateId;
		result = prime * result + ((subscriberCallNumber == null) ? 0 : subscriberCallNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (changed == null) {
			if (other.changed != null)
				return false;
		} else if (!changed.equals(other.changed))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (device == null) {
			if (other.device != null)
				return false;
		} else if (!device.equals(other.device))
			return false;
		if (id != other.id)
			return false;
		if (onkz == null) {
			if (other.onkz != null)
				return false;
		} else if (!onkz.equals(other.onkz))
			return false;
		if (stateId != other.stateId)
			return false;
		if (subscriberCallNumber == null) {
			if (other.subscriberCallNumber != null)
				return false;
		} else if (!subscriberCallNumber.equals(other.subscriberCallNumber))
			return false;
		return true;
	}

}