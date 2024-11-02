package de.clmpvp.clmpvp.commands;

import de.clmpvp.clmpvp.main.Main;
import de.clmpvp.clmpvp.util.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Fly implements CommandExecutor {

    private final ConfigManager configManager;

    public Fly(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String prefix = configManager.getPrefix();
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("lobby.fly") || p.hasPermission("lobby.*")) {
                if (p.getAllowFlight()) {
                    p.setAllowFlight(false);
                    p.sendMessage(prefix + "Du kannst nun §cnicht §7mehr fliegen");
                    return true;
                } else {
                    p.setAllowFlight(true);
                    p.sendMessage(prefix + "Du kannst §ajetzt §7fliegen");
                }
            } else {
                p.sendMessage(configManager.getNoPerm());
            }
        }
        return false;
    }
}
