package generic;

/**
 * Containts one value of any type.
 * Corresponds to one field of one database record
 * 
 */
public abstract class DbValue<T> {
	protected T value;
//	public String name;
//	public String displayName;
//	public String variableName;
//	public Class<?> type;
//	public boolean editable;
	
	public abstract T getValue();
	public abstract void setValue(T value);
	
//	public DbValue(String name, String displayname, String variableName, boolean editable) {
//		this.name=name;
//		this.displayName=displayname;
//		this.variableName=variableName;
////		this.type=type;
//		this.editable=editable;
//	}
	
	@Override
	public abstract String toString() ;
	
//	public DbValue(T value) {
//		this();
//		this.value = value;
//	};
	
	
}


