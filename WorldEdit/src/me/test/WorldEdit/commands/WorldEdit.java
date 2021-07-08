package me.test.WorldEdit.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import me.test.WorldEdit.Main;

public class WorldEdit implements Listener, CommandExecutor {
	private Main plugin;
	
	private Location Pos1;
	private Location Pos2;
	private WorldEditCommands Commands;
	private WorldEditFill fill;

	public WorldEdit(Main plugin) {
		fill = new WorldEditFill();
		this.plugin = plugin;
		plugin.getCommand("worldedit").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		Player p = (Player) sender;
		Location loc = p.getLocation();
		World w = p.getWorld();
		String blockName = label;
		String TempBlock = "cobblestone";


		if(args[0].equalsIgnoreCase("fill")) {
			if(validPos()) {
				fill.MathFill(Pos1, Pos2, TempBlock);
			}
		}
		return false;
	}
	
	

	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();
		if (event.getHand() == EquipmentSlot.HAND) { //Filters out two hands so things can be called twice
			if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.COMPASS)) {
				if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					Pos1 = event.getClickedBlock().getLocation();
					player.chat("Pos 1 X: " +Pos1.getX() + " Pos 1 Y: " + Pos1.getY()  );
				} else if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
					Pos2 = event.getClickedBlock().getLocation();
					player.chat("Pos 2 X: " +Pos2.getX() + " Pos 2 Y: " + Pos2.getY()  );

				}
			}
		}

	}
	
	public Location getPos1() {
		return Pos1;
	}
	
	public Location getPos2() {
		return Pos1;
	}
	
	public boolean validPos() {
		if (Pos1 == null || Pos2 == null) {
			return false;
		}
		return true;
	}

	// Cancels player from breaking block with compass -- Used for creative
	@EventHandler
	private void cancelBlockBreak(BlockBreakEvent event) {
		if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.COMPASS)) {
			event.setCancelled(true);
		}

	}

}