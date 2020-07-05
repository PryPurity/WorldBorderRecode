package com.github.prypurity.worldborder.cmds;

import com.github.prypurity.worldborder.Main;
import com.github.prypurity.worldborder.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class wbVersion implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Main.permissions.getString("WBVersion"))) {
                Utils.chat(player, Main.messages.getString("PluginVersion").replace("%version%", getClass().getPackage().getImplementationVersion()));
            } else {
                Utils.chat(player, Main.messages.getString("NoPerms"));
            }
        } else {
            Utils.chat(sender, Main.messages.getString("PluginVersion").replace("%version%", getClass().getPackage().getImplementationVersion()));
        }
        return false;
    }
}
