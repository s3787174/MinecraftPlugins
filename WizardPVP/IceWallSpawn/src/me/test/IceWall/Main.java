package me.test.IceWall;

import org.bukkit.plugin.java.JavaPlugin;

import me.test.IceWall.commands.IceWall;

public class Main extends JavaPlugin{
  
	@Override
	public void onEnable() {
		
		this.getServer().getPluginManager().registerEvents(new IceWall(), this);
	}

	@Override
	public void onDisable() {
		
	}
	
}
