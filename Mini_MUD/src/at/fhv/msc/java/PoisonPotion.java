package at.fhv.msc.java;

public class PoisonPotion extends Item{
	
	private int _damageAmount;
	
	public PoisonPotion(String name, int damageAmount) {
		super(name);
		_damageAmount = damageAmount;
	}
	
    public String use(Player player) {
        int currentHealth = player.getCurrentHealth();
        player.takeDamage(_damageAmount);
        int healthAfter = player.getCurrentHealth();
        player.getInventory().removeItem(this);
        return "\nYou used a " + _itemName + " and lost " + (currentHealth - healthAfter) + " health. You have " + healthAfter + " health remaining.";
    }
}
