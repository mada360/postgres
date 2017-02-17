/**
 * Created by adam on 16/02/2017.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

    public static void main( String args[] )
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/testdb",
                            "postgres", "password");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            stmt.executeUpdate("DROP TABLE  EMPLOYEE");
            String sql = "CREATE TABLE EMPLOYEE " +
                    "(EMPLOYEE_ID                  BIGINT PRIMARY KEY     NOT NULL," +
                    " FIRSTNAME           TEXT    NOT NULL, " +
                    " LASTNAME            TEXT     NOT NULL, " +
                    " START               DATE      NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}