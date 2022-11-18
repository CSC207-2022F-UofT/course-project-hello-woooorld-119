
package tutorial;

import tutorial.LoginUseCase;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This is a controller class that allows the user to input data when logging into the system.
 */

public class LoginPage{

    private final LoginUseCase userController;

    public LoginPage(LoginUseCase userController){
        this.userController = userController;
    }

    public LoginUseCase getLoginUseCase(){
        return userController;
    }

// This method initiates the login commands.

    public void beginLogin(){
        boolean temp = true;
        while (temp){
            try{
                // Used to read the input from user.
                Scanner inputReader = new Scanner(System.in);

                System.out.println("Please enter your username: ");
                String username = inputReader.nextLine();
                System.out.println("Please enter your password: ");
                String password = inputReader.nextLine();

                // Checks whether the user exists.
                HashMap<String, Boolean> status = getLoginUseCase().checkUser(username, password);
                boolean valid = status.get("Valid");

                nextChoice(username, valid);
                temp = false;

            }
            catch (InputMismatchException e){
                System.out.println("The input is incorrect. Please try again.");
            }
        }
    }

/*
 * A helper method that branches out and executes based on the user account information and status.
 * @param username
 * @param valid which is the status of the user
 */
    private void nextChoice(String username, boolean valid){
        if (valid){
            secondChoice(username);
        }
        else{
            System.out.println("Incorrect username or password. Please try again.");
        }
    }

// Helper method that branches out when valid username input.
    public void secondChoice(String username){
        String message = "Hello " + username;
        System.out.println(message);

        boolean confirmed = false;
        while (!confirmed){
            System.out.println("Please choose from the following:");
            System.out.println("Press 1 to view your login history\n" + "Press 2 to log out");

            try{
                Scanner chooseOption = new Scanner(System.in);
                int userCommand = chooseOption.nextInt();

                switch (userCommand){
                    case 1:
                        System.out.println("Your login history:");
                        ArrayList<String> historyLogin = getLoginUseCase().getLoginHistory(username);
                        for (String time: historyLogin){
                            System.out.println(time);
                        }
                        confirmed = true;
                        break;
                    case 2:
                        System.out.println("You successfully logged out.");
                        confirmed = true;
                        break;
                    default:
                        System.out.println("Wrong input. Please try again");
                }
            } catch (InputMismatchException e){
                System.out.println("Incorrect input. Please try again.");
            }
        }


    }

}
