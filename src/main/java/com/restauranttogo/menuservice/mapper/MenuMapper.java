package com.restauranttogo.menuservice.mapper;

import com.restauranttogo.menuservice.domain.MenuPo;
import com.restauranttogo.menuservice.dtos.MenuDto;
import com.restauranttogo.menuservice.services.ServingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class MenuMapper {

    @Autowired
    private ServingService servingService;
    @Autowired
    private CourseMapper courseMapper;


    public MenuDto convertToDto(MenuPo menuPo) {
        MenuDto menuDto = new MenuDto();
        menuDto.setTitle(menuPo.getTitle());
        menuPo.getCourses().stream().forEach(course -> {
                    menuDto.getCourses().add(courseMapper.convertToDto(course));
                }
        );
        menuPo.getServings().stream().forEach(serving ->
                menuDto.getServings().add(servingService.mapOneServingDto(serving))

        );

        return menuDto;
    }
}
