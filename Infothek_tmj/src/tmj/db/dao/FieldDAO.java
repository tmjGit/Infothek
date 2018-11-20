package tmj.db.dao;

public class FieldDAO {
	public String name;
	public String displayName;
	public String variableName;
	public Class<?> type;
	public boolean editable;
	
	public FieldDAO(String name, String displayname, String variableName, Class<?> type, boolean editable) {
		this.name=name;
		this.displayName=displayname;
		this.variableName=variableName;
		this.type=type;
		this.editable=editable;
	}
}
	