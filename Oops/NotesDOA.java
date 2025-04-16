package com.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotesDOA{
    public void insertNote(Note note) throws SQLException{
        String sql = "INSERT INTO notes (title, content, category) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,note.getTitle());
            stmt.setString(2,note.getContent());
            stmt.setString(3,note.getCategory());
            stmt.executeUpdate();
        }
    }
    public List<Note> getAllNotes() throws SQLException{
        List<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM notes";
        try(Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                Note note = new Note(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getString("category")
                );
                notes.add(note);
            }
        }
        return notes;
    }
    public void updateNoteContent(int id, String newContent) throws SQLException{
        String sql = "UPDATE notes SET content = ? WHERE id = ?";
        try(Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, newContent);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
    public void deleteNoteById(int id) throws SQLException{
        String sql = "Delete FROM notes WHERE id = ?";
        try(Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}