public class Employee {
    private String fullName;
    private int department; //отделы от 1 до 5
    private int salary;
    private int id;

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = Main.counter + 1;
        Main.counter++;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getDepartment() {
        return this.department;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getId() {
        return this.id;
    }

    public int setDepartment(int department) {
        return this.department = department;
    }

    public int setSalary(int salary) {
        return this.salary = salary;
    }

    public String toString() {
        return "Id: " + id + "  Full name: " + fullName + "  Department: " + department + "  Salary: " + salary;
    }
}
