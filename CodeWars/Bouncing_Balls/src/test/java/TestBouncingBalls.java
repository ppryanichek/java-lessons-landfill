package test.java;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.java.BouncingBalls;

public class TestBouncingBalls {
    @Test
    public void testBounceBall() {
        assertEquals(15, BouncingBalls.bouncingBall(30, 0.66, 1.5));
    }
}
