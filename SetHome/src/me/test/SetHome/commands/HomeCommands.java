package me.test.SetHome.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.test.SetHome.Main;

public class HomeCommands implements CommandExecutor {
	private Main plugin;
	private SetHomeCommands SetHome;
	
	public HomeCommands(Main plugin, SetHomeCommands setHome) {
		this.SetHome = setHome;
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		Player p = (Player) sender;
		if (arg[0] != "") {
			p.teleport(SetHome.getLocation(arg[0]));
			p.chat("Successfully teleported");
		} else {
			p.chat("Please enter home name");
		}
		
		return false;
	}

}
