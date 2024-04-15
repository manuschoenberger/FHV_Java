package at.fhv.msc.java;

public class User {
	
	private DBConnection _connection;
	private boolean _connected;
	private static int _exceptionCounter;
	
	public User() {
		_connection = null;
		_connected = false;
		_exceptionCounter = 0;
	}
	
	public StringBuilder connect() {
		StringBuilder output = new StringBuilder();
		
		try {
			_connection = DBConnection.acquireConnection();
			_connected = true;
			output.append("\nSuccessfully connected");
		} catch (ConnectionLimitException e) {
			_exceptionCounter++;
			output.append(e.getMessage());
		}
		
		return output;
	}
	
	public StringBuilder disconnect() throws NotConnectedException  {
		StringBuilder output = new StringBuilder();

		try {
			DBConnection.dropConnection(_connection);
		} catch (NotConnectedException e) {
			_exceptionCounter++;
			throw e;
		}
		_connected = false;
		output.append("\nSuccessfully disconnected");

		return output;
	}
	
	// GETTER / SETTER:

	public DBConnection getConnection() {
		return _connection;
	}

	public void setConnection(DBConnection connection) {
		_connection = connection;
	}

	public boolean isConnected() {
		return _connected;
	}

	public void setConnected(boolean connected) {
		_connected = connected;
	}

	public static int get_exceptionCounter() {
		return _exceptionCounter;
	}

	public static void set_exceptionCounter(int _exceptionCounter) {
		User._exceptionCounter = _exceptionCounter;
	}
}
