package at.fhv.msc.java;

import java.util.Scanner;

public class Console {
	
	private static Console _instance;

	private DataConfig _data;
	
	private Console() {
		_data = DataConfig.instance();
	}
	
	public static Console instance() {
		if (_instance == null) {
			_instance = new Console();
		}
		return _instance;
	}

	public DataConfig getData() {
		return _data;
	}

	public void setData(DataConfig data) {
		_data = data;
	}

	public static void main(String[] args) {
		Console console = Console.instance();
		
		Scanner scanner0 = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		Scanner scanner3 = new Scanner(System.in);
		Scanner scanner4 = new Scanner(System.in);
		Scanner scanner5 = new Scanner(System.in);
		Scanner scanner6 = new Scanner(System.in);
		Scanner scanner7 = new Scanner(System.in);
		Scanner scanner8 = new Scanner(System.in);
		
		while (true) {
			System.out.println("Write customer name, to make action with");
			
			for (Customer customer : console.getData().getCollection().getCustomer()) {
				System.out.println("> " + customer.getName());
			}
			
			String customerChoice = scanner0.next();
			Customer currentCustomer = new Customer();
			
			for (Customer customer : console.getData().getCollection().getCustomer()) {
				if (customer.getName().equals(customerChoice)) {
					currentCustomer = customer;
				}
			}
			
			boolean changeCustomer = false;
	        
	        while (changeCustomer == false) {
				System.out.println("\nWhat would you like to do?");
		        System.out.println("'borrow':\tBorrow product");
		        System.out.println("'unborrow':\tUnborrow product");
		        System.out.println("'unreserve':\tUnreserve product");
		        System.out.println("'extend':\tExpand borrow-time");
		        System.out.println("'products':\tPrint product data and status");
		        System.out.println("'product':\tPrint specific product");
		        System.out.println("'current':\tPrint current customer borrows");
		        System.out.println("'past':\t\tPrint past customer borrows");
		        System.out.println("'change':\tChange current Customer");
		        System.out.println("'exit':\t\tExit console\n");
		        
		        String choice = scanner1.next();
		        
		        switch (choice) {
		        case "exit":
		        	System.out.println("\nDo you want to exit the console? y/n");
		        	choice = scanner6.nextLine();
		        	if (choice.equals("y")) {
		        		System.out.println("\nConsole closed!");
		        		System.exit(0);
		        	}
		        	break;
		        case "borrow":
		        	System.out.println("\nWhat product would you like to borrow?\n");
		        	System.out.println(console.getData().getCollection().printAllProducts());  
		        	System.out.println("Write name of the product:\n");
		        	
		        	String choiceProductBorrow = scanner2.next();
		        	boolean bV1 = false;
		        	
		        	for (Product product : console.getData().getCollection().getProducts()) {
		        		if (product.getName().equals(choiceProductBorrow)) {
		        			bV1 = true;
		        			try {
								System.out.println(product.borrow(currentCustomer));
							} catch (ReservingNotPossibleException e1) {
								System.out.println(e1.getMessage());
							}
		        		}
		        	}
		        	
		        	if (bV1 == false) {
		        		System.out.println("Product not found");
		        	}
		        	
		        	break;
		        case "unborrow":
		        	if (currentCustomer.getCurrentlyBorrowedProducts().isEmpty()) {
		        		System.out.println("No products currently borrowed");
		        	} else {
		        		System.out.println("\nWhat product would you like to unborrow?\n");
		        		
			        	for (Product product : currentCustomer.getCurrentlyBorrowedProducts()) {
			        		System.out.println("> " + product.getName());
			        	}
			        	
			        	System.out.println("\nWrite name of the product:\n");
			        	
			        	String choiceProductUnborrow = scanner3.next();
			        	boolean bV2 = false;
			        	
			        	for (Product product : currentCustomer.getCurrentlyBorrowedProducts()) {
			        		if (product.getName().equals(choiceProductUnborrow)) {
			        			bV2 = true;
			        			System.out.println(product.unborrow(currentCustomer));
			        		}
			        	}
			        	
			        	if (bV2 == false) {
			        		System.out.println("Item not found");
			        	}
		        	}

		        	break;
		        case "unreserve":
		        	if (currentCustomer.getCurrentlyReservedProducts().isEmpty()) {
		        		System.out.println("No products currently reserved");
		        	} else {
		        		System.out.println("\nWhat product would you like to unreserve?\n");
		        		
			        	for (Product product : currentCustomer.getCurrentlyReservedProducts()) {
			        		System.out.println("> " + product.getName());
			        	}
			        	
			        	System.out.println("\nWrite name of the product:\n");
			        	
			        	String choiceProductUnreserve = scanner8.next();
			        	boolean bV5 = false;
			        	
			        	for (Product product : currentCustomer.getCurrentlyReservedProducts()) {
			        		if (product.getName().equals(choiceProductUnreserve)) {
			        			bV5 = true;
			        			try {
									System.out.println(product.unreserve(currentCustomer));
								} catch (ProductNotReservedException e4) {
									System.out.println(e4.getMessage());
								}
			        		}
			        	}
			        	
			        	if (bV5 == false) {
			        		System.out.println("Item not found");
			        	}
		        	}
		        	
		        	break;
		        case "extend":
		        	if (currentCustomer.getCurrentlyBorrowedProducts().isEmpty()) {
		        		System.out.println("\nNo products currently in possession\n");
		        	} else {
		        		System.out.println("\nWhat product would you like to extend?\n");
			        	for (Product product : currentCustomer.getCurrentlyBorrowedProducts()) {
			        		System.out.println("> " + product.getName());
			        	}	  
			        	
			        	System.out.println("\nWrite name of the product:\n");
			        	
			        	String choiceProductExtend = scanner4.next();
			        	boolean bV3 = false;
			        	
			        	System.out.println("\nHow many days do you want to extend this product?\n");
			        	
			        	int choiceProductExtendAmount = scanner5.nextInt();
			        	
			        	for (Product product : console.getData().getCollection().getProducts()) {
			        		if (product.getName().equals(choiceProductExtend)) {
			        			bV3 = true;
			        			try {
			        				System.out.println(product.extend(currentCustomer,choiceProductExtendAmount));
			        			} catch (MaxExtensionsReachedException e2) {
			        				System.out.println(e2.getMessage());
			        			} catch (ProductNotBorrowedException e3) {
									System.out.println(e3.getMessage());
								}
			        		}
			        	}
			        	
			        	if (bV3 == false) {
			        		System.out.println("Item not found");
			        	}
		        	}

		        	break;
		        case "products":
		        	System.out.println(console.getData().getCollection().printAllProducts());
		        	break;
		        case "product":
		        	System.out.println("\nWhat product would you like to print?\n");
		        	for (Product product : console.getData().getCollection().getProducts()) {
		        		System.out.println("> " + product.getProductID());
		        	}
		        	
		        	System.out.println("\nWrite ID of the product:\n");
		        	
		        	int choiceProductID = scanner7.nextInt();
		        	boolean bV4 = false;
		        	
		        	for (Product product : console.getData().getCollection().getProducts()) {
		        		if (product.getProductID() == choiceProductID) {
		        			bV4 = true;
		        			System.out.println(product.printInfo());
		        		}
		        	}
		        	
		        	if (bV4 == false) {
		        		System.out.println("Item not found");
		        	}
		        	
		        	break;
		        case "current":
		        	System.out.println(currentCustomer.printCustomerBorrows());
		        	break;
		        case "past":
		        	System.out.println(currentCustomer.printPastCustomerBorrows());
		        	break;
		        case "change":
		        	changeCustomer = true;
		        	break;
		        default: 
		        	System.out.println("Invalid option");
		        }
	        }
		}
	}
}
