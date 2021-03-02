package com.restauranttogo.menuservice.services;

import java.util.ArrayList;
import java.util.Optional;

import com.restauranttogo.menuservice.domain.FoodPo;
import com.restauranttogo.menuservice.dtos.FoodDto;
import com.restauranttogo.menuservice.exception.ObjectNotFoundException;
import com.restauranttogo.menuservice.mapper.MenuMapper;
import com.restauranttogo.menuservice.tool.Validate;
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
    @Autowired
    private MenuMapper menuMapper;

    public MenuDto mapMenu(MenuDto menuDto) {
        MenuPo menuPo = new MenuPo();
		/*menuPo.setCourses(new ArrayList<>());
		menuPo.setServings(new ArrayList<>());*/
        menuPo.setTitle(menuDto.getTitle());
		/*menuDto.getCourses().stream().forEach(course -> {
			courseService.mapCourse(course);
			menuPo.getCourses().add(courseRepository.findFirstByTitle(course.getTitle()));}
		);*/
        menuDto.getServings().stream().forEach(serving -> {
            if (Optional.ofNullable(servingRepository.findFirstByName(serving.getName())).isPresent()) {
                menuPo.getServings().add(servingRepository.findFirstByName(serving.getName()));
            } else {
                menuPo.getServings().add(addServingIfNotPresent(serving));
            }
        });
        return menuMapper.convertToDto(menuRepository.save(menuPo));
    }

    public <T extends ServingPo> T addServingIfNotPresent(ServingDto serving) {
        servingService.mapServing(serving);
        return servingRepository.findFirstByName(serving.getName());
    }
}
