package bmps.com.arrays.easy;

import bmps.com.dsa.arrays.easy.RotateArray;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayTest {

    @Test
    void rotLeft() {

        var rotateArr = new RotateArray();

        var res = rotateArr.rotLeft(List.of(1, 2, 3, 4, 5), 2);
        assertArrayEquals(List.of(3, 4, 5, 1,2).toArray(), res.toArray());
    }

    @Test
    void rotLeftWithOneLoop() {

        var rotateArr = new RotateArray();

        var res = rotateArr.rotLeftOneLoop(List.of(1, 2, 3, 4, 5), 2);
        assertArrayEquals(List.of(3, 4, 5, 1,2).toArray(), res.toArray());
    }
}