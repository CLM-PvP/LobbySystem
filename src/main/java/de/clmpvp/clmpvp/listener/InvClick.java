package de.clmpvp.clmpvp.listener;

import de.clmpvp.clmpvp.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (Main.buildmode.contains(p)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

}
