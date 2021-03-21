package me.Skippysunday12.AdvancedBarriers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AdvancedBarriers extends JavaPlugin{
	public static DataManager data;
	public static List<Location> locations;
	@SuppressWarnings("unchecked")
	@Override
	public void onEnable() {
		
		data = new DataManager(this, "data.yml");
		
		this.getServer().getPluginManager().registerEvents(new Events(), this);
		this.getCommand("barrierstick").setExecutor(new BarrierStick());
		this.getCommand("clearbarriers").setExecutor(new Clear());
		
		locations = Collections.synchronizedList((List<Location>) data.get().getList("locations"));
		if(locations == null) locations = Collections.synchronizedList(new ArrayList<Location>());
		new BukkitRunnable() {
			@Override
			public void run() {
				data.save();
			}
		}.runTaskTimerAsynchronously(this, 80, 80);
		
		new BukkitRunnable() {
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(p.getInventory().getItemInMainHand().equals(new ItemStick().item))
					for(Location loc : locations) {
						p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY(), loc.getZ(), 0, 0.001, 1, 0, 1, new Particle.DustOptions(Color.AQUA, 5));
					}
				}
			}
		}.runTaskTimerAsynchronously(this, 0, 5);
	}
	
	@Override
	public void onDisable() {
		
	}
}
