package me.test.IceWalker;

import org.bukkit.plugin.java.JavaPlugin;

import me.test.IceWalker.commands.IceWalker;


public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new IceWalker(this), this);
	}

	@Override
	public void onDisable() {
		System.out.println("FUDK YOU DSAHH LAZY");
	}
}
