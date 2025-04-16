package com.example;
import java.util.*;
// import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotesStreamProcessor {
    private List<Note> notes;

    public NotesStreamProcessor() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> filterByCategory(String category) {
        return notes.stream()
            .filter(note -> note.getCategory().equalsIgnoreCase(category))
            .collect(Collectors.toList());
    }
    public List<Note> searchNotes(String keyword) {
        return notes.stream()
            .filter(note -> note.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                                note.getContent().toLowerCase().contains(keyword.toLowerCase()))
            .collect(Collectors.toList());
    }
    public void displayNotes(List<Note> filteredNotes) {
        filteredNotes.forEach(System.out::println);
    }
    public static void main(String[] args) {
        NotesStreamProcessor manager = new NotesStreamProcessor();
        // Adding notes
        manager.addNote(new Note(1, "Project Kickoff", "Initial meeting notes", "Work"));
        manager.addNote(new Note(2, "Grocery List", "Buy apples, milk, and bread", "Personal"));
        manager.addNote(new Note(3, "Coding Tips", "Use functional programming in Java", "Tech"));
        manager.addNote(new Note(4, "Travel Plans", "Prepare itinerary for Paris", "Personal"));
        // Filtering by category
        System.out.println("Personal Notes:");
        manager.displayNotes(manager.filterByCategory("Personal"));

        // Searching for keyword
        System.out.println("\nNotes containing 'Java':");
        manager.displayNotes(manager.searchNotes("Java"));
    }

}
