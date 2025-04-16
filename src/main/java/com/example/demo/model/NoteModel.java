package com.example.demo.model;

public class NoteModel {
    private String title;
    private String content;
    private String category;
    public NoteModel(){}
    public NoteModel(String title, String content, String category){
        this.title = title;
        this.content = content;
        this.category = category;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public String getCategory(){
        return category;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    // public void setCategory(){
    //     this.category = category;
    // }
}
