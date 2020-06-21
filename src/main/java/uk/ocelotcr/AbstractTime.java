package uk.ocelotcr;

import org.bukkit.World;

public abstract class AbstractTime implements Runnable {

    private final World world;

    public AbstractTime(World world) {
        this.world = world;
    }

    public void run(){
        world.setTime(getTimeNeeded());
    };

    public abstract Long getTimeNeeded();
}
