package at.fhv.msc.java;

import java.util.Arrays;

public class Backpack {
	
	public final static int _DEFAULT_SIZE = 10;
	private int _volume;
	Item[] _backpackContent;
	private static int _staticBackpackID = 0;
	private int _backpackID = 0;
	
	public Backpack() {
		this(_DEFAULT_SIZE);
	}
	
	public Backpack(int volume) {
		_volume = volume;
		_backpackContent = new Item[_volume];
		
		for (int i = 0; i < _volume; i++) {
			_backpackContent[i] = new Item();
		}
		
		_backpackID = (_staticBackpackID++) + 1;
	}

	public int getVolume() { return _volume; }

	public Item[] getBackpackContent() { return _backpackContent; }

	public int getBackpackID() { return _backpackID; }

	public String addItem(Item item) {
		for (int i = 0; i < _volume; i++) {
			if (_backpackContent[i].getItem() == "<>") {
				_backpackContent[i] = item;
				return "ITEM " + _backpackContent[i].getItemID() + " ADDED";
			}
		}

		return "BACKPACK STORAGE FULL, DROP ITEMS";
	}
	
	public String dropItem(Item item, int ID) {
		for (int i = 0; i < _volume; i++) {
			if ((_backpackContent[i].getItem() != "<>") && (_backpackContent[i].getItemID() == ID)) {
				
				_backpackContent[i] = new Item();
				return "ITEM " + item.getItemID() + " DROPPED";
			}
		}

		return "ITEM " + item.getItemID() + " NOT FOUND";
	}
	
	@Override
	public String toString() {
		return "Backpack [_volume=" + _volume + ", _backpack=" + Arrays.toString(_backpackContent) + "]";
	}



	public static void main(String[] args) {
		Backpack testBackpack = new Backpack(2);
		
		String weaponSword1BL = "BLACK SWORD";
		String weaponSword2BL = "BLACK SWORD";
		String weaponSword3BL = "BLACK SWORD";
		String weaponSword1WH = "WHITE SWORD";
		String weaponSword2WH = "WHITE SWORD";
		String weaponSword3WH = "WHITE SWORD";
		
		String shieldShield1 = "BASE SHIELD";
		String shieldShield2 = "ADVANCED SHIELD";
		
		String boosterStrengthBooster1 = "BOOSTER";
		String boosterStrengthBooster2 = "BOOSTER";
		String boosterStaminaBooster1 = "BOOSTER";
		
		String potionHealthPotion1 = "POTION";
		String potionHealthPotion2 = "POTION";
		String potionHealthPotion3 = "POTION";
		String potionHealthPotion4 = "POTION";
		String potionHealthPotion5 = "POTION";
		
		Item itemToRemove1 = new Item("POTION");
		Item itemToRemove2 = new Item("BOOSTER");
		
		String msg1 = testBackpack.addItem(new Item(weaponSword1BL));
		String msg2 = testBackpack.addItem(new Item(weaponSword2BL));
		String msg3 = testBackpack.addItem(new Item(shieldShield1));
		testBackpack.addItem(itemToRemove1);
		testBackpack.addItem(new Item(potionHealthPotion1));
		testBackpack.addItem(itemToRemove2);
		
		System.out.println(msg1);
		System.out.println(msg2);
		System.out.println(msg3 + "\n");
		
		System.out.println("Backpack Status:");
		
		for (int i = 0; ((i < testBackpack.getVolume()) && (testBackpack._backpackContent[i] != null)); i++) {
			System.out.println("Pos " + (i + 1) + ":\t\tID" + testBackpack._backpackContent[i].getItemID() + " " + testBackpack._backpackContent[i].getItem());
		}
		
//		System.out.println(testBackpack.toString());
		
		String msg4 = testBackpack.dropItem(itemToRemove1,1001);
		testBackpack.dropItem(itemToRemove2,1002);
		
		System.out.println("\n\n" + msg4);
		
		System.out.println("\nBackpack Status:");
		
		for (int i = 0; ((i < testBackpack.getVolume()) && (testBackpack._backpackContent[i] != null)); i++) {
			System.out.println("Pos " + (i + 1) + ":\t\tID" + testBackpack._backpackContent[i].getItemID() + " " + testBackpack._backpackContent[i].getItem());
		}
		
//		System.out.println(testBackpack.toString());
	}

}
