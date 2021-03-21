package me.Skippysunday12.AdvancedBarriers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class BarrierStick implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("barrierstick")) {
		
			if(!sender.hasPermission("AdvancedBarriers.barrierstick")) return false;
			
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You must be a player to run this command");
				return false;
			}
			
			Player player = (Player) sender;
			
			ItemStick stick = new ItemStick();
			if(player.getInventory().firstEmpty() == -1) { 
				player.getWorld().dropItem(player.getLocation(), stick.item);
				return false;
			}
			
			player.getInventory().addItem(stick.item);
			
			
			
		}
		return false;
	}

}
