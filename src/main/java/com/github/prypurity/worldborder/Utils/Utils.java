package com.github.prypurity.worldborder.Utils;

import com.github.prypurity.worldborder.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils {

    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void chat(Player player, String string) {
        player.sendMessage(chat(string));
    }

    public static void chat(CommandSender sender, String string) {
        sender.sendMessage(chat(string));
    }

    public static void help(Player player) {
        player.sendMessage(Main.messages.getString("HelpText"));
    }

}
