package fr.epita.iam.business;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.FileIdentityDAO;
import fr.epita.iam.services.IdentityDAO;

public class CreateActivity {
	

	private static java.sql.Date getDate(String birthday_str) throws ParseException {
		SimpleDateFormat  dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = dateFormat.parse(birthday_str);
		java.sql.Date birthDay = new java.sql.Date(date.getTime());
		return birthDay;
	}
	public static void execute(Scanner scanner){
		System.out.println("Identity Creation");
		System.out.println("please input the displayName");
		String displayName = scanner.nextLine();
		System.out.println("please input the email address");
		String email = scanner.nextLine();
		System.out.println("please input the password");
		String password = scanner.nextLine();
		System.out.println("please input the birthday (dd-mm-yyyy)");
		String birthdayStr = scanner.nextLine();
		Date birthday = null;
		try{
			birthday = getDate(birthdayStr);
		}
		catch(Exception e){
			System.out.println("Error while reading the birthday");
		}
		Identity identity = new Identity("",displayName,
								email, birthday, password);
		
	
		//persist the identity somewhere
		System.out.println("this is the identity you created"+identity);
		IdentityDAO identityDAO = new IdentityDAO();
		identityDAO.create(identity);
		System.out.println("creation Done");
		
	}
}
