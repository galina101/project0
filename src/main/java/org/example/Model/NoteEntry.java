package org.example.Model;
import java.sql.Timestamp;

public class NoteEntry {
    private String noteText;
    private Timestamp time;

    public NoteEntry(Timestamp time,String noteText){
        this.noteText = noteText;
        this.time = time;
    }

    public void setNoteText(String noteText){
        this.noteText = noteText;
    }

    public void setTime(Timestamp time){
        this.time = time;
    }

    public String getNoteText(){
        return noteText;
    }

    public Timestamp getTime(){
        return time;
    }

    @Override
    public String toString() {
        return  "Journal entry created on " + time + ".\n" +
                "Journal entry content: "+ noteText + "\n" +
                "=============================================================";
    }
}
