package de.clmpvp.clmpvp.listener;

import de.clmpvp.clmpvp.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceBreak implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (Main.buildmode.contains(p)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (Main.buildmode.contains(p)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

}
