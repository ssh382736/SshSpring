package com.standard.ssh.TransicationPoc.dto;


import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "master.teacher")
public class Teacher {

    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;

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
