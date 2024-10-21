package de.clmpvp.clmpvp.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerScoreboard {

    public static void setPlayerScoreboard(Player player, String rank) {
        // Neues Scoreboard erstellen
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("clmpvp", "dummy",
                "§b§lCLM-PvP"); // Titel in Gold und fett
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        // Separator für bessere Lesbarkeit
        Score separator1 = objective.getScore("§7-----------------"); // Separator
        separator1.setScore(5);

        // Spielername
        Score nameScore = objective.getScore("§bName: §7" + player.getName()); // Name in Grün und Weiß
        nameScore.setScore(4);

        // Separator
        Score separator2 = objective.getScore("§7-----------------"); // Separator
        separator2.setScore(3);

        // Rang
        Score rankScore = objective.getScore("§bRang: §7" + rank); // Rang in Grün und Weiß
        rankScore.setScore(2);

        // Letzter Separator
        Score separator3 = objective.getScore("§7-----------------"); // Separator
        separator3.setScore(1);

        Score ip = objective.getScore("CLM-PvP.net"); // Separator
        ip.setScore(0);

        // Scoreboard dem Spieler zuweisen
        player.setScoreboard(scoreboard);
    }

}
