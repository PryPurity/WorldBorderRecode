package com.github.prypurity.worldborder;

import com.github.prypurity.worldborder.cmds.wbBorder;
import com.github.prypurity.worldborder.cmds.wbVersion;
import de.leonhard.storage.LightningBuilder;
import de.leonhard.storage.Yaml;
import de.leonhard.storage.internal.settings.ConfigSettings;
import de.leonhard.storage.internal.settings.DataType;
import de.leonhard.storage.internal.settings.ReloadSettings;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    public static Yaml mainConfig;
    public static Yaml messages;
    public static Yaml permissions;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(" ////    World Border Re-Code    \\\\");
        Bukkit.getConsoleSender().sendMessage("////        Version - 3.0.0       \\\\");
        Bukkit.getConsoleSender().sendMessage("\\\\   &cDeveloped by: BrettFlan  ////");
        Bukkit.getConsoleSender().sendMessage(" \\\\   &cRe-code by: PryPurity  ////");
        Bukkit.getConsoleSender().sendMessage(" ");
        registerCmds();
        setupStorage();

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("World Border Re-Code has been successfully Disabled!");
    }

    public void registerCmds() {
        getCommand("wbBorder").setExecutor(new wbBorder());
        getCommand("wbversion").setExecutor(new wbVersion());
    }

    private void setupStorage() {
        messages = LightningBuilder.fromFile(new File("plugins/Main/messages"))
                .addInputStreamFromResource("messages.yml")
                .setConfigSettings(ConfigSettings.PRESERVE_COMMENTS)
                .setReloadSettings(ReloadSettings.AUTOMATICALLY)
                .setDataType(DataType.SORTED).createConfig();

        mainConfig = LightningBuilder.fromFile(new File("plugins/Main/config"))
                .addInputStreamFromResource("config.yml")
                .setConfigSettings(ConfigSettings.PRESERVE_COMMENTS)
                .setReloadSettings(ReloadSettings.AUTOMATICALLY)
                .setDataType(DataType.SORTED).createConfig();

        permissions = LightningBuilder.fromFile(new File("plugins/Main/messages"))
                .addInputStreamFromResource("permissions.yml")
                .setConfigSettings(ConfigSettings.PRESERVE_COMMENTS)
                .setReloadSettings(ReloadSettings.AUTOMATICALLY)
                .setDataType(DataType.SORTED).createConfig();
    }
}
