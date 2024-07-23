import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDao {

    /**
     * @param emp
     * @throws SQL
     */
    public static void createData(Employee emp) throws SQLException{
        Connection con = DB.connect();
        String query = "INSERT INTO employee(id, name, emailId, salary) VALUES (?, ?, ?, ?)";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, emp.getId());
        pstm.setString(2, emp.getName());
        pstm.setString(3, emp.getEmail());
        pstm.setInt(4, emp.getSalary());
        pstm.execute();
        con.close();
        System.out.println("data entered successfully !!");
    }

    public static ArrayList readData() throws SQLException{
        ArrayList ans = new ArrayList<>();
        Connection con = DB.connect();
        Statement stm = con.createStatement();
        String query = "Select * from employee";
        ResultSet rset = stm.executeQuery(query);
            while(rset.next()){
                ArrayList arr = new ArrayList<>();
                arr.add(0, rset.getInt(1));
                arr.add(1, rset.getString(2));
                arr.add(2, rset.getString(3));
                arr.add(3, rset.getInt(4));
                ans.add(arr);
            }
            con.close();
            return ans;
    }

    public static void updateData(int newId, String newName) throws SQLException{
        Connection con = DB.connect();
        String query = "UPDATE employee SET name = ? WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, newName);
        pst.setInt(2, newId);
        pst.execute();
        con.close();
    }

    public static void deleteData(int id) throws SQLException {
        Connection con = DB.connect();
        String query = "DELETE from employee WHERE id = ?";
        PreparedStatement pstms = con.prepareStatement(query);
        pstms.setInt(1, id);
        pstms.execute();
        pstms.close();
        System.out.println("data deleted successfully !!");
    }

}
