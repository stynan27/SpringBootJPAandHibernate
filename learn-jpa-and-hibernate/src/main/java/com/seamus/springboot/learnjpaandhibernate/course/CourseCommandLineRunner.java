package com.seamus.springboot.learnjpaandhibernate.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.seamus.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.seamus.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.seamus.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;


@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    // @Autowired
    // private CourseJdbcRepository repository;

    // @Autowired
    // private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // Legacy JDBC/JPA way (Not SpringDataJPA)
        // repository.insert(new Course(1, "Learn AWS JPA Now!", "Seamus"));
        // repository.insert(new Course(2, "Learn Azure JPA Now!", "Seamus"));
        // repository.insert(new Course(3, "Learn Fullstack JPA Now!", "Seamus"));
        // repository.deleteById(1);
        // System.out.println(repository.findById(2));
        // System.out.println(repository.findById(3));

        // (SpringJPAWay)
        repository.save(new Course(1, "Learn AWS JPA Now!", "Seamus"));
        repository.save(new Course(2, "Learn Azure JPA Now!", "Seamus"));
        repository.save(new Course(3, "Learn Fullstack JPA Now!", "Seamus"));

        // 1l here where 'l' specifies long int.
        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        // Custom method!
        System.out.println(repository.findByAuthor("Seamus"));
        System.out.println(repository.findByName("Learn Azure JPA Now!"));
    }
}
