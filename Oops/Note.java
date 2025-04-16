package com.example;
import java.time.LocalDateTime;
public class Note{
    private int id;
    private String title;
    private String content;
    private String category;
    private LocalDateTime createdAt;
    public Note(int id, String title, String content, String category){
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.createdAt = LocalDateTime.now();
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void displayNote() {
        System.out.println("Note ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Content: " + content);
        System.out.println("Created At: " + createdAt);
    }
}
