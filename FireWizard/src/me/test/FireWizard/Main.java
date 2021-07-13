package me.test.FireWizard;

import org.bukkit.plugin.java.JavaPlugin;

import me.test.FireWizard.Abilities.FireWizardMain;

public class Main extends JavaPlugin{
  
	@Override
	public void onEnable() {
		
		this.getServer().getPluginManager().registerEvents(new FireWizardMain(this), this);
	}

	@Override
	public void onDisable() {
		
	}
	
}
