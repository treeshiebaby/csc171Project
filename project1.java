/*
Melvin Mai
mmai2@u.rochester.edu
Completion: 2/15/21
Solution to Project 1 for CSC 171
 */

import java.util.Scanner;

public class project1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Initialize Variables
        String userInput = "";
        int i;
        int j;

        //Check if the user has entered q to quit.
        while (!(userInput.equals("q"))) {

            //Ask user for input
            System.out.println("Enter text. Text to be " +
                    "redacted will appear between the tags" +
                    " <r> and </r>. Enter 'q' to quit.");
            userInput = s.nextLine();

            //Run the string to check for initial redaction indicator
            for (i = 0; i <= userInput.length(); ++i) {

                //If <r> is found, start new for loop
                if (userInput.startsWith("<r>", i)) {
                    for (j = i + 2; j <= userInput.length(); ++j) {

                        //Check if character is a letter or digit,
                        //if not check if its </r>
                        if (Character.isLetterOrDigit(userInput.charAt(j))) {
                            userInput = userInput.substring(0, j) + "*" +
                                    userInput.substring(j + 1);
                        }

                        //Checking if the ending redaction indicator is there
                        //Break out of loop if true
                        else if (userInput.startsWith("</r>", j)) {
                            break;
                        }
                    }
                }
            }

            // Remove redaction indication brackets and print the redacted string
            if (!(userInput.equals("q"))) {
                userInput = userInput.replace("<r>", "");
                userInput = userInput.replace("</r>", "");
                System.out.println(userInput);
            }
        }
    }
}
