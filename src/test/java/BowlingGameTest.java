package test.java;

import main.java.BowlingGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    @Test
    public void gutterGame() {
    BowlingGame game = new BowlingGame();
    for(int i=0; i<20; i++){
        game.roll(0);
    }
    assertEquals(0, game.getScore());
}

    @Test
    public void onePin(){
    BowlingGame game = new BowlingGame();
    game.roll(1);
    for(int i=0; i<19; i++){
        game.roll(0);
    }
    assertEquals(1, game.getScore());
}

    @Test
    public void accurateBowlingUnder(){
    BowlingGame game = new BowlingGame();

    assertThrows(IllegalArgumentException.class, () -> game.roll(-1));
}

    @Test
    public void accurateBowlingOver(){
        BowlingGame game = new BowlingGame();

        assertThrows(IllegalArgumentException.class, () -> game.roll(11));
    }

    @Test
    public void spare(){
        BowlingGame game = new BowlingGame();

        game.roll(7);
        game.roll(3);
        game.roll(1);

        assertEquals(12, game.getScore());
    }

    @Test
    public void strike(){
        BowlingGame game = new BowlingGame();

        game.roll(10);
        game.roll(1);
        game.roll(1);

        assertEquals(14, game.getScore());
    }

    @Test
    public void accurateBowlingTwo(){
        BowlingGame game = new BowlingGame();

        game.roll(4);
        assertThrows(IllegalArgumentException.class, () -> game.roll(7));
    }

    @Test
    public void perfectGame(){
        BowlingGame game = new BowlingGame();

        for(int i=0; i<12; i++){
            game.roll(10);
        }
        assertEquals(300, game.getScore());
    }

    @Test
    public void accurateBowlingThree(){
        BowlingGame game = new BowlingGame();

        for(int i=0; i<18; i++){
            game.roll(0);
        }
        game.roll(10);

        assertDoesNotThrow(() -> game.roll(3));
    }

    @Test
    public void realGame(){
        BowlingGame game = new BowlingGame();

        game.roll(10);
        game.roll(9);
        game.roll(1);
        game.roll(7);
        game.roll(0);
        game.roll(9);
        game.roll(1);
        game.roll(10);
        game.roll(10);
        game.roll(8);
        game.roll(2);
        game.roll(10);
        game.roll(9);
        game.roll(1);
        game.roll(9);
        game.roll(1);
        game.roll(7);

        assertEquals(188, game.getScore());
    }

    @Test
    public void accurateBowlingFour(){
        BowlingGame game = new BowlingGame();

        game.roll(10);
        game.roll(9);
        game.roll(1);
        game.roll(7);
        game.roll(0);
        game.roll(9);
        game.roll(1);
        game.roll(10);
        game.roll(10);
        game.roll(8);
        game.roll(2);
        game.roll(10);
        game.roll(9);
        game.roll(1);
        game.roll(9);
        game.roll(1);
        game.roll(7);

        assertThrows(IllegalArgumentException.class, () -> game.roll(3));
    }
}