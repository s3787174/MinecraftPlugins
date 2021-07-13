 package me.test.IceWall.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class IceSpeedEffect implements Listener{
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		Location onGround = player.getLocation();
		onGround.subtract(0,1,0);
		if (onGround.getBlock().getType().equals(Material.ICE)) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 5));
		}
	}
}
