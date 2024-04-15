package at.fhv.msc.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class Kursplaner {
	
	private LinkedList<Termin> _meetings;
	private static Kursplaner _instance;
	
	private Kursplaner() {
		_meetings = new LinkedList<Termin>();
	}
	
	public static Kursplaner instance() {
		if (_instance == null) {
			_instance = new Kursplaner();
		}
		return _instance;
	}

	public LinkedList<Termin> getMeetings() {
		return _meetings;
	}

	public void setMeetings(LinkedList<Termin> _meetings) {
		this._meetings = _meetings;
	}
	
	public void addMeeting(Termin termin) {
		_meetings.add(termin);
	}
	
    public void printMeetingsOnDate(LocalDate date) {
    	System.out.println("\n\nKurse am " + date + ":");
    	
        for (Termin meeting : _meetings) {
            if (meeting.getDate().equals(date)) {
            	meeting.printMeeting();
            }
        }
    }

	@Override
	public String toString() {
		return "Kursplaner [_meetings=" + _meetings + ", getMeetings()=" + getMeetings() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public static void main(String[] args) {
		Kursplaner planner = Kursplaner.instance();
		
		Kurs gr1 = new Gruppenkurs("grkurs 1",8);
		Kurs gr2 = new Gruppenkurs("grkurs 2",3);
		Kurs in1 = new Individualtraining("inkurs 1");
		Kurs in2 = new Individualtraining("inkurs 2");
		
		KursleiterIn kL1 = new KursleiterIn("Laura");
		KursleiterIn kL2 = new KursleiterIn("Franz");
		
		Person p1 = new Person("Person 1");
		Person p2 = new Person("Person 2");
		Person p3 = new Person("Person 3");
		Person p4 = new Person("Person 4");
		Person p5 = new Person("Person 5");
		
		Termin t1 = new Termin(LocalDate.of(2023, 4, 17),LocalTime.of(8, 15) ,LocalTime.of(9, 45), gr1,kL1);
		Termin t2 = new Termin(LocalDate.of(2023, 4, 17),LocalTime.of(13, 10),LocalTime.of(17, 30),gr1,kL1);
		Termin t3 = new Termin(LocalDate.of(2023, 4, 18),LocalTime.of(10, 30),LocalTime.of(11, 0), in1,kL2);
		Termin t4 = new Termin(LocalDate.of(2023, 4, 19),LocalTime.of(8, 15) ,LocalTime.of(9, 45), gr1,kL1);
		Termin t5 = new Termin(LocalDate.of(2023, 4, 19),LocalTime.of(13, 10),LocalTime.of(17, 30),gr1,kL1);
		Termin t6 = new Termin(LocalDate.of(2023, 4, 20),LocalTime.of(16, 0) ,LocalTime.of(18, 0), gr2,kL2);
		Termin t7 = new Termin(LocalDate.of(2023, 4, 21),LocalTime.of(10, 30),LocalTime.of(11, 0), in2,kL1);
		Termin t8 = new Termin(LocalDate.of(2023, 4, 22),LocalTime.of(10, 30),LocalTime.of(11, 0), in2,kL1);
		Termin t9 = new Termin(LocalDate.of(2023, 4, 23),LocalTime.of(10, 30),LocalTime.of(11, 0), in2,kL1);

		t1.addAttendee(p1);
		t1.addAttendee(p2);
		t1.addAttendee(p3);

		t2.addAttendee(p1);
		t2.addAttendee(p2);
		t2.addAttendee(p3);
		
		t3.addAttendee(p1);
		t3.addAttendee(p2); // "Maximum an Teilnehmer:innen bereits erreicht"

		t4.addAttendee(p1);
		t4.addAttendee(p2);
		t4.addAttendee(p3);
		
		t5.addAttendee(p1);
		t5.addAttendee(p2);
		t5.addAttendee(p3);
		
		t6.addAttendee(p1);
		t6.addAttendee(p2);
		t6.addAttendee(p3);
		t6.addAttendee(p4);
		t6.addAttendee(p5);
		
		t7.addAttendee(p1);

		t8.addAttendee(p2);
		
		t9.addAttendee(p3);
		
		// Kursbeschreibungen ausdrucken
		t1.printMeeting();
		t2.printMeeting();
		t3.printMeeting();
		t4.printMeeting();
		t5.printMeeting();
		t6.printMeeting();
		t7.printMeeting();
		t8.printMeeting();
		t9.printMeeting();
		
		// Kurse der Kurleiter:innen
		kL1.printCourses();
		kL2.printCourses();
		
		// Kursleiter:innen der jeweiligen Kurse
		gr1.printCourseLeader();
		gr2.printCourseLeader();
		in1.printCourseLeader();
		in2.printCourseLeader();
		
		planner.printMeetingsOnDate(LocalDate.of(2023, 4, 19));
	}
}
