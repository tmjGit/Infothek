package li.tmj.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email extends Data {
	private static final long serialVersionUID = 1L;
	//	private int personId;
	private String to;
	private String realname;
	private String URL;
//	@ManyToOne
//	private Person person;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Override
	public int getId() {
		return id;
	}

	public Email() {
		
	}
	
	public Email(int id) {
		setId(id);
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((URL == null) ? 0 : URL.hashCode());
		result = prime * result + ((realname == null) ? 0 : realname.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Email [to=" + to + ", realname=" + realname + ", URL=" + URL + "]";
	}
}
