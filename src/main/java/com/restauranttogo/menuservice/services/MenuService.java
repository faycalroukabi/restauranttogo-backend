package com.restauranttogo.menuservice.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restauranttogo.menuservice.data.CourseRepository;
import com.restauranttogo.menuservice.data.MenuRepository;
import com.restauranttogo.menuservice.data.ServingRepository;
import com.restauranttogo.menuservice.domain.MenuPo;
import com.restauranttogo.menuservice.domain.ServingPo;
import com.restauranttogo.menuservice.dtos.MenuDto;
import com.restauranttogo.menuservice.dtos.ServingDto;

@Service
public class MenuService {
	@Autowired
	private ServingRepository servingRepository;
	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ServingService servingService;
	@Autowired
	private CourseService courseService;
	
	public void mapMenu(MenuDto menuDto) {
		MenuPo menuPo = new MenuPo();
		menuPo.setCourses(new ArrayList<>());
		menuPo.setServings(new ArrayList<>());
		menuPo.setTitle(menuDto.getTitle());
		/*menuDto.getCourses().stream().forEach(course -> {
			courseService.mapCourse(course);
			menuPo.getCourses().add(courseRepository.findFirstByTitle(course.getTitle()));}
		);*/
		menuDto.getServings().stream().forEach(serving ->{
			if(Optional.ofNullable(servingRepository.findFirstByName(serving.getName())).isPresent()) {
				menuPo.getServings().add(servingRepository.findFirstByName(serving.getName()));
			}
			else {
				menuPo.getServings().add(addServingIfNotPresent(serving));
			}
		});
		menuRepository.save(menuPo);
	}
	
	public <T extends ServingPo> T addServingIfNotPresent(ServingDto serving) {
		servingService.mapServing(serving);
		return servingRepository.findFirstByName(serving.getName());
	}
}
