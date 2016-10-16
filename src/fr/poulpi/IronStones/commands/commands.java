package fr.poulpi.IronStones.commands;

import fr.poulpi.IronStones.IronStones;

public class commands {

	
		public static void register(IronStones pl)
		{
			pl.getCommand("menu").setExecutor(new C_Menu());
			pl.getCommand("ironRl").setExecutor(new C_RL());
		}
}
