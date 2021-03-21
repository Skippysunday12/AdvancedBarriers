package me.Skippysunday12.AdvancedBarriers;

import java.util.Iterator;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Clear implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("clearbarriers")) {
			
			if(!sender.hasPermission("AdvancedBarriers.clearbarriers")) return false;
			
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You must be a player to run this command");
				return false;
			}
			
			Player player = (Player) sender;
			
			Iterator<Location> it = AdvancedBarriers.locations.iterator();
			
			while(it.hasNext()) {
				it.next().getBlock().setType(Material.AIR);
				it.remove();
			}
			
			player.sendMessage(ChatColor.AQUA + "All locations removed!");
			
		}
		
		
		return false;
	}
}
