package com.restauranttogo.menuservice.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class MenuDto {
	
	private String title;
	private List<CourseDto> courses = new ArrayList<>();
	private List<ServingDto> servings = new ArrayList<>();
}
