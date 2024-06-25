package bmps.com.linkedlist;

import bmps.com.dsa.linkedlist.ListNode;
import bmps.com.dsa.linkedlist.ReverseAlternateLinkedList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ReverseAlternateLinkedListTest {

    @ParameterizedTest(name = "{index} => input={0}, output={1}, intervals={2} ({3})")
    @CsvSource({
            "'1,2,3,4,5,6,7,8', '4,3,2,1,5,6,7,8', 4, 'Case 1: Reverse first 4 elements'",
            "'1,2,3,4,5,6,7,8', '2,1,3,4,6,5,7,8', 2, 'Case 1: Reverse every 2 elements'"
    })
    void reverse4_first(String input, String output, int n, String testCase) {
        ListNode<Integer> inputArr = parseString(input);
        ListNode<Integer> outputArr = parseString(output);

        var reverseIt = new ReverseAlternateLinkedList();
        var resNode = reverseIt.reverse(inputArr, n);

        while (resNode != null) {
            assertEquals(outputArr.val, resNode.val, testCase);
            resNode = resNode.next;
            outputArr = outputArr.next;
        }
    }

    private ListNode<Integer> parseString(String input) {
        ListNode<Integer> prev = null;
        ListNode<Integer> start = null;

        // 1 -> 2 3,4,5,6,7,8
        for (String node : input.split(",")) {
            var curNode = new ListNode<>(Integer.valueOf(node));
            if (prev == null) {
                start = curNode;
                prev = curNode;
            } else {
                curNode.prev = prev;
                curNode.prev.next = curNode;
                prev = curNode;
            }
        }

        return start;
    }
}