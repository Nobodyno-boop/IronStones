package fr.poulpi.IronStones.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.poulpi.IronStones.listeners.M_MENU;

public class C_Menu implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		if(!(sender instanceof Player))
		{
			System.out.println("Error: your are not a player.");
		}else {
			if(cmd.getName().equalsIgnoreCase("menu"))
			{
				M_MENU.onPlayerOpenMenu(p);
				return true;
			}
		}
		return false;
	}

}
