package plugins.autobroadcast.pluginsmanageur;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import plugins.autobroadcast.pluginsmanageur.sheduler.BroadcastSheduler;

public class Main extends JavaPlugin{
	
	public static Main instance;
	private int shedulerSecondes = getConfig().getInt("timeExecuteBroadcast") * 20;
	public ArrayList<String> allBroadcastMessages = new ArrayList<String>();
	
	public void onEnable(){
		instance = this;
		EventManager.registerEvents(this);
		saveDefaultConfig();
		
		for(String string : Main.getInstance().getConfig().getConfigurationSection("messages").getKeys(false)) {
			allBroadcastMessages.add(Main.getInstance().getConfig().getConfigurationSection("messages").getString(string));
		}
		
		new BroadcastSheduler().runTaskTimer(this, shedulerSecondes, shedulerSecondes);
	}
	
	public void onDisable(){
	}
	
	public static Main getInstance() {
		return instance;
	}
	
}
