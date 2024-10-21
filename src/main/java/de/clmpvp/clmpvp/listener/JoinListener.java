package de.clmpvp.clmpvp.listener;

import de.clmpvp.clmpvp.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        Player p = e.getPlayer();
        p.teleport(new Location(Bukkit.getWorld(Main.world), 8, -60, 14, 90, 0));
        p.setFoodLevel(20);
        p.setHealth(20);
        p.setLevel(2024);
        if (p.hasPermission("lobby.gamemode") || p.hasPermission("lobby.*")) {
            p.setGameMode(GameMode.CREATIVE);
        } else {
            p.setGameMode(GameMode.SURVIVAL);
        }
    }

}
