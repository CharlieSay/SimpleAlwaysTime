package uk.ocelotcr;

import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class AbstractTime extends BukkitRunnable {

    private final World world;

    public AbstractTime(World world) {
        this.world = world;
    }

    public void run(){
        world.setTime(getTimeNeeded());
    };

    public abstract Long getTimeNeeded();
}
