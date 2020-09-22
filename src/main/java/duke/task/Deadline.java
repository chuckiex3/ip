package duke.task;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Represents tasks that need to be done before a specific date/time.
 */
public class Deadline extends Task {
    protected String by;
    protected DateFormat dateTime = new SimpleDateFormat("dd/MM/yyyy HHmm"); // in 24h format
    protected DateFormat outputFormat = new SimpleDateFormat("MMM dd yyyy hh.mm aa"); // in 12h format
    protected String day;

    public Deadline(String description, String by) {
        super(description);
        this.by = by.trim();
    }

    public String getDueDate() {
        return by;
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

    @Override
    public String getDay() {
        String[] dayTime = by.split(" ",2 );
        day = dayTime[0].trim();
        return day;
    }
}
