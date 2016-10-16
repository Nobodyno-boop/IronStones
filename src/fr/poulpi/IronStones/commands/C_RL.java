package fr.poulpi.IronStones.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.poulpi.IronStones.IronStones;

public class C_RL implements CommandExecutor {
	String prefix = IronStones.getInstance().getConfig().getString("server.cmd.prefix").replace('&', '§');
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player))
		{
			System.out.println("not allowed in the console.");
			return true;
		}else {
			Player p  = (Player)sender;
			if(p.isOp() && cmd.getName().equalsIgnoreCase("ironRl"))
			{
				Bukkit.getPluginManager().getPlugin("IronStones").reloadConfig();
				for(Player pls : Bukkit.getOnlinePlayers())
				{
					if(pls.isOp()){
						pls.sendMessage(prefix+ IronStones.getInstance().getConfig().getString("server.cmd.rl.msg").replaceAll("%playerName%", sender.getName()).replace('&', '§'));
					}
				}
				return true;
			}
		}
		return false;
	}

}
