package generic;

public class DbStringValue extends DbValue<String> {
//	public DbStringValue(String value) {
//		this.value=value;
//		super(value);
//	}

//	public DbStringValue(String name, String displayname, String variableName, boolean editable) {
//		super(name, displayname, variableName, editable);
//	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public void setValue(String value) {
		super.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
