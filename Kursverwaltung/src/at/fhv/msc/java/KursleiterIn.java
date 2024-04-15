package at.fhv.msc.java;

import java.util.LinkedList;

public class KursleiterIn {
	
	public final static String DEFAULT_NAME = "default leader";
	
	private String _leaderName;
	private LinkedList<Kurs> _courses;
	
	public KursleiterIn() {
		this(DEFAULT_NAME);
	}
	
	public KursleiterIn(String name) {
		_leaderName = name;
		_courses = new LinkedList<Kurs>();
	}
	
	public String getLeaderName() {
		return _leaderName;
	}

	public void setLeaderName(String _name) {
		this._leaderName = _name;
	}

	public LinkedList<Kurs> getCourses() {
		return _courses;
	}

	public void setCourses(LinkedList<Kurs> _courses) {
		this._courses = _courses;
	}
	
	public void addCourse(Kurs kurs) {
		_courses.add(kurs);
	}
	
	public void printCourses() {
		System.out.println("\n\n" +
						   "+---------------------------------------+\n" +
						   "| Alle Kurse von " + _leaderName + ":\t\t\t|\n" +
				           "+---------------------------------------+");
		
		for (Kurs course : _courses) {
			System.out.println("|\tKurs: \t" + course.getCourseName() + "\t\t|\n" +
				               "|                                       |");
		}
		
		System.out.println("+---------------------------------------+");
	}

	@Override
	public String toString() {
		return "KursleiterIn [_leaderName=" + _leaderName + ", _courses=" + _courses + ", getLeaderName()="
				+ getLeaderName() + ", getCourses()=" + getCourses() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
