package com.restauranttogo.menuservice.dtos;

import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServingDto {
	private Long identifier;
	private String name;
	private Double calories;
	private String countryOfOrigin;
	private List<IngredientDto> ingredients;
	public ServingDto(String name, Double calories, String countryOfOrigin, List<IngredientDto> ingredients) {
		super();
		this.name = name;
		this.calories = calories;
		this.countryOfOrigin = countryOfOrigin;
		this.ingredients = ingredients;
	}
	
	
}
