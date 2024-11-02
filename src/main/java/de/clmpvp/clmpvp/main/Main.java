package de.clmpvp.clmpvp.main;

import de.clmpvp.clmpvp.commands.Build;
import de.clmpvp.clmpvp.commands.ClearChat;
import de.clmpvp.clmpvp.commands.Fly;
import de.clmpvp.clmpvp.commands.Gamemodes;
import de.clmpvp.clmpvp.interact.AdminTools;
import de.clmpvp.clmpvp.interact.Compass;
import de.clmpvp.clmpvp.interact.PlayerHider;
import de.clmpvp.clmpvp.items.JoinItems;
import de.clmpvp.clmpvp.listener.*;
import de.clmpvp.clmpvp.scoreboard.*;
import de.clmpvp.clmpvp.spawn.SpawnCommand;
import de.clmpvp.clmpvp.spawn.SpawnJoin;
import de.clmpvp.clmpvp.util.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;
import java.util.ArrayList;

public final class Main extends JavaPlugin {
    private MySQL mySQL;
    private ConfigManager configManager;
    private FileConfiguration config;


    public static String console = "§7[§bCLM-PvP§7] Du musst ein Spieler sein";
    public static String world = "world";

    public static ArrayList<Player> playerhider = new ArrayList<>();
    public static ArrayList<Player> buildmode = new ArrayList<>();

    @Override
    public void onEnable() {
        configManager = new ConfigManager(this);

        mySQL= new MySQL("45.142.114.174", 3306, "rechte", "rechte", "@p2y.bq*[JM_TGJv");
        try {
            mySQL.connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    updatePlayerScoreboard(all);
                }
            }
        }.runTaskTimer(this, 0L, 20);


        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinItems(), this);
        pm.registerEvents(new Compass(configManager, this), this);
        pm.registerEvents(new PlayerHider(configManager), this);
        pm.registerEvents(new AdminTools(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new RainListener(), this);
        pm.registerEvents(new FoodListener(), this);
        pm.registerEvents(new PlaceBreak(), this);
        pm.registerEvents(new DropPickup(), this);
        pm.registerEvents(new InvClick(), this);
        pm.registerEvents(new DoubleJump(), this);
        pm.registerEvents(new ScoreboardJoin(mySQL), this);
        pm.registerEvents(new SpawnJoin(configManager), this);


        getCommand("fly").setExecutor(new Fly(configManager));
        getCommand("cc").setExecutor(new ClearChat());
        getCommand("clearchat").setExecutor(new ClearChat());
        getCommand("build").setExecutor(new Build(configManager));
        getCommand("spawn").setExecutor(new SpawnCommand(configManager));
        getCommand("gm").setExecutor(new Gamemodes());
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");


    }

    @Override
    public void onDisable() {
        try {
            mySQL.disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updatePlayerScoreboard(Player p) {
        String uuid = p.getUniqueId().toString();
        String rank = mySQL.getPlayerRank(uuid);

        PlayerScoreboard.setPlayerScoreboard(p, rank);
    }
}
