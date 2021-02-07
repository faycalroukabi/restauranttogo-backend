package com.restauranttogo.menuservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restauranttogo.menuservice.domain.CoursePo;

@Repository
public interface CourseRepository extends JpaRepository<CoursePo, Long>{

	CoursePo findFirstByTitle(String title);
}
