package com.restauranttogo.menuservice.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DrinkDto extends ServingDto{
	private Double volume;
	private Boolean alcoholic;
	public DrinkDto(String name, Double calories, String countryOfOrigin, List<IngredientDto> ingredients,
			Double volume, Boolean alcoholic) {
		super(name, calories, countryOfOrigin, ingredients);
		this.volume = volume;
		this.alcoholic = alcoholic;
	}
	
}
