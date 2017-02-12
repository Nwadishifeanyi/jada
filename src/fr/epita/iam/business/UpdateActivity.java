package fr.epita.iam.business;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.launcher.ConsoleLauncher;
import fr.epita.iam.services.FileIdentityDAO;
import fr.epita.iam.services.IdentityDAO;

public class UpdateActivity {
	

	private static java.sql.Date getDate(String birthday_str) {
		java.sql.Date birthDay = null;
		try{
			SimpleDateFormat  dateFormat = new SimpleDateFormat("dd-mm-yyyy");
			java.util.Date date = dateFormat.parse(birthday_str);
			birthDay = new java.sql.Date(date.getTime());
		}
		catch(ParseException e){
			Logger.getLogger(UpdateActivity.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("please enter a date format dd-mm-yyyy");
		}
		return birthDay;
	}
	public static void execute(Scanner scanner){
		System.out.println("Identity Update");
		IdentityDAO identityDAO = new IdentityDAO();
		List<Identity> identities = identityDAO.readAll();
		Map<String, Identity> foundIdentities = new HashMap<>();
		System.out.println("Select an identity id");
		for(Identity i : identities){
			System.out.println("Identity "+i.getUid()+ " "+i);
		}
		String identity_id = scanner.nextLine();
		Identity foundIdentity = identityDAO.find(identity_id);
		if (foundIdentity == null){
			System.out.println("Did not find identity "+identity_id);
		}
		else{
			System.out.println("Do you want to update identity: y/n");
			String answer = scanner.nextLine();
			if (answer.equalsIgnoreCase("y")){
				while(answer.equalsIgnoreCase("y")){
					System.out.println("Choose the field to update");
					System.out.println("q; birthday; displayName; password");
					String options = scanner.nextLine();
					switch(options.toLowerCase()){
						case "birthday":
							System.out.println("please enter new birthday");
							String birthdayStr = scanner.nextLine();
							foundIdentity.setBirthday(getDate(birthdayStr));
							break;
						case "displayname":
							System.out.println("please enter new display name");
							String displayName = scanner.nextLine();
							foundIdentity.setDisplayName(displayName);
							break;
						case "password":
							System.out.println("please enter new password");
							String password = scanner.nextLine();
							foundIdentity.setPassword(password);
							break;
						case "q":
							answer = "n";
							break;
						default:
							answer = "y";
					}
				}
				
			}
			else{
				System.out.println("Update cancel");
			}
		}
		
		//persist the identity somewhere
		System.out.println("this is the identity you created"+foundIdentity);
		identityDAO.update(foundIdentity);
		System.out.println("update Done");
		
	}
}
