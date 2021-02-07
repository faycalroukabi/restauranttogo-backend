package com.restauranttogo.menuservice.presentation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restauranttogo.menuservice.domain.IngredientPo;
import com.restauranttogo.menuservice.dtos.DrinkDto;
import com.restauranttogo.menuservice.dtos.FoodDto;
import com.restauranttogo.menuservice.dtos.IngredientDto;
import com.restauranttogo.menuservice.dtos.MenuDto;
import com.restauranttogo.menuservice.dtos.ServingDto;
import com.restauranttogo.menuservice.services.MenuService;
import com.restauranttogo.menuservice.services.ServingService;

@Component
public class MenuController implements CommandLineRunner{
	@Autowired
	private ServingService servingService;
	@Autowired
	private MenuService menuService;
	@Override
	public void run(String... args)  throws Exception {
		IngredientPo ingredientPo1 = new IngredientPo("carrot","vegetable");
		IngredientPo ingredientPo2 = new IngredientPo("cereal","cereal");
		IngredientPo ingredientPo3 = new IngredientPo("coffee grains", "grain");
		IngredientPo ingredientPo4 = new IngredientPo("lemon","fruits");
		IngredientPo ingredientPo5 = new IngredientPo("pineapple","fruits");
		List<IngredientPo> ingredients = Arrays.asList(ingredientPo1,ingredientPo2,ingredientPo3,ingredientPo4,ingredientPo5);
		servingService.mapIngredients(ingredients);
		IngredientDto ingredientDto1 = new IngredientDto("carrot","vegetable");
		IngredientDto ingredientDto2 = new IngredientDto("cereal","cereal");
		IngredientDto ingredientDto3 = new IngredientDto("coffee grains", "grain");
		IngredientDto ingredientDto4 = new IngredientDto("lemon","fruits");
		IngredientDto ingredientDto5 = new IngredientDto("pineapple","fruits");
		List<IngredientDto> ingredientDtos = Arrays.asList(ingredientDto1,ingredientDto2,ingredientDto3,ingredientDto4,ingredientDto5);
		ServingDto foodDto = new FoodDto("couscous",1700d, "Tunis", ingredientDtos,
				5.6d, 4);
		ServingDto foodDto2 = new FoodDto("tagine",2100d, "Morocco", ingredientDtos,
				5.4d, 3);
		ServingDto foodDto3 = new FoodDto("tagine poulet",2800d, "Morocco", ingredientDtos,
				5.4d, 3);
		ServingDto drinkDto = new DrinkDto("tea",2800d, "Morocco", ingredientDtos,
				5.4d, false);
		MenuDto menuDto= new MenuDto();
		menuDto.setServings(Arrays.asList(foodDto, foodDto2, foodDto3, drinkDto));
		menuDto.setTitle("Main menu");
		servingService.mapFood(foodDto);
		menuService.mapMenu(menuDto);
		MenuDto menuDto1= new MenuDto();
		menuDto1.setServings(Arrays.asList(foodDto, foodDto2, foodDto3, drinkDto));
		menuDto1.setTitle("Main menu 2");
		menuService.mapMenu(menuDto1);
		
		
	}
}
