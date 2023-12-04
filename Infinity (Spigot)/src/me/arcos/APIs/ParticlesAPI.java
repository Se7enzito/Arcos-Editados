package me.arcos.APIs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class ParticlesAPI {
	
	public void drawCircle(Location loc, float radius) {
		for (double t = 0; t < 50; t += 0.5) {
			float x = radius * (float) Math.sin(t);
			float z = radius * (float) Math.cos(t);

			PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.CRIT, true,
					(float) loc.getX() + x, (float) loc.getY(), (float) loc.getZ() + z, 0, 0, 0, 0, 1);

			for (Player online : Bukkit.getOnlinePlayers()) {
				((CraftPlayer) online).getHandle().playerConnection.sendPacket(packet);
			}
		}
	}
	
	public void drawCircleTimed(Location loc, float radius, int time) {
		for (double t = 0; t < time; t += 0.5) {
			float x = radius * (float) Math.sin(t);
			float z = radius * (float) Math.cos(t);

			PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.CRIT, true,
					(float) loc.getX() + x, (float) loc.getY(), (float) loc.getZ() + z, 0, 0, 0, 0, 1);

			for (Player online : Bukkit.getOnlinePlayers()) {
				((CraftPlayer) online).getHandle().playerConnection.sendPacket(packet);
			}
		}
	}

}
