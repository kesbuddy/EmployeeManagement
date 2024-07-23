
public class Employee {

    private int id;
    private String name;
    private String emailId;
    private int salary;

    public Employee(int id, String name, String emailId, int salary) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.salary = salary;
    }

    // creating getters to implement encapsulation (or else we could've got access to objects without getter if we couldn't have asigned our variables as "private")

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail(){
        return emailId;
    }

    public int getSalary(){
        return salary;
    }

}
