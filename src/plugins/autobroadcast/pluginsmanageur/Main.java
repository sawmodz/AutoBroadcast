package Plugins.GameName.PluginsManageur;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static Main instance;
	
	public void onEnable(){
		System.out.println("[Plugin teste] Enabled");
		instance = this;
		EventManager.registerEvents(this);
	}
	
	public void onDisable(){
		System.out.println("[Plugin teste] Enabled");
	}
	
	public static Main getInstance() {
		return instance;
	}
	
}
