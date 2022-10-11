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

        findMinimumSalaryDepartment(2);
        findMaximumSalaryDepartment(3);
        getSumSalaryDepartment(3);
        getAverageSalaryDepartment(4);
        indexSalaryDepartment(10, 5);
        getEmployeeDatabaseDepartment(3);

        findSalaryLess(40_000);
        findSalaryMore(41_000);
    }

    public static void getEmployeeDatabase() {
        System.out.println("Get a list of all employees with all available data on them:");
        getEmployeeDatabaseDepartment(0);
    }

    public static void getSumSalary() {
        getSumSalaryDepartment(0);
    }

    public static void findMinimumSalary() {
        findMinimumSalaryDepartment(0);
    }

    public static void findMaximumSalary() {
        findMaximumSalaryDepartment(0);
    }

    public static void getAverageSalary() {
        getAverageSalaryDepartment(0);
    }

    public static void indexSalary(int percent) {
        indexSalaryDepartment(percent, 0);
        System.out.println("The salaries of all employees are indexed by " + percent + "%");
    }

    public static void findSalaryLess(int value) {
        findSalaryLessOrMore(value, "less");
    }

    public static void findSalaryMore(int value) {
        findSalaryLessOrMore(value, "more");
    }

    public static void addEmployee(String name, int dep, int sal) {
        employeeDatabase[counter] = new Employee(name, dep, sal);
        System.out.println("A new employee has been added to the database. The employee ID is " + counter);
    }

    public static void getEmployeeFullNames() {
        System.out.println("Get the full name of all employees:");
        for (Employee employee : employeeDatabase) {
            System.out.println(employee.getFullName());
        }
        System.out.println();
    }

    public static void findMinimumSalaryDepartment(int dep) {
        findSalary("minimum", dep);
    }

    public static void findMaximumSalaryDepartment(int dep) {
        findSalary("maximum", dep);
    }

    public static void getSumSalaryDepartment(int dep) {
        int sum = 0;
        for (Employee employee : findDepartment(dep)) {
            sum += employee.getSalary();
        }
        if (dep != 0) {
            System.out.println("The cost of all salaries of the " + dep + "th department per month = " + sum);
        } else {
            System.out.println("The cost of all salaries per month = " + sum);
        }
    }

    public static void getAverageSalaryDepartment(int dep) {
        int sum = 0;
        for (Employee employee : findDepartment(dep)) {
            sum += employee.getSalary();
        }
        int averageSalary = sum / findDepartment(dep).length;
        if (dep == 0) {
            System.out.println("The average salary = " + averageSalary);
        } else {
            System.out.println("The average salary of the " + dep + "th department = " + averageSalary);
        }
    }

    public static void indexSalaryDepartment(int percent, int dep) {
        for (Employee employee : findDepartment(dep)) {
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
        }
        if (dep != 0) {
            System.out.println("The salaries of all employees of the " + dep + "th department are indexed by " + percent + "%");
        }
    }

    public static void getEmployeeDatabaseDepartment(int dep) {
        if (dep != 0) {
            System.out.println("Get a list employees of the " + dep + "th department with available data on them:");
        }
        for (Employee employee : findDepartment(dep)) {
            if (dep != 0) {
                System.out.println("ID: " + employee.getId() + "  Full name: " + employee.getFullName() + "Salary: " + employee.getSalary());
            } else {
                System.out.println(employee);
            }
        }
        System.out.println();
    }

    public static void findSalary(String text, int dep) {
        Employee value = findDepartment(dep)[0];
        for (Employee employee : findDepartment(dep)) {
            if (value.getSalary() < employee.getSalary() && text.equalsIgnoreCase("maximum")) {
                value = employee;
            } else if (value.getSalary() > employee.getSalary() && text.equalsIgnoreCase("minimum")) {
                value = employee;
            }
        }
        if (dep == 0) {
            System.out.println("The employee with a " + text + " wage = " + value);
        } else {
            System.out.println("The employee of the " + dep + "th department with a " + text + " wage = " + value);
        }
    }

    public static void findSalaryLessOrMore(int value, String text) {
        System.out.println("All employees with a salary of " + text + " than " + value + ":");
        for (Employee employee : employeeDatabase) {
            if (employee.getSalary() < value && text.equalsIgnoreCase("less")) {
                System.out.println("ID: " + employee.getId() + "  Full name: " + employee.getFullName() + " Salary: " + employee.getSalary());
            }
            if (employee.getSalary() > value && text.equalsIgnoreCase("more")) {
                System.out.println("ID: " + employee.getId() + "  Full name: " + employee.getFullName() + " Salary: " + employee.getSalary());
            }
        }
        System.out.println();
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

    public static void initialDatabase() {
        System.out.println("Enter initial data about all employees of the company:");
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
        System.out.println("The initial input of up-to-date employee data has been completed.\n");
    }
}