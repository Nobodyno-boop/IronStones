package fr.poulpi.IronStones;

import java.util.Arrays;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import fr.poulpi.IronStones.commands.commands;
import fr.poulpi.IronStones.listeners.Listeners;
import fr.poulpi.IronStones.runnable.Runnables;

public class IronStones extends JavaPlugin {
	private static IronStones instance;
	public FileConfiguration config = getConfig();
			
	@Override
	public void onEnable() {
		instance = this;
		ini_default_config();
		Listeners.registerListerners(instance);
		commands.register(instance);
		Runnables.registerRunnable();
		
	}
	
	
	private void ini_default_config()
	{
		config.addDefault("server.name", "&5Iron&6Stones");
		config.addDefault("server.motd", "&5MOTD &6Default");
		config.addDefault("server.chat.mode" , false);
		config.addDefault("server.chat_prefix", ">");
		
	
		
		String[] list = {"Le serveur en maintenance", "Site en construction", "Serveur en beta !"};
		config.addDefault("server.autoMessage_prefix", "&l[&6!&r&l]");
		config.addDefault("server.autoMessage", Arrays.asList(list));

		
		
		//Surivie
		config.addDefault("game.invMenu.survie.name", "&Icon Survie");
		String[] listMS = {"Icon survie blal", "blblblbbllb", "blbblbl"};
		config.addDefault("game.invMenu.survie.lore", Arrays.asList(listMS));
		config.addDefault("game.invMenu.survie.exe", "me");
		//Shop
		config.addDefault("game.invMenu.shop.name", "&Icon shop");
		String[] listsp = {"Icon shop blal", "blblblbbllb", "blbblbl"};
		config.addDefault("game.invMenu.shop.lore", Arrays.asList(listsp));
		config.addDefault("game.invMenu.shop.exe", "aide");
		//minage
		config.addDefault("game.invMenu.minage.name", "&Icon minage");
		String[] listmg = {"Icon minage blal", "blblblbbllb", "blbblbl"};
		config.addDefault("game.invMenu.minage.lore", Arrays.asList(listmg));
		config.addDefault("game.invMenu.minage.exe", "spawn");
		
		config.addDefault("server.cmd.prefix", "&9Serveur ->");
		config.addDefault("server.cmd.rl.msg", "have been reload by %playerName%");
		
		
		this.getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public static IronStones getInstance(){return instance;}
	
	
}
