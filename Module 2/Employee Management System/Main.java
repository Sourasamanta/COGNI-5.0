import java.util.ArrayList;
import java.util.Iterator;

/*
Arrays are represented with continious memory allocation thus searching with index can be done in O(1) time which is not possible in link list

Time Complexity
Add - O(1)
Search, Delete, Traverse - O(n)

limitation of array:
 - as it is visible delete and search takes O(n) time , so they are costly, array also leads to memory wastage
*/

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
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name : " + name);
        System.out.println("Position : " + position);
        System.out.println("Salary : " + salary);
        System.out.println("");
    }
}

class EmployeeManagementSystem {

    ArrayList<Employee> employees;

    EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    void addEmployee(Employee employee) {
        employees.add(employee);
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

        Employee e1 = new Employee(101, "Alice", "Manager", 75000);
        Employee e2 = new Employee(102, "Bob", "Developer", 60000);
        Employee e3 = new Employee(103, "Charlie", "Tester", 50000);

        ems.addEmployee(e1);
        ems.addEmployee(e2);
        ems.addEmployee(e3);

        ems.traverseEmployees();

        Employee found = ems.searchEmployee(102);
        if (found != null) {
            System.out.println("Employee Found:");
            found.display();
        } else {
            System.out.println("Employee Not Found");
        }

        ems.deleteEmployee(102);

        System.out.println("After Deletion:");
        ems.traverseEmployees();
    }
}