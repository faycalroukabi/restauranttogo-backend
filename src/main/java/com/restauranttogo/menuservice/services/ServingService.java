package com.restauranttogo.menuservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restauranttogo.menuservice.data.DrinkRepository;
import com.restauranttogo.menuservice.data.FoodRepository;
import com.restauranttogo.menuservice.data.IngredientRepository;
import com.restauranttogo.menuservice.data.ServingRepository;
import com.restauranttogo.menuservice.domain.DrinkPo;
import com.restauranttogo.menuservice.domain.FoodPo;
import com.restauranttogo.menuservice.domain.IngredientPo;
import com.restauranttogo.menuservice.domain.ServingPo;
import com.restauranttogo.menuservice.dtos.DrinkDto;
import com.restauranttogo.menuservice.dtos.FoodDto;
import com.restauranttogo.menuservice.dtos.IngredientDto;
import com.restauranttogo.menuservice.dtos.ServingDto;

@Service
public class ServingService {

	@Autowired
	private FoodRepository foodRepository;
	@Autowired
	private DrinkRepository drinkRepository;
	@Autowired
	private IngredientRepository ingredientRepository;
	@Autowired
	private ServingRepository servingRepository;

	public <T extends ServingPo> void mapCommunServing(ServingDto servingDto, T servingAbs) {
		ServingPo servingPo = servingAbs;
		servingPo.setIngredients(new ArrayList<>());
		servingDto.getIngredients().stream().forEach(ingredient -> {
			IngredientPo ingredientPo = ingredientRepository.findByName(ingredient.getName());
			servingPo.getIngredients().add(ingredientPo);
		});
		servingPo.setCalories(servingDto.getCalories());
		servingPo.setName(servingDto.getName());
		servingPo.setCountryOfOrigin(servingDto.getCountryOfOrigin());
	}

	public void mapServing(ServingDto servingDto) {
		if (servingDto instanceof FoodDto) {
			mapFood(servingDto);
		}
		if (servingDto instanceof DrinkDto) {
			mapDrink(servingDto);
		}
	}

	public void mapFood(ServingDto servingDto) {
		FoodPo foodPo = new FoodPo();
		foodPo.setAverageWeight(((FoodDto) servingDto).getAverageWeight());
		foodPo.setSufficiency(((FoodDto) servingDto).getSufficiency());
		mapCommunServing(servingDto, foodPo);
		foodRepository.save(foodPo);
	}

	public void mapDrink(ServingDto servingDto) {
		DrinkPo drinkPo = new DrinkPo();
		drinkPo.setAlcoholic(((DrinkDto) servingDto).getAlcoholic());
		drinkPo.setVolume(((DrinkDto) servingDto).getVolume());
		mapCommunServing(servingDto, drinkPo);
		drinkRepository.save(drinkPo);
	}

	public void mapIngredients(List<IngredientPo> ingredients) {
		ingredientRepository.saveAll(ingredients);
	}

	public <T extends ServingDto>  List<T> mapAllDto() {
		List<ServingPo> servingPos = servingRepository.findAll();
		List<ServingDto> servingDtos = new ArrayList<>();
		servingPos.stream().forEach(servingPo -> {
			ServingDto servingDto = mapOneServingDto(servingPo);
			servingDtos.add(servingDto);
		});
		return (List<T>) servingDtos;
	}
	
	public <T extends ServingDto, S extends ServingPo> T mapOneServingDto(S servingPo) {
		ServingDto servingDto = new ServingDto();
		if (servingPo instanceof FoodPo) {
			servingDto = new FoodDto();
			((FoodDto) servingDto).setAverageWeight(((FoodPo) servingPo).getAverageWeight());
			((FoodDto) servingDto).setSufficiency(((FoodPo) servingPo).getSufficiency());
		}
		if (servingPo instanceof DrinkPo) {
			servingDto = new DrinkDto();
			((DrinkDto) servingDto).setAlcoholic(((DrinkPo) servingPo).getAlcoholic());
			((DrinkDto) servingDto).setVolume(((DrinkPo) servingPo).getVolume());
		}
		servingDto.setCountryOfOrigin(servingPo.getCountryOfOrigin());
		servingDto.setName(servingPo.getName());
		servingDto.setCalories(servingPo.getCalories());
		List<IngredientDto> ingredientDtos = new ArrayList<>();
		servingPo.getIngredients().stream().forEach(ingredientPo -> {
			IngredientDto ingredientDto = new IngredientDto();
			ingredientDto.setName(ingredientPo.getName());
			ingredientDto.setType(ingredientPo.getType());
			ingredientDtos.add(ingredientDto);
		});
		servingDto.setIngredients(ingredientDtos);
		
		return (T) servingDto;
	}
}
