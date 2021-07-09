package me.test.WorldEdit;

import org.bukkit.plugin.java.JavaPlugin;

import me.test.WorldEdit.commands.WorldEdit;

public class Main extends JavaPlugin{
  
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new WorldEdit(this), this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
