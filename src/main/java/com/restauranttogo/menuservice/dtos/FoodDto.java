package com.restauranttogo.menuservice.dtos;

import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodDto extends ServingDto{
	private Double averageWeight;
	private Integer sufficiency;
	public FoodDto(String name, Double calories, String countryOfOrigin, List<IngredientDto> ingredients,
			Double averageWeight, Integer sufficiency) {
		super(name, calories, countryOfOrigin, ingredients);
		this.averageWeight = averageWeight;
		this.sufficiency = sufficiency;
	}
	
}
