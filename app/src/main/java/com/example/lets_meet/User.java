package com.example.lets_meet;

public class User {
    private String name,email,pass,phone;
    public int a;

    public User()
    {

    }

    public void mainpage(int y)
    {
      this.a=y;

    }

    public int login()
    {

       return this.a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
