package com.restauranttogo.menuservice.presentation;

import java.util.List;

import com.restauranttogo.menuservice.dtos.DrinkDto;
import com.restauranttogo.menuservice.dtos.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.restauranttogo.menuservice.dtos.ServingDto;
import com.restauranttogo.menuservice.services.ServingService;

@RestController
@RequestMapping("/servings")
public class ServingController {
	@Autowired
	private ServingService servingService;

	@GetMapping("/listservings")
	public <T extends ServingDto> List<T> getAll(){
		return servingService.mapAllDto();
	}


	@PostMapping("/addserving")
	public <T extends ServingDto> ResponseEntity<T> addDrink(@RequestBody T servingDto){
        ServingDto result=servingService.mapOneServingPo(servingDto);
		return new ResponseEntity(result,HttpStatus.OK);

	}

	@GetMapping("/searchServings")
	public  ResponseEntity <FoodDto> searchFood(@PathVariable Long identifier){
		FoodDto result= (FoodDto) servingService.getServingById(identifier);
		return new ResponseEntity(result,HttpStatus.OK);
	}









	}
