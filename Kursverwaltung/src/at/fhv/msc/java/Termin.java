package at.fhv.msc.java;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class Termin {
	
	private LocalDate _date;
	private LocalTime _begin;
	private LocalTime _end;
	private Duration _duration;
	
	private Kurs _course;
	private KursleiterIn _courseLeader;
	private LinkedList<Person> _attendees;
	
	private Kursplaner _coursePlanner;
	
	public Termin(LocalDate datum, LocalTime beginn, LocalTime ende, Kurs kurs, KursleiterIn kursleiterIn) {
		_date = datum;
		_begin = beginn;
		_end = ende;
		_duration = Duration.between(_begin, _end);
		
		_course = kurs;
		_courseLeader = kursleiterIn;
		
	    if (!_course.getCourseLeader().contains(_courseLeader)) {
            _course.addCourseLeader(_courseLeader);
        }
		
        if (!_courseLeader.getCourses().contains(_course)) {
            _courseLeader.addCourse(_course);
        }
        
		_attendees = new LinkedList<Person>();

		_coursePlanner = Kursplaner.instance();
		_coursePlanner.addMeeting(this);;
	}
	
	public LocalDate getDate() {
		return _date;
	}

	public void setDate(LocalDate _date) {
		this._date = _date;
	}

	public LocalTime getBegin() {
		return _begin;
	}

	public void setBegin(LocalTime _begin) {
		this._begin = _begin;
	}

	public LocalTime getEnd() {
		return _end;
	}

	public void setEnd(LocalTime _end) {
		this._end = _end;
	}

	public Duration getDuration() {
		return _duration;
	}

	public void setDuration(Duration _duration) {
		this._duration = _duration;
	}

	public Kurs getCourse() {
		return _course;
	}

	public void setCourse(Kurs _course) {
		this._course = _course;
	}

	public LinkedList<Person> getAttendees() {
		return _attendees;
	}

	public void setAttendees(LinkedList<Person> _attendees) {
		this._attendees = _attendees;
	}

	public KursleiterIn getCourseLeader() {
		return _courseLeader;
	}

	public void setCourseLeader(KursleiterIn _courseLeader) {
		this._courseLeader = _courseLeader;
	}

	public void addAttendee(Person person) {
		if (_attendees.size() > _course.getMaxAttendees()) {
			System.out.println("Maximum an Teilnehmer:innen bereits erreicht");
		} else {
			_attendees.add(person);
		}
	}
	
	public void removeAttendee(Person person) {
		if (!_attendees.contains(person)) {
			System.out.println("Person nicht gefunden!");
		} else {
			_attendees.remove(person);
		}
	}
	
	public void printMeeting() {
		System.out.println("\n\n" +
						   "+---------------------------------------+\n" + 
						   "|\tDatum: \t" + _date + "\t\t|\n" +
						   "|                                       |\n" +
						   "|\tBeginn: " + _begin + "\t\t\t|\n" +
						   "|                                       |\n" +
						   "|\tEnde: \t" + _end + "\t\t\t|\n" +
						   "|                                       |\n" +
						   "|\tLänge: \t" + _duration + "\t\t\t|\n" +
						   "|                                       |\n" +
						   "|\tKursleiter:in: " + _courseLeader.getLeaderName() + "\t\t|\n" +
						   "|                                       |\n" +
						   "|\tKurs: \t" + _course.getCourseName() + "\t\t|\n" +
						   "|                                       |");
		
		System.out.println("+---------------------------------------+\n" +
						   "|\tBESUCHER:INNEN: \t\t|\n" +
						   "+---------------------------------------+");
		
		for (Person attendee : _attendees) {
			System.out.println("|\tName: \t" + attendee.getName() + "\t\t|\n" +
						       "|                                       |");
		}
		
		System.out.println("+---------------------------------------+");
		
	}

	@Override
	public String toString() {
		return "Termin [_date=" + _date + ", _begin=" + _begin + ", _end=" + _end + ", _duration=" + _duration
				+ ", _course=" + _course + ", _courseLeader=" + _courseLeader + ", _attendees=" + _attendees
				+ ", _coursePlanner=" + _coursePlanner + ", getDate()=" + getDate() + ", getBegin()=" + getBegin()
				+ ", getEnd()=" + getEnd() + ", getDuration()=" + getDuration() + ", getCourse()=" + getCourse()
				+ ", getAttendees()=" + getAttendees() + ", getCourseLeader()=" + getCourseLeader() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
