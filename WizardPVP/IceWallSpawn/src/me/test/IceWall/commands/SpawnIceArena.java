package me.test.IceWall.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;


public class SpawnIceArena {
	//NEED TO ADD FLOOR
	//NEED TO ADD SNOWMEN
	public void spawnArena(Player player) { // FINISHED
		Location NorthWestWall = player.getLocation().clone();
		Location SouthEastWall = player.getLocation().clone();
		Location NorthEastWall = player.getLocation().clone();
		Location SouthWestWall = player.getLocation().clone();

		NorthWestWall.subtract(6, 0, 6);
		SouthWestWall.add(-6, 0, 6);
		NorthEastWall.add(6, 0, -6);
		SouthEastWall.add(6, 0, 6);

		Fillin(NorthWestWall, NorthEastWall, SouthWestWall, SouthEastWall);
	}

	public void Fillin(Location NorthWestWall, Location NorthEastWall, Location SouthWestWall, Location SouthEastWall) {
		NorthWestWall.getBlock().setType(Material.ICE);
		NorthEastWall.getBlock().setType(Material.ICE);
		SouthWestWall.getBlock().setType(Material.ICE);
		SouthEastWall.getBlock().setType(Material.ICE);
			
		for (int x = 0; x < 2; x++) {
			for (int i = 0; i < 11; i++) { // 11 blocks per way
				NorthWestWall.add(0, 0, 1);
				NorthWestWall.getBlock().setType(Material.ICE);

			}
			NorthWestWall.subtract(0, 0, 11);
			NorthWestWall.add(0, 1, 0);
			NorthWestWall.getBlock().setType(Material.ICE);

		}
		NorthWestWall.add(1, -2, 1);
		NorthWestWall.getBlock().setType(Material.LEGACY_REDSTONE_LAMP_ON);
		
		for (int x = 0; x < 2; x++) {
			for (int i = 0; i < 11; i++) { // 11 blocks per way
				NorthEastWall.subtract(1, 0, 0);
				NorthEastWall.getBlock().setType(Material.ICE);

			}
			NorthEastWall.add(11, 0, 0);
			NorthEastWall.add(0, 1, 0);
			NorthEastWall.getBlock().setType(Material.ICE);

		}
		NorthEastWall.add(-1, -2, 1);
		NorthEastWall.getBlock().setType(Material.ICE);
		for (int x = 0; x < 2; x++) {
			for (int i = 0; i < 11; i++) { // 11 blocks per way
				SouthWestWall.add(1, 0, 0);
				SouthWestWall.getBlock().setType(Material.ICE);

			}
			SouthWestWall.subtract(11, 0, 0);
			SouthWestWall.add(0, 1, 0);
			SouthWestWall.getBlock().setType(Material.ICE);
		}
		SouthWestWall.subtract(-1, 2, 1);
		SouthWestWall.getBlock().setType(Material.ICE); // WORKS
		for (int x = 0; x < 2; x++) {
			for (int i = 0; i < 11; i++) { // 11 blocks per way
				SouthEastWall.subtract(0, 0, 1);
				SouthEastWall.getBlock().setType(Material.ICE); 

			}
			SouthEastWall.add(0, 0, 11);
			SouthEastWall.add(0, 1, 0);
			SouthEastWall.getBlock().setType(Material.ICE);

		}
		SouthEastWall.subtract(1, 2, 1);
		SouthEastWall.getBlock().setType(Material.ICE); //WORKS
	}

}