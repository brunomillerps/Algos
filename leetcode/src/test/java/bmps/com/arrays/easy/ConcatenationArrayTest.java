package bmps.com.arrays.easy;

import bmps.com.dsa.arrays.easy.ConcatenationArray;
import org.junit.jupiter.api.Test;

class ConcatenationArrayTest {

    @Test
    void getConcatenation() {

        var concat = new ConcatenationArray();

        concat.getConcatenation(new int[]{1, 2, 1});
    }
}