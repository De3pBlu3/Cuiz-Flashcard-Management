import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DB_SetUp {

    public static void createNewDatabase(String fileName) {
        // check if DQuiz folder exists in appdata
        String appdataPath = System.getenv("APPDATA");
        String DquizPath = appdataPath + "/DQuiz";              // DQuiz database folder path in APPDATA

        File DquizFolder = new File(DquizPath);
        if (!DquizFolder.exists()) {
            DquizFolder.mkdir();
        }

        String url = "jdbc:sqlite:" + DquizFolder +"/" + fileName;

        // test if database exists
        File dbFile = new File(DquizFolder + "/" + fileName);
        if (dbFile.exists()) {
            System.out.println("Database already exists");
            return;
        }
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewDatabase("DQuiz.db");
    }
}


