package com.restauranttogo.menuservice.dtos;

import java.util.List;

import lombok.Data;


@Data
public class MenuDto {
	
	private String title;
	private List<CourseDto> courses;
	private List<ServingDto> servings;
}
