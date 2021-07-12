 package me.test.AlwaysDay.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.test.AlwaysDay.Main;

public class AlwaysDay implements CommandExecutor{
	private Main plugin;
	
	public AlwaysDay(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("alwaysday").setExecutor(this);
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
//		Location loc = p.getLocation();
		World w = p.getWorld();
		String newString = args[0];
		String resetName = "reset";
		p.chat(newString);

		
		if (!newString.equalsIgnoreCase(resetName)) {
			String timeArgs = args[0];
			int time = Integer.parseInt(timeArgs);
			p.setPlayerTime(time, false);	
		} else {
			p.resetPlayerTime();
		}
		
		return true;
	}

}
