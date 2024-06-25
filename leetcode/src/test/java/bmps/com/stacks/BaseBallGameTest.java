package bmps.com.stacks;

import bmps.com.dsa.stacks.BaseBallGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameTest {

    @Test
    void calPointsArray() {
         BaseBallGame game = new BaseBallGame();
         var res = game.calPointsArray(new String[]{"5","-2","4","C","D","9","+","+"});
         assertEquals(27, res);


    }
}