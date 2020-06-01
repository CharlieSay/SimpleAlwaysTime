package uk.ocelotcr;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class AlwaysNight extends AbstractTime {

    public AlwaysNight(World world) {
        super(world);
    }

    @Override
    public Long getTimeNeeded() {
        return 18000L;
    }
}
