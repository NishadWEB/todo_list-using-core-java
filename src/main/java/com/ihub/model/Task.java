package com.ihub.model;

public class Task {

    private int id;
    private String title;
    private String description;
    private String status;
    private int priority;

    public Task() {}

    public Task(String title, String description, String status, int priority) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public Task(int id,String title,String description,String status,int priority){
        this.id=id;
        this.title=title;
        this.description=description;
        this.status=status;
        this.priority=priority;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public int getPriority() {
        return priority;
    }
}