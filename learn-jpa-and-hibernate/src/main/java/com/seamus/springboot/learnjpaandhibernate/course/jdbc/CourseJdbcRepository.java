package com.seamus.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seamus.springboot.learnjpaandhibernate.course.Course;

// Spring decorator for a class which interacts with a database.
@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    // ? below indicates values to be passed from Course class.
    private static String INSERT_QUERY =
            """
                insert into course (id, name, author)
                values(?, ?, ?);
            """;
            
    private static String DELETE_QUERY =
            """
                delete from course where id=?
            """;

    private static String SELECT_QUERY =
            """
                select * from course
                where id=?
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, 
          course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        // ResultsSet -> Bean => Row Mapper (Map row to specific Bean)
        // id
        // NOTE: Requires class setter defintions for all params!
        return springJdbcTemplate.queryForObject(SELECT_QUERY, 
            new BeanPropertyRowMapper<>(Course.class), id);
    }
}
