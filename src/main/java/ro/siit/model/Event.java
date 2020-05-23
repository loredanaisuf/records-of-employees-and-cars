package ro.siit.model;

import java.util.Date;

public class Event {
    private String id;
    private String title;
    private String date;

    public Event(String id, String title, String date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public String getId(){return id;}

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}' + '\n';
    }
}
