package de.clmpvp.clmpvp.listener;

import de.clmpvp.clmpvp.main.Main;
import org.bukkit.command.PluginCommandYamlParser;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodListener implements Listener {

    @EventHandler
    public void onFood(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player && e.getEntity().getWorld().getName().equals(Main.world)) {
            e.setCancelled(true);
            e.getEntity().setFoodLevel(20);
        }
    }

}
