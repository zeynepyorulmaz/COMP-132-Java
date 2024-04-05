package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import logsystem.LogAnalyser;
import logsystem.LogProcessor;
import logsystem.LogRecord;

public class Main {
	/* *********** Pledge of Honor ************************************************ *

	I hereby certify that I have completed this lab assignment on my own
	without any help from anyone else. I understand that the only sources of authorized
	information in this lab assignment are (1) the course textbook, (2) the
	materials posted at the course website and (3) any study notes handwritten by myself.
	I have not used, accessed or received any information from any other unauthorized
	source in taking this lab assignment. The effort in the assignment thus belongs
	completely to me.
	READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
	SIGNATURE: <Zeynep Yorulmaz, 83684>
	********************************************************************************/
	
    private static void writeToFile(String fileName, Collection<LogRecord> logRecords) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + fileName))) {
            writer.write("Failed Log Records sorted by message length:\n");
            for (LogRecord logRecord : logRecords) {
                String message = (logRecord.getMessage().substring(logRecord.getMessage().indexOf("- ") + 2));
                writer.write(message + "\n");
            }
            System.out.println("Output written to: src/" + fileName);
        }
    }
    public static void main(String[] args) {
        try {
            String filePath = "src/server_logs.txt";
            LogAnalyser logAnalyser = new LogAnalyser(filePath);
            LogProcessor logProcessor = new LogProcessor(filePath);

            // Testing LogAnalyser methods
            System.out.println("---- LogAnalyser Tests ----");
            System.out.println("\nEntry Counts:");
            logAnalyser.getEntryCounts();

            System.out.println("\nError Entries:");
            logAnalyser.getErrors();

            System.out.println("\nWarning Entries:");
            logAnalyser.getWarnings();

            System.out.println("\nInfo Entries:");
            logAnalyser.getInfos();

            System.out.println("\nEntries in Time Frame [2023-03-24 00:00:00, 2023-03-25 00:00:00]:");
            logAnalyser.getEntriesInTimeFrame("2023-03-24 00:00:00", "2023-03-25 00:00:00");

            System.out.println("\nEntries that Contain 'User 2415':");
            logAnalyser.getEntriesThatContain("User 2415");

            // Testing LogProcessor methods
            System.out.println("\n---- LogProcessor Tests ----");
            System.out.println("\nStatistics:");
            logProcessor.getStatistics();

            System.out.println("\nCropped Entries (maxLength 64):");
            logProcessor.getCroppedEntries(64);

            System.out.println("\nSorted By Date:");
            logProcessor.sortByDate();

        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                String filePath = "src/server_logs.txt";
                LogAnalyser logAnalyser = new LogAnalyser(filePath);


                Collection<LogRecord> failedLogRecords = logAnalyser.getFailedLogRecordsSortedByLength();

                System.out.println("-------------------------- In Lab --------------------------");
                writeToFile("Smithtxt.", failedLogRecords);

                
                
            } catch (IOException ex) {
                ex.printStackTrace();
        }
    }
}

   

