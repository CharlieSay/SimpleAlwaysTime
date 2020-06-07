package uk.ocelotcr;

import org.bukkit.World;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class AbstractTimeTest {

    AbstractTime abstractTime;

    World world = mock(World.class);

    @Test
    public void shouldSetDayTimeToZeroLong(){
        abstractTime = new AlwaysDay(world);
        Long expectedTime = 500l;

        Long timeNeeded = abstractTime.getTimeNeeded();

        assertEquals(expectedTime, timeNeeded);
    }

    @Test
    public void shouldSetNightTimeTo18000Long(){
        abstractTime = new AlwaysNight(world);
        Long expectedTime = 18000L;

        Long timeNeeded = abstractTime.getTimeNeeded();

        assertEquals(expectedTime, timeNeeded);
    }
}
