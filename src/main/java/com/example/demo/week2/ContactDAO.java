package com.example.demo.week2;

import java.util.ArrayList;

public class ContactDAO {
    ArrayList<Contact> clist;
    public ContactDAO() {
        clist = new ArrayList<Contact>();
    }
    public void add(Contact contact){
        clist.add(contact);
    }
    public ArrayList<Contact> getList(){
        return clist;
    }
}
