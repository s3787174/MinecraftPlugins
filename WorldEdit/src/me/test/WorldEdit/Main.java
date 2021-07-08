package me.test.WorldEdit;

import org.bukkit.plugin.java.JavaPlugin;

import me.test.WorldEdit.commands.WorldEdit;
import me.test.WorldEdit.commands.WorldEditCommands;

public class Main extends JavaPlugin{
  
	@Override
	public void onEnable() {
//		WorldEditCommands commands = new WorldEditCommands(this);
		this.getServer().getPluginManager().registerEvents(new WorldEdit(this), this);
	}
	
	@Override
	public void onDisable() {
		
	}
}