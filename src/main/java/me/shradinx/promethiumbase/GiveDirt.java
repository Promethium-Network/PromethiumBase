package me.shradinx.promethiumbase;

import java.util.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.command.Command;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveDirt implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Please provide an amount.");
        } else if (args.length == 1) {
            try {
                if (sender != null && Integer.parseInt(args[0]) >= 1 && Integer.parseInt(args[0]) <= 64) {
                    ItemStack dirt = new ItemStack(Material.DIRT);
                    ItemMeta meta = dirt.getItemMeta();
                    assert meta != null;
                    meta.setDisplayName(ChatColor.AQUA + "balls");
                    List<String> balls = Arrays.asList(ChatColor.BLUE + "This is my special dirt :)", " ");
                    meta.setLore(balls);
                    dirt.setItemMeta(meta);
                    dirt.setAmount(Integer.parseInt(args[0]));
                    player.getInventory().addItem(dirt);
                    player.sendMessage(ChatColor.GREEN + "here's some dirt :)");
                } else {
                    assert player != null;
                    player.sendMessage(ChatColor.RED + "Amount must be between 1 and 64.");
                }
                return true;
            } catch (final NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "Amount must be a number.");
                return true;
            } catch (Exception e) {
                player.sendMessage(ChatColor.RED + "Amount must be a number between 1 and 64.");
                return true;
            }
        } else {
            player.sendMessage(ChatColor.RED + "Only one number may be provided.");
        }
        return true;
    }
}
