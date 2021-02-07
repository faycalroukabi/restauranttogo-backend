package com.restauranttogo.menuservice.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.restauranttogo.menuservice.dtos.ServingDto;
import com.restauranttogo.menuservice.services.ServingService;

@RestController
@RequestMapping("/servings")
public class ServingController {
	@Autowired
	private ServingService servingService;
	
	@GetMapping("/listservings")
	public <T extends ServingDto> List<T> getAll(){
		List<T> servings = servingService.mapAllDto();
		return servings;
	}

}
