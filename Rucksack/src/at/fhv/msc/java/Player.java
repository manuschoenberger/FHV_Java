package at.fhv.msc.java;

public class Player {
	
	private static int _staticPlayerID;
	private int _playerID;
	private Backpack _backpack;
	private int _health;
	private int _stamina;
	private int _shield;
	private int _totalXP;
	private int _level;
	private int _position;
	
	public Player() {
		_playerID = (_staticPlayerID++) + 1;
		_backpack = new Backpack();
	}
	
	public Player(int volume) {
		_playerID = (_staticPlayerID++) + 1;

		_backpack = new Backpack(volume);
		
	}
	
	public static int get_staticPlayerID() {
		return _staticPlayerID;
	}

	public static void set_staticPlayerID(int _staticPlayerID) {
		Player._staticPlayerID = _staticPlayerID;
	}

	public int get_playerID() {
		return _playerID;
	}

	public void set_playerID(int _playerID) {
		this._playerID = _playerID;
	}

	public Backpack get_backpack() {
		return _backpack;
	}

	public void set_backpack(Backpack _backpack) {
		this._backpack = _backpack;
	}

	public int get_health() {
		return _health;
	}

	public void set_health(int _health) {
		this._health = _health;
	}

	public int get_stamina() {
		return _stamina;
	}

	public void set_stamina(int _stamina) {
		this._stamina = _stamina;
	}

	public int get_shield() {
		return _shield;
	}

	public void set_shield(int _shield) {
		this._shield = _shield;
	}

	public int get_totalXP() {
		return _totalXP;
	}

	public void set_totalXP(int _totalXP) {
		this._totalXP = _totalXP;
	}

	public int get_level() {
		return _level;
	}

	public void set_level(int _level) {
		this._level = _level;
	}

	public int get_position() {
		return _position;
	}

	public void set_position(int _position) {
		this._position = _position;
	}

	public void addItemToBackpack(Item item) {
		_backpack.addItem(item);
	}
	
	public void dropItemFromBackpack(Item item, int itemID) {
		_backpack.dropItem(item, itemID);
	}

	@Override
	public String toString() {
		return "Player [_backpack=" + _backpack + "]";
	}

	public static void main(String[] args) {
		Player testPlayer = new Player();
		
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
		
		testPlayer.addItemToBackpack(new Item(weaponSword1BL));
		testPlayer.addItemToBackpack(new Item(weaponSword2BL));
		testPlayer.addItemToBackpack(new Item(shieldShield1));
		testPlayer.addItemToBackpack(itemToRemove1);
		testPlayer.addItemToBackpack(new Item(potionHealthPotion1));
		testPlayer.addItemToBackpack(itemToRemove2);
		
		System.out.println("Backpack Status:");
		
		for (int i = 0; ((i < testPlayer.get_backpack().getVolume()) && (testPlayer.get_backpack()._backpackContent[i] != null)); i++) {
			System.out.println("Pos " + (i + 1) + ":\t\tID" + testPlayer.get_backpack()._backpackContent[i].getItemID() + " " + testPlayer.get_backpack()._backpackContent[i].getItem());
		}
		
		testPlayer.dropItemFromBackpack(itemToRemove1,1001);
		testPlayer.dropItemFromBackpack(itemToRemove2,1002);
		
		System.out.println("\nBackpack Status:");
		
		for (int i = 0; ((i < testPlayer.get_backpack().getVolume()) && (testPlayer.get_backpack()._backpackContent[i] != null)); i++) {
			System.out.println("Pos " + (i + 1) + ":\t\tID" + testPlayer.get_backpack()._backpackContent[i].getItemID() + " " + testPlayer.get_backpack()._backpackContent[i].getItem());
		}

	}

}
