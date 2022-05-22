package lesson05;

public class Person {
    private String lastName;
    private String firstName;
    private String secondName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person (String lastName,
                   String firstName,
                   String secondName,
                   String position,
                   String email,
                   String phone,
                   int salary,
                   int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String getAllInfo() {
        return("Ф.И.О: " + this.lastName + " " +
                this.firstName + " " +
                this.secondName + ", должность: " +
                this.position + ", e-mail: " +
                this.email + ", тел.: " +
                this.phone + ", оклад: " +
                this.salary + " руб., возраст: " +
                this.age);

    }
}
