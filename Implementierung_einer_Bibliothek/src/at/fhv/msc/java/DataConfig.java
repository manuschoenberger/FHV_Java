package at.fhv.msc.java;

import java.time.LocalDate;

public class DataConfig {
	
	private static DataConfig _instance;
	private Collection _collection;
	
	private Book _book1;
	private Book _book2;
	private Book _book3;
	
	private CDRom _cd1;
	private CDRom _cd2;
	private CDRom _cd3;
	
	private Magazine _mag1;
	private Magazine _mag2;
	private Magazine _mag3;
	
	private Video _video1;
	private Video _video2;
	private Video _video3;
	
	private Videogame _game1;
	private Videogame _game2;
	private Videogame _game3;
	
	private Customer _extPerson1;
	private Customer _extPerson2;
	private Customer _student1;
	private Customer _student2;
	private Customer _teacher1;
	private Customer _teacher2;
	
	private DataConfig() {
		_collection = Collection.instance();
		
		_book1 = new Book("Book1","978-4-8386-4318-9","Publisher1", 242);
		_book2 = new Book("Book2","978-9-9127-1243-0","Publisher2", 51);
		_book3 = new Book("Book3","978-5-0462-4237-9","Publisher2", 253);
		_book1.addMultiple(3);
		
		_cd1 = new CDRom("CD1","Artist1", 12);
		_cd2 = new CDRom("CD2","Artist2", 32);
		_cd3 = new CDRom("CD3","Artist2", 7);
		
		_mag1 = new Magazine("Magazine1",LocalDate.of(2023, 4, 17));
		_mag2 = new Magazine("Magazine2",LocalDate.of(2023, 4, 24));
		_mag3 = new Magazine("Magazine3",LocalDate.of(2023, 5, 1));
		
		_video1 = new Video("Video1","Genre1",129);
		_video2 = new Video("Video2","Genre2",142);
		_video3 = new Video("Video3","Genre2",301);
		
		_game1 = new Videogame("Game1","Console1");
		_game2 = new Videogame("Game2","Console2");
		_game3 = new Videogame("Game3","Console2");
		
		_extPerson1 = new Customer("ExtPerson1","Address1",CustomerType.external);
		_extPerson2 = new Customer("ExtPerson2","Address2",CustomerType.external);
		
		_student1 = new Customer("Student1","Address3",CustomerType.student);
		_student2 = new Customer("Student2","Address4",CustomerType.student);
		
		_teacher1 = new Customer("Teacher1","Address5",CustomerType.teacher);
		_teacher2 = new Customer("Teacher2","Address6",CustomerType.teacher);
	}
	
	public static DataConfig instance() {
		if (_instance == null) {
			_instance = new DataConfig();
		}
		return _instance;
	}

	// GETTER / SETTER:

	public Collection getCollection() {
		return _collection;
	}

	public void setCollection(Collection collection) {
		_collection = collection;
	}

	public Book getBook1() {
		return _book1;
	}

	public void setBook1(Book book1) {
		_book1 = book1;
	}

	public Book getBook2() {
		return _book2;
	}

	public void setBook2(Book book2) {
		_book2 = book2;
	}

	public Book getBook3() {
		return _book3;
	}

	public void setBook3(Book book3) {
		_book3 = book3;
	}

	public CDRom getCd1() {
		return _cd1;
	}

	public void setCd1(CDRom cd1) {
		_cd1 = cd1;
	}

	public CDRom getCd2() {
		return _cd2;
	}

	public void setCd2(CDRom cd2) {
		_cd2 = cd2;
	}

	public CDRom getCd3() {
		return _cd3;
	}

	public void setCd3(CDRom cd3) {
		_cd3 = cd3;
	}

	public Magazine getMag1() {
		return _mag1;
	}

	public void setMag1(Magazine mag1) {
		_mag1 = mag1;
	}

	public Magazine getMag2() {
		return _mag2;
	}

	public void setMag2(Magazine mag2) {
		_mag2 = mag2;
	}

	public Magazine getMag3() {
		return _mag3;
	}

	public void setMag3(Magazine mag3) {
		_mag3 = mag3;
	}

	public Video getVideo1() {
		return _video1;
	}

	public void setVideo1(Video video1) {
		_video1 = video1;
	}

	public Video getVideo2() {
		return _video2;
	}

	public void setVideo2(Video video2) {
		_video2 = video2;
	}

	public Video getVideo3() {
		return _video3;
	}

	public void setVideo3(Video video3) {
		_video3 = video3;
	}

	public Videogame getGame1() {
		return _game1;
	}

	public void setGame1(Videogame game1) {
		_game1 = game1;
	}

	public Videogame getGame2() {
		return _game2;
	}

	public void setGame2(Videogame game2) {
		_game2 = game2;
	}

	public Videogame getGame3() {
		return _game3;
	}

	public void setGame3(Videogame game3) {
		_game3 = game3;
	}

	public Customer getExtPerson1() {
		return _extPerson1;
	}

	public void setExtPerson1(Customer extPerson1) {
		_extPerson1 = extPerson1;
	}

	public Customer getExtPerson2() {
		return _extPerson2;
	}

	public void setExtPerson2(Customer extPerson2) {
		_extPerson2 = extPerson2;
	}

	public Customer getStudent1() {
		return _student1;
	}

	public void setStudent1(Customer student1) {
		_student1 = student1;
	}

	public Customer getStudent2() {
		return _student2;
	}

	public void setStudent2(Customer student2) {
		_student2 = student2;
	}

	public Customer getTeacher1() {
		return _teacher1;
	}

	public void setTeacher1(Customer teacher1) {
		_teacher1 = teacher1;
	}

	public Customer getTeacher2() {
		return _teacher2;
	}

	public void setTeacher2(Customer teacher2) {
		_teacher2 = teacher2;
	}
}
