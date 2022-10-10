public class Main {
    public static int counter;
    public static Employee[] employeeDatabase = new Employee[10];

    public static void main(String[] args) {

        initialDatabase();

        getEmployeeDatabase();
        getSumSalary();
        findMinimumSalary();
        findMaximumSalary();
        getAverageSalary();
        getEmployeeFullNames();
        indexSalary(5);
        indexSalaryDepartment(10, 5);
        findMinimumSalary();
        findMaximumSalary();
    }

    public static void getEmployeeDatabase() {
        System.out.println("Get a list of all employees with all available data on them:");
        for (Employee employee : employeeDatabase) {
            System.out.println(employee);
        }
        System.out.println();
    }

    public static void getSumSalary() {
        int sum = 0;
        for (Employee employee : employeeDatabase) {
            sum += employee.getSalary();
        }
        System.out.println("The cost of all salaries per month = " + sum);
        System.out.println();
    }

    public static void findMinimumSalary() {
        findSalary("minimum");
    }

    public static void findMaximumSalary() {
        findSalary("maximum");
    }

    public static void findSalary(String text) {
        Employee value = employeeDatabase[0];
        for (Employee employee : employeeDatabase) {
            if (value.getSalary() < employee.getSalary() && text.equalsIgnoreCase("maximum")) {
                value = employee;
            } else if (value.getSalary() > employee.getSalary() && text.equalsIgnoreCase("minimum")) {
                value = employee;
            }
        }
        System.out.println("The employee with a " + text + " wage = " + value);
        System.out.println();
    }


    public static void getAverageSalary() {
        int sum = 0;
        for (Employee employee : employeeDatabase) {
            sum += employee.getSalary();
        }
        int averageSalary = sum / employeeDatabase.length;
        System.out.println("The average salary = " + averageSalary);
        System.out.println();
    }

    public static void getEmployeeFullNames() {
        System.out.println("Get the full name of all employees:");
        for (Employee employee : employeeDatabase) {
            System.out.println(employee.getFullName());
        }
        System.out.println();
    }

    public static void addEmployee(String name, int dep, int sal) {
        employeeDatabase[counter] = new Employee(name, dep, sal);
        System.out.println("A new employee has been added to the database. The employee ID is " + counter);
    }

    public static void initialDatabase() {
        System.out.println("Enter data about all employees of the company:");
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
        System.out.println("The initial input of up-to-date employee data has been completed.");
        System.out.println("");
    }

    public static void indexSalary(int percent) {
        indexSalaryDepartment(percent, 0);
        System.out.println("The salaries of all employees are indexed by " + percent + "%");
        System.out.println();
    }

    public static void indexSalaryDepartment(int percent, int dep) {
        for (Employee employee : findDepartment(dep)) {
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
        }
        if (dep != 0) {
        System.out.println("The salaries of all employees of the " + dep + "th department are indexed by " + percent + "%");
        System.out.println();
        }
    }

    public static Employee[] findDepartment(int dep) {
        if (dep == 0) {
            return employeeDatabase;
        }
        Employee[] department = new Employee[counter];
        int departmentCounter = 0;
        for (Employee employee : employeeDatabase) {
            if (employee.getDepartment() == dep) {
                department[departmentCounter] = employee;
                departmentCounter++;
            }
        }
        Employee[] departmentReturn = new Employee[departmentCounter];
        for (int i = 0; i < departmentReturn.length; i++) {
            departmentReturn[i] = department[i];
        }
        return departmentReturn;
    }
}