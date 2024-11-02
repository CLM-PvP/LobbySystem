package de.clmpvp.clmpvp.commands;

import de.clmpvp.clmpvp.main.Main;
import de.clmpvp.clmpvp.util.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class Build implements CommandExecutor {

    private final ConfigManager configManager;

    public Build(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            String prefix = configManager.getPrefix();

            Player p = (Player) sender;

            if (args.length == 0) {
                Location loc = p.getLocation();
                if (!Main.buildmode.contains(p)) {
                    Main.buildmode.add(p);
                    p.sendMessage(prefix + "Du bist nun im §bBuildmode");
                    p.getInventory().clear();
                } else if (Main.buildmode.contains(p)){
                    Main.buildmode.remove(p);
                    p.sendMessage(prefix + "Du bist nun §bnicht mehr im Buildmode");
                    p.getInventory().clear();

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
            } else if (args.length == 1) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (!Main.buildmode.contains(target)) {
                        Main.buildmode.add(target);
                        p.sendMessage(prefix + "Der Spieler §b" + args[0] + " §7befindet sich jetzt im §bBuildmode");
                        target.sendMessage(prefix + "Du wurdest in den §bBuildmode §7gesetzt");
                    } else if (Main.buildmode.contains(target)) {
                        Main.buildmode.remove(target);
                        p.sendMessage(prefix + "Der Spieler §b" + args[0] + " §7befindet sich jetzt §bnicht mehr im Buildmode");
                        target.sendMessage(prefix + "Du wurdest aus dem §bBuildmode entfernt");
                        p.getInventory().clear();
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
            } else {
                p.sendMessage(prefix + "bitte nutze /build <spieler>");
            }

        } else {
            sender.sendMessage(configManager.getNoPerm());
        }


        return false;
    }
}
