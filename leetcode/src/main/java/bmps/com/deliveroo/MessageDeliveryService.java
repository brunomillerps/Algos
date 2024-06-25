package bmps.com.deliveroo;

import java.util.*;

public class MessageDeliveryService {

    public List<String> getMessageStatus(List<Integer> timestamps, List<String> messages, int k) {

        Map<String, Integer> lastDelivered = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < messages.size(); i++) {
            var ts = timestamps.get(i);
            var message = messages.get(i);

            if (lastDelivered.containsKey(message) && ts - lastDelivered.get(message) < k) {
                result.add("false");
            } else {
                result.add("true");
                lastDelivered.put(message, ts);
            }
        }

        return result;

    }
}
