package com.restauranttogo.menuservice.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restauranttogo.menuservice.dtos.ServingDto;
import com.restauranttogo.menuservice.services.ServingService;

@RestController
@RequestMapping("/servings")
@CrossOrigin(origins = "http://localhost:3000")
public class ServingController {
	@Autowired
	private ServingService servingService;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/listservings",produces=MediaType.APPLICATION_JSON_VALUE)
	public <T extends ServingDto> List<T> getAll() {
		List<T> servings = servingService.mapAllDto();
		return servings;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/searchservings/{searchquery}",produces=MediaType.APPLICATION_JSON_VALUE)
	public <T extends ServingDto> List<T> searchServingByQuery(@PathVariable("searchquery") String searchQuery) {
		List<T> servings = servingService.searchServings(searchQuery);
		return servings;
	}
	

}
