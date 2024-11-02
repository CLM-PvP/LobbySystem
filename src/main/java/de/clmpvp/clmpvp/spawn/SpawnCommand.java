package de.clmpvp.clmpvp.spawn;

import de.clmpvp.clmpvp.main.Main;
import de.clmpvp.clmpvp.scoreboard.PlayerScoreboard;
import de.clmpvp.clmpvp.util.ConfigManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {

    private final ConfigManager configManager;

    public SpawnCommand(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String prefix = configManager.getPrefix();
        Player player = (Player) sender;

        if (!(sender instanceof Player)) {
            sender.sendMessage(prefix + "§cNur Spieler können diesen Befehl verwenden.");
            return true;
        }

        if (player.hasPermission("lobby.spawn.set") || player.hasPermission("lobby.*")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("set")) {
                configManager.setSpawn(player.getLocation());
                player.sendMessage(prefix + "§7Spawnpunkt erfolgreich gesetzt.");
            } else {
                Location spawn = configManager.getSpawn();
                if (spawn == null) {
                    player.sendMessage(prefix + "§cDer Spawnpunkt wurde noch nicht gesetzt.");
                } else {
                    player.teleport(spawn);
                    player.sendMessage(prefix + "Du wurdest zum Spawn teleportiert.");
                }
            }
        }

        return true;
    }
}