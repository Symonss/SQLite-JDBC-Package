
package sqlitejdbcdriverconnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Symons
 */
public class SQLiteJDBCDriverConnection {    
  /**
     * Connect to a sample database
     */
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    /*
    Creating a database!
     1.First, specify the database name and its location e.g., c:\sqlite\db\test.db
     2.Second, connect to the database via SQLite JDBC driver.
    3.By simply connecting to a database that do not exitst SQLite creates the database
    */
     public static void createNewDatabase(String fileName) {
 
        String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    /**
     * @Main method
     */
    public static void main(String[] args) {
       // connect();
       createNewDatabase("test.db");
    }
    
}
