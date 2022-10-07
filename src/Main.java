public class Main {
    public static int counter;
    public static Employee[] employeeDatabase = new Employee[10];

    public static void main(String[] args) {
        addEmployee("Иванов Иван Иванович", 1, 30_000);
        addEmployee("Максимов Иван Иванович", 1, 30_000);
        addEmployee("Федоров Федор Федорович", 2, 35_000);
        addEmployee("Павлов Павел Павлович", 5, 30_000);
        addEmployee("Иванов Федор Александрович", 2, 35_000);
        addEmployee("Иванов Павел Иванович", 3, 30_000);
        addEmployee("Иванов Федор Антонович", 4, 40_000);
        addEmployee("Александров Иван Иванович", 3, 50_000);
        addEmployee("Викторов Федор Иванович", 5, 45_000);
        addEmployee("Иванов Виктор Иванович", 4, 25_000);

        getEmployeeData();
        getSumSalary();
        findMinimumWage();
        findMaximumWage();
        getAverageSalary();
        getEmployeeFullNames();
    }

    public static void getEmployeeData() {
        for (Employee employee : employeeDatabase) {
            System.out.println(employee);
        }
    }

    public static void getSumSalary() {
        int sum = 0;
        for (Employee employee : employeeDatabase) {
            sum += employee.getSalary();
        }
        System.out.println("The cost of all salaries per month = " + sum);
    }

    public static void findMinimumWage() {
        Employee min = employeeDatabase[0];
        for (Employee employee : employeeDatabase) {
            if (min.getSalary() > employee.getSalary()) {
                min = employee;
            }
        }
        System.out.println("The employee with a minimum wage = " + min);
    }

    public static void findMaximumWage() {
        Employee max = employeeDatabase[0];
        for (Employee employee : employeeDatabase) {
            if (max.getSalary() < employee.getSalary()) {
                max = employee;
            }
        }
        System.out.println("The employee with a maximum wage = " + max);
    }

    public static void getAverageSalary() {
        int sum = 0;
        for (Employee employee : employeeDatabase) {
            sum += employee.getSalary();
        }
        int averageSalary = sum / employeeDatabase.length;
        System.out.println("The average salary = " + averageSalary);
    }

    public static void getEmployeeFullNames() {
        for (Employee employee : employeeDatabase) {
            System.out.println(employee.getFullName());
        }
    }

    public static void addEmployee(String name, int dep, int sal) {
        employeeDatabase[counter] = new Employee(name, dep, sal);
    }
}