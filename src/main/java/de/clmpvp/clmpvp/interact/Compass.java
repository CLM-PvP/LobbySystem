package de.clmpvp.clmpvp.interact;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.clmpvp.clmpvp.main.Main;
import de.clmpvp.clmpvp.util.ConfigManager;
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
import org.bukkit.plugin.Plugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Compass implements Listener {

    private final ConfigManager configManager;
    private final Main plugin;

    public Compass(ConfigManager configManager, Main plugin) {
        this.configManager = configManager;
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = e.getItem();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
            return;
        }
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bNavigator")) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                    Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST, "§bNavigator");

                    ItemStack i1 = new ItemStack(Material.GRASS_BLOCK);
                    ItemMeta i1m = i1.getItemMeta();
                    if (i1m != null) {
                        i1m.setDisplayName("§7CityBuild");
                        i1.setItemMeta(i1m);
                    }


                    inv.setItem(13, i1);
                    p.openInventory(inv);

                }
            }
    }
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        String prefix = configManager.getPrefix();
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getView().getTitle().equalsIgnoreCase("§bNavigator")) {
                e.setCancelled(true);
                try {
                    if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.GRASS_BLOCK) {
                        if (e.getCurrentItem().getItemMeta() != null &&
                                e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7CityBuild")) {

                            p.sendMessage(prefix + "Du wirst zum CityBuild gesendet");
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);

                            // Sende Spieler zu "CityBuild"-Server
                            sendPlayerToServer(p, "CityBuild");
                        }
                    }
                } catch (Exception ex) {
                    p.sendMessage("Fehler 2");
                    throw new RuntimeException(ex);
                }
            }
        } catch (RuntimeException ex) {
            p.sendMessage("Fehler 3");
            throw new RuntimeException(ex);
        }
    }
    private void sendPlayerToServer(Player p, String serverName) {
        try {
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(byteArray);
            out.writeUTF("Connect");
            out.writeUTF(serverName);
            p.sendPluginMessage(plugin, "BungeeCord", byteArray.toByteArray());
        } catch (IOException e) {
            p.sendMessage("Fehler beim Verbinden zum Server.");
            throw new RuntimeException(e);
        }
    }

}
