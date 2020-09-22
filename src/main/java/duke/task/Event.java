package duke.task;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {
    protected String time;
    protected DateFormat dateTime = new SimpleDateFormat("dd/MM/yyyy HHmm"); // in 24h format
    protected DateFormat outputFormat = new SimpleDateFormat("MMM dd yyyy hh.mm aa"); // in 12h format
    protected String day;

    public Event(String description, String time) {
        super(description);
        this.time = time.trim();
    }

    public String getTime() {
        return time;
    }

    public String getTaskDescription() {
        return description;
    }

    @Override
    public String toString() {
        try {
            return "[E]" + super.toString() + " (at: " + reformatDate() + ")";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String reformatDate() throws ParseException {
        Date date = dateTime.parse(time);
        return outputFormat.format(date);
    }

    @Override
    public String getDay() {
        String[] dayTime = time.split(" ",2 );
        day = dayTime[0].trim();
        return day;
    }
}
