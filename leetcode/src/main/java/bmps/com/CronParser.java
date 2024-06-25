package bmps.com;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class CronParser {
    private String[] cronFields;

    public CronParser(String cronExpression) {
        cronFields = cronExpression.split("\\s+");
        if (cronFields.length != 5) {
            throw new IllegalArgumentException("Invalid Cron expression, it must have exactly 5 fields");
        }
    }

    public LocalDateTime getNextExecution(LocalDateTime dateTime) {
        LocalDateTime nextTime = dateTime.plusMinutes(1).truncatedTo(ChronoUnit.MINUTES);

        while (true) {
            if (matches(nextTime)) {
                return nextTime;
            }
            nextTime = nextTime.plusMinutes(1);
        }
    }

    private boolean matches(LocalDateTime dateTime) {
        return matchesField(cronFields[0], dateTime.getMinute()) &&
                matchesField(cronFields[1], dateTime.getHour()) &&
                matchesField(cronFields[2], dateTime.getDayOfMonth()) &&
                matchesField(cronFields[3], dateTime.getMonthValue()) &&
                matchesField(cronFields[4], dateTime.getDayOfWeek().getValue() % 7);
    }

    private boolean matchesField(String field, int value) {
        if (field.equals("*")) {
            return true;
        } else if (field.contains(",")) {
            String[] values = field.split(",");
            return Arrays.stream(values).anyMatch(v -> matchesField(v, value));
        } else if (field.contains("-")) {
            String[] range = field.split("-");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);
            return value >= start && value <= end;
        } else if (field.contains("/")) {
            String[] step = field.split("/");
            int base = field.startsWith("*") ? 0 : Integer.parseInt(step[0]);
            int interval = Integer.parseInt(step[1]);
            return (value - base) % interval == 0;
        } else {
            return Integer.parseInt(field) == value;
        }
    }

    public static void main(String[] args) {
        CronParser parser = new CronParser("*/15 * * * *");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextExecution = parser.getNextExecution(now);
        System.out.println("Next execution time: " + nextExecution);
    }
}
