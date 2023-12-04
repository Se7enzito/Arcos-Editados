package me.arcos.APIs;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemsAPI {

	private final StatiscsAPI statiscs = new StatiscsAPI();

	public ItemStack perfil(Player p) {
		ItemStack item = HeadsAPI.getPlayerSkull(p.getName());
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.GOLD + p.getName());
		meta.setLore(Arrays.asList(ChatColor.YELLOW + "Informações", "",
				ChatColor.YELLOW + "Vida Máxima: " + ChatColor.GREEN + p.getMaxHealth(),
				ChatColor.RED + "Kills: " + ChatColor.GREEN + statiscs.getKillsPlayers(p),
				ChatColor.YELLOW + "Mortes: " + ChatColor.GREEN + statiscs.getMortes(p)));

		item.setItemMeta(meta);

		return item;
	}

	public ItemStack arco_explosivo(Player p, boolean menu) {
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.RED + "Arco Explosivo");

		if (menu == true) {
			meta.setLore(Arrays.asList(ChatColor.DARK_GREEN + "CLIQUE DIREITO " + ChatColor.GRAY + "para selecionar",
					"", ChatColor.YELLOW + "Funcionamento: Atire flechas explosivas"));
		}
		item.setItemMeta(meta);

		return item;
	}

	public ItemStack arco_teleporte(Player p, boolean menu) {
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.RED + "Arco de Teleporte");

		if (menu == true) {
			meta.setLore(Arrays.asList(ChatColor.DARK_GREEN + "CLIQUE DIREITO " + ChatColor.GRAY + "para selecionar",
					"", ChatColor.YELLOW + "Funcionamento: Atire flechas que te teleportam para onde cairem"));
		}

		item.setItemMeta(meta);

		return item;
	}

	public ItemStack arco_raio(Player p, boolean menu) {
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.RED + "Arco de Raios");

		if (menu == true) {
			meta.setLore(Arrays.asList(ChatColor.DARK_GREEN + "CLIQUE DIREITO " + ChatColor.GRAY + "para selecionar",
					"", ChatColor.YELLOW + "Funcionamento: Atire flechas elétricas"));
		}

		item.setItemMeta(meta);

		return item;
	}
}