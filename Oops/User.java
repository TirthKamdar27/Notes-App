package com.example;
public class User extends BaseEntity{
    private String name;
    private String email;
    private String password;
    private String role;
    public User(int id, String name, String email, String password, String role){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
    @Override
    public String toString(){
        return super.toString() + "\n Name : " + name + "\n Email : " + email + "\n Role : " + role;
    }
    public static void main(String args[]){
        User user = new User(1, "John Doe", "johndoe@example.com", "pass@123", "Admin");
        System.out.println(user);
    }
}

