package bmps.com.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    @Test
    public void test1() {
        MergeIntervals mi = new MergeIntervals();

        var intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        var expected = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        var res = mi.merge(intervals);

        assertArrayEquals(expected, res);
    }

    @Test
    public void test2() {

        MergeIntervals mi = new MergeIntervals();

        var intervals = new int[][]{{1,4}, {4,5}};
        var expected = new int[][]{{1, 5}};
        var res = mi.merge(intervals);

        assertArrayEquals(expected, res);
    }

    @Test
    public void test3() {

        MergeIntervals mi = new MergeIntervals();

        var intervals = new int[][]{{1,4}, {0,2}, {3,5}};
        var expected = new int[][]{{0, 5}};
        var res = mi.merge(intervals);

        assertArrayEquals(expected, res);
    }
}