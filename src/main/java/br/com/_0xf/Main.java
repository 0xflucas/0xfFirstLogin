package br.com._0xf;

import br.com._0xf.handlers.LoginHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        LoginHandler loginHandler = new LoginHandler(this);
        Bukkit.getPluginManager().registerEvents(loginHandler, this);

        msgs();
    }

    void msgs() {
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7==============================================================");
        Bukkit.getConsoleSender().sendMessage("§d=>[0xfFirstLogin] §f" + this.getDescription().getName() + " " + this.getDescription().getVersion() + " plugin habilitado com sucesso!!!");
        Bukkit.getConsoleSender().sendMessage("§7==============================================================");
        Bukkit.getConsoleSender().sendMessage("");
    }
}