package me.test.SetHome.commands;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListCommands implements CommandExecutor {
	private SetHomeCommands setHome;
	private HashMap HomeList = new HashMap<String, Location>();
	
	public ListCommands(SetHomeCommands setHome) {
		this.setHome = setHome;
		HomeList = setHome.getHomeList();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) sender;
		String longString = "";
		for (Object i : HomeList.keySet()) {
			String Temp = i.toString();
			longString += Temp + " ";
			}
		p.sendMessage(longString);
		return false;
	}

}
