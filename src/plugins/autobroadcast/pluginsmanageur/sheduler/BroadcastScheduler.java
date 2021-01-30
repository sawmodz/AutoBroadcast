package plugins.autobroadcast.pluginsmanageur.sheduler;

import org.bukkit.Bukkit;
import plugins.autobroadcast.pluginsmanageur.Main;

import java.util.Collections;

public class BroadcastScheduler implements Runnable {

	int currentIndex;

	public BroadcastScheduler() {
		this.currentIndex = 0;
	}

	@Override
	public void run() {
		if (currentIndex == 0)
			Collections.shuffle(Main.MESSAGES);
		Bukkit.broadcastMessage(Main.MESSAGES.get(currentIndex));
		currentIndex = (currentIndex + 1) % Main.MESSAGES.size();
	}
}
