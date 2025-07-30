package br.com._0xf.handlers;

import br.com._0xf.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class LoginHandler implements Listener {

    private final FileConfiguration config;
    public LoginHandler(Main main) {
        this.config = main.getConfig();
        this.config.options().copyDefaults(true);
    }

    @EventHandler(priority = EventPriority.LOW)
    void onPlayerLogin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
//        p.sendMessage("admin: " + p.isOp());

        if (!p.hasPlayedBefore()) {
            List<String> commands = config.getStringList("commands");
            for (String command : commands) {
                if (command != null) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("{player}", p.getName()));
                }
            }

            for(String message : config.getStringList("messages")) {
                if (message != null) {
                    p.sendMessage(message.replace("{player}", p.getName()));
                }
            }
        }
    }
}
