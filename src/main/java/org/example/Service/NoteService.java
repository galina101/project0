package org.example.Service;

import org.example.Exception.NoteException;
import org.example.Model.NoteEntry;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class NoteService {

    List<NoteEntry> entries;

    /**
     * my journal entry list
     * 1 -> {noteText:"hello", time:11:02}
     * 2 -> {noteText:"hello2", time:11:23}
     */

    public NoteService() {
        this.entries = new ArrayList<>();
    }

    /**
     * Add a new noteEntry to my arrayList, given a String input
     */
    public void saveNote(String input) {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        NoteEntry newNoteEntry = new NoteEntry(currentTime, input);
        entries.add(newNoteEntry);
    }

    public void updateNote(int index, String newValue) {
        Timestamp oldTimestamp = entries.get(index).getTime();
        entries.set(index, new NoteEntry(oldTimestamp, newValue));
        System.out.println("The note #" + (index + 1) + " was updated.");
    }

    public void deleteNote(int index) throws NoteException {

        try {
            Main.log.warn("We are about to delete " + index);
            // Main.log.warn(entries.displayEntries());
            System.out.println("The following entry is about to get deleted: " +
                    " \n" + entries.get(index));

            this.entries.remove(index);
            System.out.println("The note #" + (index + 1) + " was deleted.");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("No such entry exists. Please type a valid entry number.");
            throw new NoteException("Delete failed.");
        }
    }

    /**
     * Return all the noteEntries from the arrayList (which, can be accomplished
     * by just returning the ArrayList)
     */
    public List<NoteEntry> getEntries() {
        return this.entries;
    }

    public int getEntriesLength() {
        return this.entries.size();
    }

    //Reference: https://ioflood.com/blog/java-list-methods/
    public List<NoteEntry> displayEntries() {
        ListIterator<NoteEntry> listIterator = entries.listIterator();

        while (listIterator.hasNext()) {
            System.out.println((listIterator.nextIndex() + 1) + ": " + listIterator.next());
        }
        return null;
    }


    public ArrayList<NoteEntry> searchEntries(String searchWord) {

       List <NoteEntry> entriesFound = null;
        NoteEntry currentEntry;
        ListIterator<NoteEntry> entriesFoundListIterator = entriesFound.listIterator();

        //Search
        for (int i = 0; i < entries.size(); i = i + 1) {
            currentEntry = entries.get(i);
            Main.log.warn ("Currently searching for "+ searchWord + " in the following entry: " + entries.get(i));
            //System.out.println("Entries.get(i): " + entries.get(i));
           // System.out.println("currentEntry.getNoteText(): " + currentEntry.getNoteText());

            String currentEntryText = currentEntry.getNoteText();

            //convert both strings to lower case for non-case sensitive search
            searchWord = searchWord.toLowerCase();
            currentEntryText = searchWord.toLowerCase();

            if (currentEntryText.contains(searchWord)) {
                //add entry to the array of NoteEntry
                entriesFound.add(currentEntry);
            }

            //Display
            while (entriesFoundListIterator.hasNext()) {
                System.out.println((entriesFoundListIterator.nextIndex() + 1) + ": " + entriesFoundListIterator.next());
            }
        }

        return null;
    }
}
