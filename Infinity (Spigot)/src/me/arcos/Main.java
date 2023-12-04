package me.arcos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import me.arcos.APIs.Cooldown;
import me.arcos.commands.Commands;
import me.arcos.events.Arcos;
import me.arcos.events.Events;

public class Main extends JavaPlugin {
	
	public static Main m;
	public BukkitScheduler sh = Bukkit.getScheduler();
	public PluginManager pm = Bukkit.getPluginManager();
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Infinity ligado com sucesso");
		
		pm.registerEvents(new Arcos(), this);
		pm.registerEvents(new Events(), this);
		pm.registerEvents(new Commands(), this);
		
		getCommand("arcos").setExecutor(new Commands());
		
		Cooldown.setupCooldown();
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Infinity desligado");
		
		HandlerList.unregisterAll();
		
		super.onDisable();
	}
	
	@Override
	public void onLoad() {
		m = this;
		
		super.onLoad();
	}

}