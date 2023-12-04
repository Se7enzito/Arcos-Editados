package me.arcos.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import me.arcos.APIs.ItemsAPI;
import me.arcos.APIs.MessagesAPI;

public class Commands implements CommandExecutor, Listener {

	private final MessagesAPI messagesAPI = new MessagesAPI("[InfinityLive] ");
	private final ItemsAPI item = new ItemsAPI();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("arcos")) {
			messagesAPI.abriuMenu();

			openMenuArcos(p);
		}

		return false;
	}
	
	@EventHandler
	public void clickInventory(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Tipos de Arcos")) {
			e.setCancelled(true);
			
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().isSimilar(item.arco_explosivo(p, true))) {
					p.closeInventory();
					p.getInventory().addItem(item.arco_explosivo(p, false));
				} else if (e.getCurrentItem().isSimilar(item.arco_raio(p, true))) {
					p.closeInventory();
					p.getInventory().addItem(item.arco_raio(p, false));
				} else if (e.getCurrentItem().isSimilar(item.arco_teleporte(p, true))) {
					p.closeInventory();
					p.getInventory().addItem(item.arco_teleporte(p, false));
				} else {
					return;
				}
			}
		}
	}

	private void openMenuArcos(Player p) {
		Inventory inventory = Bukkit.createInventory(null, 3 * 9, ChatColor.RED + "Tipos de Arcos");

		inventory.setItem(4, item.perfil(p));
		inventory.setItem(13, item.arco_explosivo(p, true));
		inventory.setItem(12, item.arco_raio(p, true));
		inventory.setItem(14, item.arco_teleporte(p, true));

		p.openInventory(inventory);
	}
}