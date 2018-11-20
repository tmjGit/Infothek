package li.tmj.db.model.base;


public abstract class Cross extends Data{
	private String comment, name;
	private int personId, referentId;
	
	public Cross() {
		super();
	}
	
	public Cross(int id) {
		super(id);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getReferentId() {
		return referentId;
	}
	public void setReferentId(int referentId) {
		this.referentId = referentId;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}


	@Override
	public String toString() {
		return "personXaddress [id=" + id + ", changed=" + changed + ", created=" + created + ", comment=" + comment
				+ ", referentId=" + referentId + ", personId=" + personId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((changed == null) ? 0 : changed.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + id;
		result = prime * result + personId;
		result = prime * result + referentId;
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
		Cross other = (Cross) obj;
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
		if (personId != other.personId)
			return false;
		if (referentId != other.referentId)
			return false;
		return true;
	}
}
