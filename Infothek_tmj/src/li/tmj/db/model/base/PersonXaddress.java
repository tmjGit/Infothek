package li.tmj.db.model.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonXaddress extends Cross {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Override
	public int getId() {
		return id;
	}

}
