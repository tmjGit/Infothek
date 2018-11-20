package generic;

/**
 * Describes field properties one table.
 *
 */
public class DbField {
	public String name;
	public String displayName;
//	public String variableName;
	public Class<?> type;
	public boolean editable;
		
//	public DbField(String name, String displayname, String variableName, Class<?> type, boolean editable) {
	public DbField(String name, String displayname, Class<?> type, boolean editable) {
		this.name=name;
		this.displayName=displayname;
	//	this.variableName=variableName;
		this.type=type;
		this.editable=editable;
	}
}
