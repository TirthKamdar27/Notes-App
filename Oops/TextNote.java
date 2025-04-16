package com.example;
public class TextNote extends Note{
    public TextNote(int id, String title, String content, String category){
        super(id, title, content, category);
    }
    @Override
    public void displayNote(){
        System.out.println("======Note======");
        super.displayNote();
        System.out.println("----------------");
    }
    public static void main(String[] args) {
        TextNote textnote = new TextNote(1, "Meeting Notes", "Discussing Roadmap", "Work");
        textnote.displayNote();
    }
}
