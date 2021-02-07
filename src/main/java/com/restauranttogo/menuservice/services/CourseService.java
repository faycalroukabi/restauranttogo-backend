package com.restauranttogo.menuservice.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restauranttogo.menuservice.data.CourseRepository;
import com.restauranttogo.menuservice.data.ServingRepository;
import com.restauranttogo.menuservice.domain.CoursePo;
import com.restauranttogo.menuservice.domain.ServingPo;
import com.restauranttogo.menuservice.dtos.CourseDto;
import com.restauranttogo.menuservice.dtos.ServingDto;

@Service
public class CourseService {
	@Autowired
	private ServingRepository servingRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ServingService servingService;
	
	public void mapCourse(CourseDto courseDto) {
		CoursePo coursePo = new CoursePo();
		coursePo.setServings(new ArrayList<>());
		coursePo.setTitle(courseDto.getTitle());
		coursePo.setCourses(courseDto.getCourses());
		courseDto.getServings().stream().forEach(serving ->{
			if(Optional.ofNullable(servingRepository.findFirstByName(serving.getName())).isPresent()) {
				coursePo.getServings().add(servingRepository.findFirstByName(serving.getName()));
			}
			else {
				coursePo.getServings().add(addServingIfNotPresent(serving));
			}
		});
		
		courseRepository.save(coursePo);
	}
	
	public <T extends ServingPo> T addServingIfNotPresent(ServingDto serving) {
		servingService.mapServing(serving);
		return servingRepository.findFirstByName(serving.getName());
	}
}
