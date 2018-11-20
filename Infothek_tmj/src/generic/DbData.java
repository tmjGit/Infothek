package generic;

/**
 * Contains values of any (mixed) types.
 * Corresponds to one database record.
 */
public class DbData {
	private DbValue<?>[] values;
	 
	public DbData(int countValues) {
		values=new DbValue[countValues];// throws DBConnectException { // alternativ hier Fehlerlogging + throw new DaoException					 
	}

	public DbValue<?> getValue(int Index) {
		return values[Index];
	}

	public void setValue(int Index, DbValue<?> value) {
		this.values[Index] = value;
	}

//	public void setIntValue(int Index, int value) {
//		((DbIntValue) this.values[Index]).setValue(value);
//	}
//
//	public void setStringValue(int Index, String value) {
//		((DbStringValue) this.values[Index]).setValue(value);
//	}
//
//	public void setBooleanValue(int Index, Boolean value) {
//		((DbBooleanValue) this.values[Index]).setValue(value);
//	}
//
//	public int getIntValue(int Index) {
//		return ((DbIntValue) values[Index]).getValue();
//	}
//
//	public String getStringValue(int Index) {
//		return ((DbStringValue) values[Index]).getValue();
//	}
//
//	public Boolean getBooleanValue(int Index) {
//		return ((DbBooleanValue) values[Index]).getValue();
//	}
	
}

