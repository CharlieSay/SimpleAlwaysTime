package uk.ocelotcr;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public final class AlwaysTime extends JavaPlugin {

    private TimeSchedulerManager timeSchedulerManager;

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("AlwaysTimeEnabled!");
        Bukkit.getPluginManager().addPermission(new Permission("alwaystime.change"));
        this.getCommand("alwaystime").setExecutor(this);
        timeSchedulerManager = new TimeSchedulerManager(Bukkit.getScheduler());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] arg) {
        Player player = (Player) sender;
        if (permissionChecker(player, commandLabel)) {
            if (!arg[0].isEmpty()) {
                return timeSchedulerManager.scheduleTask(this, player.getWorld(), arg[0]);
            } else {
                player.sendMessage("Incorrect usage.");
            }
        }
        return true;
    }

    private boolean permissionChecker(Player player, String commandLabel) {
        return commandLabel.equalsIgnoreCase("alwaystime") && player.hasPermission("alwaystime.change");
    }
}



