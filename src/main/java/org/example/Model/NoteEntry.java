package org.example.Model;

import java.sql.Time;
import java.sql.Timestamp;

public class NoteEntry {
    private String noteText;
    private Timestamp time;

    public NoteEntry(String noteText){
        this.noteText = noteText;
//        if I don't have a timestamp provided, I have a choice (as a developer) to choose between
//        leaving 'time' null or setting the time to the current time here.
    }

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
        return //"Journal entry number #: " + entryNumber + ".\n"+
                "Journal entry created on " + time + ".\n" +
                "Journal entry content: "+ noteText + "\n" +
                "=============================================================";
    }
}
