package me.shradinx.promethiumbase;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.*;

public class FactionsCommand implements CommandExecutor {
    Yaml yaml = new Yaml();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        String factionHelp = ChatColor.YELLOW + "----- Usage: ----- \n" + ChatColor.GRAY + "/factions | /fac | /f \n" + ChatColor.GRAY + "create {name}: Create a faction with the name {name}";
        if (args.length == 0) {
            player.sendMessage(factionHelp);
            return true;
        } else if (args.length == 2 && args[0].equals("create")) {
            String name = args[1];
            player.sendMessage(name);
            return true;
        } else {
            player.sendMessage(factionHelp);
        }
        return true;
    }
}
