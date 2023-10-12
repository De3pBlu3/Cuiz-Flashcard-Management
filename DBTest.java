import java.util.Arrays;
import java.util.Objects;

public class DBTest {
    public static void main(String[] args) {
//        DB_SetUp.createNewDatabase();
//        DB_CreateTables.CreateStandardTables();
//        DB_UserInteract.selectAll();
//        DB_UserInteract.insert("john", "test");
//        System.out.println(DB_UserInteract.loginCheck("john", "pass12"));



        System.out.println(Arrays.toString(DB_CardInteract.returnAllCards()));
//        System.out.println(DB_CardInteract.returnCardByID("AAAB"));
//        System.out.println(Arrays.toString(DB_CardInteract.returnCardsByCategory(0)));
//        card question5 = new card("ASDD", "What is 1+1?", "1;2;3;4", 1, 0, 0);
//        DB_CardInteract.addCardToDB(question5);
    }

}
