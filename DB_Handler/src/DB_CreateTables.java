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
        String sql_create_table_cards =
                """
            CREATE TABLE IF NOT EXISTS cards (
                "card_id"	TEXT NOT NULL,
                "question"	TEXT,
                "answers"	TEXT,
                "correct_answer_index"	INTEGER,
                "category"	INTEGER,
                "difficulty"	INTEGER,
                PRIMARY KEY("card_id")
            ) WITHOUT ROWID;
                    """;
        String sql_create_table_user =
                """
                    CREATE TABLE IF NOT EXISTS users (
                        "user_ID"	TEXT,
                        "password"	TEXT,
                        PRIMARY KEY("user_ID")
                    ); WITHOUT ROWID;
                                """;

        String sql_create_table_score =
                """
                CREATE TABLE "scores" (
                    "score"	INTEGER,
                    "card_id"	TEXT,
                    "user_ID"	TEXT,
                    FOREIGN KEY("card_id") REFERENCES "cards"("card_id"),
                    FOREIGN KEY("user_ID") REFERENCES "users"("user_ID")
                );""";


        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql_create_table_cards); 
            stmt.execute(sql_create_table_user);
            stmt.execute(sql_create_table_score);
            System.out.println("Tables created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
