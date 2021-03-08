package com.restauranttogo.menuservice.presentation;

import java.util.List;

import com.restauranttogo.menuservice.dtos.MenuDto;
import com.restauranttogo.menuservice.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.restauranttogo.menuservice.dtos.ServingDto;
import com.restauranttogo.menuservice.services.ServingService;

@RestController
@RequestMapping("/servings")
@CrossOrigin(origins="http://localhost:3000")
public class ServingController {
	@Autowired
	private ServingService servingService;

	@Autowired
	private MenuService menuService;


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


	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path="/addMenu",consumes= MediaType.APPLICATION_JSON_VALUE)
	public void addMenu(@RequestBody MenuDto menuDto) {
		menuService.mapMenu(menuDto);
	}
}
