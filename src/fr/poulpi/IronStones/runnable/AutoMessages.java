package fr.poulpi.IronStones.runnable;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;

import fr.poulpi.IronStones.IronStones;

public class AutoMessages {
	
	public static void Auto()
	{
		Bukkit.getScheduler().scheduleSyncRepeatingTask(IronStones.getInstance(), new Runnable() {
			
			final List<String> list = IronStones.getInstance().getConfig().getStringList("server.autoMessage");
			@Override
			public void run() {
				Random r = new Random();

				Bukkit.broadcastMessage(IronStones.getInstance().getConfig().getString("server.autoMessage_prefix").replace('&', '§')+ " §r"+list.get(r.nextInt(list.size())));
				
			}
		}, 12000, 12000);// 5min
	}
}
