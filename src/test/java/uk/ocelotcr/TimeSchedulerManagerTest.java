package uk.ocelotcr;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TimeSchedulerManagerTest {

    BukkitScheduler bukkitScheduler = mock(BukkitScheduler.class);
    JavaPlugin javaPlugin = mock(JavaPlugin.class);
    World world = mock(World.class);
    TimeSchedulerManager timeSchedulerManager;

    @Test
    public void shouldCancelTask_WhenCommandIsProvided(){
        timeSchedulerManager = new TimeSchedulerManager(bukkitScheduler);
        when(bukkitScheduler.runTaskTimer(getJavaPlugin(), any(BukkitRunnable.class), any(),any())).thenReturn(getDayBukkitTask());

        boolean day = timeSchedulerManager.scheduleTask(javaPlugin, world, "day");

        assertTrue(day);
    }

    private BukkitTask getDayBukkitTask(){
        BukkitTask bukkitTask = mock(BukkitTask.class);
        when(bukkitTask.getOwner()).thenReturn(javaPlugin);
        when(bukkitTask.getTaskId()).thenReturn(1);
        when(bukkitTask.isCancelled()).thenReturn(false);
        return bukkitTask;
    }

    private JavaPlugin getJavaPlugin(){
        JavaPlugin javaPlugin = mock(JavaPlugin.class);
        when(javaPlugin.toString()).thenReturn("Hello");
        when(javaPlugin.getName()).thenReturn("AlwaysTime");
        when(javaPlugin.hashCode()).thenReturn(10);
        when(javaPlugin.isEnabled()).thenReturn(true);
        return javaPlugin;
    }

    private AlwaysDay getAlwaysDay(){
        return new AlwaysDay(world);
    }

}