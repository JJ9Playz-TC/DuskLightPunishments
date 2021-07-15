package me.jaydusk.dusklightpunishments;

import me.jaydusk.dusklightpunishments.GUI.GUI;
import me.jaydusk.dusklightpunishments.GUI.GUIListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class DusklightPunishments extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("dlpun")){
            if(sender.hasPermission("dlpun.gui")){
                new GUI((Player) sender, 1);
            }
        }

        return false;
    }
}
