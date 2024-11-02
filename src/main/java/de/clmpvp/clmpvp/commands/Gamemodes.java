package de.clmpvp.clmpvp.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gamemodes implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Überprüfen, ob der Sender ein Spieler ist
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("lobby.gm") || player.hasPermission("lobby.*")) {
                // Überprüfen, ob das richtige Argument übergeben wurde
                if (args.length == 1) {
                    try {
                        int mode = Integer.parseInt(args[0]);

                        switch (mode) {
                            case 0:
                                player.setGameMode(GameMode.SURVIVAL);
                                player.sendMessage("Du bist jetzt im Überlebensmodus.");
                                break;
                            case 1:
                                player.setGameMode(GameMode.CREATIVE);
                                player.sendMessage("Du bist jetzt im Kreativmodus.");
                                break;
                            case 2:
                                player.setGameMode(GameMode.ADVENTURE);
                                player.sendMessage("Du bist jetzt im Abenteuermodus.");
                                break;
                            case 3:
                                player.setGameMode(GameMode.SPECTATOR);
                                player.sendMessage("Du bist jetzt im Zuschauermodus.");
                                break;
                            default:
                                player.sendMessage("Ungültiger Spielmodus. Bitte wähle 0, 1, 2 oder 3.");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        player.sendMessage("Bitte gib eine gültige Zahl ein (0, 1, 2 oder 3).");
                    }
                } else {
                    player.sendMessage("Bitte benutze die richtige Syntax: /gm <0|1|2|3>");
                }
                return true;
            }


        } else {
            sender.sendMessage("Dieser Befehl kann nur von Spielern verwendet werden.");
            return false;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        // Überprüfen, ob der Sender ein Spieler ist und ob er die richtigen Argumente eingibt
        if (args.length == 1) {
            // Gibt die möglichen Argumente für Tab-Vervollständigung zurück
            return Arrays.asList("0", "1", "2", "3");
        }
        return new ArrayList<>(); // Leere Liste zurückgeben, wenn keine Argumente
    }
}

