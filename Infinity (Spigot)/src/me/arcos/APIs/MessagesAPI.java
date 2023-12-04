package me.arcos.APIs;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessagesAPI {

	private final String serverPrefix;

	public MessagesAPI(String serverPrefix) {
		this.serverPrefix = serverPrefix;
	}

	public String formatMessage(String message) {
		return ChatColor.translateAlternateColorCodes('&', serverPrefix + " " + message);
	}

	public String getUparLevelErro() {
		return formatMessage(ChatColor.RED + "Uso do comando: /uparlevel (level) [player]");
	}
	
	public String getMorte(Player killer, Player morreu) {
		return formatMessage(ChatColor.RED + "" + killer + " matou o " + morreu);
	}
	
	public String abriuMenu() {
		return formatMessage(ChatColor.RED + "Menu aberto com sucesso");
	}
}
