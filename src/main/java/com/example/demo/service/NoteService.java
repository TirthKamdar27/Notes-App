package com.example.demo.service;

import com.example.demo.entity.Note;
import com.example.demo.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepo noteRepo;

    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    public Note createNote(String title, String content, String category) {
        Note note = new Note(title, content, category);
        return noteRepo.save(note);
    }

    public void updateNote(Integer id, String title, String content, String category) {
        Optional<Note> existingNote = noteRepo.findById(id);
        if (existingNote.isPresent()) {
            Note note = existingNote.get();
            note.setTitle(title);
            note.setContent(content);
            note.setCategory(category);
            noteRepo.save(note);  // This saves the updated note
        }
    }

    public void deleteNote(int id) {
        noteRepo.deleteById(id);
    }

    public Note getNoteById(int id) {
        return noteRepo.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
    }
}
