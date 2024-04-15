package at.fhv.msc.java;

import java.io.Serializable;

public class Map implements Serializable {
	private static final long serialVersionUID = 1L;

	private static Map _instance;
	
	private Field _cell01;
	private Field _cell02;
	private Field _cell03;
	private Field _cell04;
	private Field _cell05;
	private Field _cell06;
	private Field _cell07;
	private Field _cell08;
	private Field _cell09;
	private Field _cell10;
	private Field _cell11;
	private Field _cell12;
	private Field _cellNull;
	
	private Door _cell02to03;
	private Door _cell08to09;
	
	private Wall _wall;
	
	private Item _keyShed;
	private Item _keyChurch;
	
	private Item _healthPotionLVL01;
	private Item _poisonPotionLVL02;
	
	private Item _armorLVL01;
	
	private Food _bread;
	
	private Map() {
		
		_cell01 = new Field("Spawn", "Starting Point for current Playing Field");
		_cell02 = new Field("Empty", "Entrance way to shed");
		_cell03 = new Field("Shed", "You are at the door of the shed, Key for entrance to the church");
		_cell04 = new Field("Item", "Key for door to Shed");
		_cell05 = new Field("Consumable", "1 Health Potion LVL 1");
		_cell06 = new Field("Thornbush", "-20 Health for going through a thorny bush (not implemented yet)");
		_cell07 = new Field("Consumable", "1 Bread");
		_cell08 = new Field("Entrance", "Entrance to church");
		_cell09 = new Field("Door hall", "You are at the door of the church");
		_cell10 = new Field("Empty", "");
		_cell11 = new Field("Armor", "1 Armor LVL 1");
		_cell12 = new Field("Consumable", "1 Poison Potion LVL 2");
		
		_cellNull = new Field();
		
		_wall = new Wall("Wall", "");
		
		_keyShed = new Key("Shed_Key");
		_keyChurch = new Key("Church_Key");
		
		_cell02to03 = new Door("Shed Door", "Door to Shed", _keyShed, _cell02, _cell03);
		_cell08to09 = new Door("Church Door", "Door to Church", _keyChurch, _cell08, _cell09);
		
		((Key) _keyShed).addCorrespondingDoor(_cell02to03);
		((Key) _keyChurch).addCorrespondingDoor(_cell08to09);
		
		_healthPotionLVL01 = new HealthPotion("Health_Potion", 50);
		_poisonPotionLVL02 = new PoisonPotion("Poison_Potion", 120);
		
		_armorLVL01 = new Armor("Armor", 50);
		
		_bread = new Food("Bread", 10);
		
		_cell01.defineSurroundings(_cellNull, _cell02, _cell04, _cellNull);
		_cell02.defineSurroundings(_cellNull, _cell02to03, _cell05, _cell01);
		_cell03.defineSurroundings(_wall, _wall, _wall, _cell02to03);
		_cell04.defineSurroundings(_cell01, _cell05, _cellNull, _cellNull);
		_cell05.defineSurroundings(_cell02, _cellNull, _cell06, _cell04);
		_cell06.defineSurroundings(_cell05, _cellNull, _cell07, _cellNull);
		_cell07.defineSurroundings(_cell06, _cell08, _cellNull, _cellNull);
		_cell08.defineSurroundings(_cellNull, _cell08to09, _cellNull, _cell07);
		_cell09.defineSurroundings(_wall, _cell10, _cell11, _cell08to09);
		_cell10.defineSurroundings(_wall, _wall, _cell12, _cell09);
		_cell11.defineSurroundings(_cell09, _cell12, _wall, _wall);
		_cell12.defineSurroundings(_cell10, _wall, _wall, _cell11);
		
		_cell03.addItem(_keyChurch);
		_cell04.addItem(_keyShed);
		_cell05.addItem(_healthPotionLVL01);
		_cell07.addItem(_bread);
		_cell11.addItem(_armorLVL01);
		_cell12.addItem(_poisonPotionLVL02);
	}	
	
