package ObjectAndClasses;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee empOne = new Employee("RUNOOB1");
        Employee empTwo = new Employee("RUNOOB2");

        empOne.empAge(26);
        empOne.empDesignation("高级程序员");
        empOne.empSalary(500);
        empOne.printEmployee();

        empTwo.empAge(21);
        empTwo.empDesignation("菜鸟程序员");
        empTwo.empSalary(1000);
        empTwo.printEmployee();
    }
}
