package at.fhv.msc.java;

public class HealthPotion extends Item {
	
	private int _healAmount;
	
	public HealthPotion(String name, int healAmount) {
		super(name);
		_healAmount = healAmount;
	}
	
    @Override
    public String use(Player player) {
        if (player.getCurrentHealth() < player.getMaxHealth()) {
            int currentHealth = player.getCurrentHealth();
            player.heal(_healAmount);
            int healthAfter = player.getCurrentHealth();
            player.getInventory().removeItem(this);
            return "\nYou used a " + _itemName + " and gained " + (healthAfter - currentHealth) + " health. You are now at " + healthAfter + " health.";
        } else {
        	return "\nYou are already at full health.";
        }
    }
}
