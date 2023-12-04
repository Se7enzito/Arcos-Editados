package me.arcos.APIs;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class StatiscsAPI {
	
	public int getMortes(Player p) {
		return p.getStatistic(Statistic.DEATHS);
	}
	
	public int getKillsPlayers(Player p) {
		return p.getStatistic(Statistic.PLAYER_KILLS);
	}
	
	public int getKillsEntity(Player p) {
		return p.getStatistic(Statistic.MOB_KILLS);
	}
	
	public int getKillsGeral(Player p) {
		return p.getStatistic(Statistic.MOB_KILLS) + p.getStatistic(Statistic.PLAYER_KILLS);
	}
}
