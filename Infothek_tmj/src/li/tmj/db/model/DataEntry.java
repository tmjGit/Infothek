package li.tmj.db.model;

import java.time.LocalDateTime;

/**
 * This class takes a field name as String and the corresponding value as object
 * which may be a String, an int or a LocalDateTime.
 * @author Student
 *
 */
public class DataEntry {
    private String fieldName;
    private Object value;

    public DataEntry(String fieldName, Object value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getValue() {
        return value;
    }
    
    public String getValueAsString() {
    	return (String) value;
    }
    
    public int getValueAsInt() {
    	return (int) value;
    }
    
    public LocalDateTime getValueAsLocalDateTime() {
    	return (LocalDateTime) value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    
    public boolean valueIsString() {
    	return value instanceof String;
    }
    
    public boolean valueIsInt() {
    	return value.getClass().equals(int.class);
    }
    
    public boolean valueIsLocalDateTime() {
    	return value instanceof LocalDateTime;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataEntry other = (DataEntry) obj;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DataEntry [fieldName=" + fieldName + ", value=" + value + "]";
	}

}