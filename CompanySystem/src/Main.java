import java.util.*;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        Employee employee;
        String name;
        int n;
        int id;
        double salary;
        double percentage;

        System.out.print("How many employees will be registered? ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEmployee #" + (i + 1) + ": ");

            do {

                System.out.print("Id: ");
                id = sc.nextInt();

            } while (verifyID(employees, id));

            System.out.print("Name: ");
            sc.nextLine();
            name = sc.nextLine();

            System.out.print("Salary: ");
            salary = sc.nextDouble();

            employees.add(new Employee(id, name, salary));
        }

        System.out.print("\nEnter the employee ID tha will have salary increase: ");
        id = sc.nextInt();

        if (verifyID(employees, id)) {

            System.out.print("Enter the percentage: ");
            percentage = sc.nextDouble();

            increaseSalaryById(employees, id, percentage);

        } else System.out.println("This ID does not exist!");

        System.out.println("\nList of employees: ");

        for (Employee e : employees) System.out.println(e);
    }

    public static Boolean verifyID(List<Employee> employees, int id) {

        //if (employees.isEmpty()) return false;

        Employee employee = employees.stream().filter(emp -> emp.getId() == id).findFirst().orElse(null);

        return (employee != null);
    }

    public static void increaseSalaryById(List<Employee> employees, int id, double percentage) {

        employees.stream().filter(emp -> emp.getId() == id).findFirst().ifPresent(emp -> emp.increaseSalary(percentage));
    }
}