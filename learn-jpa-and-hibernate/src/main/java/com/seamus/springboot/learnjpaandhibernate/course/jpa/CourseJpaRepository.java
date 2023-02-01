package com.seamus.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.seamus.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional // Necessary Decorator to perform DB transactions
public class CourseJpaRepository {

    // In-place of @Autowired here -> expresses a dependency entityManager (more-specific)
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        // All mapping is done at class/component level!
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
      Course course = entityManager.find(Course.class, id);
      entityManager.remove(course);
  }
}
