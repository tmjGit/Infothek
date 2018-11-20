package generic;

public class DbBooleanValue extends DbValue<Boolean> {
//	public DbBooleanValue(boolean value) {
//		super();
//		this.value = value;
//		super(value);
//	}
	
//	public DbBooleanValue(String name, String displayname, String variableName, boolean editable) {
//		super(name, displayname, variableName, editable);
//	}

	@Override
	public Boolean getValue() {
		return this.value;
	}

	@Override
	public void setValue(Boolean value) {
		super.value = value;
	}
	

	@Override
	public String toString() {
		return value.toString();
	}
}
