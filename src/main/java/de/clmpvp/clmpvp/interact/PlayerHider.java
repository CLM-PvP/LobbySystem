package de.clmpvp.clmpvp.interact;

import de.clmpvp.clmpvp.main.Main;
import de.clmpvp.clmpvp.util.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerHider implements Listener {

    private final ConfigManager configManager;

    public PlayerHider(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        String prefix = configManager.getPrefix();
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem().getType() == Material.BLAZE_ROD) {
                if (Main.playerhider.contains(p)) {
                    Main.playerhider.remove(p);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        p.showPlayer(all);
                        p.sendMessage(prefix + "Du siehst nun alle Spieler");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 5));
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                    }
                } else {
                    Main.playerhider.add(p);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        p.hidePlayer(all);
                        p.sendMessage(prefix + "Du siehst nun keine Spieler mehr");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 5));
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                    }
                }
            }
        }
    }

}
