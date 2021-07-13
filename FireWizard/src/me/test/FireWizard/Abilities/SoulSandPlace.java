 package me.test.FireWizard.Abilities;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SoulSandPlace {	
	
	//FINISHED
	public void soulGroundPlace(Player player) {
	Location Ground = player.getLocation();
	Ground.setY(player.getLocation().getY() - 1);
	Ground.subtract(2,0,2);
	for(int i = 0; i < 5; i++) {
		for(int y = 0; y < 5; y++) {
			Ground.getBlock().setType(Material.SOUL_SAND);
			Ground.add(0, 0, 1);
		}
		Ground.add(1, 0, 0);
		Ground.subtract(0,0,5);
	}
	}
}
