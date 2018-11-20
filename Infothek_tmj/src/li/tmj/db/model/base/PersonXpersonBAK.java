package li.tmj.db.model.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonXpersonBAK extends Data {
	private String relation;
	private int person1Id;
	private int person2Id;
//	protected int id=0; // id generated by the external DB and then always >0
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Override
	public int getId() {
		return id;
	}
//	@Override
//	public void setId(int id) {
//		this.id = id;
//	}

	public PersonXpersonBAK() {
		
	}
	
	public PersonXpersonBAK(int id) {
		setId(id);
	}

	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public int getPerson1Id() {
		return person1Id;
	}
	public void setPerson1Id(int person1Id) {
		this.person1Id = person1Id;
	}
	public int getPerson2Id() {
		return person2Id;
	}
	public void setPerson2Id(int person2Id) {
		this.person2Id = person2Id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((changed == null) ? 0 : changed.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + id;
		result = prime * result + person1Id;
		result = prime * result + person2Id;
		result = prime * result + ((relation == null) ? 0 : relation.hashCode());
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
		PersonXpersonBAK other = (PersonXpersonBAK) obj;
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
		if (id != other.id)
			return false;
		if (person1Id != other.person1Id)
			return false;
		if (person2Id != other.person2Id)
			return false;
		if (relation == null) {
			if (other.relation != null)
				return false;
		} else if (!relation.equals(other.relation))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "personXperson [id=" + id + ", changed=" + changed + ", created=" + created + ", relation=" + relation
				+ ", person1Id=" + person1Id + ", person2Id=" + person2Id + "]";
	}
	
}