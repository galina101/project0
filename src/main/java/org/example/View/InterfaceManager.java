package org.example.View;
import org.example.Exception.InterfaceManagerException;
import org.example.Exception.NoteException;
import org.example.Model.NoteEntry;
import org.example.Model.Prompt;
import org.example.Service.NoteService;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.Service.Main.promptMenu;

public class InterfaceManager {

    NoteService noteService = new NoteService();
    Scanner sc = new Scanner(System.in);
    private String userInput;
    int index;

    public InterfaceManager(){
    }


    public void inputToPrompt (String userInput) {

        //convert user input to upper case before validating it
        String promptType = userInput.toUpperCase();
        Prompt prompt = new Prompt();
        String output;

        switch (promptType) {
            case "BG":
            case "BR":
            case "DJ":
            case "CW":
            case "BP":

                //If input is valid, then display a random prompt

                output = prompt.returnPrompt(promptType);
                System.out.println (output);

                interpretAddAction();

                noteService.displayEntries();

                break;
            default:
                //Invalid input
                output = "Invalid input. Try again.";
                System.out.println (output);

        }
    }

    public void interpretAddAction() {
        System.out.println("Enter your thoughts below:");
        String userEntry = sc.nextLine();
        noteService.saveNote(userEntry);
        System.out.println("Entry saved!");
    }


    public void interpretDeleteAction() throws NoteException {
        System.out.println("What entry number do you want to delete?");
        System.out.println("Enter a number from 1 to " + noteService.getEntriesLength() + ". ");
        userInput = sc.nextLine();

        try {
            index = Integer.parseInt(userInput);
            index--;
            noteService.deleteNote(index);

        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("!!! Wrong input. Integers only");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (NoteException e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("!!!No such entry exists. Please type a valid entry number.");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }


    }
    public void interpretUpdateAction() throws IndexOutOfBoundsException {
        System.out.println("What entry number do you want to update?");
        System.out.println("Enter a number from 1 to " + noteService.getEntriesLength() + ". ");
        userInput = sc.nextLine();

        System.out.println("Enter new content for your entry:");
        String content = sc.nextLine();

        try {
            index = Integer.parseInt(userInput);
            index--;
            noteService.updateNote(index, content);

        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("!!! Wrong input. Integers only");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("!!!No such entry exists. Please type a valid entry number.");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }

    }

    public void interpretSearchAction() throws IndexOutOfBoundsException {
        System.out.println("The search is completed by content. Enter a string you want to search by: ");
        userInput = sc.nextLine();

        NoteEntry entryFound = noteService.searchEntries(userInput);

        if (entryFound != null) {
            System.out.println("Entry found: ");
            System.out.println(entryFound.toString());
        }
        else if (entryFound == null) {
            System.out.println("No entries found.");
        }


    }

    public void ValidateCLIInput (String userInput) throws InterfaceManagerException, NoteException {
        String command = userInput.toUpperCase();

        if (command.equals("NEW")) {
            //go back to the main menu
            promptMenu();

        } else if (command.equals("VIEW")) {
            noteService.displayEntries();

            //SHOULD GO TO "WHAT DO YOU WANT TO DO NOW"?

        } else if (command.equals("DELETE")){
            interpretDeleteAction();

            //display remaining entries
            System.out.println("");
            System.out.println("Here are your remaining entries: ");
            noteService.displayEntries();
        }
        else if (command.equals("UPDATE")){
            interpretUpdateAction();

            //display all entries
            System.out.println("");
            System.out.println("Here is what in your journal now: ");
            noteService.displayEntries();
        }
        else if (command.equals("SEARCH")){
            interpretSearchAction();

            //display the entry found
            System.out.println("");
        }
        else {
            throw new InterfaceManagerException("Invalid input. Going back to daily journal prompt.");
        }

    }
}
