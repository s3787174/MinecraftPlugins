 package me.test.WorldEdit.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
//import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
//import org.bukkit.event.Event;
//import org.bukkit.event.player.PlayerEvent;
//import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerInteractEvent;

import me.test.WorldEdit.Main;

public class WorldEdit implements CommandExecutor{
	private Main plugin;
	
	public WorldEdit(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("WorldEdit").setExecutor(this);
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerUse(PlayerInteractEvent event){
	    Player p = event.getPlayer();
	 
	    if(p.getItemInHand().getType() == Material.BLAZE_POWDER){
	    }
	    else if(p.getItemInHand().getType() == Material.BLAZE_ROD){
	        //Do whatever
	    }
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Location loc = p.getLocation();
		World w = p.getWorld();
//
//		PlayerInteractEntityEvent e = (PlayerInteractEntityEvent) p.getPlayer();
//		if (e.getRightClicked() != null) {
//			p.chat("EDITTING THING");
//
//		}

			
		return false;
	}

}
