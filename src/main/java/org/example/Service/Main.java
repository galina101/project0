package org.example.Service;

import org.example.Exception.InterfaceManagerException;
import org.example.Exception.NoteException;
import org.example.View.InterfaceManager;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Journaling app that provides a user with a writing prompt.
 */
public class Main {
    static InterfaceManager interfaceManager = new InterfaceManager();

    public static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws InterfaceManagerException, IndexOutOfBoundsException, NoteException {

        Scanner sc = new Scanner(System.in);
        String userInput;
        System.out.println("Welcome to your daily journal!");

        promptMenu();

        //infinite loop for a menu
        while (true) {

            System.out.println("What do you want to do now? " + "\n" +
                    "New entry (New), " +
                    "View all entries (View), " +
                            "Update an entry (Update), Search (Search), Delete (Delete) or Exit (Exit)");
            userInput = sc.nextLine();
            interfaceManager.ValidateCLIInput(userInput);
            }
        }
    public static void promptMenu(){
        System.out.println("What do you want to write about today? " +
                "Select the type of prompt: Beginner (BG), Brainstorming (BR), Daily Journal (DJ), " +
                "Creative Writing (CW), Body Positivity (BP): ");

        Scanner sc = new Scanner(System.in);
        String userInput;

        userInput = sc.nextLine();
        interfaceManager.inputToPrompt(userInput);

    }

    }


