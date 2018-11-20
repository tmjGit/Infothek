package generic;

public class DbIntValue extends DbValue<Integer> {
//	public DbIntValue(int value) {
//		super(value);
//	}

//	public DbIntValue(String name, String displayname, String variableName, boolean editable) {
//		super(name, displayname, variableName, editable);
//	}

	@Override
	public Integer getValue() {
		return this.value;
	}

	@Override
	public void setValue(Integer value) {
		super.value = value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}
