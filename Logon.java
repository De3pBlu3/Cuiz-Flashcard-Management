import java.util.Scanner;
public class Logon {
	public static void main(String[] args) {
		logon();
	}
	
	public static void logon() { 
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to The quiz");
		System.out.println("Log in (1) or Sign up (2)");
		int logon = in.nextInt(); //Line to choose
		in.nextLine();
		if (logon == 2) {
			
			//----------SIGN-UP------------// things to add (confirm password?) (straight to login after?)
			
			System.out.print("Choose a new username: ");
			String user = in.nextLine();
			System.out.println("Choose a new password: ");
			String pass = in.nextLine();
	
			DB_UserInteract.insert(user, pass); // new username and password stored
			System.out.print("New user created successfully");
		
				
		}else {
			//----------LOGIN------------// things to add (try again if user or password is wrong)
			//while (DB_UserInteract.loginCheck(user, pass) == false) { //loop to allow user to attempt login again after inserting incorrect details
				System.out.print("Username: ");
				String user = in.nextLine();
				System.out.print("Password: ");
				String pass = in.nextLine();
			
				if (DB_UserInteract.loginCheck(user, pass)) { //Checks whether username and password exists
				//DB_UserInteract.loginCheck(user, pass) = true; //ends loop
					System.out.println("Successful login");
				}else {
					System.out.println("Username or password does not match"); //loop continues
				}
			}
		}
	}

