package com.example.demo.controller;
import com.example.demo.entity.Note;
import com.example.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return "index";
    }

    @GetMapping("/add")
    public String addNote(Model model) {
        model.addAttribute("note", new Note());  // for adding new note
        return "note-form";
    }

    @PostMapping("/save")
    public String saveNote(@ModelAttribute Note note) {
        if (note.getId() != null && note.getId() > 0) {  // Check if we are updating an existing note
            noteService.updateNote(note.getId(), note.getTitle(), note.getContent(), note.getCategory());
        } else {  // Otherwise, it's a new note
            noteService.createNote(note.getTitle(), note.getContent(), note.getCategory());
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable("id") int id, Model model) {
        Note note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        return "note-form";  // Show the form with existing data
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") int id) {
        noteService.deleteNote(id);
        return "redirect:/";
    }
}


