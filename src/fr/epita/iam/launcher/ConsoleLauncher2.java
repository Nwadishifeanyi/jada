package fr.epita.iam.launcher;

import java.util.Scanner;

import fr.epita.iam.business.CreateActivity;

public class ConsoleLauncher2 {
	
	public static void main(String[] args){
		System.out.println("Welcome to the IAM software");
		Scanner scanner = new Scanner(System.in);
		//Authentification
		/*if (authenticate(scanner)){
			end(scanner);
			return;
		}*/
		//menu
		System.out.println("Please select an action: ");
		System.out.println("1, Create an identity");
		System.out.println("2, Modify an identity");
		System.out.println("3, delete an identity");
		String choice = scanner.nextLine();
		
		switch (choice) {
		case "1":
			//create
			//CreateActivity createActivity = new CreateActivity();
			CreateActivity.execute(scanner);
			break;
		case "2":
			//modify
			break;
		case "3":
			//delete
			break;
		case "q":
			//Quit
			break;
		default:
			System.out.println("Your choice is not recognized");
		}
		end(scanner);
	}

	private static void end(Scanner scanner) {
		System.out.print("Thank you for using this application , goodbye");
		scanner.close();
	}

	private static boolean authenticate(Scanner scanner) {
		System.out.println("Please typer your login");
		String login = scanner.nextLine();
		System.out.println("Please typer your password");
		String password = scanner.nextLine();
		
		
		if (login.equals("admin") && password.equals("admin")){
			System.out.println("Authenfication was Successfull");
			return true;
		}
		else{
			System.out.println("Authentifaction failed");
			scanner.close();
			return false;
		}
	}
}
