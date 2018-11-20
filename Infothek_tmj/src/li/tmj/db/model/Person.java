package li.tmj.db.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Person extends Data {
	private static final long serialVersionUID = 1L;
	private String dataFolder;
	private String messagesFolder;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	private String sex;
	private String died;
	private String category;
	private String nameFamily;
	private String nameFamilyPre;
	private String nameIndividual;
//	private Media pic;
	private String smokes;
	private String other;
	private String special;
	private String stop;
	private Collection<Email> emails=new ArrayList<>();
	private Collection<Address> addresses=new ArrayList<>();	
	private Collection<Fone> fones=new ArrayList<>();
//	private Collection<Person> persons=new ArrayList<>();
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) //@Override
	public int getId() {
		return id;
	}

	public Person() {
		
	}
	
	public Person(int id) {
		setId(id);
	}

	@ManyToMany//(mappedBy="persons")
	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

	@OneToMany
	public Collection<Email> getEmails() {
		return emails;
	}

	public void setEmails(Collection<Email> emails) {
		this.emails = emails;
	}

	@ManyToMany//(mappedBy="persons")
	public Collection<Fone> getFones() {
		return fones;
	}

	public void setFones(Collection<Fone> fones) {
		this.fones = fones;
	}
//	@ManyToMany(mappedBy="persons")
//	public Collection<Person> getPersons() {
//		return persons;
//	}
//
//	public void setPersons(Collection<Person> persons) {
//		this.persons = persons;
//	}

	public String getDataFolder() {
		return dataFolder;
	}

	public void setDataFolder(String dataFolder) {
		this.dataFolder = dataFolder;
	}

	public String getMessagesFolder() {
		return messagesFolder;
	}

	public void setMessagesFolder(String messagesFolder) {
		this.messagesFolder = messagesFolder;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public int getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}

	public int getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDied() {
		return died;
	}

	public void setDied(String died) {
		this.died = died;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNameFamily() {
		return nameFamily;
	}

	public void setNameFamily(String nameFamily) {
		this.nameFamily = nameFamily;
	}

	public String getNameFamilyPre() {
		return nameFamilyPre;
	}

	public void setNameFamilyPre(String nameFamilyPre) {
		this.nameFamilyPre = nameFamilyPre;
	}

	public String getNameIndividual() {
		return nameIndividual;
	}

	public void setNameIndividual(String nameIndividual) {
		this.nameIndividual = nameIndividual;
	}

	public String getSmokes() {
		return smokes;
	}

	public void setSmokes(String smokes) {
		this.smokes = smokes;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getStop() {
		return stop;
	}

	public void setStop(String stop) {
		this.stop = stop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + birthDay;
		result = prime * result + birthMonth;
		result = prime * result + birthYear;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((dataFolder == null) ? 0 : dataFolder.hashCode());
		result = prime * result + ((died == null) ? 0 : died.hashCode());
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((fones == null) ? 0 : fones.hashCode());
		result = prime * result + ((messagesFolder == null) ? 0 : messagesFolder.hashCode());
		result = prime * result + ((nameFamily == null) ? 0 : nameFamily.hashCode());
		result = prime * result + ((nameFamilyPre == null) ? 0 : nameFamilyPre.hashCode());
		result = prime * result + ((nameIndividual == null) ? 0 : nameIndividual.hashCode());
		result = prime * result + ((other == null) ? 0 : other.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((smokes == null) ? 0 : smokes.hashCode());
		result = prime * result + ((special == null) ? 0 : special.hashCode());
		result = prime * result + ((stop == null) ? 0 : stop.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (birthDay != other.birthDay)
			return false;
		if (birthMonth != other.birthMonth)
			return false;
		if (birthYear != other.birthYear)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dataFolder == null) {
			if (other.dataFolder != null)
				return false;
		} else if (!dataFolder.equals(other.dataFolder))
			return false;
		if (died == null) {
			if (other.died != null)
				return false;
		} else if (!died.equals(other.died))
			return false;
		if (emails == null) {
			if (other.emails != null)
				return false;
		} else if (!emails.equals(other.emails))
			return false;
		if (fones == null) {
			if (other.fones != null)
				return false;
		} else if (!fones.equals(other.fones))
			return false;
		if (messagesFolder == null) {
			if (other.messagesFolder != null)
				return false;
		} else if (!messagesFolder.equals(other.messagesFolder))
			return false;
		if (nameFamily == null) {
			if (other.nameFamily != null)
				return false;
		} else if (!nameFamily.equals(other.nameFamily))
			return false;
		if (nameFamilyPre == null) {
			if (other.nameFamilyPre != null)
				return false;
		} else if (!nameFamilyPre.equals(other.nameFamilyPre))
			return false;
		if (nameIndividual == null) {
			if (other.nameIndividual != null)
				return false;
		} else if (!nameIndividual.equals(other.nameIndividual))
			return false;
		if (this.other == null) {
			if (other.other != null)
				return false;
		} else if (!this.other.equals(other.other))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (smokes == null) {
			if (other.smokes != null)
				return false;
		} else if (!smokes.equals(other.smokes))
			return false;
		if (special == null) {
			if (other.special != null)
				return false;
		} else if (!special.equals(other.special))
			return false;
		if (stop == null) {
			if (other.stop != null)
				return false;
		} else if (!stop.equals(other.stop))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Person [dataFolder=" + dataFolder + ", messagesFolder=" + messagesFolder + ", birthYear=" + birthYear
//				+ ", birthMonth=" + birthMonth + ", birthDay=" + birthDay + ", sex=" + sex + ", died=" + died
//				+ ", category=" + category + ", nameFamily=" + nameFamily + ", nameFamilyPre=" + nameFamilyPre
//				+ ", nameIndividual=" + nameIndividual + ", smokes=" + smokes + ", other=" + other + ", special="
//				+ special + ", stop=" + stop + ", addresses=" + addresses
//				+ "]";
//	}

//	@Override
//	public String toString() {
//		return "Person [dataFolder=" + dataFolder + ", messagesFolder=" + messagesFolder + ", birthYear=" + birthYear
//				+ ", birthMonth=" + birthMonth + ", birthDay=" + birthDay + ", sex=" + sex + ", died=" + died
//				+ ", category=" + category + ", nameFamily=" + nameFamily + ", nameFamilyPre=" + nameFamilyPre
//				+ ", nameIndividual=" + nameIndividual + ", smokes=" + smokes + ", other=" + other + ", special="
//				+ special + ", stop=" + stop + ", emails=" + emails + ", addresses=" + addresses + ", fones=" + fones
//				+ "]";
//	}

	
	
}
