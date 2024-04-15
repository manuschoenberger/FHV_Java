package at.fhv.msc.java;

public class Person {
	
	public final static String DEFAULT_NAME = "default person";
	
	private String _name;
	
	public Person() {
		this(DEFAULT_NAME);
	}
	
	public Person(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}

	@Override
	public String toString() {
		return "Person [_name=" + _name + ", getName()=" + getName() + "]";
	}
}
