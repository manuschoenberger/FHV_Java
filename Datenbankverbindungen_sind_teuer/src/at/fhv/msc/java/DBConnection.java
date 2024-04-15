package at.fhv.msc.java;

import java.util.LinkedList;

public class DBConnection {
	
	final static int _DEFAULT_CONNECTIONS_DATABASES = 5;
	final static int _DEFAULT_MAX_CONNECTIONS = _DEFAULT_CONNECTIONS_DATABASES;
	private static LinkedList<DBConnection> _OpenConnections = new LinkedList<>();
	private static LinkedList<DBConnection> _ClosedConnections = new LinkedList<>();


	static {	
		for (int i = 0; i < _DEFAULT_CONNECTIONS_DATABASES ; i++) {
			_OpenConnections.add(new DBConnection());
		}
	}
	
	private DBConnection() {}
	
	public static DBConnection acquireConnection() throws ConnectionLimitException {
		if (_ClosedConnections.size() < _DEFAULT_MAX_CONNECTIONS) {
			DBConnection con = _OpenConnections.pop();
			_ClosedConnections.push(con);
			
			return con;
		} else {
			throw new ConnectionLimitException("\nConnection limit reached");
		}
	}
	
	public static void dropConnection(DBConnection connection) throws NotConnectedException {
		if (!_ClosedConnections.remove(connection)) {
			throw new NotConnectedException("Connection not found in list");
		}
		
		_OpenConnections.push(connection);
	}
}
