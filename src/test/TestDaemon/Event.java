package test.TestDaemon;

import java.util.Date;

/**
 * Created by DBQ on 2016/12/22.
 */
public class Event
{
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    private java.util.Date date;
    private String event;

    public Event() {
    }
}