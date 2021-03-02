package com.restauranttogo.menuservice.presentation;

import java.util.List;

import com.restauranttogo.menuservice.domain.MenuPo;
import com.restauranttogo.menuservice.dtos.DrinkDto;
import com.restauranttogo.menuservice.dtos.FoodDto;
import com.restauranttogo.menuservice.dtos.MenuDto;
import com.restauranttogo.menuservice.services.MenuService;
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

	@Autowired
	private MenuService menuService;

	@GetMapping("/list_servings")
	public <T extends ServingDto> List<T> getAll(){
		return servingService.mapAllDto();
	}


	@PostMapping("/add_serving")
	public <T extends ServingDto> ResponseEntity<T> addDrink(@RequestBody T servingDto){
        ServingDto result=servingService.mapOneServingPo(servingDto);
		return new ResponseEntity(result,HttpStatus.OK);
	}



   @PostMapping("/add_menu")
	public ResponseEntity<MenuDto> addMenu(@RequestBody MenuDto menuDto){
		MenuDto menudto = menuService.mapMenu(menuDto);
		return new ResponseEntity(menudto,HttpStatus.OK);
   }


	@GetMapping("/{id}")
	public <T extends ServingDto> ResponseEntity<T> getById(@PathVariable Long id){
		ServingDto result=servingService.getServingById(id);
		return new ResponseEntity(result,HttpStatus.OK);
	}

	@GetMapping("/search/{name}")
	public <T extends ServingDto> ResponseEntity<T> getByName(@PathVariable String name){
		ServingDto result=servingService.getServingByName(name);
		return new ResponseEntity(result,HttpStatus.OK);
	}




	}
