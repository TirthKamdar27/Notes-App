package com.example.demo.repository;

import com.example.demo.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface NoteRepo extends JpaRepository<Note, Integer> {
    List<Note> findByCategory(String category);
}
