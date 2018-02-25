/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.hailstonesequence;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import north.hailstonesequence.HailstoneSequence;

/**
 *
 * @author northernpike
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hailstone sequence calculator");
        int startingPoint = 0;
        
        while(true) {
            System.out.println("Give a starting number between 0 and 1000000:");
            String startingPointAsString = scanner.nextLine();
            if(startingPointAsString.length() < 7) { //First check if the number is over 7 digits in order to 
                
                startingPoint = Integer.parseInt(startingPointAsString);
                
                if (startingPoint > 0) {
                    break;
                }
                
            }           

        }

        
        HailstoneSequence hScalculator = new HailstoneSequence(startingPoint); //Create new HailstoneSequence with startingpoint
        hScalculator.calculateSequence(); //Call the method to calculate the sequence. Now the values can be asked for by the getters
        
	try {
            File file = new File("sequence.html");  //Create new file and write the information required from Hailstone sequence
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" + 
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    The input number was " + hScalculator.getStartingPoint() + "\n" +
                "    </br> The number of steps it took to reach number 1 was " + hScalculator.getRounds() + " \n" +
                "    </br> The second largest number in the sequence was " + hScalculator.getSecondLargestPoint() + "\n" +
                "  </body>\n" +
                "</html>\n" );
            fileWriter.flush();
            fileWriter.close();
            Desktop.getDesktop().browse(file.toURI()); //Open the created html file in browser
        } catch (IOException e) {
	}
        
        
        
        System.out.println("The required values have been saved in sequence.html file that can be found at the root of the project");
    }
}
