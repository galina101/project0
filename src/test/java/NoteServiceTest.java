import org.example.Exception.NoteException;
import org.example.Model.NoteEntry;
import org.example.Service.Main;
import org.example.Service.NoteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;


//Reference: https://www.tutorialspoint.com/junit/junit_using_assertion.htm

public class NoteServiceTest {
    NoteService noteServiceTest;

    @Before
    public void setUp () {noteServiceTest = new NoteService();}

    //Verify that the list of entries is empty when created
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
    public void noteServiceDeleteNote () throws NoteException{
        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();
        int index = 0;

        noteServiceTest.saveNote("This is an entry #1.");
        noteServiceTest.deleteNote(index);

        Assert.assertTrue(noteEntriesTest.size() == 0);
    }
    //Delete multiple journal entries
    @Test
    public void noteServiceDeleteMultipleNotes() throws NoteException{
        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();
        int index = 0;

        noteServiceTest.saveNote("This is an entry #1.");
        noteServiceTest.saveNote("This is an entry #2.");
        noteServiceTest.saveNote("This is an entry #3.");
        noteServiceTest.deleteNote(index);
        noteServiceTest.deleteNote(index++);

        Assert.assertTrue(noteEntriesTest.size() == 1);
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
    @Test (expected = NoteException.class)
    public void deleteEntryInvalidIndex1 () throws NoteException {

        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();
        int index = -1;

        noteServiceTest.saveNote("This is an entry #1.");
        noteServiceTest.saveNote("This is an entry #2.");
        noteServiceTest.saveNote("This is an entry #3.");

        noteServiceTest.deleteNote(index);
    }

    @Test (expected = NoteException.class)
    public void deleteEntryInvalidIndex2 () throws NoteException{

        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();
        int index = 3;

        noteServiceTest.saveNote("This is an entry #1.");
        noteServiceTest.saveNote("This is an entry #2.");
        noteServiceTest.saveNote("This is an entry #3.");

        noteServiceTest.deleteNote(index);
    }
    @Test
    public void noteServiceDeleteNote3() throws NoteException {
        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();
        int index = 2;

        noteServiceTest.saveNote("This is an entry #1.");
        noteServiceTest.saveNote("This is an entry #2.");
        noteServiceTest.saveNote("This is an entry #3.");

        noteServiceTest.deleteNote(index);

        NoteEntry currentEntry = noteServiceTest.getEntries().get(index-1);
        String actual = currentEntry.getNoteText();
        String expected = "This is an entry #2.";

        Assert.assertEquals(actual, expected);
    }

//    @Test
//    public void noteServiceSearch(){
//        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();
//        noteServiceTest.saveNote("This is an entry #1.");
//        noteServiceTest.saveNote("This is an entry #2.");
//        noteServiceTest.saveNote("This is an entry #3.");
//
//        String searchWord = "2";
//        NoteEntry actual = noteServiceTest.searchEntries(searchWord);
//
//
//        Assert.assertTrue(actual.getNoteText().contains(searchWord));
//    }

    //confirm that the method can handle null
//
//    public void noteServiceSearch3(){
//        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();
//        noteServiceTest.saveNote("This is an entry #1.");
//        noteServiceTest.saveNote("This is an entry #2.");
//        noteServiceTest.saveNote("This is an entry #3.");
//
//        String searchWord = "add";
//        NoteEntry actual = noteServiceTest.searchEntries(searchWord);
//
//
//        Assert.assertNull(actual.getNoteText().contains(searchWord));
//    }

    //Display correct length of the array
    @Test
    public void checkLength () {
        int expected = 3;
        int actual;

        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();

        noteServiceTest.saveNote("This is an entry #1.");
        noteServiceTest.saveNote("This is an entry #2.");
        noteServiceTest.saveNote("This is an entry #3.");

        actual = noteServiceTest.getEntriesLength();
        Assert.assertEquals(actual, expected);
    }


@Test
    public void searchMethodTest () {
        List<NoteEntry> expected;
        List<NoteEntry> actual;

        List<NoteEntry> noteEntriesTest = noteServiceTest.getEntries();
        String searchWord = "an";
        NoteEntry currentEntry;
        boolean containsExpectedSearchWord;
        int actualSize;
        int expectedSize;

        noteServiceTest.saveNote("This is an entry #1.");
        noteServiceTest.saveNote("This is an entry #2.");
        noteServiceTest.saveNote("This is an entry #3.");

        noteServiceTest.searchEntries(searchWord);

        actual = noteServiceTest.searchEntries(searchWord);
        Main.log.warn (actual.toString());

        actualSize = actual.size();
        Main.log.warn ("Actual size of an array " + actualSize);

        expectedSize = 3;
        //is search word equal to the getNoteText() of the object?
        for (int i = 0; i < actual.size(); i = i + 1) {
            currentEntry = actual.get(i);
            String currentEntryText = currentEntry.getNoteText();
            containsExpectedSearchWord = currentEntryText.contains("an");
            //searchWord
        }
        //expected that 3 ArrayList<NoteEntry> are returned

        Assert.assertEquals(actualSize,expectedSize);
    }
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
}
