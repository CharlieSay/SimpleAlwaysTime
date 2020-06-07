package uk.ocelotcr;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlwaysTimeTest {

    AlwaysTime alwaysTime;

    @BeforeEach
    public void setUp(){
        alwaysTime = new AlwaysTime();
    }

    @Test
    public void shouldScheduleTask_WhenPlayerHasPermissionsAndRightCommand_ThenPerformCommand(){
        Player player = mock(Player.class);
        World world = mock(World.class);
        when(player.getWorld()).thenReturn(world);
        when(player.hasPermission("alwaystime.change")).thenReturn(true);
//        alwaysTime.onCommand();
    }

}