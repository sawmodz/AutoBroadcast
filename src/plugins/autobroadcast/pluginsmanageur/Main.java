package plugins.autobroadcast.pluginsmanageur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.mrcubee.annotation.spigot.config.Config;
import fr.mrcubee.annotation.spigot.config.ConfigAnnotation;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import plugins.autobroadcast.pluginsmanageur.sheduler.BroadcastScheduler;

public class Main extends JavaPlugin {

	public static final List<String> MESSAGES = new ArrayList<String>();

	@Config(path = "timeExecuteBroadcast")
	private static int timeExecuteBroadCast;
	@Config(path = "messages", color = true)
	private static List<String> configMessage;

	private BroadcastScheduler broadcastScheduler;
	private BukkitTask bukkitTask;

	@Override
	public void reloadConfig() {
		if (this.bukkitTask != null) {
			this.bukkitTask.cancel();
			this.bukkitTask = null;
		}
		super.reloadConfig();
		ConfigAnnotation.loadClass(getConfig(), Main.class);
		Main.MESSAGES.clear();
		if (Main.configMessage == null || Main.configMessage.isEmpty())
			return;
		Main.MESSAGES.addAll(Main.configMessage);
		if (timeExecuteBroadCast < 1)
			timeExecuteBroadCast = 1;
		this.bukkitTask = Bukkit.getScheduler().runTaskTimer(this, this.broadcastScheduler, 0, Main.timeExecuteBroadCast * 20L);
	}

	@Override
	public void onLoad() {
		saveDefaultConfig();
		this.broadcastScheduler = new BroadcastScheduler();
	}

	@Override
	public void onEnable() {
		reloadConfig();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		reloadConfig();
		return true;
	}
}
