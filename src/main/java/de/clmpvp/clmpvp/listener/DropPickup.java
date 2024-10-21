package de.clmpvp.clmpvp.listener;

import de.clmpvp.clmpvp.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class DropPickup implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (Main.buildmode.contains(p)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (Main.buildmode.contains(p)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

}
