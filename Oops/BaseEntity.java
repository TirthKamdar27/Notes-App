package com.example;
import java.time.LocalDateTime;
public class BaseEntity{
    private int id;
    private LocalDateTime createdId;
    public BaseEntity(int id){
        this.id = id;
        this.createdId = LocalDateTime.now();
    }
    public int getId(){
        return id;
    }
    public LocalDateTime getCreatedId(){
        return createdId;
    }
    @Override
    public String toString(){
        return " ID : " + id + "\n Created at : " + createdId;  
    } 
}