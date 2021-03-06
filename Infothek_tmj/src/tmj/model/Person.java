package tmj.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Person implements Serializable{
	private static final long serialVersionUID = -491148874780953135L;
	// Struktur: id(int), namFam, namIndiv, created(Timestamp), changed(Timestamp),

	private int id=-1; // id generated by the external DB and then always >0
	private String namFam;
	private String namIndiv;
	private LocalDateTime created;
	private LocalDateTime changed;
	private int gebJahr;
	private int gebMonat;
	private int gebTag;
	private int stop;
	private String sex;
	
	public Person() {}

	public Person(String namFam, String namIndiv, LocalDateTime created, LocalDateTime changed, int gebJahr, int gebMonat, int gebTag, int stop, String sex) {
		this.namFam = namFam;
		this.namIndiv = namIndiv;
		this.created = created;
		this.changed = changed;
		this.gebJahr = gebJahr;
		this.gebMonat = gebMonat;
		this.gebTag = gebTag;
		this.stop = stop;
		this.sex = sex;
	}

	public Person(int id, String namFam, String namIndiv, LocalDateTime created, LocalDateTime changed, int gebJahr, int gebMonat, int gebTag, int stop, String sex) {
		this(namFam,   namIndiv,   created,   changed,   gebJahr,   gebMonat,   gebTag,   stop,   sex);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
	
}
