package com.seamus.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seamus.springboot.learnjpaandhibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    // Can define your own methods as well!
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
