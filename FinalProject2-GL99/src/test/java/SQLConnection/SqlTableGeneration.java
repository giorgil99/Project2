package SQLConnection;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//   Generate rows for sql table

public class SqlTableGeneration {

@Test
    public static void SQLTable() throws SQLException {
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO Table_2(id,firstName,lastName,phone,password,address,email,country,state,city,zip,ad) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = ServerConnector.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
            String ad = dtf.format(LocalDateTime.now());
            Faker faker = new Faker();

            pstmt.setInt(1, (int) faker.number().randomNumber(4,true));
            pstmt.setString(2,faker.name().firstName());
            pstmt.setString(3,faker.name().lastName());
            pstmt.setString(4,String.valueOf(faker.number().randomNumber(10,true)));
            pstmt.setString(5,faker.internet().password(8,10,true));
            pstmt.setString(6,faker.address().streetAddress());
            pstmt.setString(7,faker.internet().emailAddress());
            pstmt.setString(8,faker.address().country());
            pstmt.setString(9,faker.address().state());
            pstmt.setString(10,faker.address().city());
            pstmt.setInt(11, Integer.parseInt(faker.number().digits(3)));
            pstmt.setString(12,ad);

            pstmt.executeUpdate();
            pstmt.getConnection().commit();
            pstmt.close();




        } catch (SQLException | IOException throwable) {
            throwable.printStackTrace();
            if (pstmt != null) {
                pstmt.getConnection().rollback();
                System.out.println("Exception !!!");
            }

        }
    }
}
