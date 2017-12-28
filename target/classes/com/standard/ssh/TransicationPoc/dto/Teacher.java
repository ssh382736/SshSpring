package com.standard.ssh.TransicationPoc.dto;


import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int number;
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;

    public Teacher(String id,String name){}

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
