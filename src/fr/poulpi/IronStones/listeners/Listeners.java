package fr.poulpi.IronStones.listeners;


import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.poulpi.IronStones.IronStones;

public class Listeners {
	
	
	
	public static void registerListerners(IronStones pl)
	{
		PluginManager pm = Bukkit.getPluginManager();
		 
		pm.registerEvents(new L_MOTD(), pl);
		pm.registerEvents(new L_Chat(), pl);
		pm.registerEvents(new M_MENU(), pl);
	}
}
