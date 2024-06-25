package bmps.com.arrays.easy;

import bmps.com.dsa.arrays.easy.RemoveElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

    @Test
    void removeElement() {
        var nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        var removeElement = new RemoveElement();

        var res = removeElement.removeElement(nums, 2);
        assertEquals(5, res);

    }
}