package me.Skippysunday12.AdvancedBarriers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if(event.getHand() != EquipmentSlot.HAND) return;
		if(event.getClickedBlock() == null) return;
		
		ItemStick i = new ItemStick();
		ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
		if(!(i.equals(item))) return;
		BlockFace b = event.getBlockFace();	
		Location loc = event.getClickedBlock().getLocation();
		
		switch (b) {
		case UP:
			loc = loc.clone().add(.5, 1.5, .5);
			break;
			
		case DOWN:
			loc = loc.clone().subtract(-.5, .5, -.5);
			break;
			
		case NORTH:
			loc = loc.clone().subtract(-.5, -.5, .5);
			break;
			
		case SOUTH:
			loc = loc.clone().add(.5, .5, 1.5);
			break;
			
		case EAST:
			loc = loc.clone().add(1.5, .5, .5);
			break;
			
		case WEST:
			loc = loc.clone().subtract(.5, -.5, -.5);
			break;
			
		default:
			break;
		}
		
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			loc.getBlock().setType(Material.MOVING_PISTON);
			
			if(!AdvancedBarriers.locations.contains(loc)) {
				AdvancedBarriers.locations.add(loc.clone());
				AdvancedBarriers.data.get().set("locations", AdvancedBarriers.locations);
			}
		}
		
		else if(event.getAction() == Action.LEFT_CLICK_BLOCK) {
			event.setCancelled(true);
			loc.getBlock().setType(Material.AIR);
			if(AdvancedBarriers.locations.contains(loc))
				AdvancedBarriers.locations.remove(loc);
			
			AdvancedBarriers.data.get().set("locations", AdvancedBarriers.locations);
		}
		else return;
	}
}
