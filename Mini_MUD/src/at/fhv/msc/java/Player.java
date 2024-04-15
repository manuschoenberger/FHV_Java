package at.fhv.msc.java;

import java.io.Serializable;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static int _staticPlayerID;
	private int _playerID;
	private Inventory _inventory;
	private int _maxHealth;
	private int _currentHealth;
	private int _maxStamina;
	private int _currentStamina;
	private int _currentArmor;
	private Cell _currentPosition;
	
	public Player() {
		_playerID = (_staticPlayerID++) + 1;
		_inventory = new Inventory();
		_maxHealth = 100;
		_currentHealth = 100;
		_maxStamina = 50;
		_currentStamina = 50;
		_currentArmor = 0;
		_currentPosition = Map.instance().getCell01();
	}
	
	public String spawn() {
		return _currentPosition.printCellInfo();
	}
	
	public void takeDamage(int amount) {
		_currentHealth -= amount;
	}

	public void heal(int amount) {
		_currentHealth = Math.min(_maxHealth, _currentHealth + amount);
	}
	
	public void wearArmor(int amount) {
		_currentArmor = amount;
	}
	
	public void getStamina(int amount) {
		_currentStamina += amount;
	}
	
	// GETTER/SETTER:

	public int getPlayerID() {
		return _playerID;
	}

	public void setPlayerID(int playerID) {
		_playerID = playerID;
	}

	public Inventory getInventory() {
		return _inventory;
	}

	public void setInventory(Inventory inventory) {
		_inventory = inventory;
	}

	public int getMaxHealth() {
		return _maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		_maxHealth = maxHealth;
	}

	public int getCurrentHealth() {
		return _currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		_currentHealth = currentHealth;
	}

	public int getMaxStamina() {
		return _maxStamina;
	}

	public void setMaxStamina(int maxStamina) {
		_maxStamina = maxStamina;
	}

	public int getCurrentStamina() {
		return _currentStamina;
	}

	public void setCurrentStamina(int currentStamina) {
		_currentStamina = currentStamina;
	}

	public int getCurrentArmor() {
		return _currentArmor;
	}

	public void setCurrentArmor(int currentArmor) {
		_currentArmor = currentArmor;
	}

	public Cell getCurrentPosition() {
		return _currentPosition;
	}

	public void setCurrentPosition(Cell currentPosition) {
		_currentPosition = currentPosition;
	}

	@Override
	public String toString() {
		return "Player [_playerID=" + _playerID + ", _inventory=" + _inventory + ", _maxHealth=" + _maxHealth
				+ ", _currentHealth=" + _currentHealth + ", _maxStamina=" + _maxStamina + ", _currentStamina="
				+ _currentStamina + ", _currentArmor=" + _currentArmor + ", _currentPosition=" + _currentPosition
				+ ", getPlayerID()=" + getPlayerID() + ", getInventory()=" + getInventory() + ", getMaxHealth()="
				+ getMaxHealth() + ", getCurrentHealth()=" + getCurrentHealth() + ", getMaxStamina()=" + getMaxStamina()
				+ ", getCurrentStamina()=" + getCurrentStamina() + ", getCurrentArmor()=" + getCurrentArmor()
				+ ", getCurrentPosition()=" + getCurrentPosition() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
