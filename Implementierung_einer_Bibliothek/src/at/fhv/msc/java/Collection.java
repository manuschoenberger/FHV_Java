package at.fhv.msc.java;

import java.util.LinkedList;

public class Collection {
	
	private static Collection _instance;
	
	private LinkedList<Product> _products;
	
	private LinkedList<Book> _books;
	private LinkedList<Magazine> _magazines;
	private LinkedList<Video> _videos;
	private LinkedList<CDRom> _cds;
	private LinkedList<Videogame> _videogames;
	private LinkedList<Customer> _customer;
	
	private Collection() {
		_products = new LinkedList<>();
		
		_books = new LinkedList<>();
		_magazines = new LinkedList<>();
		_videos = new LinkedList<>();
		_cds = new LinkedList<>();
		_videogames = new LinkedList<>();
		_customer = new LinkedList<>();
	}
	
	public static Collection instance() {
		if (_instance == null) {
			_instance = new Collection();
		}
		return _instance;
	}
	
	public StringBuilder printAllProducts() {
		StringBuilder output = new StringBuilder();
		
		for (Product product : _products) {
			output.append(product.printInfo() + "\n");
		}
		
		return output;
	}
	
	public StringBuilder printAllCustomers() {
		StringBuilder output = new StringBuilder();

		for (Customer customer : _customer) {
			output.append(customer.printCustomerBorrows() + "\n");
		}
		
		return output;
	}
	
	// GETTER / SETTER:

	public LinkedList<Book> getBooks() {
		return _books;
	}

	public void setBooks(LinkedList<Book> books) {
		_books = books;
	}

	public LinkedList<Magazine> getMagazines() {
		return _magazines;
	}

	public void setMagazines(LinkedList<Magazine> magazines) {
		_magazines = magazines;
	}

	public LinkedList<Video> getVideos() {
		return _videos;
	}

	public void setVideos(LinkedList<Video> videos) {
		_videos = videos;
	}

	public LinkedList<CDRom> getCds() {
		return _cds;
	}

	public void setCds(LinkedList<CDRom> cds) {
		_cds = cds;
	}

	public LinkedList<Videogame> getVideogames() {
		return _videogames;
	}

	public void setVideogames(LinkedList<Videogame> videogames) {
		_videogames = videogames;
	}

	public LinkedList<Customer> getCustomer() {
		return _customer;
	}

	public void setCustomer(LinkedList<Customer> customer) {
		_customer = customer;
	}
	
	public LinkedList<Product> getProducts() {
		return _products;
	}

	public void setProducts(LinkedList<Product> products) {
		_products = products;
	}
}
