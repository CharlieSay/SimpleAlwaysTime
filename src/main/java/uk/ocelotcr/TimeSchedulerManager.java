package uk.ocelotcr;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Optional;

public class TimeSchedulerManager {

    public static Optional<Integer> scheduledTimeId;
    private final BukkitScheduler bukkitScheduler;

    public TimeSchedulerManager(BukkitScheduler bukkitScheduler) {
        this.bukkitScheduler = bukkitScheduler;
    }

    public boolean scheduleTask(JavaPlugin javaPlugin, World world, String selection) {
        if (scheduledTimeId.isPresent() && selection.equalsIgnoreCase("off")) {
            bukkitScheduler.getPendingTasks().get(scheduledTimeId.get()).cancel();
            scheduledTimeId = Optional.empty();
            return true;
        }
        if (selection.equalsIgnoreCase("day")) {
            scheduledTimeId = Optional.of(bukkitScheduler.scheduleSyncRepeatingTask(javaPlugin, new AlwaysDay(world), 0, 1200));
            return true;
        } else if (selection.equalsIgnoreCase("night")) {
            scheduledTimeId = Optional.of(bukkitScheduler.scheduleSyncRepeatingTask(javaPlugin, new AlwaysNight(world), 0, 1200));
            return true;
        }
        return false;
    }
}

