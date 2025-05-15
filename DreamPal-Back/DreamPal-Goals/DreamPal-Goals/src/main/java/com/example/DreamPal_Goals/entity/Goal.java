package com.example.DreamPal_Goals.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Goals")
public class Goal {
    @Id
    private String id;
    private String title;
    private String type;
    private String deadline;
    private boolean done;
    private String userId;

    public Goal(String id, String title, String type, String deadline, boolean done, String userId) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.deadline = deadline;
        this.done = done;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDeadline() {
        return deadline;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
