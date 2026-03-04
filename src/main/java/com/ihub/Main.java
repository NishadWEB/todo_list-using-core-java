package com.ihub;

import com.ihub.controller.TaskController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TaskController controller = new TaskController();

        while(true){

            System.out.println("\n===============================");
            System.out.println("        TODO LIST SYSTEM");
            System.out.println("===============================");

            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. Generate Task Report");
            System.out.println("5. Exit");

            System.out.print("\nChoose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> controller.addTask();

                case 2 -> controller.viewTasks();

                case 3 -> controller.updateStatus();

                case 4 -> controller.generateReport();

                case 5 -> {
                    System.out.println("Exiting application...");
                    System.exit(0);
                }

                default -> System.out.println("Invalid option.");
            }
        }
    }
}