package model.array;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = -491148874780953135L;
	private int id=-1; // id generated by the external DB and then always >0
	private String[] values=new String[8];
	
	public Person() {}

	public Person(String[] values) {
		this.values = values;
	}

	public Person(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8) {
		this.values[0] = value1;
		this.values[1] = value2;
		this.values[2] = value3;
		this.values[3] = value4;
		this.values[4] = value5;
		this.values[5] = value6;
		this.values[6] = value7;
		this.values[7] = value8;
	}

	public Person(int id, String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8) {
		this(value1, value2, value3, value4, value5, value6, value7, value8);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue(int Index) {
		return values[Index];
	}

	public void setValue(int Index, String value) {
		this.values[Index] = value;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		if (id != other.id)
//			return false;
//		if(id>0) // This object already exist in the DB, so we need not check the data fields.
//			return true;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		if (id != other.id)
//			return false;
//		if (mobil == null) {
//			if (other.mobil != null)
//				return false;
//		} else if (!mobil.equals(other.mobil))
//			return false;
//		if (nachname == null) {
//			if (other.nachname != null)
//				return false;
//		} else if (!nachname.equals(other.nachname))
//			return false;
//		if (ort == null) {
//			if (other.ort != null)
//				return false;
//		} else if (!ort.equals(other.ort))
//			return false;
//		if (plz == null) {
//			if (other.plz != null)
//				return false;
//		} else if (!plz.equals(other.plz))
//			return false;
//		if (strasse == null) {
//			if (other.strasse != null)
//				return false;
//		} else if (!strasse.equals(other.strasse))
//			return false;
//		if (telefon == null) {
//			if (other.telefon != null)
//				return false;
//		} else if (!telefon.equals(other.telefon))
//			return false;
//		if (vorname == null) {
//			if (other.vorname != null)
//				return false;
//		} else if (!vorname.equals(other.vorname))
//			return false;
//		return true;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		if(id>0) // This object already exist in the DB, so we don't use the data fields as characterization.
//			return result;
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + ((mobil == null) ? 0 : mobil.hashCode());
//		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
//		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
//		result = prime * result + ((plz == null) ? 0 : plz.hashCode());
//		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
//		result = prime * result + ((telefon == null) ? 0 : telefon.hashCode());
//		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
//		return result;
//	}
//
//	@Override
//	public String toString() {
//		return "Person [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", plz=" + plz + ", ort=" + ort
//				+ ", strasse=" + strasse + ", telefon=" + telefon + ", mobil=" + mobil + ", email=" + email + "]";
//	}
	
}
