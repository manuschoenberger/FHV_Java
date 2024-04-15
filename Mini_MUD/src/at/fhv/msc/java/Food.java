package at.fhv.msc.java;

public class Food extends Item {

	private int _staminaAmount;
	
	public Food(String name, int staminaAmount) {
		super(name);
		_staminaAmount = staminaAmount;
	}
	
    public String use(Player player) {
        int currentStamina = player.getCurrentStamina();
        player.getStamina(_staminaAmount);
        int staminaAfter = player.getCurrentStamina();
        player.getInventory().removeItem(this);
        return "\nYou ate " + _itemName + " and gained " + (staminaAfter - currentStamina) + " stamina. You now have " + staminaAfter + " stamina";
    }
}
