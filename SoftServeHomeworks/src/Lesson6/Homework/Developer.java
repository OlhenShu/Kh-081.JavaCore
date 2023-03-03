package Lesson6.Homework;

public class Developer extends  Employee {
    private String position = "Java developer";

    public Developer(String name, int salary, int age) {
        super(name, salary, age);
    }

    @Override
    public String report() {
        return String.format("Name: %1s , Salary: %1d , Position: %2s , Age: %2d", super.getName(), super.getSalary(), position , super.getAge());
    }
}