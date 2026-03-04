package com.ihub.service;

import com.ihub.repository.TaskRepository;
import com.ihub.model.Task;

import java.util.List;

public class TaskService {

    TaskRepository repo = new TaskRepository();

    public void addTask(String title,String description,int priority){

        String status="Pending";

        Task task = new Task(title,description,status,priority);

        repo.addTask(task);
    }


    public List<Task> getTasks(){
        return repo.getAllTasks();
    }


    public boolean updateTaskStatus(int id,String status){
        return repo.updateStatus(id,status);
    }



    // status count :

    public int getCompletedCount(){
        return repo.countByStatus("Done");
    }

    public int getDoingCount(){
        return repo.countByStatus("Doing");
    }

    public int getPendingCount(){
        return repo.countByStatus("Pending");
    }
}