package me.test.WorldEdit.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.test.WorldEdit.Main;

public class WorldEditCommands implements CommandExecutor{
	private Main plugin;
	
	public WorldEditCommands(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("WorldEdit").setExecutor(this);
		
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
//		Player p = (Player) sender;
//		Location loc = p.getLocation();
//		World w = p.getWorld();
//		String blockName = label;
		return false;
	}

}
