import java.time.LocalDate;
import java.time.Period;

public class Person {
	  
	public enum Gender {
		male, female;
	}
	
	private String _firstName;
	private String _lastName;
	private Gender _gender;
	private LocalDate _birthDate;
	
	private Person _partner;
	private Person _mainBestMan1;
	private Person _mainBestMan2;
	
	private String _maidenName;
	private boolean _engagement;
	private String _divorceReason;
	
	public Person(String firstName, String lastName, Gender gender, LocalDate dateOfBirth) {
		_firstName = firstName;
		_lastName = lastName;
		_gender = gender;
		_birthDate = dateOfBirth;
		
		_partner = null;
		_mainBestMan1 = null;
		_mainBestMan2 = null;
		
		_maidenName = null;
		_engagement = false;
		_divorceReason = null;
	}
	
	public String marry(Person partner, Person bestMan1, Person bestMan2) {
		LocalDate currentDate = LocalDate.now();
		
		if ((_engagement == false) && (partner._engagement == false) && (Period.between(_birthDate, currentDate).getYears() >= 18) && (Period.between(partner._birthDate, currentDate).getYears() >= 18) && (Period.between(bestMan1._birthDate, currentDate).getYears() >= 18) && (Period.between(bestMan2._birthDate, currentDate).getYears() >= 18) && (_gender != partner._gender)) {
			_partner = partner;
			partner._partner = this;
			_engagement = true;
			partner._engagement = true;
			
			_mainBestMan1 = bestMan1;
			partner._mainBestMan1 = bestMan1;
			_mainBestMan2 = bestMan2;
			partner._mainBestMan2 = bestMan2;
			
			if (_gender == Gender.female) {
				_maidenName = _lastName;
				_lastName = _partner._lastName;
			} else {
				partner._maidenName = partner._lastName;
				partner._lastName = _lastName;
			}
			
			return "Marriage successful!";
		} else if (!(_engagement == false)) {
			return "Person is already engaged!";
		} else if (!(partner._engagement == false)) {
			return "Partner is already engaged!";
		} else if (!(Period.between(_birthDate, currentDate).getYears() >= 18)) {
			return "Person must be older than 18!";
		} else if (!(Period.between(partner._birthDate, currentDate).getYears() >= 18)) {
			return "Partner must be older than 18!";
		} else if (!(Period.between(bestMan1._birthDate, currentDate).getYears() >= 18)) {
			return "First Best Man must be older than 18!";
		} else if (!(Period.between(bestMan2._birthDate, currentDate).getYears() >= 18)) {
			return "Second Best Man must be older than 18!";
		} else if (!(_gender != partner._gender)) {
			return "Couple must be of different gender!";
		} else {
			return "ERROR";
		}
	}
	
	public String divorce(Person partner, String reasonForDivorce) {
		if ((_partner != null) && (partner._partner != null)) {
			_partner = null;
			partner._partner = null;
			_divorceReason = reasonForDivorce;
			partner._divorceReason = reasonForDivorce;
			
			_mainBestMan1 = null;
			partner._mainBestMan1 = null;
			_mainBestMan2 = null;
			partner._mainBestMan2 = null;
			
			if (_gender == Gender.female) {
				_lastName = _maidenName;
				_maidenName = null;
			} else {
				partner._lastName = partner._maidenName;
				partner._maidenName = null;
			}
			
			return "Divorce successful!";
		} else if (!(_partner != null) || !(partner._partner != null)) {
			return "Couple is not engaged!";
		} else {
			return "ERROR";
		}
	}

	@Override
	public String toString() {
		return "Person [_firstName=" + _firstName + ", _lastName=" + _lastName + ", _gender=" + _gender
				+ ", _birthDate=" + _birthDate + ", _partner=" + _partner + ", _mainBestMan1=" + _mainBestMan1
				+ ", _mainBestMan2=" + _mainBestMan2 + ", _maidenName=" + _maidenName + ", _engagement=" + _engagement
				+ ", _divorceReason=" + _divorceReason + "]";
	}

	public static void main(String[] args) {
		Person person1 = new Person("Max","Mustermann",Gender.male,LocalDate.of(2000,1,1));
		Person person2 = new Person("Maria","Musterfrau",Gender.female,LocalDate.of(2000,1,1));
		
		Person bestMan1 = new Person("Trauzeuge","1",Gender.male,LocalDate.of(2000,1,1));
		Person bestMan2 = new Person("Trauzeuge","2",Gender.female,LocalDate.of(2000,1,1));
		
		System.out.println(person1.marry(person2, bestMan1, bestMan2));

		System.out.println(person2.divorce(person1,"Vernächlässigung"));
	}

}
