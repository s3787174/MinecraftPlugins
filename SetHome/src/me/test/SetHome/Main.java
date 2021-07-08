package me.test.SetHome;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import me.test.SetHome.commands.HomeCommands;
import me.test.SetHome.commands.ListCommands;
import me.test.SetHome.commands.SetHomeCommands;

public class Main extends JavaPlugin{

	private Location location;
	private SetHomeCommands SetHome;
	@Override
	public void onEnable() {
		SetHome = new SetHomeCommands(this);
		getCommand("sethome").setExecutor(SetHome);
		getCommand("home").setExecutor(new HomeCommands(this, SetHome));
		
		getCommand("listhomes").setExecutor(new ListCommands(SetHome));

	}
}
