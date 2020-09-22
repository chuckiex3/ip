package duke.task;

import duke.exceptions.TimeFormatException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    protected String by;
    protected DateFormat dateTime = new SimpleDateFormat("dd/MM/yyyy HHmm"); // in 24h format
    protected DateFormat outputFormat = new SimpleDateFormat("MMM dd yyyy hhmm aa"); // in 12h format

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getDueDate() {
        return by;
    }

    public String getTaskDescription() {
        return description;
    }

    @Override
    public String toString() {
        try {
            return "[D]" + super.toString() + " (by: " + reformatDate() + ")";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String reformatDate() throws ParseException {
        Date date = dateTime.parse(by);
        return outputFormat.format(date);
    }
}
