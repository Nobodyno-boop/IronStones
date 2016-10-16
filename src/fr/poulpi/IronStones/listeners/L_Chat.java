package fr.poulpi.IronStones.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.poulpi.IronStones.IronStones;

public class L_Chat implements Listener {

	
	
		@EventHandler
		public void OnSendChat(AsyncPlayerChatEvent e)
		{
		if(IronStones.getInstance().getConfig().getBoolean("server.chat.mode") == true){
			Player p = e.getPlayer();
			String msg = e.getMessage();
			String config_msg = IronStones.getInstance().getConfig().getString("server.chat_prefix").replace("%playerName%", p.getName()).replace("%msg%", msg);
			
			if(p.isOp()) {
				e.setFormat(config_msg.replace('&', '§'));
			}else {
				e.setFormat(config_msg);
			}
		}
		}
		
		
		
}
