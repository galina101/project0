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

    public static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws InterfaceManagerException, IndexOutOfBoundsException {

        InterfaceManager interfaceManager = new InterfaceManager();
        Scanner sc = new Scanner(System.in);

        //infinite loop for a menu
        while (true) {
            System.out.println("Welcome to your daily journal! What do you want to write about today? " +
                                "Select the type of prompt: Beginner (BG), Brainstorming (BR), Daily Journal (DJ), " +
                                "Creative Writing (CW), Body Positivity (BP): ");

            String userInput = sc.nextLine();
            interfaceManager.inputToPrompt(userInput);

            System.out.println("What do you want to do now? New entry (New), view all entries (View), update an entry (Update), search (Search) or delete (Delete)?");
            userInput = sc.nextLine();
            interfaceManager.ValidateCLIInput(userInput);
            }

        }

    }


