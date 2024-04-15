package at.fhv.msc.java;

public class Gruppenkurs extends Kurs {
	
	public Gruppenkurs(String kurstitel, int maximaleTeilnehmeranzahl) {
		super(kurstitel, maximaleTeilnehmeranzahl);
	}

	@Override
	public String toString() {
		return "Gruppenkurs [getCourseName()=" + getCourseName() + ", getMaxAttendees()=" + getMaxAttendees()
				+ ", getCourseLeader()=" + getCourseLeader() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
