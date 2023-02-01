package com.seamus.springboot.learnjpaandhibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Provided mapping from Java Bean (def here) and DB Table
@Entity //(name="Course_Details") - NOT NEEDED, but specifies Table name
public class Course {
    @Id // Decorator specifying primary key
    private long id;
    private String name;
    //@Column(name="author") // Map property author to course Table column "author" (NOT NEEDED)
    private String author;

    public Course() {
        
    }

    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
    }
}
