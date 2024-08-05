import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class NoteBook {
    private StringBuilder notes = new StringBuilder();
    private String fileName = "Log_";

    public void Save() {
        LocalDateTime timeWithDate = LocalDateTime.now();

        String baseTime = timeWithDate.toString();
        String temp = baseTime.replace(':', '_');
        String timeLabel = temp.replace('.', '_');
        try {
            File file = new File(fileName + timeLabel);
            PrintWriter outputFile = new PrintWriter(file);
            outputFile.println(notes);
            outputFile.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void LogStatus(String comment, ArrayList<WashingMachine> washers) {
        notes.append("LogStatus      (" + comment + ")\n");
        for (WashingMachine w : washers) {
            String statusMessage = w.ReportStatus();
            notes.append(statusMessage + "\n");
        }
    }

}