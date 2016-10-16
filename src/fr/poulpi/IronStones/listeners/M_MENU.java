package fr.poulpi.IronStones.listeners;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.poulpi.IronStones.IronStones;


public class M_MENU implements Listener {
	
	private static String title = "§9Menu";

	
	public static void onPlayerOpenMenu(Player p)
	{

		Inventory inv =  Bukkit.createInventory(null, 3*9, title);
		
		ItemStack panel1 = new ItemStack(Material.STAINED_GLASS_PANE,1, (short)5 );
		ItemMeta pa1 = panel1.getItemMeta();
		pa1.setDisplayName("§7");
		panel1.setItemMeta(pa1);
		
		ItemStack panel2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);
		ItemMeta pa2 = panel2.getItemMeta();
		pa2.setDisplayName("§7");
		panel2.setItemMeta(pa2);
		
		ItemStack panel3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		ItemMeta pa3 = panel3.getItemMeta();
		pa3.setDisplayName("§3");
		panel3.setItemMeta(pa3);
		
		
		ItemStack mondeS = new ItemStack(Material.DIRT);
		ItemMeta ms = mondeS.getItemMeta();
		String mS = IronStones.getInstance().getConfig().getString("game.invMenu.survie.name").replace('&', '§');
		List<String> loreS = IronStones.getInstance().getConfig().getStringList("game.invMenu.survie.name");
		ms.setLore(loreS);
		ms.setDisplayName(mS);
		mondeS.setItemMeta(ms);
		
		ItemStack shop = new ItemStack(Material.EMERALD);
		ItemMeta sp = shop.getItemMeta();
		String spn = IronStones.getInstance().getConfig().getString("game.invMenu.shop.name").replace('&', '§');
		List<String> los =	IronStones.getInstance().getConfig().getStringList("game.invMenu.shop.lore");
		sp.setLore(los);
		sp.setDisplayName(spn);
		shop.setItemMeta(sp);
		
		
		
		ItemStack minage = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta mg = minage.getItemMeta();
		String mgn = IronStones.getInstance().getConfig().getString("game.invMenu.minage.name").replace('&', '§');
		List<String> loreM = IronStones.getInstance().getConfig().getStringList("game.invMenu.minage.lore");
		mg.setDisplayName(mgn);
		mg.setLore(loreM);
		minage.setItemMeta(mg);
		
		
		
		
		inv.setItem(0, panel1);
		inv.setItem(1, panel1);
		inv.setItem(2, panel1);
		inv.setItem(9, panel1);
		inv.setItem(10, mondeS);
		inv.setItem(11, panel1);
		inv.setItem(18, panel1);
		inv.setItem(19, panel1);
		inv.setItem(20, panel1);
		// End survie
		
		inv.setItem(3, panel2);
		inv.setItem(4, panel2);
		inv.setItem(5, panel2);
		inv.setItem(12, panel2);
		inv.setItem(14, panel2);
		inv.setItem(13, shop);
		inv.setItem(21, panel2);
		inv.setItem(22, panel2);
		inv.setItem(23, panel2);
		//end shop
		
		inv.setItem(6, panel3);
		inv.setItem(7, panel3);
		inv.setItem(8, panel3);
		inv.setItem(15, panel3);
		inv.setItem(16, minage);
		inv.setItem(17, panel3);
		inv.setItem(24, panel3);
		inv.setItem(25, panel3);
		inv.setItem(26, panel3);
		// End minage
		
		p.openInventory(inv);
	}
	
	
	
	@EventHandler
	public   void onInteractInvMenu(InventoryClickEvent e)
	{
		if(e.getInventory().getTitle().equalsIgnoreCase(title))
		{
			Player p = (Player) e.getWhoClicked();
			
			switch (e.getCurrentItem().getType()) {
			case STAINED_GLASS_PANE:
					e.setCancelled(true);
				break;
			case DIRT:
					p.performCommand(IronStones.getInstance().getConfig().getString("game.invMenu.survie.exe"));
					p.closeInventory();
					e.setCancelled(true);
				break;
			case DIAMOND_PICKAXE:
					p.performCommand(IronStones.getInstance().getConfig().getString("game.invMenu.minage.exe"));
					p.closeInventory();
				e.setCancelled(true);
				break;
			case EMERALD:
					p.performCommand(IronStones.getInstance().getConfig().getString("game.invMenu.shop.exe"));
					p.closeInventory();
				e.setCancelled(true);
				break;
			default:
				break;
			}
		}
	}
	
}
