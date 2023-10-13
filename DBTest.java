
import java.util.Objects;

public class DBTest {
    public static void main(String[] args) {
//        HELLO! This is the sample code to demonstrate interacting with the db, adding cards, retrieving cards, and *creating* the database!
//        Now if you compile this file *without* having the DB_Handler module or the sqlite-jdbc.jar file in the classpath, it will not work!
//        If you need any help with that LMK, cause it might be different depending on what IDE you use and how ur project is set up!!



//        ------------------------------------------------------- DATABASE CREATION ---------------------------------------------------------
//        When the user first starts up the program, there WILL NOT be a database! We are gonna need to make it for them! This command does that:
        DB_SetUp.createNewDatabase();
//        This will check if the database exists, and if it doesn't, it will create an empty database! If the database already-
//        exists it will do nothing!

//        However this database we have created is completly empty, we need to fill it with tables. Each 'table' will contain
//        a different type of data. For example, we will have a table for cards, a table for users, and a table for scores.
//        If you imagine an spreadsheet, each table is its own sheet, and within each sheet, is a different set up of columns and rows and data!
//        So for example, the card table looks like this:
//        card_id | question     | answers | correct_answer_index | category | difficulty
//        AAAA    | What is 1+1? | 1;2;3;4 | 1                    | 0        | 0

        DB_CreateTables.CreateStandardTables();

//        this creates the tables in the database! If the tables already exist, it will do nothing! (or it might crash i cant remember lol)



//        ------------------------------------------------------- CREATING/INTERACTION WITH CARDS ---------------------------------------------------------
//        Now that we have made the database and created the tables, we can start adding stuff to the database!
//        The way to add cards to the database is with:
        card question5 = new card("ASDD", "What is 1+1?", "1;2;3;4", 1, 0, 0);
        DB_CardInteract.addCardToDB(question5);

//       I created a class called 'card', which means you can create a card object using the first command! In the same way you can create a string object!
//        we can then interact with this object in a few ways! For example, we can print it out to the console:
        System.out.println(question5); // this will print all details pertaining to the card

        // or we can print a specific detail:
        System.out.println(question5.Question_content); // this will print the question of the card
//        Now that we have created a card object, we can add it to the database using the second command!


//        Let's say you want to RETRIEVE stuff from the database. We want to show a player a card of difficulty 1! We can do that with:
        card[] cards_difficulty1 = DB_CardInteract.returnCardsByDifficulty(1);
//        this will return ALL cards with that difficulty.
//        we can then show the first result with
        System.out.println(cards_difficulty1[0]);



//       ------------------------------------------------------- CREATING/INTERACTION WITH USERS ---------------------------------------------------------
//        WE can do the exact same this as we did for cards with USERS! The only difference is that their is no 'user' class, and as such no user object. Instead we just use strings!
//        ALl this means practically is that instead of creating a card object like below,
        card question6 = new card("ASDD", "What colour is the sky?", "blue;red;green;yellow", 0, 0, 0);
//         we just insert the username/password RIGHT into the database!

        DB_UserInteract.insert("Username", "Password"); // this creates a new user with username : Username and password : Password


//        We can check if a user has gotten their login correct by using the following command:
        System.out.println(DB_UserInteract.loginCheck("Username", "Password")); // this will return true if the username and password match, and false if they dont!

//        We can also get all the users in the database with:
        DB_UserInteract.selectAll(); // this will print all the users in the database to the console!

//        ---------------------------------------------------- ALL OTHER INTERACTIONS ---------------------------------------------------------
//        These are all the methods i created to interact with the database! If you need any more, let me know!
//        Cards functions (DB_CardInteract)
//        methods:                    | return type:      | parameters:
//        -----------------------------------------------------------------
//        amountOfCardsTotal          | int               | none
//        amountOfCardsWithWhere      | int               | string (where sql statement)
//        returnAllCards              | array of cards    | none
//        returnCardByID              | card              | string (id of card)
//        returnCardsByDifficulty     | array of cards    | int    (difficulty int)
//
//
//        User functions (DB_CardInteract)
//        methods:                    | return type:      | parameters:
//        -----------------------------------------------------------------
//        loginCheck                  | bool              | user_ID, password (string)
//        selectAll                   | int               | string (where sql statement)
//        insert                      | none              | user_ID, password (string)

    }

}
