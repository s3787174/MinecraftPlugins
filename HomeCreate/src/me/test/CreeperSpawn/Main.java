package me.test.CreeperSpawn;

import org.bukkit.plugin.java.JavaPlugin;

import me.test.CreeperSpawn.commands.CreeperCommand;

public class Main extends JavaPlugin{
  
	@Override
	public void onEnable() {
		new CreeperCommand(this);
	}
}
