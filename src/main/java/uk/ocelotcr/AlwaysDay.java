package uk.ocelotcr;

import org.bukkit.World;

public class AlwaysDay extends AbstractTime {

    public AlwaysDay(World world) {
        super(world);
    }

    @Override
    public Long getTimeNeeded() {
        return 500L;
    }
}
