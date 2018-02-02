/**
 * MagazineRack.java  --A driver program to exercise the MagazineList collection.
 * @author				Lewis/Loftus
 * @author				Ratna Lama / King Arthur Alagao
 * @version   			1.0
 * @since     			12/03/2017
*/

import java.io.*;
import java.util.Scanner;

public class MagazineRack {

	/**
	* Algorithm:
 	* 1. Displays the magazines in mags.dat file 
 	* OR tells the user if the file does not exist.
 	* 2. Asks the user to insert a magazine to the list.
 	* 3. Asks the user to delete a magazine from the list.
 	* 4. Displays the output from the file.
	* @parm 	args 	the command-line argument
	*/
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
        MagazineList rack = new MagazineList();
     
        char keepGoing = 'y';
        String magazineTitle, answer, deleteTitle;
  
        File magazineFile = new File("mags.dat");

		/**
		* Scans through the file
		*/
		System.out.println();

		try
        {
            Scanner scanFile = new Scanner(magazineFile);
            
            System.out.println("Here are your magazines: ");
            while (scanFile.hasNextLine()) 
            {
                String magTitle = scanFile.nextLine();
                System.out.println(magTitle);
                rack.insert(new Magazine(magTitle));
            }            
            scanFile.close();
        }
        catch(IOException e)
        {
            System.out.println("Sorry no magazines exist in mags.txt"); 
        }
 
        System.out.println();
        
        while(keepGoing == 'y')
        {
            System.out.print("Would you like to enter a title: (y/n): ");
            answer = scan.nextLine();
            keepGoing = answer.charAt(0);
            while(keepGoing != 'y' && keepGoing != 'n' 
                    && keepGoing != 'Y' && keepGoing != 'N')
            {
                System.out.print("Would you like to enter a title: (y/n): ");
                answer = scan.nextLine();
                keepGoing = answer.charAt(0);
            }
         
            if(keepGoing == 'y')
            {
                System.out.print("Enter a title: ");
                magazineTitle = scan.nextLine();
                rack.insert(new Magazine(magazineTitle));
            }
        }
        System.out.println();

		/**
		* Writes to the external file and also displays the output 
		*/
		try
        {
            PrintWriter outFile = new PrintWriter(magazineFile);
            outFile.print(rack);
            outFile.close();
            
            Scanner traverseThrough = new Scanner(magazineFile);
            
            System.out.println("Here are your magazines: ");
            while (traverseThrough.hasNextLine()) 
            {
                String magTitle = traverseThrough.nextLine();
                System.out.println(magTitle);
            }
            traverseThrough.close();
        }
        catch(IOException e)
        {
            System.out.printf("ERROR : %s\n", e);
        }

		/**
		* Deletes magazine title.
		*/
		try
        {
        System.out.print("Enter a title to delete: ");
        deleteTitle = scan.nextLine();
        rack.delete(new Magazine(deleteTitle));
        }
        catch(NullPointerException e)
        {
            System.out.println("The magazine you want to delete is not on " 
                    + "your list.");
        }

		/**
		* Displays the magazine title.
		*/
		try
        {
            PrintWriter outFile = new PrintWriter(magazineFile);
            outFile.print(rack);
            outFile.close();
            
            Scanner traverseThrough = new Scanner(magazineFile);
            
            System.out.println();
            System.out.println("Here are your magazines: ");
            while (traverseThrough.hasNextLine()) 
            {
                String magTitle = traverseThrough.nextLine();
                System.out.println(magTitle);
            }
            traverseThrough.close();
        }
        catch(IOException e)
        {
            System.out.printf("ERROR : %s\n", e);
        }

	} // end main() method
	
} // end MagazineRack class