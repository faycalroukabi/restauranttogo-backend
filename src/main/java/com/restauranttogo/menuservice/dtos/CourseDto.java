package com.restauranttogo.menuservice.dtos;

import java.util.List;

import lombok.Data;

@Data
public class CourseDto {
	private String title;
	private Integer courses;
	private List<ServingDto> servings;
}
