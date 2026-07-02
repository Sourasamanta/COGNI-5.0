import java.util.ArrayList;
import java.util.Iterator;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

class EmployeeManagementSystem {
    ArrayList<Employee> employees;

    EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    Employee searchEmployee(int employeeId) {
        for (Employee emp : employees) {
            if (emp.employeeId == employeeId) {
                return emp;
            }
        }
        return null;
    }

    void traverseEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee emp : employees) {
            emp.display();
        }
    }

    void deleteEmployee(int employeeId) {
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee emp = iterator.next();

            if (emp.employeeId == employeeId) {
                iterator.remove();
                System.out.println("Employee deleted successfully.");
                return;
            }
        }

        System.out.println("Employee not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        ems.addEmployee(new Employee(101, "Alice", "Manager", 75000));
        ems.addEmployee(new Employee(102, "Bob", "Developer", 60000));
        ems.addEmployee(new Employee(103, "Charlie", "Tester", 50000));

        System.out.println("All Employees:");
        ems.traverseEmployees();

        System.out.println("Searching Employee ID 102:");
        Employee emp = ems.searchEmployee(102);

        if (emp != null) {
            emp.display();
        } else {
            System.out.println("Employee not found.");
        }

        ems.deleteEmployee(102);

        System.out.println("Employees After Deletion:");
        ems.traverseEmployees();
    }
}