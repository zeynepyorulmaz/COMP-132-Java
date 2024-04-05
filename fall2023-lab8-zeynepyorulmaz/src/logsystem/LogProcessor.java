package logsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LogProcessor {
    private String logFilePath;

    public LogProcessor(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void getStatistics() throws IOException {
        List<String> logEntries = readLogEntries();

        double averageLength = logEntries.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);

        Optional<String> longestEntry = logEntries.stream()
                .max(Comparator.comparingInt(String::length));

        Optional<String> shortestEntry = logEntries.stream()
                .min(Comparator.comparingInt(String::length));

        System.out.println("Average length: " + averageLength);
        System.out.println("Longest entry (" + longestEntry.map(String::length).orElse(0) + " chars): " + longestEntry.orElse(""));
        System.out.println("Shortest entry (" + shortestEntry.map(String::length).orElse(0) + " chars): " + shortestEntry.orElse(""));
    }

    public void getCroppedEntries(int maxLength) throws IOException {
        List<String> logEntries = readLogEntries();

        String firstEntry = logEntries.stream().findFirst().orElse("");
        String lastEntry = logEntries.stream().reduce((first, second) -> second).orElse("");

        String croppedFirstEntry = firstEntry.length() > maxLength ? firstEntry.substring(0, maxLength) + "..." : firstEntry;
        String croppedLastEntry = lastEntry.length() > maxLength ? lastEntry.substring(0, maxLength) + "..." : lastEntry;

        System.out.println("First entry: " + croppedFirstEntry);
        System.out.println("Last entry: " + croppedLastEntry);
    }

    public void sortByDate() throws IOException {
        List<String> logEntries = readLogEntries();

        List<String> sortedEntries = logEntries.stream()
                .sorted(Comparator.comparing(this::extractTimestamp))
                .collect(Collectors.toList());

        System.out.println("First entry: " + sortedEntries.get(0));
        System.out.println("Last entry: " + sortedEntries.get(sortedEntries.size() - 1));
    }

    private String extractTimestamp(String entry) {
        return entry.substring(0, 23);
    }

    private List<String> readLogEntries() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            return reader.lines().collect(Collectors.toList());
        }
    }
}
