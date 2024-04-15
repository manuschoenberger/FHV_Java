package at.fhv.msc.java;

import java.util.LinkedList;

public abstract class Kurs {
	
	public final static String DEFAULT_COURSE_NAME = "default course";
	public final static int DEFAULT_MAXIMUM_ATTENDEES = 12;
	
	protected String _courseName;
	protected int _maxAttendees;
	protected LinkedList<KursleiterIn> _courseLeader;
	
	public Kurs() {
		this(DEFAULT_COURSE_NAME,DEFAULT_MAXIMUM_ATTENDEES);
	}
	
	public Kurs(String kurstitel, int maximaleTeilnehmeranzahl) {
		_courseName = kurstitel;
		_maxAttendees = maximaleTeilnehmeranzahl;
		_courseLeader = new LinkedList<KursleiterIn>();
	}
	
	public String getCourseName() {
		return _courseName;
	}

	public void setCourseName(String _courseName) {
		this._courseName = _courseName;
	}

	public int getMaxAttendees() {
		return _maxAttendees;
	}

	public void setMaxAttendees(int _maxAttendees) {
		this._maxAttendees = _maxAttendees;
	}

	public LinkedList<KursleiterIn> getCourseLeader() {
		return _courseLeader;
	}

	public void setCourseLeader(LinkedList<KursleiterIn> _courseLeader) {
		this._courseLeader = _courseLeader;
	}
	
	public void addCourseLeader(KursleiterIn kursleiterIn) {
		_courseLeader.add(kursleiterIn);
	}
	
	public void printCourseLeader() {
		System.out.println("\n\n" +
						   "+---------------------------------------+\n" +
						   "| Kursleiter:in von " + _courseName + ":\t\t|\n" +
				           "+---------------------------------------+");
		
		for (KursleiterIn courseLeader : _courseLeader) {
			System.out.println("|\tName: \t" + courseLeader.getLeaderName() + "\t\t\t|\n" +
				               "|                                       |");
		}
		
		System.out.println("+---------------------------------------+");
	}

	@Override
	public String toString() {
		return "Kurs [_courseName=" + _courseName + ", _maxAttendees=" + _maxAttendees + ", _courseLeader="
				+ _courseLeader + ", getCourseName()=" + getCourseName() + ", getMaxAttendees()=" + getMaxAttendees()
				+ ", getCourseLeader()=" + getCourseLeader() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
