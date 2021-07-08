 package me.test.Top.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.test.Top.Main;

public class Top implements CommandExecutor{
	private Main plugin;
	
	public Top(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("top").setExecutor(this);
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		World world = p.getWorld();
		Block HighestBlock = world.getHighestBlockAt(p.getLocation());
		Location newPlayerLocation = HighestBlock.getLocation();
		newPlayerLocation.add(0, 1, 0);
		p.teleport(newPlayerLocation);
		return true;
	}

}
