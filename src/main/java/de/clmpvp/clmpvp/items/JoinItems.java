package de.clmpvp.clmpvp.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinItems implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        ItemStack i1 = new ItemStack(Material.COMPASS);
        ItemMeta i1m = i1.getItemMeta();
        i1m.setDisplayName("§bNavigator");
        i1.setItemMeta(i1m);

        ItemStack i2 = new ItemStack(Material.BLAZE_ROD);
        ItemMeta i2m = i2.getItemMeta();
        i2m.setDisplayName("§aPlayer Hider");
        i2.setItemMeta(i2m);

        ItemStack i3 = new ItemStack(Material.LEGACY_REDSTONE_TORCH_ON);
        ItemMeta i3m = i3.getItemMeta();
        i3m.setDisplayName("§cServer tools");
        i3.setItemMeta(i3m);

        ItemStack i4 = new ItemStack(Material.CHEST);
        ItemMeta i4m = i4.getItemMeta();
        i4m.setDisplayName("§bExtras");
        i4.setItemMeta(i4m);
        p.getInventory().clear();

        if (p.hasPermission("lobby.admin") || p.hasPermission("lobby.*")) {
            p.getInventory().setItem(2, i1);
            p.getInventory().setItem(0, i2);
            p.getInventory().setItem(6, i3);
            p.getInventory().setItem(8, i4);
        } else {
            p.getInventory().setItem(4, i1);
            p.getInventory().setItem(0, i2);
            p.getInventory().setItem(8, i4);
        }
    }
}
