package me.test.WorldEdit.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import me.test.WorldEdit.Main;
import net.md_5.bungee.api.ChatColor;

public class WorldEdit implements Listener, CommandExecutor {
	private Main plugin;

	private Location Pos1;
	private Location Pos2;
	private WorldEditFill fill;
	private List<Material> undoListMaterial = new ArrayList<>();
	private List<Location> undoListLocation = new ArrayList<>();

	public WorldEdit(Main plugin) {
		fill = new WorldEditFill(undoListMaterial, undoListLocation);
		this.plugin = plugin;
		plugin.getCommand("worldedit").setTabCompleter(new TabComplete());
		plugin.getCommand("worldedit").setExecutor(this);
	}

	private void setUndoList() {
		this.undoListMaterial = fill.getUndoList();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args[0].equalsIgnoreCase("fill")) {
			if (validPos()) {
				fill.Fillin(Pos1, Pos2, args[1]);
				setUndoList();

			} else {
				sender.sendMessage(ChatColor.RED + "You need to choose your positions first");
			}
		} else if (args[0].equalsIgnoreCase("replace")) {
			if (validPos()) {
				fill.replace(Pos1, Pos2, args[1], args[2]);
//				setUndoList();
			} else {
				sender.sendMessage(ChatColor.RED + "You need to choose your positions first");
			}
		} else if (args[0].equalsIgnoreCase("undo")) {
			if (fill.checkUndo()) {
				fill.undo();
				sender.sendMessage(ChatColor.RED + "Blocks are back in place");

			} else {
				sender.sendMessage(ChatColor.RED + "You need to choose your positions first");
			}
		}
		return false;
	}

	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();
		if (event.getHand() == EquipmentSlot.HAND) { // Filters out two hands so things can be called twice
			if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.COMPASS)) {
				if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					Pos1 = event.getClickedBlock().getLocation();
					player.sendMessage("Pos 1 X: " + Pos1.getX() + "Y: " + Pos1.getY() + " Z: " + Pos1.getZ());
				} else if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
					Pos2 = event.getClickedBlock().getLocation();
					player.sendMessage("Pos 2 X: " + Pos2.getX() + "Y: " + Pos2.getY() + " Z: " + Pos2.getZ());
				} else if (event.getAction() == Action.RIGHT_CLICK_AIR) {
					Pos1 = player.getLocation().getBlock().getLocation();
					player.sendMessage("Pos 1 X: " + Pos1.getX() + "Y: " + Pos1.getY() + " Z: " + Pos1.getZ());
				} else if (event.getAction() == Action.LEFT_CLICK_AIR) {
					Pos2 = player.getLocation().getBlock().getLocation();
					player.sendMessage("Pos 2 X: " + Pos2.getX() + "Y: " + Pos2.getY() + " Z: " + Pos2.getZ());

				}
			}
		}

	}

	// checks if the positions have been selected
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
