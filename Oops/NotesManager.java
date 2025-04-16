package com.example;
import java.util.*;
public class NotesManager{
    private List<Note> notes;
    private Map<Integer, Note> notesMap;
    public NotesManager(){
        notes = new ArrayList<>();
        notesMap = new HashMap<>();
    }
    public void addNote(Note note){
        notes.add(note);
        notesMap.put(note.getId(), note);
    }
    public void displayNotes(){
        if(notes.isEmpty()){
            System.out.println("No notes found, create one");
            return;
        }
        else{
            for(Note note : notes){
                System.out.println(note);
                System.out.println("--------------");
            }
        }
    }
    public Note findNoteById(int id){
        return notesMap.get(id);
    }
    public static void main(String[] args) {
        NotesManager manager = new NotesManager();
        manager.addNote(new Note(1, "Meeting Notes", "Discussed project roadmap", "Work"));
        manager.addNote(new Note(2, "Shopping List", "Buy milk, bread, eggs", "Personal"));
        manager.addNote(new Note(3, "Book Ideas", "Outline for new book project", "Creative"));
        System.out.println("All Notes : \n");
        manager.displayNotes();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter note id to search");
        int searchId = sc.nextInt();
        Note foundNote = manager.findNoteById(searchId);
        if(foundNote != null){
            System.out.println("Note found with id " + searchId + " \n " + foundNote);
            foundNote.displayNote();
        }
        else{
            System.out.println("Note with ID " + searchId + " not found.");
        }
        sc.close();
    }
}