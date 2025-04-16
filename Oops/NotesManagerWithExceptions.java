package com.example;
import java.util.*;
public class NotesManagerWithExceptions{
    private List<Note> notes;
    public NotesManagerWithExceptions(){
        notes = new ArrayList<>();
    }
    public void addNote(Note note) throws InvalidNoteException{
        if(note.getTitle() == null || note.getTitle().isEmpty()){
            throw new InvalidNoteException("Note title cannot be null");
        }
        if(note.getContent() == null || note.getContent().isEmpty()){
            throw new InvalidNoteException("Note content cannot be null");
        }
        notes.add(note);
        System.out.println("Note added successfully" + note.getTitle());
    }
    public void displayNotes() throws InvalidNoteException{
        if(notes.isEmpty()){
            throw new InvalidNoteException("No notes found, create one");
        }
        else{
            for(Note note : notes){
                System.out.println(note);
                System.out.println("--------------");
            }
        }
    }
    public Note findNoteById(int id) throws InvalidNoteException{
        for (Note note : notes) {
            if (note.getId() == id){
                return note;
            }
        }
        throw new InvalidNoteException("Note with ID " + id + " not found.");
    }
    public static void main(String[] args) {
        NotesManagerWithExceptions manager = new NotesManagerWithExceptions();
        try {
            manager.addNote(new Note(1, "Meeting Notes", "Discussed project roadmap", "Work"));
            manager.addNote(new Note(2, "Shopping List", "Buy milk, bread, eggs", "Personal"));
            manager.addNote(new Note(3, "Book Ideas", "Outline for new book project", "Creative"));
            manager.addNote(new Note(4, "", "This note has no title", "Misc"));
        } catch (InvalidNoteException e) {
            System.out.println(" Error " + e.getMessage());
        }
        try {
            System.out.println("All Notes : \n");
            manager.displayNotes();
        } catch (InvalidNoteException e) {
            System.out.println(" Error " + e.getMessage());
        }
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter note id to search");
            int searchId = sc.nextInt();
            Note foundNote = manager.findNoteById(searchId);
            System.out.println("Note found with id " + searchId + " \n " + foundNote);
            foundNote.displayNote();
            sc.close();
        } catch (InvalidNoteException e) {
            System.out.println(" Error " + e.getMessage());
        }
        
    }
    
}