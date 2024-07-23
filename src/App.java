import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Employee Management CRUD application");
        System.out.println("1 - Create | 2 - Read | 3 - Update | 4 - Delete");
        Scanner s = new Scanner(System.in);
        System.out.print("Select a number : ");
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter employee id : ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter employee name : ");
                String name = sc.nextLine();
                System.out.print("Enter employee email id : ");
                String emailId = sc.nextLine();
                System.out.print("Enter Salary : ");
                int salary = sc.nextInt();
                Employee emp = new Employee(id, name, emailId, salary);
                EmployeeDao.createData(emp);
                break;
            case 2:
                System.out.println("current database looks like : ");
                ArrayList ans = EmployeeDao.readData();
                for(int i = 0; i<ans.size(); i++){
                    System.out.println(ans.get(i));
                }
                break;
            case 3:
                Scanner scc = new Scanner(System.in);
                System.out.print("enter id to be updated : ");
                int newId = scc.nextInt();
                scc.nextLine();
                System.out.print("enter name to be updated :");
                String newName = scc.nextLine();
                EmployeeDao.updateData(newId, newName);
                break;
            case 4:
                Scanner sccc = new Scanner(System.in);
                System.out.print("Select the id you want to delete : ");
                int delId =  sccc.nextInt();
                EmployeeDao.deleteData(delId);
                break;
            default:
                System.out.println("Invalid number");
        }
    }
}
