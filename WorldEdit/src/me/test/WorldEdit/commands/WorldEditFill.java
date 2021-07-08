package me.test.WorldEdit.commands;

import org.bukkit.Location;
import org.bukkit.Material;

public class WorldEditFill {

	public WorldEditFill() {
	}

	public void MathFill(Location pos1, Location pos2, String tempBlock) {
		Double XDifference = pos1.getX() - pos2.getX();
		Double ZDifference = pos1.getZ() - pos2.getZ();
		Double YDifference = pos1.getY() - pos2.getY();
		Location Origin = pos1.clone();
		if (XDifference > 0 || ZDifference > 0) {
			Origin = pos2.clone();
		} else {
			XDifference *= -1;
			ZDifference *= -1;
			YDifference *= -1;
		}

		//SOUTH AND WEST FACING DOES NOT WORK

		for (int Y = 0; Y < YDifference+1; Y++) {
			for (int X = 0; X < XDifference + 1; X++) {
				for (int Z = 0; Z < ZDifference + 1; Z++) {
					Origin.getBlock().setType(Material.GLOWSTONE);
					Origin.add(0, 0, 1);
				}
				Origin.add(1, 0, 0);
				Origin.subtract(0, 0, ZDifference + 1);
			}
			Origin.add(0, 1, 0);
			Origin.subtract(XDifference + 1, 0, 0);


		}
	}
}