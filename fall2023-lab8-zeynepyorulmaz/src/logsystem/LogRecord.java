package logsystem;

public class LogRecord implements Comparable<LogRecord> {
    private String message;

    public LogRecord(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int compareTo(LogRecord other) {
        return Integer.compare(this.message.length(), other.message.length());
    }
}
