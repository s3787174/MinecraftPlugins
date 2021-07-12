package me.test.SetHome.commands;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.test.SetHome.Main;

public class SetHomeCommands implements CommandExecutor {
	private Main plugin;
	private Location location;
	private HashMap<String, Location> PlayerHomes;
	
	public SetHomeCommands(Main plugin) {
		this.plugin = plugin;
		PlayerHomes = new HashMap<String, Location>();
	}
	
	public Location getLocation(String HomeName) {
		return PlayerHomes.get(HomeName);	
	}
	public HashMap getHomeList() {
		return PlayerHomes;	
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		Player p = (Player) sender;
		if(arg[0] != "") {
			String HomeName = arg[0];
			Location loc = p.getLocation();
			PlayerHomes.put(HomeName, loc);
			p.chat("Home: " +HomeName + ", added successfully");
		} else {
			p.chat("Please enter home name");
		}
		return false;
	}

}
