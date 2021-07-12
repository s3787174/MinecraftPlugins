package me.test.AlwaysDay;

import org.bukkit.plugin.java.JavaPlugin;

import me.test.AlwaysDay.commands.AlwaysDay;

public class Main extends JavaPlugin{
  
	@Override
	public void onEnable() {
		new AlwaysDay(this);
	}
}
