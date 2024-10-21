package de.clmpvp.clmpvp.spawn;

import de.clmpvp.clmpvp.util.ConfigManager;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SpawnJoin implements Listener {

    private final ConfigManager configManager;

    public SpawnJoin(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String prefix = configManager.getPrefix();
        Location spawn = configManager.getSpawn();

        if (spawn != null) {
            event.getPlayer().teleport(spawn);
            event.getPlayer().sendMessage(prefix + "Willkommen! Du wurdest zum Spawn teleportiert.");
        } else {
            event.getPlayer().sendMessage(prefix + "§cDer Spawnpunkt wurde noch nicht gesetzt.");
        }
    }
}