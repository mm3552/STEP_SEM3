package classes_and_objects.assigment_problems;

class EmployeeInfo {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    EmployeeInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeInfo("Divya", 65000);
        new EmployeeInfo("Arjun", 0);
        new EmployeeInfo("Priya", 70000);

        System.out.println("3 Employee objects created");
        EmployeeInfo.printCompanyInfo();
    }
}
