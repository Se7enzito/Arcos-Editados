package me.arcos.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.arcos.APIs.MessagesAPI;

public class Events implements Listener {
	
	private final MessagesAPI messagesAPI = new MessagesAPI("[InfinityLive] ");
	
	@EventHandler
	public void pDeath(PlayerDeathEvent e) {
		Player killer = e.getEntity().getKiller();
		Player player = e.getEntity();
		
		e.setDeathMessage(messagesAPI.getMorte(killer, player));
	}
}
