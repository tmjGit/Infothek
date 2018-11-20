package li.tmj.db.model.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonXphoneBAK extends Data {
	private String comment;
	private int phoneId;
	private String name;
	private int personId;
//	protected int id=0; // id generated by the external DB and then always >0
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Override
	public int getId() {
		return id;
	}
//	@Override
//	public void setId(int id) {
//		this.id = id;
//	}

	public PersonXphoneBAK() {
		
	}
	
	public PersonXphoneBAK(int id) {
		setId(id);
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int addressId) {
		this.phoneId = addressId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		return "personXphone [id=" + id + ", changed=" + changed + ", created=" + created + ", comment=" + comment
				+ ", addressId=" + phoneId + ", name=" + name + ", personId=" + personId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + phoneId;
		result = prime * result + ((changed == null) ? 0 : changed.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + personId;
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
		PersonXphoneBAK other = (PersonXphoneBAK) obj;
		if (phoneId != other.phoneId)
			return false;
		if (changed == null) {
			if (other.changed != null)
				return false;
		} else if (!changed.equals(other.changed))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (personId != other.personId)
			return false;
		return true;
	}

}
