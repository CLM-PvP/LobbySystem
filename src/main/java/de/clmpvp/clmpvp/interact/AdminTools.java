package de.clmpvp.clmpvp.interact;

import de.clmpvp.clmpvp.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminTools implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = e.getItem();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
            return;
        }
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cServer tools")) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING, "§cServer tools");

                ItemStack i1 = new ItemStack(Material.PAPER);
                ItemMeta i1m = i1.getItemMeta();
                i1m.setDisplayName("§bChatClear");
                i1.setItemMeta(i1m);

                ItemStack i2 = new ItemStack(Material.BARRIER);
                ItemMeta i2m = i2.getItemMeta();
                i2m.setDisplayName("§c§lReload");
                i2.setItemMeta(i2m);

                ItemStack i3 = new ItemStack(Material.FEATHER);
                ItemMeta i3m = i3.getItemMeta();
                i3m.setDisplayName("§7Fly");
                i3.setItemMeta(i3m);



                inv.setItem(1, i1);
                inv.setItem(2, i2);
                inv.setItem(3, i3);
                p.openInventory(inv);

            }
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getView().getTitle().equalsIgnoreCase("§cServer tools")) {
                e.setCancelled(true);
                try {
                    if (e.getCurrentItem().getType() == Material.PAPER) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bChatClear")) {
                            p.performCommand("cc");
                        }
                    }
                } catch (Exception ex) {
                    p.sendMessage("Fehler 1");
                    throw new RuntimeException(ex);
                }
            }
        } catch (RuntimeException ex) {
            p.sendMessage("Fehler 2");
            throw new RuntimeException(ex);
        }
    }
    @EventHandler
    public void onClick1(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getView().getTitle().equalsIgnoreCase("§cServer tools")) {
                e.setCancelled(true);
                try {
                    if (e.getCurrentItem().getType() == Material.BARRIER) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lReload")) {
                            p.performCommand("reload");
                            p.performCommand("reload confirm");
                        }
                    }
                } catch (Exception ex) {
                    p.sendMessage("Fehler 3");
                    throw new RuntimeException(ex);
                }
            }
        } catch (RuntimeException ex) {
            p.sendMessage("Fehler 4");
            throw new RuntimeException(ex);
        }
    }
    @EventHandler
    public void onClick2(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getView().getTitle().equalsIgnoreCase("§cServer tools")) {
                e.setCancelled(true);
                try {
                    if (e.getCurrentItem().getType() == Material.FEATHER) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Fly")) {
                            p.performCommand("fly");
                        }
                    }
                } catch (Exception ex) {
                    p.sendMessage("Fehler 3");
                    throw new RuntimeException(ex);
                }
            }
        } catch (RuntimeException ex) {
            p.sendMessage("Fehler 4");
            throw new RuntimeException(ex);
        }
    }

}
