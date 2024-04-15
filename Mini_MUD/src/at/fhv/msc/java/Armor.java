package at.fhv.msc.java;

import java.io.Serializable;

public class Armor extends Item {
	int _armorAmount;
	
	public Armor(String name, int armorAmount) {
		super(name);
		_armorAmount = armorAmount;
	}
	
    @Override
    public String use(Player player) {
        player.wearArmor(_armorAmount);
        int armorAfter = player.getCurrentArmor();
        return "\nYou now wear a " + _itemName + ". You currently have " + armorAfter + " armor.";
    }
}
