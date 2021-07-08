 package me.test.IceWall.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class IceGround implements Listener{	
	@EventHandler()
	public void placeIce(PlayerInteractEvent event) {
				System.out.println("AHSD");
				Player player = (Player) event.getPlayer();
				if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					Location BlockLocate = event.getClickedBlock().getLocation();
					BlockLocate.add(0,1,0);
					BlockLocate.getBlock().setType(Material.AIR);
				}
				iceGroundPlace(player);
			}

	
	public void iceGroundPlace(Player player) {		//FINISHED
	Location Ground = player.getLocation();
	Ground.setY(player.getLocation().getY() - 1);
	Ground.subtract(10,0,10);
	for(int i = 0; i < 21; i++) {
		for(int y = 0; y < 21; y++) {
			Ground.getBlock().setType(Material.ICE);
			Ground.add(0, 0, 1);
		}
		Ground.add(1, 0, 0);
		Ground.subtract(0,0,21);
	}
	}
}
