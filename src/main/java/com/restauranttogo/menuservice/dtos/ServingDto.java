package com.restauranttogo.menuservice.dtos;

import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServingDto {
	private String name;
	private Double calories;
	private String countryOfOrigin;
	private List<IngredientDto> ingredients;
	
}
