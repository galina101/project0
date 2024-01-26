import org.example.Exception.NoteException;
import org.example.Model.NoteEntry;
import org.example.Service.NoteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNull;

public class NoteServiceTest {
    NoteService noteServiceTest;

    @Before
    public void setUp () {noteServiceTest = new NoteService();}

    @Test
    public void noteServiceEmptyAtStart () {
        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();
        Assert.assertTrue(noteEntriesTest.size() == 0);
    }

    //Add a journal entry
    @Test
    public void noteServiceSaveNote() {
        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();
        String noteText = "Test Entry";
        noteServiceTest.saveNote(noteText);

        Assert.assertTrue(noteEntriesTest.size() > 0);
    }

    //Delete a journal entry
    @Test
    public void noteServiceDeleteNote() {
        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();
        int index = 1;

        noteServiceTest.saveNote("This is a test entry.");
        noteServiceTest.deleteNote(index);

        Assert.assertNull(noteEntriesTest);
    }

    @Test
    public void noteServiceUpdateNote() {
        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();
        int index = 2;

        noteServiceTest.saveNote("This is an entry #1.");
        noteServiceTest.saveNote("This is an entry #2.");
        noteServiceTest.saveNote("This is an entry #3.");

        noteServiceTest.updateNote(index, "This is an updated entry #3.");

        NoteEntry currentEntry = noteServiceTest.getEntries().get(index);
        String actual = currentEntry.getNoteText();
        String expected = "This is an updated entry #3.";

        Assert.assertEquals(actual, expected);
    }


    //Get all the journal entries

    //Print all the journal entries

    //Delete a journal entry that doesn't exist (outside of range)
    @Test
//    public void deleteEntryInvalidIndex (){
//        int index = -1;
//        try {
//            noteServiceTest.deleteNote(index);
//            Assert.fail();
//        } catch (ArrayIndexOutOfBoundsException e) {
//
//        }
//    }

    //Delete method - User enters a double when int is requested
//@Test
//public void interpretDeleteActionDoubleInsteadOfInt () {
//try {
//    double userInput = 4.0;
// //   Assert.assertThrows(noteServiceTest.deleteNote(userInput));
//   // Assert.fail();
//} catch (NumberFormatException e) {
//
//}
//}
    //Delete method - User enters a string when int is requested
    //@Test
    public void deleteEntryStringInsteadOfInt () {

    }
    //Display correct length of the array
    @Test
    public void checkLength () {
        int expected;
//getEntriesLength
    }

}
