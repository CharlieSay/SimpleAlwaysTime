package uk.ocelotcr;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.Optional;

public class TimeSchedulerManager {

    public static Optional<BukkitTask> scheduledTimeId = Optional.empty();
    private final BukkitScheduler bukkitScheduler;

    public TimeSchedulerManager(BukkitScheduler bukkitScheduler) {
        this.bukkitScheduler = bukkitScheduler;
    }

    public boolean scheduleTask(JavaPlugin javaPlugin, World world, String selection) {
        if (scheduledTimeId.isPresent() && selection.equalsIgnoreCase("off")) {
            Bukkit.broadcastMessage(String.valueOf(bukkitScheduler.getPendingTasks().size()));
            boolean remove = bukkitScheduler.getPendingTasks().remove(scheduledTimeId.get());
            Bukkit.broadcastMessage("removing of task was " + remove);
            Bukkit.broadcastMessage(String.valueOf(bukkitScheduler.getPendingTasks().size()));
            scheduledTimeId = Optional.empty();
            return true;
        }
        if (selection.equalsIgnoreCase("day")) {
            if (!scheduledTimeId.isPresent()) {
                scheduledTimeId = Optional.of(Bukkit.getScheduler().runTaskTimer(javaPlugin, new AlwaysDay(world), 0, 1200));
                return true;
            }
        } else if (selection.equalsIgnoreCase("night")) {
            if (!scheduledTimeId.isPresent()) {
                scheduledTimeId = Optional.of(Bukkit.getScheduler().runTaskTimer(javaPlugin, new AlwaysNight(world), 0, 1200));
                return true;
            }
        }
        return false;
    }
}

