package me.test.WorldEdit.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class TabComplete implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length >= 2) {
			List<String> list = getContainedMaterials(args[1]);
			return list;
		}
		return null;
	}
	private List<String> getAllMaterials() {
		List<String> list = new ArrayList<String>();
		for (Material material : Material.values()) {
			list.add(material.name());
		}
		return list;
	}
	private List<String> getContainedMaterials(String material) {
		List<String> list = new ArrayList<String>();
		for (String addMaterials : getAllMaterials()) {
			if (addMaterials.contains(addMaterials.toUpperCase())) {
				list.add(addMaterials);
			}
		}
		return list;
	}


}
