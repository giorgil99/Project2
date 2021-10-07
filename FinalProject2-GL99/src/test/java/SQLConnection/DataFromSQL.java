package SQLConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

// Takes data from sql sever

public class DataFromSQL {

    public static String id;
    public static String firstName;
    public static String lastName;
    public static String phone;
    public static String password;
    public static String address;
    public static String email;
    public static String country;
    public static String state;
    public static String city;
    public static String zip;

    public void SQLData() {

        try {
            Statement pstmt1 = ServerConnector.getConnection().createStatement();

            String checker = "SELECT TOP 1 * FROM Table_2 ORDER BY ad DESC";
            ResultSet rs = pstmt1.executeQuery(checker);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("Column data number is: " + columnsNumber);
            if (rs.next()) {
                id = rs.getString(1);
                firstName = rs.getString(2);
                lastName = rs.getString(3);
                phone = rs.getString(4);
                password = rs.getString(5);
                address = rs.getString(6);
                email = rs.getString(7);
                country = rs.getString(8);
                state = rs.getString(9);
                city = rs.getString(10);
                zip = rs.getString(11);

                System.out.println("User id is: " + id);
            }
            pstmt1.getConnection().close();

        } catch (Exception e) {
            System.out.println("checker query failed");
        }


    }

}
