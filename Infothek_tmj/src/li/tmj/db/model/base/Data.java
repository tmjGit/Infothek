package li.tmj.db.model.base;

import java.time.LocalDateTime;

//@Entity @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Data {
//	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	protected int id=0; // id generated by the external DB and then always >0
	protected LocalDateTime changed;
	protected LocalDateTime created;
	
	public abstract int getId();// {
//		return id;
//	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Data() {
		
	}
	
	public Data(int id) {
		setId(id);
	}
	
	public LocalDateTime getChanged() {
		return changed;
	}
	public void setChanged(LocalDateTime changed) {
		this.changed = changed;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Data [changed=" + changed + ", created=" + created + "]";
//		return "Data [id=" + id + ", changed=" + changed + ", created=" + created + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((changed == null) ? 0 : changed.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
//		result = prime * result + id;
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
		Data other = (Data) obj;
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
//		if (id != other.id)
//			return false;
		return true;
	}
}
