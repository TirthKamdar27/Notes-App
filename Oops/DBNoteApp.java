package com.example;
import java.sql.SQLException;
import java.util.List;

public class DBNoteApp{
    public static void main(String[] args) {
        NotesDOA doa = new NotesDOA();
        try {
            Note newNote = new Note(0, "JDBC Tut", "Connect Java to MySQL", "Tech");
            doa.insertNote(newNote);
            System.out.println("Added new Note");
            List<Note> notes = doa.getAllNotes();
            System.out.println("All notes : \n");
            notes.forEach(System.out::println);
            doa.updateNoteContent(1, "Updated content  using JDBC");
            System.out.println("Update a Note with id 1");
            doa.deleteNoteById(2);
            System.out.println("Delete a Note with id 2");
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}