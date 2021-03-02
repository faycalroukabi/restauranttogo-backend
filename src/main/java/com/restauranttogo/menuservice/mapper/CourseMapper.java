package com.restauranttogo.menuservice.mapper;

import com.restauranttogo.menuservice.data.CourseRepository;
import com.restauranttogo.menuservice.data.ServingRepository;
import com.restauranttogo.menuservice.domain.CoursePo;
import com.restauranttogo.menuservice.dtos.CourseDto;
import com.restauranttogo.menuservice.services.ServingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;
@Component
public class CourseMapper {

    @Autowired
    private ServingService servingService;

    public CourseDto convertToDto(CoursePo coursePo) {
        CourseDto courseDto = new CourseDto();
        /*courseDto.setServings(new ArrayList<>());*/
        courseDto.setTitle(coursePo.getTitle());
        courseDto.setCourses(coursePo.getCourses());
        coursePo.getServings().stream().forEach(serving ->{
            courseDto.getServings().add(servingService.mapOneServingDto(serving));

        });

       return courseDto;
    }
}
