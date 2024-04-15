package at.fhv.msc.java;

public class Individualtraining extends Kurs {
	
	public Individualtraining(String kurstitel) {
		super(kurstitel,1);
	}

	@Override
	public String toString() {
		return "Individualtraining [getCourseName()=" + getCourseName() + ", getMaxAttendees()=" + getMaxAttendees()
				+ ", getCourseLeader()=" + getCourseLeader() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
