

public class DBTest {
    public static void main(String[] args) {
        DB_SetUp.createNewDatabase(".db");
        DB_CreateTables.CreateStandardTables();
    }
}
