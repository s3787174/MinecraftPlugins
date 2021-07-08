package me.test.Top;

import org.bukkit.plugin.java.JavaPlugin;

import me.test.Top.commands.Top;

public class Main extends JavaPlugin{
  
	@Override
	public void onEnable() {
		new Top(this);
	}
}
