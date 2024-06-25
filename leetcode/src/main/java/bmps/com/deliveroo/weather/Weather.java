package bmps.com.deliveroo.weather;

import java.util.List;

public record Weather (String name, String weather, List<String> status) {
}
