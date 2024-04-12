import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Task class representing individual tasks
class Task {
    private int taskId;
    private String description;
    private String dueDate;
    private boolean completed;

    // Constructor to initialize task object
    public Task(int taskId, String description, String dueDate) {
        this.taskId = taskId;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false; // By default, task is not completed
    }

    // Getters and setters for task attributes
    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

// TaskManager class to manage tasks
class TaskManager {
    private List<Task> tasks; // List to store tasks

    // Constructor to initialize task manager
    public TaskManager() {
        this.tasks = new ArrayList<>(); // Initialize task list
    }

    // Method to add task to the task manager
    public void addTask(Task task) {
        tasks.add(task); // Add task to the list
    }

    // Method to mark a task as completed
    public void markTaskAsCompleted(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                task.setCompleted(true); // Set completed flag to true
                return;
            }
        }
        System.out.println("Task with ID " + taskId + " not found.");
    }

    // Method to view all tasks
    public void viewAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task.getTaskId() + " - " + task.getDescription() + " - Due: " + task.getDueDate() + " - Completed: " + task.isCompleted());
        }
    }

    // Method to get the list of tasks
    public List<Task> getTasks() {
        return tasks;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager(); // Create task manager object

        // Main loop for task management system
        while (true) {
            // Display menu options
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View All Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add new task
                    System.out.println("\nAdding Task");
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Due Date: ");
                    String dueDate = scanner.nextLine();
                    Task task = new Task(taskManager.getTasks().size() + 1, description, dueDate); // Task ID is assigned based on the current number of tasks
                    taskManager.addTask(task); // Add task to the task manager
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    // Mark task as completed
                    System.out.println("\nMarking Task as Completed");
                    System.out.print("Enter Task ID to mark as completed: ");
                    int taskId = scanner.nextInt();
                    taskManager.markTaskAsCompleted(taskId); // Mark task as completed
                    System.out.println("Task marked as completed.");
                    break;
                case 3:
                    // View all tasks
                    System.out.println("\nViewing All Tasks");
                    taskManager.viewAllTasks(); // View all tasks in the task manager
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
