package com.github.prypurity.worldborder.cmds;

import com.github.prypurity.worldborder.Main;
import com.github.prypurity.worldborder.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class wborder implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String check = label.toLowerCase();
            if (player.hasPermission(Main.permissions.getString("Wborder")) || player.isOp()) {
                if (args.length == 0) {
                    Utils.chat(player, " ");
                    Utils.chat(player, "&e&lWorld Border Re-Code");
                    Utils.chat(player, "&cDeveloped by: BrettFlan");
                    Utils.chat(player, "&cRe-coded & Maintained: PryPurity & Andrewandy");
                    Utils.chat(player, " ");
                    Utils.chat(player, "For help, please use the '/wborder help' command.");
                } else if (check.equals("help") || check.equals("?")) {
                    Utils.chat(player, "/wborder set <radius> <Square/Circle>");
                }
            } else {
                Utils.chat(player, Main.messages.getString("NoPerms"));
            }
        } else {
            Utils.chat(sender, Main.messages.getString("SenderNotPlayer"));
        }
        return false;
    }
}
