public class Employee {

    private final Integer id;
    private String name;
    private Double salary;

    //Basic constructor
    public Employee(Integer id, String name, Double salary) {

        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    //Getters and setters methods
    public Integer getId() {return id;}
    public String getName() {return name;}
    public Double getSalary() {return salary;}

    public void setName(String name) {this.name = name;}

    //General methods
    public void increaseSalary(Double percentage) {

        this.salary += (this.salary * percentage) / 100;
    }

    public String toString() {

        return getId() + ", " + getName() + ", " + getSalary();
    }
}
