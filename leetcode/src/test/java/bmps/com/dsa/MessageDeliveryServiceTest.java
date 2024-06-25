package bmps.com.dsa;

import bmps.com.deliveroo.MessageDeliveryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MessageDeliveryServiceTest {

    @Test
    void getMessageStatus() {
        MessageDeliveryService ms = new MessageDeliveryService();
        var timestamps = List.of(1, 4, 5, 10, 11, 14);
        var messages = List.of("hello", "bye", "bye", "hello", "bye", "hello");

        var res = ms.getMessageStatus(timestamps, messages, 5);
        Assertions.assertArrayEquals(new String[]{"true", "true", "false", "true", "true", "false"}, res.toArray());
    }
}