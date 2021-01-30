package plugins.autobroadcast.pluginsmanageur.sheduler;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import plugins.autobroadcast.pluginsmanageur.Main;

public class BroadcastSheduler extends BukkitRunnable{
	
	private Random random = new Random();
	
	@Override
	public void run() {
		Bukkit.broadcastMessage(Main.getInstance().allBroadcastMessages.get(random.nextInt(Main.getInstance().allBroadcastMessages.size())));
	}

}