	public static Map instance() {
		if (_instance == null) {
			_instance = new Map();
		}
		return _instance;
	}
	
    public String printAllCells() {
    	String output = new String();
    	
    	for (Cell cell : Cell.get_cells()) {
    		output += cell.printCellInfo();
    	}
    	
    	return output;
    }
    
    // GETTER/SETTER:

	public Field getCell01() {
		return _cell01;
	}

	public void setCell01(Field cell01) {
		_cell01 = cell01;
	}

	public Field getCell02() {
		return _cell02;
	}

	public void setCell02(Field cell02) {
		_cell02 = cell02;
	}

	public Field getCell03() {
		return _cell03;
	}

	public void setCell03(Field cell03) {
		_cell03 = cell03;
	}

	public Field getCell04() {
		return _cell04;
	}

	public void setCell04(Field cell04) {
		_cell04 = cell04;
	}

	public Field getCell05() {
		return _cell05;
	}

	public void setCell05(Field cell05) {
		_cell05 = cell05;
	}

	public Field getCell06() {
		return _cell06;
	}

	public void setCell06(Field cell06) {
		_cell06 = cell06;
	}

	public Field getCell07() {
		return _cell07;
	}

	public void setCell07(Field cell07) {
		_cell07 = cell07;
	}

	public Field getCell08() {
		return _cell08;
	}

	public void setCell08(Field cell08) {
		_cell08 = cell08;
	}

	public Field getCell09() {
		return _cell09;
	}

	public void setCell09(Field cell09) {
		_cell09 = cell09;
	}

	public Field getCell10() {
		return _cell10;
	}

	public void setCell10(Field cell10) {
		_cell10 = cell10;
	}

	public Field getCell11() {
		return _cell11;
	}

	public void setCell11(Field cell11) {
		_cell11 = cell11;
	}

	public Field getCell12() {
		return _cell12;
	}

	public void setCell12(Field cell12) {
		_cell12 = cell12;
	}

	public Door getCell02door03() {
		return _cell02to03;
	}

	public void setCell02door03(Door cell02door03) {
		_cell02to03 = cell02door03;
	}

	public Door getCell08door09() {
		return _cell08to09;
	}

	public void setCell08door09(Door cell08door09) {
		_cell08to09 = cell08door09;
	}

	public Wall getWall() {
		return _wall;
	}

	public void setWall(Wall wall) {
		_wall = wall;
	}

	public Item getKeyShed() {
		return _keyShed;
	}

	public void setKeyShed(Item keyShed) {
		_keyShed = keyShed;
	}

	public Item getKeyChurch() {
		return _keyChurch;
	}

	public void setKeyChurch(Item keyChurch) {
		_keyChurch = keyChurch;
	}

	public Item getHealthPotionLVL01() {
		return _healthPotionLVL01;
	}

	public void setHealthPotionLVL01(Item healthPotionLVL01) {
		_healthPotionLVL01 = healthPotionLVL01;
	}

	public Item getBread() {
		return _bread;
	}

	public void setBread(Food bread) {
		_bread = bread;
	}

	public Item getPoisonPotionLVL02() {
		return _poisonPotionLVL02;
	}

	public void setPoisonPotionLVL02(Item poisonPotionLVL02) {
		_poisonPotionLVL02 = poisonPotionLVL02;
	}

	public Item getArmorLVL01() {
		return _armorLVL01;
	}

	public void setArmorLVL01(Item armorLVL01) {
		_armorLVL01 = armorLVL01;
	}

	public Field getCellNull() {
		return _cellNull;
	}

	public void setCellNull(Field cellNull) {
		_cellNull = cellNull;
	}

	public Door getCell02to03() {
		return _cell02to03;
	}

	public void setCell02to03(Door cell02to03) {
		_cell02to03 = cell02to03;
	}

	public Door getCell08to09() {
		return _cell08to09;
	}

	public void setCell08to09(Door cell08to09) {
		_cell08to09 = cell08to09;
	}
}
