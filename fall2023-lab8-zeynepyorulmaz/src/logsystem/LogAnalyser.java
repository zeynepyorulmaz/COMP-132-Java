package logsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogAnalyser {
    private String logFilePath;

    public LogAnalyser(String logFilePath) {
        this.logFilePath = logFilePath;
    }
    

    public void getEntryCounts() throws IOException {
        List<String> logEntries = readLogEntries();


        List<String> errorEntries = filterEntries(logEntries, "ERROR");
        displayCategory("Error", errorEntries);

        List<String> infoEntries = filterEntries(logEntries, "INFO");
        displayCategory("Info", infoEntries);

        List<String> warnEntries = filterEntries(logEntries, "WARN");
        displayCategory("Warning", warnEntries);
    }

    public void getErrors() throws IOException {
        List<String> logEntries = readLogEntries();
        List<String> errorEntries = filterEntries(logEntries, "ERROR");

        displayEntries("Error Entries", errorEntries);
    }

    public void getWarnings() throws IOException {
        List<String> logEntries = readLogEntries();
        List<String> warnEntries = filterEntries(logEntries, "WARN");

        displayEntries("Warning Entries", warnEntries);
    }

    public void getInfos() throws IOException {
        List<String> logEntries = readLogEntries();
        List<String> infoEntries = filterEntries(logEntries, "INFO");

        displayEntries("Info Entries", infoEntries);
    }

    public void getEntriesInTimeFrame(String startTime, String endTime) throws IOException {
        List<String> logEntries = readLogEntries();
        Pattern pattern = Pattern.compile("\\[(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})]");

        List<String> filteredEntries = logEntries.stream()
                .filter(entry -> {
                    Matcher matcher = pattern.matcher(entry);
                    if (matcher.find()) {
                        String timestampStr = matcher.group(1);
                        return isWithinTimeFrame(timestampStr, startTime, endTime);
                    }
                    return false;
                })
                .collect(Collectors.toList());

        displayEntries("Entries in Time Frame [" + startTime + ", " + endTime + "]", filteredEntries);
    }

    private boolean isWithinTimeFrame(String timestamp, String startTime, String endTime) {
        return timestamp.compareTo(startTime) >= 0 && timestamp.compareTo(endTime) <= 0;
    }


    public void getEntriesThatContain(String phrase) throws IOException {
        List<String> logEntries = readLogEntries();
        List<String> filteredEntries = logEntries.stream()
                .filter(entry -> entry.contains(phrase))
                .collect(Collectors.toList());

        displayEntries("Entries that Contain '" + phrase + "'", filteredEntries);
    }

    private List<String> readLogEntries() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            return reader.lines().collect(Collectors.toList());
        }
    }
    public Collection<LogRecord> getFailedLogRecordsSortedByLength() throws IOException {
        List<LogRecord> logRecords = readLogRecords();

        return logRecords.stream()
                .filter(logRecord -> logRecord.getMessage().contains("Failed"))
                .sorted()
                .collect(Collectors.toList());
    }

    private List<LogRecord> readLogRecords() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            return reader.lines()
                    .map(LogRecord::new)
                    .collect(Collectors.toList());
        }
    }

    private void displayCategory(String category, List<String> entries) {

        System.out.println("Total: " + entries.size());

        if (!entries.isEmpty()) {
            System.out.println(entries.get(0));
            System.out.println(entries.get(entries.size() - 1));
        } else {
            System.out.println("There is no such an entry");
        }
        System.out.println();
    }

    private void displayEntries(String title, List<String> entries) {

        System.out.println("Total: " + entries.size());

        if (!entries.isEmpty()) {
            entries.stream()
            .limit(2).forEach(System.out::println);
        } else {
            System.out.println("There is no such an entry");
        }
        System.out.println();
    }

    private List<String> filterEntries(List<String> logEntries, String category) {
        return logEntries.stream().filter(entry -> entry.contains("[" + category + "]")).collect(Collectors.toList());
    }
}
