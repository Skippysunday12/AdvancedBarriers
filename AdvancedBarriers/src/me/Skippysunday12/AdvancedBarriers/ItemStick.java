package me.Skippysunday12.AdvancedBarriers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class ItemStick {
	
	ItemStack item = null;
	
	public ItemStick() {
		item = new ItemStack(Material.STICK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Barrier Stick");
		meta.addEnchant(Enchantment.DURABILITY, 1, false);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Use this to place advanced barriers");
		meta.setLore(lore);
		item.setItemMeta(meta);
	}
	
	public boolean equals(ItemStack i) {
		return i.equals(item);
	}
	
	public ItemStack stick() {return item;}

}
