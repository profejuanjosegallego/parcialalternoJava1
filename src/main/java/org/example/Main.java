package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption;


        // COLORS

        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String WHITE = "\u001B[37m";



        /* LOGIN VARIABLES */

        String userName = "Mateo";
        String savedEmail = "email@email.com";
        String savedPassword = "123";
        String typedEmail;
        String typedPassword;


        ArrayList<HashMap<String, Object>> clothes = new ArrayList<>(); // ArrayList to save clothes

        while (true) { // Login's loop

            System.out.print(WHITE + " 📧 type your email: ");
            typedEmail = keyEntry.nextLine();

            System.out.print(WHITE + " 🔒 type your password: ");
            typedPassword = keyEntry.nextLine();

            /* VALIDATING CREDENTIALS */

            if (typedEmail.equalsIgnoreCase(savedEmail) && typedPassword.equals(savedPassword)) { // If credentials are valid

                System.out.println(GREEN + "Welcome " + userName + " 👋🏼");

                do {

                    try {

                        /* MENU OPTIONS */

                        System.out.println(BLUE + """
                                \s
                                 👕 Welcome to a clothes manager... What do yo want to do?
                                \s
                                 1) Save Clothes in BD 📝
                                 2) Show Stock of Clothes 📦
                                 3) LOGOUT 🚪
                                                            \s
                                \s""");

                        System.out.print("Type your Option: ");
                        menuOption = keyEntry.nextInt();
                        keyEntry.nextLine();


                        if (menuOption == 1) { // Save clothe in a HashMap "Database"

                            HashMap<String, Object> clothe = new HashMap<>();

                            System.out.print(WHITE + "Name of the Clothe: ");
                            String clotheName = keyEntry.nextLine();

                            System.out.print(WHITE + "Size (S/M/L/XL): ");
                            String clotheSize = keyEntry.nextLine();

                            System.out.print(WHITE + "Price (integer number): ");
                            Integer clothePrice = Integer.parseInt(keyEntry.nextLine().trim());

                            clothe.put("name", clotheName);
                            clothe.put("size", clotheSize);
                            clothe.put("price", clothePrice);

                            clothes.add(clothe); // Adding clothes in a list of clothes

                            System.out.println(GREEN + "✅ Clothe saved Successfully: ");


                        } else if (menuOption == 2) { // LIST OF CLOTHES 🥼

                            for (HashMap<String, Object> clothesList : clothes) {

                                // Iterate a forEach to show the list in the requested format

                                System.out.println("=================================================================\n");
                                System.out.println(GREEN + "📋 Stock of Clothes:");
                                System.out.println(clothesList.get("name") + "|" + clothesList.get("size") + "|" + clothesList.get("price"));
                                System.out.println("\n=================================================================");


                            }
                        } else if (menuOption == 3) { // Closing Program
                            System.out.println(YELLOW + "Good bye 👋🏼");
                            break;
                        } else {
                            System.out.println(RED + "Invalid Option ❌");
                        }

                    } catch (InputMismatchException ex) { // Exception for Errors
                        System.out.println(RED + "Invalid Option it must be a number between one and three (1-3).");
                        keyEntry.nextLine();
                        menuOption = -1;
                        System.out.print("\npress ENTER to continue...");
                        keyEntry.nextLine();
                        System.out.println();
                    } catch (Exception ex) {
                        // Any other Exception
                        System.out.println(RED + "Ups, something went Wrong: " + ex.getMessage());
                        System.out.print("\npress ENTER to continue...");
                        keyEntry.nextLine();
                        System.out.println();
                    }

                } while (true);

                break;

            } else {
                System.out.println(RED + "Invalid credentials. ❌");
            }
        }
    }
}