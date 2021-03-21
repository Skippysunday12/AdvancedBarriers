package me.Skippysunday12.AdvancedBarriers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class DataManager{
	
	private File file;
	private FileConfiguration config;
	private String name;
	private AdvancedBarriers plugin;
	
	public DataManager(AdvancedBarriers b, String name) {
		plugin = b;
		this.name = name;
		setup();
	}
	
	
	
	private void setup() {
		if(!plugin.getDataFolder().exists()) plugin.getDataFolder().mkdir();
		
		file = new File(plugin.getDataFolder(), name);
		
		if(!file.exists()) try {
			file.createNewFile();
		}catch(IOException e) { e.printStackTrace(); Bukkit.getLogger().log(Level.SEVERE, "Could not create file");}	
		config = YamlConfiguration.loadConfiguration(file);
		
		if(file.length() == 0) {
			InputStream in = new ByteArrayInputStream("locations: []".getBytes(StandardCharsets.UTF_8));
			config = YamlConfiguration.loadConfiguration(new InputStreamReader(in));
			save();
		}
	}
	
	
	public void save() {try {
		config.save(file);
	} catch (IOException e) {
		e.printStackTrace();
	}}
	
	public void reload() {config = YamlConfiguration.loadConfiguration(file);}
	
	public FileConfiguration get() {return config;}
	
	
	
	
	
	
	
	
	
	
	
	
}