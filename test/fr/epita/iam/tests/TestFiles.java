package fr.epita.iam.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import fr.epita.iam.business.CreateActivity;
import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.FileIdentityDAO;

public class TestFiles {
	
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

			FileIdentityDAO fileIdentityDAO = new FileIdentityDAO("tests.txt");
			fileIdentityDAO.write(new Identity("123", "Thomas Broussard", "thomas.broussard@gmail.com"));
			fileIdentityDAO.write(new Identity("456", "Clément Serrano", "clement.serrano@natsystem.fr"));
			
			List<Identity> list = fileIdentityDAO.readAll();
			System.out.println(list);
			
		
			
		}
}
