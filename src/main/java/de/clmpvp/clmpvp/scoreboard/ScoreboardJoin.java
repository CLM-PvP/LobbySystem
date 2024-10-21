package de.clmpvp.clmpvp.scoreboard;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ScoreboardJoin implements Listener {
    private final MySQL mySQL;

    public ScoreboardJoin(MySQL mySQL) {
        this.mySQL = mySQL;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        String uuid = e.getPlayer().getUniqueId().toString();
        String rank = mySQL.getPlayerRank(uuid);
        PlayerScoreboard.setPlayerScoreboard(e.getPlayer(), rank);
    }

}
