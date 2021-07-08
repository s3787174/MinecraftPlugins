 package me.test.IceWall.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectTypeWrapper;

import com.mojang.datafixers.types.templates.List;

import me.test.IceWall.Main;

public class IceWall implements Listener{
	private float Direction;
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		Location onGround = player.getLocation();
		onGround.subtract(0,1,0);
		if (onGround.getBlock().getType().equals(Material.ICE)) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, 5));
		}
	}
	
	
	@EventHandler()
	public void thrownDirection(PlayerInteractEvent event) {
		if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.SNOWBALL)) {
			Player player = (Player) event.getPlayer();
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				Direction = player.getLocation().getYaw();
			}
		}
		else if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.ICE)) {
			System.out.println("THIS IS HOW WE DO IT");
			Player player = (Player) event.getPlayer();
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				IceGround Ground = new IceGround();
				Ground.placeIce(event);
			}
		}
	}
	
	
	@EventHandler()
	public void onLand(ProjectileHitEvent event) {
		if(event.getEntityType() == EntityType.SNOWBALL) {
			if(event.getEntity().getShooter() instanceof Player) {
				Location loc = event.getEntity().getLocation();
				placeBlocks(loc);
				Direction = 0;
			}
		}
	}
	
	private void placeBlocks(Location loc) {		//FINISHED
		System.out.println("BLOCk position:" +loc);
		System.out.println("Direction:" +Direction);

		Location LS = loc.clone();
		Location FL = loc.clone();
		Location FF = loc.clone();
		Location FR = loc.clone();
		Location RS = loc.clone();
		
		if (Direction > 315 && Direction < 360 || Direction > 0 && Direction < 45) { //NORTH
			LS.add(2, 0, 0).getBlock().setType(Material.ICE);
			FL.add(1, 0, 1).getBlock().setType(Material.ICE);
			FF.add(0, 0, 1).getBlock().setType(Material.ICE);
			FR.add(-1, 0, 1).getBlock().setType(Material.ICE);
			RS.add(-2, 0, 0).getBlock().setType(Material.ICE);
			
			LS.add(0, 1, 0).getBlock().setType(Material.ICE);
			FL.add(0, 1, 0).getBlock().setType(Material.ICE);
			FF.add(0, 1, 0).getBlock().setType(Material.ICE);
			FR.add(0, 1, 0).getBlock().setType(Material.ICE);
			RS.add(0, 1, 0).getBlock().setType(Material.ICE);
		}
		
		if (Direction > 45 && Direction < 135) { //WEST
			LS.add(0, 0, -2).getBlock().setType(Material.ICE);
			FL.add(-1, 0, 1).getBlock().setType(Material.ICE);
			FF.add(-1, 0, 0).getBlock().setType(Material.ICE);
			FR.add(-1, 0, -1).getBlock().setType(Material.ICE);
			RS.add(0, 0, 2).getBlock().setType(Material.ICE);
			LS.add(0, 1, 0).getBlock().setType(Material.ICE);
			FL.add(0, 1, 0).getBlock().setType(Material.ICE);
			FF.add(0, 1, 0).getBlock().setType(Material.ICE);
			FR.add(0, 1, 0).getBlock().setType(Material.ICE);
			RS.add(0, 1, 0).getBlock().setType(Material.ICE);
				
			}

		if (Direction > 135 && Direction < 225) { //NORTH
			LS.add(-2, 0, 0).getBlock().setType(Material.ICE);
			FL.add(-1, 0, -1).getBlock().setType(Material.ICE);
			FF.add(0, 0, -1).getBlock().setType(Material.ICE);
			FR.add(1, 0, -1).getBlock().setType(Material.ICE);
			RS.add(2, 0, 0).getBlock().setType(Material.ICE);
			LS.add(0, 1, 0).getBlock().setType(Material.ICE);
			FL.add(0, 1, 0).getBlock().setType(Material.ICE);
			FF.add(0, 1, 0).getBlock().setType(Material.ICE);
			FR.add(0, 1, 0).getBlock().setType(Material.ICE);
			RS.add(0, 1, 0).getBlock().setType(Material.ICE);

		}
		if (Direction > 225 && Direction < 315) { //EAST
			LS.add(0, 0, -2).getBlock().setType(Material.ICE);
			FL.add(1, 0, -1).getBlock().setType(Material.ICE);
			FF.add(1, 0, 0).getBlock().setType(Material.ICE);
			FR.add(1, 0, 1).getBlock().setType(Material.ICE);
			RS.add(0, 0, 2).getBlock().setType(Material.ICE);	
			LS.add(0, 1, 0).getBlock().setType(Material.ICE);
			FL.add(0, 1, 0).getBlock().setType(Material.ICE);
			FF.add(0, 1, 0).getBlock().setType(Material.ICE);
			FR.add(0, 1, 0).getBlock().setType(Material.ICE);
			RS.add(0, 1, 0).getBlock().setType(Material.ICE);
			
		}
		}

}
