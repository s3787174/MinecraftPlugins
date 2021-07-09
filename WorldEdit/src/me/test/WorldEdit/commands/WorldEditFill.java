package me.test.WorldEdit.commands;

import org.bukkit.Location;
import org.bukkit.Material;

public class WorldEditFill {

	private Double XDifference;
	private Double ZDifference;
	private Double YDifference;
	private Location Origin;

	public WorldEditFill() {
	}
	
	public void replace(Location pos1, Location pos2, String oldBlock, String newBlock) {
		Material replacementblock = Material.matchMaterial(newBlock);
		Material replacedBlock = Material.matchMaterial(oldBlock);

		MathFill(pos1, pos2);
		replaceLoop(XDifference, ZDifference, YDifference, Origin, replacementblock, replacedBlock);
	}
	

	private void replaceLoop(Double xDifference2, Double zDifference2, Double yDifference2, Location Origin,
			Material replacementblock, Material replacedBlock) {
		for (int Y = 0; Y < YDifference + 1; Y++) {
			for (int X = 0; X < XDifference + 1; X++) {
				for (int Z = 0; Z < ZDifference + 1; Z++) {
					if (Origin.getBlock().getType() == replacedBlock) {
						Origin.getBlock().setType(replacementblock);
					}
					Origin.add(0, 0, 1);
				}
				Origin.add(1, 0, 0);
				Origin.subtract(0, 0, ZDifference + 1);
			}
			Origin.add(0, 1, 0);
			Origin.subtract(XDifference + 1, 0, 0);
		}
		
	}

	public void Fillin(Location pos1, Location pos2, String tempBlock) {
		Material block = Material.matchMaterial(tempBlock);
		MathFill(pos1, pos2);
		fillInLoop(XDifference, ZDifference, YDifference, Origin, block);
	}
	
	
	

	public void fillInLoop(Double XDifference, Double ZDifference, Double YDifference, Location Origin,
			Material block) {
		for (int Y = 0; Y < YDifference + 1; Y++) {
			for (int X = 0; X < XDifference + 1; X++) {
				for (int Z = 0; Z < ZDifference + 1; Z++) {
					if (Origin.getBlock().getType() != Material.GLOWSTONE) {
						Origin.getBlock().setType(block);
					}
					Origin.add(0, 0, 1);
				}
				Origin.add(1, 0, 0);
				Origin.subtract(0, 0, ZDifference + 1);
			}
			Origin.add(0, 1, 0);
			Origin.subtract(XDifference + 1, 0, 0);
		}
	}

	public void MathFill(Location pos1, Location pos2) {
		XDifference = pos1.getX() - pos2.getX();
		ZDifference = pos1.getZ() - pos2.getZ();
		YDifference = pos1.getY() - pos2.getY();
		this.Origin = pos1.clone();

		if (XDifference == 0) {
			if (pos1.getZ() > pos2.getZ()) {
				Origin.setZ(pos2.getZ());
			}
		}
		if (ZDifference == 0) {
			if (pos1.getX() > pos2.getX()) {
				Origin.setX(pos2.getX());
			}
		}
		if (XDifference >= 0 && ZDifference < 0) {
			// Minus XDifference Pos1 Origin
			ZDifference *= -1;
			Origin.subtract(XDifference, 0, 0);
		} else if (XDifference < 0 && ZDifference >= 0) {
			// MINUS ZDifference Pos1 Origin
			XDifference *= -1;
			Origin.subtract(0, 0, ZDifference);
		} else if (XDifference > 0 && ZDifference > 0) {
			Origin = pos2.clone();
		} else if (XDifference < 0 && ZDifference < 0) {
			if (XDifference < 0) {
				XDifference *= -1;
				ZDifference *= -1;
			}
			Origin = pos1.clone();
		} else {
			if (XDifference < 0) {
				XDifference *= -1;
			}
			if (ZDifference < 0) {
				ZDifference *= -1;
			}

		}
		if (YDifference < 0) {
			YDifference *= -1;
		}
		if (pos1.getY() > pos2.getY()) {
			Origin.setY(pos2.getY());
		} else {
			Origin.setY(pos1.getY());
		}

	}
}
