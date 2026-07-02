/*
singly link list basically move in one direction, we can start from head to last
while
doubly link list can be traverse from start to end and end to start, so doubly link list is much more flexible

Time Complexity O(n) for add , search , delete , traverse

link list is dynamic so no static memore allocation, no memory wastage and efficient insertion and deletion
*/

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    void display() {
        System.out.println("Task ID: " + taskId);
        System.out.println("Task Name: " + taskName);
        System.out.println("Status: " + status);
        System.out.println();
    }
}

class TaskManagementSystem {
    Task head;

    TaskManagementSystem() {
        head = null;
    }

    void addTask(Task task) {
        if (head == null) {
            head = task;
        } else {
            Task start = head;

            while (start.next != null) {
                start = start.next;
            }

            start.next = task;
        }
    }

    Task searchTask(int taskId) {
        Task start = head;

        while (start != null) {
            if (start.taskId == taskId) {
                return start;
            }
            start = start.next;
        }

        return null;
    }

    void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task start = head;

        while (start != null) {
            start.display();
            start = start.next;
        }
    }

    void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Task start = head;
        Task prev = null;

        while (start != null) {
            if (start.taskId == taskId) {
                prev.next = start.next;
                System.out.println("Task deleted successfully.");
                return;
            }

            prev = start;
            start = start.next;
        }

        System.out.println("Task not found.");
    }
}

public class Main {
    public static void main(String[] args) {

        TaskManagementSystem tms = new TaskManagementSystem();

        Task t1 = new Task(101, "Design UI", "Pending");
        Task t2 = new Task(102, "Develop Backend", "In Progress");
        Task t3 = new Task(103, "Testing", "Pending");

        tms.addTask(t1);
        tms.addTask(t2);
        tms.addTask(t3);

        System.out.println("All Tasks:");
        tms.traverseTasks();

        System.out.println("Searching Task 102:");
        Task task = tms.searchTask(102);

        if (task != null) {
            task.display();
        } else {
            System.out.println("Task not found.");
        }

        tms.deleteTask(102);

        System.out.println("Tasks After Deletion:");
        tms.traverseTasks();
    }
}