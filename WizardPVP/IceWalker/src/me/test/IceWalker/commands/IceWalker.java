package me.test.IceWalker.commands;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.test.IceWalker.Main;
import net.minecraft.server.v1_16_R3.EntityTypes;

public class IceWalker implements Listener, CommandExecutor {
	private ArrayList<Player> WalkingList = new ArrayList();
	private Main plugin;
	
	
	public IceWalker(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("IceWalker").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player player = (Player) arg0;
		if (arg3[0].equalsIgnoreCase("true")) {
			WalkingList.add(player);
		} else {
			WalkingList.remove(player);
		}
		return false;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
		if (WalkingList.contains(p)) {
		Location Loc = e.getPlayer().getLocation();
		Location TempLoc = e.getPlayer().getLocation();
		
		Location TL = e.getPlayer().getLocation().add(1, -1, -1);
		Location TF = e.getPlayer().getLocation().add(1, -1, 0);
		Location TR = e.getPlayer().getLocation().add(1, -1, 1);
		Location RR = e.getPlayer().getLocation().add(0, -1, 1);
		Location BR = e.getPlayer().getLocation().add(-1, -1, 1);
		Location BB =e.getPlayer().getLocation().add(-1, -1, 0);
		Location BL = e.getPlayer().getLocation().add(-1, -1, -1);
		Location LL = e.getPlayer().getLocation().add(0, -1, -1);
		
		
		TempLoc.subtract(0, 1, 0);
		if (TempLoc.getBlock().getType().equals(Material.WATER) && !p.isInWater()) {
			TempLoc.getBlock().setType(Material.ICE);
			TL.getBlock().setType(Material.ICE);
			TF.getBlock().setType(Material.ICE);
			TR.getBlock().setType(Material.ICE);
			RR.getBlock().setType(Material.ICE);
			BR.getBlock().setType(Material.ICE);
			BB.getBlock().setType(Material.ICE);
			BL.getBlock().setType(Material.ICE);
			LL.getBlock().setType(Material.ICE);
		}
		}


	}
}
