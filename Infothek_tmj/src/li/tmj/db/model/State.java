package li.tmj.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class State extends Data {
	private static final long serialVersionUID = 1L;
	private String nameDeu;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Override
	public int getId() {
		return id;
	}
	
	public State() {
		
	}
	
	public State(int id) {
		setId(id);
	}

	public String getNameDeu() {
		return nameDeu;
	}

	public void setNameDeu(String nameDeu) {
		this.nameDeu = nameDeu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nameDeu == null) ? 0 : nameDeu.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "State [nameDeu=" + nameDeu + "]";
	}


	

	
	
}
