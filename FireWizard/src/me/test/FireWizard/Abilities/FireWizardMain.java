package me.test.FireWizard.Abilities;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectTypeWrapper;
import org.bukkit.util.Vector;

import com.mojang.datafixers.types.templates.List;

import me.test.FireWizard.Main;

public class FireWizardMain implements Listener, CommandExecutor {
	private float Direction;
	private ArrayList<Player> List_of_Fire_Wizard = new ArrayList();
	private Main plugin;

	public FireWizardMain(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("FireWizard").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		Player player = (Player) sender; // GENERAL TURN OFF AND ON TO BE USED LATER FOR FURTHER DEVELOPMENT
		if (args[0].equalsIgnoreCase("true")) {
			player.chat("Player chose FireWizard");
			List_of_Fire_Wizard.add(player);

		} else if (args[0].equalsIgnoreCase("false")) {
			List_of_Fire_Wizard.remove(player);
		}
		return false;
	}

	@EventHandler // TO BE CHANGED
	public void onPlayerMove(PlayerMoveEvent e) {
		if (List_of_Fire_Wizard.contains(e.getPlayer())) {
			Player player = e.getPlayer();
			Location onGround = player.getLocation().clone();
			Location TopGround = player.getLocation().clone();
			onGround.subtract(0, 1, 0);
			if (onGround.getBlock().getType().equals(Material.SOUL_SAND) || TopGround.getBlock().getType().equals(Material.SOUL_SAND) ) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10, 3));
			}
		}
	}

	@EventHandler()
	public void thrownDirection(PlayerInteractEvent event) {
		if (List_of_Fire_Wizard.contains(event.getPlayer())) {

			// TO BE CHANGED - THIS DOESNT APPLY TO ANY FIRE WIZARD ABILTIES
			Player player = (Player) event.getPlayer();
			if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.SNOWBALL)) {
				if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					Direction = player.getLocation().getYaw();
				}
			}
			// PLACESOUL IS CURRENTLY BEING USED AS A THROWABLE = MORE OP CHANGE IT TO
			// ANOTHER TYPE OF PLACEABLE
//		else if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.ICE)) {
//			if (event.getPlayer().isOnGround()) {
//				if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
//					SoulSandPlace Ground = new SoulSandPlace();
//					Ground.placeSoul(event);
//				}
//			}
//		}
			// TO BE CHANGED TO: BLAZE; CREATE A TRAIL OF FIRE FOR 5 SECONDS
			else if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BLAZE_POWDER)) {
				if (event.getPlayer().isOnGround()) {
					if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
//						FireTrail Trail = new FireTrail();
//						FireTrail.spawnArena(event.getPlayer()); 
					}
				}
			}
			// TO BE CHANGED - USE FOR PLANTING SOUL UNDER TARGET
			else if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.FIRE_CHARGE)) {
				if (event.getAction() == Action.RIGHT_CLICK_AIR|| event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					player.launchProjectile(Fireball.class).setVelocity(player.getLocation().getDirection().multiply(1.5));
					
				}
			}
		}

	}

	@EventHandler // Cancel the ice being placed
	public void onBlockPlace(BlockPlaceEvent event) {
		if (List_of_Fire_Wizard.contains(event.getPlayer())) {

			if (event.getBlock().getType() == Material.ICE) {
				event.setCancelled(true);
			} else if (event.getBlock().getType() == Material.SNOW_BLOCK) {
				event.setCancelled(true);
			}
		}
	}

	// WAND DAMAGE ICE ===================================
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		Entity entityDamage = event.getEntity();
		if (event.getDamager().getType() == EntityType.EGG) {
			if (entityDamage instanceof Player) {
				event.setDamage(2);
				Player playerDamaged = (Player) entityDamage;
				SoulSandPlace placeSoulSand = new SoulSandPlace();
				placeSoulSand.soulGroundPlace(playerDamaged);
			}
		}
	}

	// TO BE CHANGED
	// WAND DAMAGE ICE =================================== //TO BE CHANGED
	@EventHandler()
	public void EggThrow(PlayerEggThrowEvent event) {
		if (List_of_Fire_Wizard.contains(event.getPlayer())) {

			event.setHatching(false);
		}
	}

	@EventHandler() // TO BE CHANGED
	public void onLand(ProjectileHitEvent event) {
		if (List_of_Fire_Wizard.contains(event.getEntity().getShooter())) {
			if (event.getEntityType() == EntityType.SNOWBALL) {
				if (event.getEntity().getShooter() instanceof Player) {
					Location loc = event.getEntity().getLocation();
					placeBlocks(loc);
					Direction = 0;
				}

			}
			// WAND DAMAGE ICE ===================================
			else if (event.getEntityType() == EntityType.EGG) {
				event.getEntityType().EGG.isSpawnable();
				if (event.getEntity().getShooter() instanceof Player) {
					Player player = (Player) event.getEntity().getShooter();
					if (event.getHitEntity() instanceof Player) {
						player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
					}
				}
			}
		}

	}

	private void placeBlocks(Location loc) { // FINISHED //TO BE MOVED??? //TO BE CHANGED
		Location LS = loc.clone();
		Location FL = loc.clone();
		Location FF = loc.clone();
		Location FR = loc.clone();
		Location RS = loc.clone();

		if (Direction > 315 && Direction < 360 || Direction > 0 && Direction < 45) { // NORTH
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

		if (Direction > 45 && Direction < 135) { // WEST
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

		if (Direction > 135 && Direction < 225) { // NORTH
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
		if (Direction > 225 && Direction < 315) { // EAST
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
