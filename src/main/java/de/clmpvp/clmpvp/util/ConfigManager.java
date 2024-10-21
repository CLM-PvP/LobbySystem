package de.clmpvp.clmpvp.util;

import de.clmpvp.clmpvp.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

    private final Main plugin;
    private final FileConfiguration config;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        loadDefaultConfig();
    }

    // Standardwerte laden, falls sie fehlen
    private void loadDefaultConfig() {
        plugin.saveDefaultConfig();
    }

    // Prefix aus der Config lesen
    public String getPrefix() {
        String rawPrefix = config.getString("prefix", "&a[CLM-PvP] &r");
        return ChatColor.translateAlternateColorCodes('&', rawPrefix);
    }

    // --- SPAWN BEZOGENE METHODEN ---

    // Spawn setzen
    public void setSpawn(Location location) {
        config.set("spawn.world", location.getWorld().getName());
        config.set("spawn.x", location.getX());
        config.set("spawn.y", location.getY());
        config.set("spawn.z", location.getZ());
        config.set("spawn.yaw", location.getYaw());
        config.set("spawn.pitch", location.getPitch());
        plugin.saveConfig();
    }

    // Spawn abrufen
    public Location getSpawn() {
        if (!config.contains("spawn.world")) {
            Bukkit.getLogger().warning(getPrefix() + "§c Spawnpunkt ist noch nicht gesetzt.");
            return null;
        }

        World world = Bukkit.getWorld(config.getString("spawn.world"));
        if (world == null) {
            Bukkit.getLogger().warning(getPrefix() + "§c Welt für den Spawnpunkt konnte nicht gefunden werden.");
            return null;
        }

        double x = config.getDouble("spawn.x");
        double y = config.getDouble("spawn.y");
        double z = config.getDouble("spawn.z");
        float yaw = (float) config.getDouble("spawn.yaw");
        float pitch = (float) config.getDouble("spawn.pitch");

        return new Location(world, x, y, z, yaw, pitch);
    }
}
