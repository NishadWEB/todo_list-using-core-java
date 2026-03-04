package com.ihub.controller;

import com.ihub.service.TaskService;
import com.ihub.model.Task;

import java.util.List;
import java.util.Scanner;

public class TaskController {

    Scanner sc = new Scanner(System.in);
    TaskService service = new TaskService();


    public void addTask(){

        System.out.print("\nEnter Task Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        System.out.print("Enter Priority (1-High 2-Medium 3-Low): ");
        int priority=sc.nextInt();
        sc.nextLine();

        service.addTask(title,description,priority);

        System.out.println("Task added successfully.");
    }


    public void viewTasks(){

        List<Task> tasks = service.getTasks();

        if(tasks.isEmpty()){
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n-------------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-25s %-10s %-8s\n","ID","Title","Description","Status","Priority");
        System.out.println("---------------------------------------------------------------------------");

        for(Task t:tasks){
            System.out.printf("%-5d %-20s %-25s %-10s %-8d\n",
                    t.getId(),
                    t.getTitle(),
                    t.getDescription(),
                    t.getStatus(),
                    t.getPriority());
        }
    }


    public void updateStatus(){
        System.out.print("\nEnter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Choose Status");
        System.out.println("1. Pending");
        System.out.println("2. Doing");
        System.out.println("3. Done");
        System.out.print("=> ");

        int choice = sc.nextInt();
        sc.nextLine();

        String status = switch (choice) {
            case 1 -> "Pending";
            case 2 -> "Doing";
            case 3 -> "Done";
            default -> {
                System.out.println("Invalid choice. Default is Pending.");
                yield "Pending"; // yield is bsclly a retrn
            }
        };

        boolean updated = service.updateTaskStatus(id, status);

        if(updated){
            System.out.println("Task updated successfully.");
        }else{
            System.out.println("Task ID not found.");
        }
    }


    public void generateReport(){

        int done = service.getCompletedCount();
        int doing = service.getDoingCount();
        int pending = service.getPendingCount();

        System.out.println("\nTask Summary Report");
        System.out.println("--------------------");

        System.out.println("Completed Tasks : "+ done);
        System.out.println("Doing Tasks     : "+ doing);
        System.out.println("Pending Tasks   : "+ pending);
    }
}