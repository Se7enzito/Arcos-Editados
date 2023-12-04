package me.arcos.events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.projectiles.ProjectileSource;

import me.arcos.APIs.ItemsAPI;
import me.arcos.APIs.ParticlesAPI;

public class Arcos implements Listener {

	private ItemsAPI item = new ItemsAPI();
	private ParticlesAPI part = new ParticlesAPI();

	@EventHandler
	public void shootEvent(EntityShootBowEvent e) {
		Player p = (Player) e.getEntity();
		Arrow arrow = (Arrow) e.getProjectile();

		if (e.getEntity() instanceof Player) {
			if (p.getItemInHand().isSimilar(item.arco_explosivo(p, false))) {
				TNTPrimed tnt = (TNTPrimed) arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.PRIMED_TNT);
				tnt.setVelocity(arrow.getVelocity());
			}
		}
	}

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		Projectile arrow = e.getEntity();
		ProjectileSource p = arrow.getShooter();

		if (arrow instanceof Arrow & p instanceof Player) {
			Player player = (Player) p;
			if (player.getItemInHand().isSimilar(item.arco_teleporte(player, false))) {
				player.teleport(arrow.getLocation().setDirection(player.getLocation().getDirection()));
				
				part.drawCircle(arrow.getLocation(), 4);
			} else if (player.getItemInHand().isSimilar(item.arco_raio(player, false))) {
				arrow.getLocation().getWorld().strikeLightning(arrow.getLocation());
				
				part.drawCircle(arrow.getLocation(), 2);
			}
		}
	}
}