package li.tmj.db.exception;

public class DBConnectException extends RuntimeException {
	private static final long serialVersionUID = -8682357067807286452L;

	public DBConnectException() {}

	public DBConnectException(String message) {
		super(message);
	}	
}
