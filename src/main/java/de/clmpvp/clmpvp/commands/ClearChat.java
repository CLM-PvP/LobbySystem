package de.clmpvp.clmpvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearChat implements CommandExecutor  {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("lobby.cc") || p.hasPermission("lobby.*")) {

                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§7Der Chat wurde von §b" + p.getName() + " §7geleert");



            }
        }
        return false;
    }
}
