package com.github.prypurity.worldborder.cmds;

import com.github.prypurity.worldborder.Main;
import com.github.prypurity.worldborder.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class wbBorder implements CommandExecutor {
    public Map<String, wbBorder> subCommands = new LinkedHashMap<String, wbBorder>();
    private Set<String> subCMDWorldname = new LinkedHashSet<String>();
    public String name = "";
    public boolean hasWorldNameInput = false;

    private void cmd(wbBorder cmd) {
        subCommands.put(cmd.name, cmd);
        if (cmd.hasWorldNameInput)
            subCMDWorldname.add(cmd.name);
    }

    public void cmdList() {
        cmd(new wbFill());
        cmd(new wbHelp());
    }

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
                    Utils.chat(player, "For help, please use the '/wbBorder help' command.");
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
