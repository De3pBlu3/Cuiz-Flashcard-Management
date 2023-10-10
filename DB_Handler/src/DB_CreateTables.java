
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_CreateTables {
    public static void CreateStandardTables() {
        // SQLite connection string
        String appdataPath = System.getenv("APPDATA");
        String DquizPath = appdataPath + "/DQuiz";              // DQuiz database folder path in APPDATA

        String url = "jdbc:sqlite:" + DquizPath +"/" + "DQuiz.db";

        // SQL statement for creating a new table
        String sql =
                """
                CREATE TABLE IF NOT EXISTS cards (
                	card_id integer PRIMARY KEY,
                	name text NOT NULL,
                	capacity real
                );
                """;

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
