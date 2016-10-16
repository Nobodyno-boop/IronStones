package fr.poulpi.IronStones.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import fr.poulpi.IronStones.IronStones;

public class L_MOTD implements Listener {
	
	@EventHandler
	public void onServerPing(ServerListPingEvent e)
	{
		String motd = IronStones.getInstance().getConfig().getString("server.motd");
		
		e.setMotd(motd.replace('&', '§'));
	}

}
